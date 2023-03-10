public class Arvuti {
    Info info;
    double maksumus;

    public Arvuti(Info info, int maksumus) {
        this.info = info;
        this.maksumus = maksumus;
    }

    public void seadistaInfo(Info info) {
        this.info = info
    };

    public void suurendaMaksumus(int kuiPalju) {
        this.maksumus = this.maksumus + kuiPalju;
    }
    public void paneDollaritesse() {
        this.maksumus = this.maksumus * 1.1;
    }

    public void muudaRami() {

    }

    public String kysiOpSysteemi(){
        return opSysteem;
    }
}
