public class KylmikuToode extends Toiduaine implements Management{
    String nimetus;

    String tyyp;

    public KylmikuToode(String kood, String nimetus, String tyyp) {
        super(kood);
        this.nimetus = nimetus;
        this.tyyp = tyyp;
    }


    @Override
    public String getKategooria() {

        if(kood.startsWith("KT")){
            return "Külmiku toode";
        } else {
            return "Ei ole külmiku toode";
        }
    }

    @Override
    public String getTemperatuur() {
        if(kood.charAt(3) == '0'){
            return "Temperatuurivahemik on: -" + kood.substring(4,6) + " kuni -" + kood.substring(6,8) + " kraadi";
        }
        else if(kood.charAt(3) == '1'){
            if (kood.substring(4, 6).equals("00")) {
                return "Temperatuurivahemik on: 0 kuni +" + kood.substring(6, 8) + " kraadi";
            } else {
                return "Temperatuurivahemik on: +"  + kood.substring(4,6) + " kuni +" + kood.substring(6,8) + " kraadi";
            }
        } else {
            return "Vigane kood";
        }
    }
}
