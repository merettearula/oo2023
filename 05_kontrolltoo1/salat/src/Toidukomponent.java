
/*Koosta klass toidukomponendi tarbeks (kogus, viit toiduainele).
        Loo mõned toidukomponendid (nt. 100 g kartuleid, 30 g hapukoort, 50 g vorsti).
        Lisa toidukomponendile käsklus selle sees leiduva rasvakoguse arvutamiseks.*/
public class Toidukomponent {

    Toiduaine toiduaine;
    double kogus;

    public Toidukomponent(Toiduaine toiduaine, double kogus) {
        this.toiduaine = toiduaine;
        this.kogus = kogus;
    }

    public double tagastaRasvaKogus(Toiduaine toiduaine) {
        double rasvaKogus = this.kogus * toiduaine.rasvad / 100;
        return rasvaKogus;
    }

    public double tagastaValguKogus(Toiduaine toiduaine) {
        double valguKogus = this.kogus * toiduaine.valgud / 100;
        return valguKogus;
    }
    public double susivesikuteKogus(Toiduaine toiduaine) {
        double susivesikuteKogus = this.kogus * toiduaine.susivesikud / 100;
        return susivesikuteKogus;
    }
}
