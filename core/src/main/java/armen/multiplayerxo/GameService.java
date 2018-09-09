package armen.multiplayerxo;

import armen.multiplayerxo.forms.GameForm;
import armen.multiplayerxo.forms.XOForm;

public interface GameService {

     void initOrReset();

     GameForm startGame(String name);

     GameForm joinGame(String sessionId, String name);


     GameForm checkGame(String sessionId);

     void addId(String id);

     int checkId(String id);

     boolean checkSessionId(String id);

     String generateId();

     String generateSession();

     GameForm setValue(String id, String sessionId, int x, int y);




}
