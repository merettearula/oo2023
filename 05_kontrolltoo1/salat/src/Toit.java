/*Koosta klass toidu jaoks (nimetus, toidukomponendid).
  Toidule käsklused küsimaks sisalduvate valkude, rasvade ja süsivesikute kogust.
  Loo retsepti järgi toit (nt. kartulisalat), küsi salatis leiduvate toitainete kogused.
  Koosta klass, kus näidatakse valitud toidu etteantud koguse (nt. 5 kg kartulisalati) jaoks vajalikud
  toiduained.
 */

import java.util.List;

public class Toit {
    String nimetus;
    List<Toidukomponent> toidukomponent;
    double toiduKogusKilogramm;

    public Toit(String nimetus, List<Toidukomponent> toidukomponent, double toiduKogusKilogramm) {
        this.nimetus = nimetus;
        this.toidukomponent = toidukomponent;
        this.toiduKogusKilogramm = toiduKogusKilogramm;
    }

    public double leiaToiduaineKogus(String otsitavToiduaine) {
        for (int i = 0; i < toidukomponent.size(); i++) {
            Toidukomponent komponent = toidukomponent.get(i);
            if (komponent.toiduaine.nimetus.equals(otsitavToiduaine)) {
                return komponent.kogus;
            }
        }
        return 0.0;
    }

    public double annaValgudRasvadSysivesikud(){
        double summa = 0.0;
        for (int i = 0; i < toidukomponent.size(); i++) {
            Toidukomponent toiduainekomplekt = toidukomponent.get(i);
            double rasvad = toiduainekomplekt.tagastaRasvaKogus(toiduainekomplekt.toiduaine);
            double valgud = toiduainekomplekt.tagastaValguKogus(toiduainekomplekt.toiduaine);
            double susivesikud = toiduainekomplekt.susivesikuteKogus(toiduainekomplekt.toiduaine);
            summa += rasvad + valgud + susivesikud;
    }
        return summa;
}

}
