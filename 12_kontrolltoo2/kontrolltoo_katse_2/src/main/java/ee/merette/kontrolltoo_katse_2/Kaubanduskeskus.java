package ee.merette.kontrolltoo_katse_2;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Kaubanduskeskus {
    private int id;
    private String nimetus;
    private List<Pood> hoidla;

    public List<Pood> getHoidla() {
        return hoidla;
    }
}
