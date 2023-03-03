import org.w3c.dom.ls.LSOutput;

public class Main {
    public static void main(String[] args) {
        Automyyk auto1 = new Automyyk("Merette", "123ABC");
        Automyyk auto2 = new Automyyk("Anna", "123ABD");
        Automyyk auto3 = new Automyyk("Mari", "123ABF");

        String omanikuVahetus = auto1.autoVahetabOmanikku("Kati");
        System.out.println(omanikuVahetus);

        auto2.autoMyyakseMaha();

        auto3.kasAutoMyydud();

    }


}