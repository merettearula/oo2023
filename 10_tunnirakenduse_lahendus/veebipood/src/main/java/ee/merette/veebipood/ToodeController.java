package ee.merette.veebipood;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController //võimaldab api päringuid vastu võtta
public class ToodeController {
    //import üles
    @Autowired
    ToodeRepository toodeRepository;
    List<Toode> tooted = new ArrayList<>(Arrays.asList(
            new Toode(1,"Koola", 1.5),
            new Toode(2,"Fanta", 1.0),
            new Toode(3,"Sprite", 1.7),
            new Toode(4,"Vichy", 2.0),
            new Toode(5,"Vitamin well", 2.5)
    ));
    @GetMapping("tooted")
    public List<Toode> saaTooted() {
        return toodeRepository.findAll();
    }


    @GetMapping("kustuta-toode/{id}")
    public String kustutaToodeVariant2(@PathVariable int id) {
        toodeRepository.deleteById(id);
        return "Toode kustutatud!";
    }


    @GetMapping("lisa-toode")
    public List<Toode> lisaToode(
            @RequestParam int id,
            @RequestParam String nimi,
            @RequestParam double hind) {
        /*tooted.add(new Toode(id, nimi, hind));
        return tooted;*/
        toodeRepository.save(new Toode(id, nimi, hind));
        return toodeRepository.findAll();
    }

    //kustuta kõik tooted
    @GetMapping("kustuta-koik-tooted")
    public List<Toode> kustutaKoik(){
        toodeRepository.deleteAll();
        return toodeRepository.findAll();
    }

    @GetMapping("saa-toode/{id}")
    public Optional<Toode> saaToode(
            @PathVariable int id
    ){
        Optional<Toode> toode = toodeRepository.findById(id);
        return toode;
    }

    @GetMapping("suurim-hind")
    public Toode suurimHind(){
        tooteHine = toodeRepository.
    }
    //localhost:8080/lisa-toode?id=8&nimi=Mullivesi&hind=2.3&aktiivne=true
//Repository peab iga andmetabeli jaoks eraldi lisama
}
