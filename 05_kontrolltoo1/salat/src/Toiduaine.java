
/* Koosta klass toiduaine tarbeks (nimetus, valkude, rasvade ja süsivesikute protsent).
   Protsent kokku ei saa ületada 100 - muidu antakse veateade. Loo mõni toiduaine (nt. kartul, hapukoor, vorst).*/
public class Toiduaine {
    String nimetus;
    double valgud;
    double rasvad;
    double susivesikud;

    public Toiduaine(String nimetus, double valgud, double rasvad, double susivesikud) {
        this.nimetus = nimetus;
        this.valgud = valgud;
        this.rasvad = rasvad;
        this.susivesikud = susivesikud;
        if (this.valgud + this.rasvad + this.susivesikud > 100) {
            System.out.println(this.nimetus + ": " + "protsentide summa ei tohi ületada 100!");
        } else {
            System.out.println(this.nimetus + ": " + "toiduaine on sobilik!");
        }
    }

}
