package armen.multiplayerxo.forms;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Getter
@Setter
public class XOForm {

    private int value;
    private int side;
    private String id;
    private String gameSession;
    private String name;

    public XOForm(int value, int side, String id, String gameSession, String name) {
        this.value = value;
        this.side = side;
        this.id = id;
        this.gameSession = gameSession;
        this.name = name;
    }
}
