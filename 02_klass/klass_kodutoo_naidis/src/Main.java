import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Kasutaja merette1 = new Kasutaja("merette1", "merette", "merette.arula@gmail.com",
                "merette", "arula");
        Kasutaja merette2 = new Kasutaja("merette", "merette", "merette.arula@gmail.com",
                "merette", "arula");
        Kasutaja merette3 = new Kasutaja("merette", "merette", "merette.arula@gmail.com",
                "merette", "arula");

        String prindiKustutamine = merette1.kustutaKasutaja();
        System.out.println(prindiKustutamine);

        merette1.muudaParool("mermer");

        Tellimus tellimus1 = new Tellimus("Merette", Arrays.asList("Coca", "Fanta"));
        Tellimus tellimus2 = new Tellimus("Merette", Arrays.asList("Coca", "Fanta"));
        Tellimus tellimus3 = new Tellimus("Merette", Arrays.asList("Coca", "Fanta"));

        tellimus2.muudaMakstuks();
        tellimus1.kasOnMakstud();
    }
}