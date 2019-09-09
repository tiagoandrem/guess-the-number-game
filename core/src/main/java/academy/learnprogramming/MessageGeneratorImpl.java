package academy.learnprogramming;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.spi.LoggerFactoryBinder;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

public class MessageGeneratorImpl implements MessageGenerator{

    // == Constants ==

        public static final Logger log = LoggerFactory.getLogger(MessageGeneratorImpl.class);


    // == Fields ==
    @Autowired
    private Game game;
    private int guessCount = 10;

    // == Init ==

    @PostConstruct
    public void init(){
        log.info("Game {}", game);
    }
    // == Public Methods ==
    @Override
    public String getMainMessage() {
        return "The Number is between: " + game.getSmallest() + "and " + game.getBiggest() + " Can you guess it?" ;
    }

    @Override
    public String getResultMessage() {

        if(game.isGameWon()){
            return "Congrats, you guess it, the number is " + game.getNumber();
        }else if(game.isGameLost()){
            return "You lost, the right number is" + game.getNumber();
        }else if (!game.isValidNumberRange()){
            return "Invalid Number Range";
        }else if(game.getRemainingGuesses() == guessCount){
            return "What is your first Guess?";
        }
        else{
            String direction = "Lower";
            if (game.getGuess() < game.getNumber())
                direction = "Higher";
            return direction + "You have" + game.getRemainingGuesses() + "Guesses remaining";

        }

    }
}
