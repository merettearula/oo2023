import java.util.Date;

public class Automyyk {
    String omanik;
    String autoNumbriMark;
    boolean myydud;
    Date myymiseAeg;

    public Automyyk(String omanik, String autoNumbriMark) {
        this.omanik = omanik;
        this.autoNumbriMark = autoNumbriMark;
        this.myydud = false;
        this.myymiseAeg = null;
    }

    public void autoMyyakseMaha(){
        this.myydud = true;
        this.myymiseAeg = new Date();
    }

    public String autoVahetabOmanikku(String uusOmanik){
        this.omanik = uusOmanik;
        return "Autol uus omanik "+uusOmanik;
    }

    public void kasAutoMyydud(){
        if(myydud) {
            System.out.println("Auto juba müüdud");
        } else {
            System.out.println("Auto pole veel müüdud");
        }
    }
}
