public class Tavatoode extends Toiduaine implements Management{
    String nimetus;

    String tyyp;

    public Tavatoode(String kood, String nimetus, String tyyp) {
        super(kood);
        this.nimetus = nimetus;
        this.tyyp = tyyp;
    }

    @Override
    public String getKategooria() {
        if(kood.substring(5,7).equals("TT")){
            return "Tavatoode";
        } else {
            return "Ei ole tavatoode";
        }
    }

    @Override
    public String getTemperatuur() {
        if (kood.substring(1, 3).equals("00")) {
            return "Temperatuurivahemik on: 0 kuni +" + kood.substring(3, 5) + " kraadi";
        } else {
            return "Temperatuurivahemik on: +" + kood.substring(1, 3) + " kuni +" + kood.substring(3, 5) + " kraadi";
        }
    }
}
