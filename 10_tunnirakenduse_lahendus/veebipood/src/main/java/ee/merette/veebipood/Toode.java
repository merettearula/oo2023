package ee.merette.veebipood;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity //andmebaasitabeliks kuulutamine/defineerimine
public class Toode { //andmebaasi nimi on klassi nimi
    @Id //primaarvõtmega
    private int id; //standard panna andmebaasi ID long
    private String nimi;
    private double hind;

}
