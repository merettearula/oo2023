import java.util.ArrayList;
import java.util.List;

/*Koosta uus klass, kus on toiduainete listid ning kus saab toiduaineid objektide kaudu lisada ja kustutada,
 nime järgi andmeid vaadata ning rasvaprotsendivahemiku järgi otsida.*/
public class ToiduaineList {
    public List<Toiduaine> toiduained = new ArrayList<Toiduaine>();

    public void lisameToiduaine(String nimetus, double valgud, double rasvad, double susivesikud) {
        Toiduaine toiduaine = new Toiduaine(nimetus, valgud, rasvad, susivesikud);
        toiduained.add(toiduaine);
    }

    public void kustutaToiduaine(String nimi) {
        for (int i = 0; i < toiduained.size(); i++) {
            if (toiduained.get(i).nimetus.equals(nimi)) {
                Toiduaine eemaldatudToiduaine = toiduained.remove(i);
                System.out.println(eemaldatudToiduaine.nimetus + " eemaldatud");
                break;
            }
        }
    }

    public List<Toiduaine> otsinRasvaProtsendiJargi(double minRasvaprotsent, double maxRasvaprotsent) {
        List<Toiduaine> leitudToiduained = new ArrayList<Toiduaine>();

        for (int i = 0; i < toiduained.size(); i++) {
            if (toiduained.get(i).rasvad >= minRasvaprotsent && toiduained.get(i).rasvad <= maxRasvaprotsent) {
                leitudToiduained.add(toiduained.get(i));
            }
        }
        return leitudToiduained;

    }
}

