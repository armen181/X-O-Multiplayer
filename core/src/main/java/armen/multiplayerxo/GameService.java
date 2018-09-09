package armen.multiplayerxo;

import armen.multiplayerxo.forms.XOForm;

public interface GameService {

     void initOrReset();

     String startGame(int mode);

     boolean checkGame(int[][] array);

     void addId(String id);

     int checkId(String id);

     String generateId();

     String generateSession();

     XOForm[][] setValue(String id, int x, int y);




}
