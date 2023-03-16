import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(aritKeskmine(3,4,5));
        System.out.println(aritKeskmine(4,5,6));
        System.out.println(aritKeskmine(5,5,6));

        double[] sisend = {3,4,5,6};
        System.out.println(Arrays.toString(libisevKeksmine(sisend)));

        LibisevKeskmine libisev = new LibisevKeskmine(2,3,4);
        libisev.lisaArv(4);
        System.out.println(libisev.arvudKeskmisega);
    }

    private static double aritKeskmine(double arv1, double arv2, double arv3){
        return (arv1 + arv2 + arv3) / 3;

    }

    //* Koosta funktsioon massiivi libiseva keskmise leidmiseks. Väljundiks on massiiv, mis on sisendist kahe elemendi
    // võrra lühem ning mille iga elemendi väärtuseks on sisendmassiivi vastava elemendi ning
    // selle järgmise ja ülejärgmise elemendi keskmine.
    //4,4,5,5,6,7,8,9


    private static double[] libisevKeksmine(double[] arvud) {
        double[] valjund = new double[arvud.length - 2]; //kui teen uue array, siis pean pikkuse ütlema kohe
        for (int i = 0; i < arvud.length-2; i++) {
            valjund[i] = (arvud[i] + arvud[i+1] + arvud[i+2]) / 3;
        }
        return valjund;
    }
}