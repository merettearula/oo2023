package ee.merette.kontrolltoo_katse_2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class PoodController {

    List<Pood> poodideList = Arrays.asList(new Pood(1, "Loomapood", 9, 18, 14),
            new Pood(2, "Rimi", 8, 22, 25),
            new Pood(3, "Kullapood", 10, 18, 4));


    //localhost:8080/lisa-pood?id=1&nimetus=Loomapood&avamiseAeg=9&sulgemiseAeg=18&kylastajateArv=14
    @GetMapping("kas-pood-lahti/{kellaaeg}")
    public String kasPoodLahti(
            @RequestParam int kellaaeg
    ) {
        for(Pood pood : poodideList) {
            int avamiseAeg = pood.getAvamiseAeg();
            int sulgemiseAeg = pood.getSulgemiseAeg();
            if (kellaaeg >= avamiseAeg && kellaaeg < sulgemiseAeg) {
                return "Pood on sel ajal avatud";
            } else {
                return "Pood on sel ajal suletud";
            }
        }

    }
}