import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AutomaatTest {

    @Test
    public void kontrolli_kas_on_sugavkulma_toode_kui_alguses_on_skt(){
        SygavkylmaToode toode = new SygavkylmaToode("SKT110306", "Tere", "jook");
        assertEquals("Sügavkülmiku toode", toode.getKategooria());
    }
    @Test
    public void kontrolli_kas_on_kylmiku_toode_kui_alguses_on_kt(){
        KylmikuToode toode2 = new KylmikuToode("KT210004", "toode", "tootetüüp");
        assertEquals("Külmiku toode", toode2.getKategooria());
    }

    @Test
    public void kontrolli_kas_on_tavatoode_kui_lopus_on_tt(){
        Tavatoode toode3 = new Tavatoode("20424TT", "toode", "tootetüüp");
        assertEquals("Tavatoode", toode3.getKategooria());
    }

    @Test
    public void kontrolli_kas_temperatuur_on_miinus_24_kuni_18_kraadi(){
        SygavkylmaToode toode4 = new SygavkylmaToode("SKT22418", "külmtoode", "külmtoode");
        assertEquals("Temperatuurivahemik on: -24 kuni -18 kraadi", toode4.getTemperatuur());
    }

    @Test
    public void kontrolli_kas_temperatuur_on_pluss_3_kuni_6_kraadi(){
        KylmikuToode toode5 = new KylmikuToode("KT110306", "külmikutoode", "külmiku toode");
        assertEquals("Temperatuurivahemik on: +03 kuni +06 kraadi", toode5.getTemperatuur());
    }

    @Test
    public void kontrolli_kas_temperatuur_on_0_kuni_24_kraadi(){
        Tavatoode toode6 = new Tavatoode("10024TT", "tavatoode", "tava toode");
        assertEquals("Temperatuurivahemik on: 0 kuni +24 kraadi", toode6.getTemperatuur());
    }
}
