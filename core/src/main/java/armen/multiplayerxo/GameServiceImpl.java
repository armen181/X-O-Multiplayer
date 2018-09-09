package armen.multiplayerxo;

import armen.multiplayerxo.forms.XOForm;
import lombok.extern.slf4j.Slf4j;

import java.util.Random;

@Slf4j
public class GameServiceImpl implements GameService {

    private XOForm[][] game = new XOForm[3][3];
    private String idForFirst = "";
    private String idForSecond = "";
    private String sessionId = "";
    private String nameForFirst = "";
    private String nameForSecond = "";
    Random random = new Random();
    private int idLength = 15;

    @Override
    public void initOrReset() {
        XOForm xo = new XOForm(0,0 ,"","","");
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                game[i][j]=xo;
            }
        }
        idForFirst="";
        idForSecond="";
    }

    @Override
    public XOForm startGame(int mode, String name) {
           if(mode==1) {
               initOrReset();
               idForFirst = generateId();
               sessionId = generateSession();
               XOForm ret = new XOForm(0, 0, idForFirst, sessionId, name);

               return ret;
           }else if(mode==2){





           }
    }


    @Override
    public boolean checkGame(int[][] array) {
        return false;
    }

    @Override
    public void addId(String id) {

    }

    @Override
    public int checkId(String id) {
        return 0;
    }

    @Override
    public String generateId() {

        String idForReturn = "";
        for(int i=0;i<idLength;i++){
            char letter =(char)(random.nextInt(74)+48);
            idForReturn += String.valueOf(letter);
        }
        return idForReturn;
    }

    @Override
    public String generateSession() {

        String sessionForReturn = "";
        for(int i=0;i<idLength;i++){
            char letter =(char)(random.nextInt(74)+48);
            sessionForReturn += String.valueOf(letter);
        }
        return sessionForReturn;
    }

    @Override
    public XOForm[][] setValue(String id, int x, int y) {
        return new XOForm[0][];
    }
}
