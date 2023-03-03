import java.util.Date;
import java.util.List;

public class Tellimus {
    Date tegemiseAeg;
    String tellija;

    List<String> tooted;

    boolean makstud;

    public Tellimus(String tellija, List<String> tooted) {
        this.tegemiseAeg = new Date();
        this.tellija = tellija;
        this.tooted = tooted;
        this.makstud = makstud;
    }

    public void muudaMakstuks() {
        makstud = true;
    }

    public boolean kasOnMakstud() {
        if (makstud) {
            return "Makstud!";
        } else {
            return "Maksmata!";
        }
        return makstud;

    }
}
