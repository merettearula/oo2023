package ee.merette.loomaaed;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class LoomaaedListController {
    List<Loom> loomad = new ArrayList<>(Arrays.asList(
            new Loom(1,"Kaelkirjak", 8),
            new Loom(2, "Ninasarvik", 2),
            new Loom(3, "Karu", 5),
            new Loom(4, "Zebra", 1)

    ));

    @GetMapping("loomad")
    public List<Loom> saaLoomad(){

        return loomad;
    }

    @DeleteMapping("kustuta-loom/{index}")
    public List<Loom> kustutaLoom(@PathVariable int index){
        loomad.remove(index);
        return loomad;
    }

    @PostMapping("lisa-loom")
    public List<Loom> lisaLoomURLParameetritega(
            @RequestParam int id,
            @RequestParam String nimi,
            @RequestParam int vanus) {
        loomad.add(new Loom(id, nimi, vanus));
        return loomad;
    }


}
