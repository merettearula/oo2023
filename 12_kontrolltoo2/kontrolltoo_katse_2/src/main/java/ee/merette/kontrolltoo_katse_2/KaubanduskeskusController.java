package ee.merette.kontrolltoo_katse_2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class KaubanduskeskusController {

    List<Pood> poodideListLounakas = Arrays.asList(
            new Pood(1, "Loomapood", 9, 18, 14),
            new Pood(2, "Rimi", 8, 22, 25),
            new Pood(3, "Kullapood", 10, 18, 4));

    List<Pood> poodideListKaubamaja = Arrays.asList(
            new Pood(4, "Loomapood", 9, 18, 14),
            new Pood(5, "Rimi", 8, 22, 4),
            new Pood(6, "Taimepood", 10, 18, 4));
    private List<Kaubanduskeskus> kaubanduskeskusteList = Arrays.asList(
            new Kaubanduskeskus(1, "Lõunakas", poodideListLounakas),
            (new Kaubanduskeskus(2, "Kaubamaja", poodideListKaubamaja)));

    //Tee API otspunkti kaudu kokkuarvutus, kui palju on selles kaubanduskeskuses kõiki poode kokku külastatud
    @GetMapping("koik-kulastajad/{id}")
    public int koikKulastajad(@PathVariable int id) {
        int koikKulastajad = 0;

        Kaubanduskeskus kaubanduskeskus = findKaubanduskeskusById(id);

        if (kaubanduskeskus != null) {
            for (Pood pood : kaubanduskeskus.getHoidla()) {
                koikKulastajad += pood.getKylastajateArv();
            }
        }

        return koikKulastajad;
    }

    //Võimalda API otspunktist küsida kindlast kaubanduskeskusest etteantud ajal lahti olevaid poode
    @GetMapping("lahtiolevad-poed/{id}/{kellaaeg}")
    public List<Pood> lahtiolevadPoed(
            @PathVariable int id,
            @PathVariable int kellaaeg
    ) {
        List<Pood> lahtiolevadPoed = new ArrayList<>();

        Kaubanduskeskus kaubanduskeskus = findKaubanduskeskusById(id);

        if (kaubanduskeskus != null) {
            for (Pood pood : kaubanduskeskus.getHoidla()) {
                if (kellaaeg >= pood.getAvamiseAeg() && kellaaeg < pood.getSulgemiseAeg()) {
                    lahtiolevadPoed.add(pood);
                }
            }
        }
        return lahtiolevadPoed;
    }

    //Leiame id järgi kaubanduskeskuse
    private Kaubanduskeskus findKaubanduskeskusById(int id) {
        for (Kaubanduskeskus kaubanduskeskus : kaubanduskeskusteList) {
            if (kaubanduskeskus.getId() == id) {
                return kaubanduskeskus;
            }
        }
        return null;
    }
//Võimalda API otspunkti kaudu välja näidata numbrit, mitu külastust on tehtud kaubanduskeskusesse kindlal tunnil
// (andes sisendiks API otspunktilt selle tunni).
    @GetMapping("kylastuste-arv/{id}/{tund}")
    public int kylastusteArv(
            @PathVariable int id,
            @PathVariable int tund
    ) {
        int kylastusteArv = 0;

        Kaubanduskeskus kaubanduskeskus = findKaubanduskeskusById(id);

        if (kaubanduskeskus != null) {
            for (Pood pood : kaubanduskeskus.getHoidla()) {
                if (tund >= pood.getAvamiseAeg() && tund < pood.getSulgemiseAeg()) {
                    kylastusteArv += pood.getKylastajateArv();
                }
            }
        }
        return kylastusteArv;
    }
}
