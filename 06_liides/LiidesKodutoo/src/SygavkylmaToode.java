public class SygavkylmaToode extends Toiduaine implements Management{
    String nimetus;

    String tyyp;

    public SygavkylmaToode(String kood, String nimetus, String tyyp) {
        super(kood);
        this.nimetus = nimetus;
        this.tyyp = tyyp;
    }

    @Override
    public String getKategooria() {
        if(kood.startsWith("SKT")){
            return "Sügavkülmiku toode";
        } else {
            return "Ei ole sügavkülmiku toode";
        }
    }

    @Override
    public String getTemperatuur() {
        return "Temperatuurivahemik on: -" + kood.substring(4,6) + " kuni -" + kood.substring(6,8) + " kraadi";
    }
}
