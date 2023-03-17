

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Toiduaine kartul = new Toiduaine("kartul", 5,15, 80);
        Toidukomponent toidukomponent1 = new Toidukomponent(kartul, 100);
        Toiduaine hapukoor = new Toiduaine("hapukoor", 15,30, 60);
        Toiduaine vorst = new Toiduaine("vorst", 25,30, 45);

        Toidukomponent toidukomponent2 = new Toidukomponent(vorst, 14);

        ToiduaineList toidulist1 = new ToiduaineList();
        List<Toidukomponent> komponendid = new ArrayList<Toidukomponent>();

        //komponentide list
        komponendid.add(new Toidukomponent(vorst, 100));
        komponendid.add(new Toidukomponent(hapukoor, 50));
        komponendid.add(new Toidukomponent(kartul,25));
        Toit kartulisalat = new Toit("kartulisalat", komponendid, 1);

        System.out.println(kartulisalat.leiaToiduaineKogus("vorst"));
        System.out.println(kartulisalat.annaValgudRasvadSysivesikud(""));

        System.out.println(toidukomponent1.tagastaRasvaKogus(kartul));
        System.out.println(toidukomponent2.tagastaRasvaKogus(vorst));

        toidulist1.lisameToiduaine("kõrvits", 5,15, 80);
        toidulist1.lisameToiduaine("kommid", 29,15, 23);
        toidulist1.lisameToiduaine("õlu", 29,10, 43);
        toidulist1.lisameToiduaine("hapukoor", 15,30, 60);
        toidulist1.kustutaToiduaine("hapukoor");

        //ToiduaineList toidulist2 = new ToiduaineList();
        List<Toiduaine> leitudToiduained = toidulist1.otsinRasvaProtsendiJargi(10,15);
        for (int i = 0; i < leitudToiduained.size(); i++) {
            System.out.println("Leitud toiduained rasvaprotsendi vahemikus " + leitudToiduained.get(i).nimetus);
        }


    }

}