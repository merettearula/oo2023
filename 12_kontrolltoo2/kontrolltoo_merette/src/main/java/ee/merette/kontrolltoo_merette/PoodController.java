package ee.merette.kontrolltoo_merette;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalTime;
import java.util.Date;
import java.util.List;

@RestController
public class PoodController {
    @Autowired
    PoodRepository poodRepository;

    //localhost:8080/lisa-pood?id=1&nimetus=Loomapood&avamiseAeg=9&sulgemiseAeg=18&kylastajateArv=14
    @GetMapping("lisa-pood")
    public List<Pood> lisaPood(
            @RequestParam Long id,
            @RequestParam String nimetus,
            @RequestParam int avamiseAeg,
            @RequestParam int sulgemiseAeg,
            @RequestParam int kylastajateArv
            ) {

        poodRepository.save(new Pood(id, nimetus, avamiseAeg,sulgemiseAeg, kylastajateArv));
        return poodRepository.findAll();

    }
}


