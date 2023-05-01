package ee.merette.loomaaed;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoomController {
    Loom loom = new Loom(6, "Tiiger", 8);

    @GetMapping("loom")
    public Loom saaLoom(){
        return loom;
    }

    @GetMapping("kustuta-loom")
    public Loom kustutaLoom() {
        loom = null;
        return loom;
    }

    @GetMapping("suurenda-vanust")
    public Loom suurendaVanust(){
        loom.setVanus( loom.getVanus()+1);
        return loom;
    }
}
