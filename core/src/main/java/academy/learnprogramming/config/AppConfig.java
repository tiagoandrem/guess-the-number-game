package academy.learnprogramming.config;

import academy.learnprogramming.*;
import org.springframework.context.annotation.*;

@Configuration
@Import(GameConfig.class)
@ComponentScan(basePackages = "academy.learnprogramming")
public class AppConfig {

    // == Bean Methods ==

    @Bean
    public Game game () {
        return new GameImpl();
    }

    @Bean
    public MessageGenerator messageGenerator(){
        return new MessageGeneratorImpl();
    }


}
