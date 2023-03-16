import java.util.ArrayList;
import java.util.List;

public class LibisevKeskmine {

    List<Double> arvudListis = new ArrayList<>();
    List<Double> arvudKeskmisega = new ArrayList<>();
    public LibisevKeskmine(double arv1, double arv2, double arv3) {
        arvudListis.add(arv1);
        arvudListis.add(arv2);
        arvudListis.add(arv3);
    }

    public void lisaArv(double arv){
        arvudListis.add(arv);
        //arraylisti puhul size, array puhul length
        //kui pole varem midagi lisatud, siis arvudKeskmisega suurus 0
        for (int i = arvudKeskmisega.size(); i < arvudListis.size()-2; i++) {
            double keskmine = (arvudListis.get(i) + arvudListis.get(i+1) + arvudListis.get(i+2)) / 3;
            arvudKeskmisega.add(keskmine);
        }
        /*double[] valjund = new double[arvud.length - 2]; //kui teen uue array, siis pean pikkuse ütlema kohe
        for (int i = 0; i < arvud.length-2; i++) {
            valjund[i] = (arvud[i] + arvud[i+1] + arvud[i+2]) / 3;
        }
        return valjund;*/
    }
}
