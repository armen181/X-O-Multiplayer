package armen.multiplayerxo.forms;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GameForm {

    private XOForm[][] game;
    private String idForFirst;
    private String idForSecond;
    private String sessionId;
    private String nameForFirst;
    private String nameForSecond;
    private int side;
    private int gameEnded;

    public GameForm(XOForm[][] game, String idForFirst, String idForSecond, String sessionId, String nameForFirst, String nameForSecond, int side, int gameEnded) {
        this.game = game;
        this.idForFirst = idForFirst;
        this.idForSecond = idForSecond;
        this.sessionId = sessionId;
        this.nameForFirst = nameForFirst;
        this.nameForSecond = nameForSecond;
        this.side = side;
        this.gameEnded = gameEnded;
    }

    public void print(){
        System.out.println("X0Y0_value = " + game[0][0].getValue() + " X0Y0_side = " + game[0][0].getSide() + " X1Y0_value = " + game[0][1].getValue() + " X1Y0_side = " + game[0][1].getSide() +" X2Y0_value = " + game[0][2].getValue() + " X2Y0_side = " + game[0][2].getSide());
        System.out.println(" ");
        System.out.println("X0Y1_value = " + game[1][0].getValue() + " X0Y1_side = " + game[1][0].getSide() + " X1Y1_value = " + game[1][1].getValue() + " X1Y1_side = " + game[1][1].getSide() +" X2Y1_value = " + game[1][2].getValue() + " X2Y1_side = " + game[1][2].getSide());
        System.out.println(" ");
        System.out.println("X0Y2_value = " + game[2][0].getValue() + " X0Y2_side = " + game[2][0].getSide() + " X1Y2_value = " + game[2][1].getValue() + " X1Y2_side = " + game[2][1].getSide() +" X2Y2_value = " + game[2][2].getValue() + " X2Y2_side = " + game[2][2].getSide());
        System.out.println(" ");
        System.out.println("Side 1 name = " + nameForFirst);
        System.out.println("Side 2 name = " + nameForSecond);
        System.out.println("Side 1 ID = " + idForFirst);
        System.out.println("Side 2 ID = " + idForSecond);
        System.out.println("Session ID = " + sessionId);
        System.out.println("Who will Set =  " + (side==1?"Side 1": side==2?"Side 2":"Game note started"));
        System.out.println("Games status = " + (gameEnded!=0?"Game Ended": "Game not Ended"));



    }
}
