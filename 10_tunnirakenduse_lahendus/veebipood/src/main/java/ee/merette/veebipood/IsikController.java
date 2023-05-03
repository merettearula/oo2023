package ee.merette.veebipood;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RestController //võimaldab api päringuid vastu võtta
public class IsikController {
    @Autowired
    IsikRepository isikRepository;
    List<Isik> isikud = new ArrayList<>(Arrays.asList(
            new Isik(1,"Coca","Koola", new Date()),
            new Isik(2,"Orange","Fanta", new Date()),
            new Isik(3,"Roheline","Sprite", new Date()),
            new Isik(4,"Vesi", "Vichy", new Date()),
            new Isik(5,"Vitamin", "Well", new Date())
    ));
    @GetMapping("isikud")
    public List<Isik> saaIsikud() {
        return isikRepository.findAll();
    }


    @GetMapping ("kustuta-isik/{id}")
    public String kustutaIsikVariant2(@PathVariable int id) {
        isikRepository.deleteById(id);
        return "Isik kustutatud!";
    }


    @GetMapping("lisa-isik")
    public List<Isik> lisaIsik(
            @RequestParam int id,
            @RequestParam String eesnimi,
            @RequestParam String perenimi) {
        //isikud.add(new Isik(id, eesnimi, perenimi, new Date()));
        //return isikud;
        isikRepository.save(new Isik(id, eesnimi, perenimi, new Date()));
        return isikRepository.findAll();

    }

    //localhost:8080/lisa-isik?id=8&eesnimi=Mullivesi&perenimi="Vesine"

}
