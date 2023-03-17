/*


 * Koosta uus klass, kus on toiduainete listid ning kus saab toiduaineid objektide kaudu lisada ja kustutada,
 nime järgi andmeid vaadata ning rasvaprotsendivahemiku järgi otsida.
 Koosta lisamise, arvutamise, otsimise ja kustutamise kontrollimiseks automaattest.

 * Koosta klass toidu jaoks (nimetus, toidukomponendid).
 Toidule käsklused küsimaks sisalduvate valkude, rasvade ja süsivesikute kogust.
 Loo retsepti järgi toit (nt. kartulisalat), küsi salatis leiduvate toitainete kogused.
 Koosta klass, kus näidatakse valitud toidu etteantud koguse (nt. 5 kg kartulisalati) jaoks vajalikud toiduained.
 Kontrolli automaattestiga arvutuste õigsust.
*/

public class Main {
    public static void main(String[] args) {
        Toidukomponent toidukomponent1 = new Toidukomponent(new Toiduaine("juust", 25, 30, 45), "100g");
        Toiduaine kartul = new Toiduaine("kartul", 5,15, 80);
        Toiduaine hapukoor = new Toiduaine("hapukoor", 15,30, 60);
        Toiduaine vorst = new Toiduaine("vorst", 25,30, 45);


        String kartulUleSaja = kartul.uleSaja();
        String hapukoorUleSaja = hapukoor.uleSaja();
        String vorstUleSaja = vorst.uleSaja();
        System.out.println(kartul.nimetus + ": " + kartulUleSaja);
        System.out.println(hapukoor.nimetus + ": " + hapukoorUleSaja);
        System.out.println(vorst.nimetus + ": " + vorstUleSaja);


    }

}