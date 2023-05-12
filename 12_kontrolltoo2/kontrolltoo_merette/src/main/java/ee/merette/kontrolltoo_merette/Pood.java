package ee.merette.kontrolltoo_merette;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Pood {
    @Id
    private Long id;
    private String nimetus;
    private int avamiseAeg;
    private int sulgemiseAeg;
    private int kylastajateArv;
}