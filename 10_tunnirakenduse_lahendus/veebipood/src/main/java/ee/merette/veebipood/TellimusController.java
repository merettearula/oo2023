package ee.merette.veebipood;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RestController
public class TellimusController {

    @Autowired
    IsikRepository isikRepository;
//    IsikController isikController;
    @Autowired
    ToodeRepository toodeRepository;

    @Autowired
    TellimusRepository tellimusRepository;

//    ToodeController toodeController; //otseühendus selle klassiga, ühel ja samal mälukohal
//    List<Toode> tellimuseTooted = new ArrayList<>(Arrays.asList(
//            new Toode(3,"Sprite", 1.7),
//            new Toode(3,"Sprite", 1.7)
//    ));
//    List<Toode> tellimuse2Tooted = new ArrayList<>(Arrays.asList(
//            new Toode(3,"Sprite", 1.7),
//            new Toode(4,"Vichy", 2.0),
//            new Toode(5,"Vitamin well", 2.5)
//    ));

//    Isik tellija =  new Isik(1, "Ees", "Pere", new Date());
//    List<Tellimus> tellimused = new ArrayList<>(Arrays.asList(
//            new Tellimus(1, tellija, tellimuseTooted),
//            new Tellimus(2, tellija, tellimuse2Tooted)
//    ));

    @GetMapping("tellimused")
    public List<Tellimus> saaTellimused() {
        return tellimusRepository.findAll();
    }


    @DeleteMapping("kustuta-tellimus/{id}")
    public String kustutaTellimus(@PathVariable int id) {
        tellimusRepository.deleteById(id);
        return "Tellimus kustutatud!";
    }


    //localhost:8080/lisa-tellimus?id=9&tellijaIndex=3&tooteIndex=2
//    @PostMapping("lisa-tellimus")
//    public List<Tellimus> lisaToode(
//            @RequestParam int id,
//            @RequestParam int tellijaIndex,
//            @RequestParam int tooteIndex) {
//        //tellimused.add(new Tellimused(id, nimi, hind));
//        //IsikController isikController = new IsikController();
//        //System.out.println(isikController);           prinditakse kogu aeg uus mälukoht  -> Dependecy Injection
//        Isik tellija = isikController.isikud.get(tellijaIndex);
//        //ToodeController toodeController = new ToodeController();
//        Toode tellitudToode = toodeController.tooted.get(tooteIndex);
//        List<Toode> tellitudTooted = new ArrayList<>(Arrays.asList(tellitudToode));
//        tellimused.add(new Tellimus(id, tellija, tellitudTooted));
//        return tellimused;
//    }

    //localhost:8080/lisa-tellimus?id=9&tellijaId=4&tooteIds=2,2,3
    @PostMapping("lisa-tellimus2")
    public List<Tellimus> lisaToode2(
            @RequestParam int id,
            @RequestParam int tellijaId,
            @RequestParam int[] tooteIds) throws Exception {
        Isik tellija = isikRepository.findById(tellijaId).get();

        List<Toode> tellitudTooted = new ArrayList<>();
        for(Integer i: tooteIds ) {
            if (i == 12) {
                throw new Exception("IDga 12 ei saa andmebaasi lisada");
            }
            Toode toode = toodeRepository.findById(i).get();
            tellitudTooted.add(toode);
        }
        //tellimused.add(new Tellimus(id, tellija, tellitudTooted));
       // return tellimused;
        tellimusRepository.save(new Tellimus(id, tellija, tellitudTooted));
        return tellimusRepository.findAll();
    }

    //localhost:8080/lisa-tellimus3
    //päringusse parameetreid ei lisa, täpsustna need bodys

    @PostMapping("lisa-tellimus3")
    public List<Tellimus> lisaTellimus3(
            @RequestBody Tellimus tellimus) {
        tellimusRepository.save(tellimus);
        return tellimusRepository.findAll();
    }

    //localhost:8080/lisa-tellimus4
    @PostMapping("lisa-tellimus4")
    public List<Tellimus> lisaTellimus4(
            @RequestBody Tellimus tellimus) {

       // Isik isik = isikController.isikud.get(tellimus.getTellija().getId());
        Isik isik = isikRepository.findById(tellimus.getTellija().getId()).get();
        List<Toode> tellitudTooted = new ArrayList<>();
        for(Toode t: tellimus.getTooted() ){
            //Toode toode = toodeController.tooted.get(t.getId());
            Toode toode = toodeRepository.findById(t.getId()).get();
            tellitudTooted.add(toode);
        }

       // tellimused.add(new Tellimus(tellimus.getId(), isik, tellitudTooted));
        //return tellimused;
        tellimusRepository.save(new Tellimus(tellimus.getId(), isik, tellitudTooted));
        return tellimusRepository.findAll();
    }

    @GetMapping("saa-kogusumma")
    public double saaKoguSumma(){
       List<Tellimus> tellimused  = tellimusRepository.findAll();
       double kogusumma = 0;
        for (Tellimus t: tellimused) {
            for(Toode toode: t.getTooted()) {
                kogusumma += toode.getHind();
            }
        }
        return kogusumma;
    }

}
