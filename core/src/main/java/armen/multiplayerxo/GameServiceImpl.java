package armen.multiplayerxo;

import armen.multiplayerxo.forms.GameForm;
import armen.multiplayerxo.forms.XOForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Random;

@Slf4j
@Service
public class GameServiceImpl implements GameService {

    private GameForm game;
    private XOForm[][] xos = new XOForm[3][3];
    private String nameForFirst = "";
    private String nameForSecond = "";
    Random random = new Random();
    private int idLength = 15;
    private int sessionLength = 4;

    @Override
    public void init() {

        XOForm xo = new XOForm(0, 0);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                xos[i][j] = xo;
            }
        }
        game = new GameForm(xos, "", "", "", "", "", 0, 0);

    }

    @Override
    public void reset() {

        XOForm xo = new XOForm(0, 0);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                xos[i][j] = xo;
            }
        }
        game.setGame(xos);
    }
    @Override
    public GameForm startGame(String name) {
        init();
        game.setNameForFirst(name);
        game.setIdForFirst(generateId());
        game.setSessionId(generateSession());
        //game.setSide(1);
        return game;
    }


    @Override
    public GameForm joinGame(String sessionId, String name) {
        if (checkSessionId(sessionId)) {
            game.setNameForSecond(name);
            game.setIdForSecond(generateId());
            game.setSide(1);
            return game;
        }
        return null;
    }


    @Override
    public GameForm checkGame(String sessionId,String id) {
    if(checkId(id)>0&&checkSessionId(sessionId))
        return game;
    return null;
    }

    @Override
    public int checkGame(GameForm gameForm) {
        XOForm[][] xo =  gameForm.getGame();
        if(xo[0][0].getSide()==1&&xo[0][1].getSide()==1&&xo[0][2].getSide()==1)
            return 1;
        if(xo[1][0].getSide()==1&&xo[1][1].getSide()==1&&xo[1][2].getSide()==1)
            return 1;
        if(xo[2][0].getSide()==1&&xo[2][1].getSide()==1&&xo[2][2].getSide()==1)
            return 1;
        if(xo[0][0].getSide()==1&&xo[1][0].getSide()==1&&xo[2][0].getSide()==1)
            return 1;
        if(xo[0][1].getSide()==1&&xo[1][1].getSide()==1&&xo[2][1].getSide()==1)
            return 1;
        if(xo[0][2].getSide()==1&&xo[1][2].getSide()==1&&xo[2][2].getSide()==1)
            return 1;


        if(xo[0][2].getSide()==2&&xo[1][1].getSide()==2&&xo[2][0].getSide()==2)
            return 2;
        if(xo[0][0].getSide()==2&&xo[1][1].getSide()==2&&xo[2][2].getSide()==2)
            return 2;
        if(xo[0][0].getSide()==2&&xo[0][1].getSide()==2&&xo[0][2].getSide()==2)
            return 2;
        if(xo[1][0].getSide()==2&&xo[1][1].getSide()==2&&xo[1][2].getSide()==2)
            return 2;
        if(xo[2][0].getSide()==2&&xo[2][1].getSide()==2&&xo[2][2].getSide()==2)
            return 2;
        if(xo[0][0].getSide()==2&&xo[1][0].getSide()==2&&xo[2][0].getSide()==2)
            return 2;
        if(xo[0][1].getSide()==2&&xo[1][1].getSide()==2&&xo[2][1].getSide()==2)
            return 2;
        if(xo[0][2].getSide()==2&&xo[1][2].getSide()==2&&xo[2][2].getSide()==2)
            return 2;
        if(xo[0][2].getSide()==2&&xo[1][1].getSide()==2&&xo[2][0].getSide()==2)
            return 2;
        if(xo[0][0].getSide()==2&&xo[1][1].getSide()==2&&xo[2][2].getSide()==2)
            return 2;

        for(int i=0;i<3;i++){

            for(int j=0;j<3;j++){
                if(xo[i][j].getValue()!=1)
                    return 0;
            }
        }
        return 3;

    }

    @Override
    public boolean checkSessionId(String id) {
        return game.getSessionId().equals(id);
    }

    @Override
    public int checkId(String id) {
        if(game.getIdForFirst().equals(id)){
            return 1;
        }else if(game.getIdForSecond().equals(id)){
            return 2;
        }
        return 0;
    }

    @Override
    public String generateId() {

        String idForReturn = "";
        for (int i = 0; i < idLength; i++) {
            char letter = (char) (random.nextInt(74) + 48);
            idForReturn += String.valueOf(letter);
        }
        return idForReturn;
    }

    @Override
    public String generateSession() {

        String sessionForReturn = "";
        for (int i = 0; i < sessionLength; i++) {
            char letter = (char) (random.nextInt(10) + 48);
            sessionForReturn += String.valueOf(letter);
        }
        return sessionForReturn;
    }

    @Override
    public GameForm setValue(String id, String sessionId, int x, int y) {
        if(checkId(id)==1 && game.getSide()==1) {
            if(game.getGame()[y][x].getValue()!=1) {

                XOForm[][] set = game.getGame();
                set[y][x] = new XOForm(1, 1);
                game.setGame(set);
                game.setSide(2);
                game.setGameEnded(checkGame(game));
            }
            return game;
        }if(checkId(id)==2 && game.getSide()==2) {
            if(game.getGame()[y][x].getValue()!=1) {
                XOForm[][] set = game.getGame();
                set[y][x] = new XOForm(1, 2);
                game.setGame(set);
                game.setSide(1);
                game.setGameEnded(checkGame(game));
            }
            return game;
        }

        return null;
    }
}
