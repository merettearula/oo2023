package ee.merette.veebipood;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RestController //võimaldab api päringuid vastu võtta
public class IsikController {
    List<Isik> isikud = new ArrayList<>(Arrays.asList(
            new Isik(1,"Coca","Koola", new Date()),
            new Isik(2,"Orange","Fanta", new Date()),
            new Isik(3,"Roheline","Sprite", new Date()),
            new Isik(4,"Vesi", "Vichy", new Date()),
            new Isik(5,"Vitamin", "Well", new Date())
    ));
    @GetMapping("isikud")
    public List<Isik> saaIsikud() {
        return isikud;
    }


    @DeleteMapping("kustuta-isik/{index}")
    public String kustutaIsikVariant2(@PathVariable int index) {
        isikud.remove(index);
        return "Isik kustutatud!";
    }


    @PostMapping("lisa-isik")
    public List<Isik> lisaIsik(
            @RequestParam int id,
            @RequestParam String eesnimi,
            @RequestParam String perenimi,
            @RequestParam double hind) {
        isikud.add(new Isik(id, eesnimi, perenimi, new Date()));
        return isikud;
    }

    //localhost:8080/lisa-isik?id=8&eesnimi=Mullivesi&perenimi="Vesine"

}
