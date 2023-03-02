public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        String vaataArvu = paarisVoiPaaritu(12);
        String vaataArvu2 = paarisVoiPaaritu(15);
        System.out.println(vaataArvu);
        System.out.println(vaataArvu2);

        vaiksemArv(4.0,7.0);
        vaiksemArv(8.0,3.0);

        int korrutis1 = korrutaKolmArvu(4,5,6);
        int korrutis2 = korrutaKolmArvu(8,1,4);
        System.out.println(korrutis1);
        System.out.println(korrutis2);
    }

    //korrutame kolm sisestatud arvu omavahel
    private static int korrutaKolmArvu(int number1, int number2, int number3) {
        return number1*number2*number3;
    }

    //vaatame kumb sisestatud arvudest on väiksem
    private static void vaiksemArv(double arv, double arv2) {
        if (arv < arv2) {
            System.out.println("esimene arv on väiksem");
        } else {
            System.out.println("teine arv on väiksem");
        }
    }
    //vaatame kas sisestatud arv on paaritu või paaris
    private static String paarisVoiPaaritu(int arv) {
        if (arv % 2 == 0) {
            return "arv on paaris";
        } else {
            return "arv on paaritu";
        }
    }

}
