import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Automaattest {
    @Test
    public void kontrolli_kolmnurga_ymbermoot(){
        Kolmnurk kolmnurk = new Kolmnurk(3, 5.0, 6, 8);
        assertEquals(19.0, kolmnurk.arvutaYmbermoot(), 0.0);
    }
}
