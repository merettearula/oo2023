package ee.merette.kontrolltoo_katse_2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
public class PoodController {

    List<Pood> poodideList = Arrays.asList(new Pood(1, "Loomapood", 9, 18, 14),
            new Pood(2, "Rimi", 8, 22, 25),
            new Pood(3, "Kullapood", 10, 18, 4));

//Loo API otspunkt, millele parameetrina antakse ette uuritav kellaaeg ning tagastatakse,
// kas pood on sel ajal lahti või kinni.
    //localhost:8080/kas-pood-lahti/{kellaaeg}
    @GetMapping("kas-pood-lahti/{kellaaeg}")
    public String kasPoodLahti(@PathVariable int kellaaeg) {
        for (Pood pood : poodideList) {
            int avamiseAeg = pood.getAvamiseAeg();
            int sulgemiseAeg = pood.getSulgemiseAeg();
            if (kellaaeg >= avamiseAeg && kellaaeg < sulgemiseAeg) {
                return "Pood on sel ajal avatud";
            }
        }
        return "Pood on sel ajal suletud";
    }

    //Lisa API otspunkt külastamiseks, mis suurendab andmebaasis poe külastuste arvu ühe võrra.
    @PostMapping("suurenda-kylastuste-arvu/{poodId}")
    public String suurendaKylastusteArvu(@PathVariable int poodId) {
        for (Pood pood : poodideList) {
            if (pood.getId() == poodId) {
                pood.setKylastajateArv(pood.getKylastajateArv() + 1);
                return "Poe külastuste arv on suurendatud, külastajate arv: " + pood.getKylastajateArv();
            }
        }
        return "Poodi ei leitud.";
    }
}

