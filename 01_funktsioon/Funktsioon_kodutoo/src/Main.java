public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        printForCycle(5);
        printForCycle(10);
        String hinnang = temperatuuriHinnang(-2.5);
        String hinnang2 = temperatuuriHinnang(5.7);
        System.out.println(hinnang);
        System.out.println(hinnang2);
        
        double summa = arvutaTaksoMaksumus(3.5);
        double summa2 = arvutaTaksoMaksumus(1.2);
        System.out.println(summa);
        System.out.println(summa2);
    }

    private static String temperatuuriHinnang(double temp) {
        String hinnang;
        if (temp < 0) {
            return "on jääs";
        } else {
            return "on vesi";
        }
    }

    private static double arvutaTaksoMaksumus(double tunnid) {
        return 3+0.8*tunnid;
    }

    private static void printForCycle(int kordadeArv) {
        for (int i = 0; i < kordadeArv; i++) {
            System.out.println(i);

        }
    }
}