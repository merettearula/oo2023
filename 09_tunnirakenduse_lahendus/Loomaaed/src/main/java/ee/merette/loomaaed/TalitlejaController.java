package ee.merette.loomaaed;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class TalitlejaController {
    List<Loom> loomadeList = Arrays.asList(new Loom(6, "Tiiger", 8), new Loom(7, "Jõehobu", 12), new Loom(8, "Jääkaru", 2));
    List<Loom> loomadeList1 = Arrays.asList(new Loom(10, "Elevant", 3), new Loom(11, "Panter", 2), new Loom(12, "Kits", 3));

    Talitleja talitleja1 = new Talitleja("Merette", loomadeList);
    Talitleja talitleja2 = new Talitleja("Mark", loomadeList1);

    List<Talitleja>  talitlejateList = new ArrayList<>(Arrays.asList(talitleja1, talitleja2));

    @GetMapping("saa-talitleja-loomad/{nimi}")
    public List<Loom> saaTalitlejaLoomad(
            @PathVariable String nimi){
//
        for (int i = 0; i < talitlejateList.size(); i++) {
            if(talitlejateList.get(i).getNimi().equals(nimi)){
                return talitlejateList.get(i).getVoimalikudLoomad();
            } else {
                System.out.println("Talitlejat ei leitud");
            }

        }
        System.out.println("Talitlejat ei leitud");
        return Arrays.asList();
    }

    @DeleteMapping ("kustuta-talitleja/{nimi}")
    public List<Talitleja> kustutaTalitlejaLoom(
            @PathVariable String nimi) {
        for (int i = 0; i < talitlejateList.size(); i++) {
            if(talitlejateList.get(i).getNimi().equals(nimi)){
                talitlejateList.remove(i);
                return talitlejateList;
            } else {
                System.out.println("Talitlejat ei leitud");
            }

        }
        return null;
    }

    @PostMapping("lisa-talitleja")
    public List<Talitleja> lisaTalitleja(
            @RequestBody Talitleja talitleja
    ) {
        talitlejateList.add(talitleja);
        return talitlejateList;
    }
}
