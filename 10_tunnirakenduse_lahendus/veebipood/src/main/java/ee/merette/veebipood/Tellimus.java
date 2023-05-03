package ee.merette.veebipood;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Tellimus {
    @Id
    private int id;

    //oneToOne -> isik ja kontaktandmed
    @ManyToOne
    private Isik tellija;
    @ManyToMany
    private List<Toode> tooted;
}
