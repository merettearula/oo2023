package ee.merette.loomaaed;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Loom {
    private int id;
    private String nimetus;
    private int vanus;
}
