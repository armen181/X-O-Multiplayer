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
    public void initOrReset() {

        XOForm xo = new XOForm(0, 0);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                xos[i][j] = xo;
            }
        }
        game = new GameForm(xos, "", "", "", "", "", 0, 0);

    }

    @Override
    public GameForm startGame(String name) {
        initOrReset();
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
    public void addId(String id) {

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
            }
            return game;
        }if(checkId(id)==2 && game.getSide()==2) {
            if(game.getGame()[y][x].getValue()!=1) {
                XOForm[][] set = game.getGame();
                set[y][x] = new XOForm(1, 2);
                game.setGame(set);
                game.setSide(1);
            }
            return game;
        }

        return null;
    }
}
