public class Auto {
    Info info;
    double maksumus;
    boolean myydud;

    public Auto(Info info, double maksumus, boolean myydud) {
        this.info = info;
        this.maksumus = maksumus;
        this.myydud = false;
    }

    public String muudaHinda(double hinnaSuurendus) {
        this.maksumus = this.maksumus + hinnaSuurendus;
        return "Uus hind on: "+this.maksumus;
    }

    public void autoMyyakseMaha(){
        this.myydud = true;
        System.out.println("Auto müüdud");
    }

}
