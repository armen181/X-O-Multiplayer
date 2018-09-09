package armen.multiplayerxo.forms;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class XOForm {

    private int value;
    private int side;


    public XOForm(int value, int side) {
        this.value = value;
        this.side = side;

    }

    @Override
    public String toString() {
        return "Value = " + value + " Side = " + side ;
    }
}
