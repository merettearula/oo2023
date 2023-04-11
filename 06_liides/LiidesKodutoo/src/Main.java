public class Main {
    public static void main(String[] args) {
        //kood, 1 toode, 1 näitab et + , 03-06 kraadi
        KylmikuToode piim = new KylmikuToode("KT110306", "Tere", "jook");
        KylmikuToode kohuke = new KylmikuToode("KT210004", "Kassikohuke", "magustoit");


        //lõpus on kas + v -
        SygavkylmaToode jaatis = new SygavkylmaToode("SKT12418", "Limpa", "magustoit");
        SygavkylmaToode pelmeenid = new SygavkylmaToode("SKT22418", "Pealinna pelmeenid", "soolane");


        Tavatoode riis = new Tavatoode("10024TT", "sõmer", "kuivaine");
        Tavatoode tatar = new Tavatoode("20424TT", "Hea tatar", "kuivaine");

        System.out.println("Piim: ");
        System.out.println(piim.getTemperatuur());
        System.out.println(piim.getKategooria());
        System.out.println("Kohuke: ");
        System.out.println(kohuke.getTemperatuur());
        System.out.println(kohuke.getKategooria());
        System.out.println("Jäätis: ");
        System.out.println(jaatis.getTemperatuur());
        System.out.println(jaatis.getKategooria());
        System.out.println("Pelmeenid: ");
        System.out.println(pelmeenid.getTemperatuur());
        System.out.println(pelmeenid.getKategooria());
        System.out.println("Riis: ");
        System.out.println(riis.getKategooria());
        System.out.println(riis.getTemperatuur());
        System.out.println("Tatar: ");
        System.out.println(tatar.getKategooria());
        System.out.println(tatar.getTemperatuur());

    }
}