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
            new Pood(4, "Riidepood", 10, 18, 14),
            new Pood(5, "Selver", 8, 22, 26),
            new Pood(6, "Taimepood", 10, 18, 4));
    private List<Kaubanduskeskus> kaubanduskeskusteList = Arrays.asList(
            new Kaubanduskeskus(1, "Lõunakas", poodideListLounakas),
            (new Kaubanduskeskus(2, "Kaubamaja", poodideListKaubamaja)));

    //Tee API otspunkti kaudu kokkuarvutus, kui palju on selles kaubanduskeskuses kõiki poode kokku külastatud

    //localhost:8080/koik-kulastajad/1
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

    //localhost:8080/lahtiolevad-poes/1/8
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

    //localhost:8080/kylastuste-arv/2/12
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

    //Tee teine API otspunkt, mis tagastab kõige külastatavama poe selles tunnis.

    //localhost:8080/koige-kylastatav-pood/2/8
    @GetMapping("koige-kylastatav-pood/{id}/{kellaaeg}")
    public Pood koigeKylastatumPood(
            @PathVariable int id,
            @PathVariable int kellaaeg
    ){
        Pood koigeKylastatumPood = null;
        int maksimaalneKylastajateArv = 0;
        Kaubanduskeskus kaubanduskeskus = findKaubanduskeskusById(id);

        for (Pood pood : kaubanduskeskus.getHoidla()){
            if (kellaaeg >= pood.getAvamiseAeg() && kellaaeg < pood.getSulgemiseAeg()){
                if (pood.getKylastajateArv() > maksimaalneKylastajateArv) {
                    maksimaalneKylastajateArv = pood.getKylastajateArv();
                    koigeKylastatumPood = pood;
                }
            }

        }
        return koigeKylastatumPood;
    }

    //Tee kolmas API otspunkt, mis tagastab kõige külastatavama kaubanduskeskuse selles tunnis.
    @GetMapping("koige-kylastatav-kaubanduskeskus/{kellaaeg}")
    public String koigeKylastatumPood(
            @PathVariable int kellaaeg
    ){
        Kaubanduskeskus koigeKylastatumKaubanduskeskus = null;
        int maksimaalneKylastajateArv = 0;


        for (Kaubanduskeskus kaubanduskeskus : kaubanduskeskusteList) {
            int kylastusteArv = 0;

            for (Pood pood : kaubanduskeskus.getHoidla()) {
                if (kellaaeg >= pood.getAvamiseAeg() && kellaaeg < pood.getSulgemiseAeg()) {
                    kylastusteArv += pood.getKylastajateArv();
                }
                if (kylastusteArv > maksimaalneKylastajateArv) {
                    maksimaalneKylastajateArv = kylastusteArv;
                    koigeKylastatumKaubanduskeskus = kaubanduskeskus;
                }
            }
        }
        if (koigeKylastatumKaubanduskeskus != null) {
            return koigeKylastatumKaubanduskeskus.getNimetus() + " on kõige külastatum kaubanduskeskus, kus on " +
                    maksimaalneKylastajateArv + " külastajat";
        } else {
            return "Ühtegi kaubanduskeskust ei leitud";
        }

    }
}
