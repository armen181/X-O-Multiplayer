package armen.multiplayerxo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Run {

    @EventListener
    public void start(ContextRefreshedEvent contextRefreshedEvent) {
        log.info("App was stared");

    }
}
