package academy.learnprogramming.console;

import academy.learnprogramming.config.AppConfig;
import academy.learnprogramming.Game;
import academy.learnprogramming.MessageGenerator;
import academy.learnprogramming.NumberGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        log.info("The guessing number game");

        //Create context (container)
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        //Get number generator bean from context(container)
        NumberGenerator numberGenerator = context.getBean( NumberGenerator.class);

        //call next() method
        int number = numberGenerator.next();

        log.info("number = {}", number);

        //Get String generator bean from context(container)
        MessageGenerator messageGenerator = context.getBean(MessageGenerator.class);

        String string = messageGenerator.getMainMessage();
        String string1 = messageGenerator.getResultMessage();

        log.info("String = {}", string );
        log.info("String = {}", string1);

        //get game bean from context(container)
        Game game = context.getBean(Game.class);

        // close context (container)
        context.close();
    }
}
