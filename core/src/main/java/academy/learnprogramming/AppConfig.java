package academy.learnprogramming;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "academy.learnprogramming")
public class AppConfig {

    // == Bean Methods ==

    @Bean
    public MessageGenerator messageGenerator(){
        return new MessageGeneratorImpl();
    }


    @Bean
    public NumberGenerator numberGenerator() {
        return new NumberGeneratorImpl();
    }

    @Bean
    public Game game () {
        return new GameImpl();
    }
}
