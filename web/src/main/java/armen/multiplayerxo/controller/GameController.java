package armen.multiplayerxo.controller;



import armen.multiplayerxo.GameService;
import armen.multiplayerxo.forms.GameForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class GameController {


    // == field ==


    private GameService gameService;


    private boolean status = false;
    private boolean use50_50 = false;


    // == constructor ==
    @Autowired
    public GameController(GameService gameService) {
        this.gameService = gameService;
    }


    // === RQ ===
    @PostMapping("startGame")
    public GameForm startGame(@RequestHeader String name) {

        return gameService.startGame(name);
    }

    @PostMapping("joinGame")
    public GameForm joinGame(@RequestHeader String sessionId,@RequestHeader String name) {

        return gameService.joinGame(sessionId,name);
    }

    @PostMapping("set")
    public GameForm set(@RequestHeader String id, @RequestHeader String sessionId,@RequestHeader int y,@RequestHeader int x) {

        return gameService.setValue(id,sessionId,x,y);
    }
    @PostMapping("get")
    public GameForm get(@RequestHeader String id,@RequestHeader String sessionId) {

        return gameService.checkGame(sessionId,id);
    }

    @PostMapping("reset")
    public GameForm reset (@RequestHeader String id,@RequestHeader String sessionId) {

        gameService.reset();
        return gameService.checkGame(sessionId,id);
    }


//    @PostMapping("setValue")
//    public SudokuForm[][] getQuestion(@RequestHeader int x, @RequestHeader int y, @RequestHeader int value) {
//        return gameService.setAnswer(x, y, value);
//    }
//
//    @PostMapping("reset")
//    public SudokuForm[][] init(@RequestHeader int mode) {
//        gameService.init();
//        gameService.generate();
//        return gameService.getPlayableMatrix(mode);
//    }
//
//    @GetMapping("end")
//    public SudokuForm[][] end() {
//        gameService.init();
//        SudokuForm sudokuForm = new SudokuForm(0,false,true);
//        SudokuForm[][]  array = new SudokuForm[][] {{sudokuForm,sudokuForm,sudokuForm,sudokuForm,sudokuForm,sudokuForm,sudokuForm,sudokuForm,sudokuForm},{sudokuForm,sudokuForm,sudokuForm,sudokuForm,sudokuForm,sudokuForm,sudokuForm,sudokuForm,sudokuForm},{sudokuForm,sudokuForm,sudokuForm,sudokuForm,sudokuForm,sudokuForm,sudokuForm,sudokuForm,sudokuForm},{sudokuForm,sudokuForm,sudokuForm,sudokuForm,sudokuForm,sudokuForm,sudokuForm,sudokuForm,sudokuForm},{sudokuForm,sudokuForm,sudokuForm,sudokuForm,sudokuForm,sudokuForm,sudokuForm,sudokuForm,sudokuForm},{sudokuForm,sudokuForm,sudokuForm,sudokuForm,sudokuForm,sudokuForm,sudokuForm,sudokuForm,sudokuForm},{sudokuForm,sudokuForm,sudokuForm,sudokuForm,sudokuForm,sudokuForm,sudokuForm,sudokuForm,sudokuForm},{sudokuForm,sudokuForm,sudokuForm,sudokuForm,sudokuForm,sudokuForm,sudokuForm,sudokuForm,sudokuForm},{sudokuForm,sudokuForm,sudokuForm,sudokuForm,sudokuForm,sudokuForm,sudokuForm,sudokuForm,sudokuForm}};
//        return array;
//    }


}
