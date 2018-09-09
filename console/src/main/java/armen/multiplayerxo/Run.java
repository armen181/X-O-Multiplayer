package armen.multiplayerxo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Slf4j
@Component
public class Run {

    GameService gameService;

    @Autowired
    public Run(GameService gameService) {
        this.gameService = gameService;
    }

    @EventListener
    public void start(ContextRefreshedEvent contextRefreshedEvent) {
        log.info("App was stared");
        gameService.startGame("Armen").print();
        Scanner scanner = new Scanner(System.in);

        String sess = scanner.nextLine();

        gameService.joinGame(sess,"Narek").print();

        gameService.checkGame(sess).print();
        scanner.nextLine();
        String ids = scanner.nextLine();
        gameService.setValue(ids,sess, 1,1).print();
        ids = scanner.nextLine();
    }
}
