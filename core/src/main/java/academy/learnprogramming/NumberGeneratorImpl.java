package academy.learnprogramming;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Random;


@Component
public class NumberGeneratorImpl implements NumberGenerator {

    // Fields
    private final Random random = new Random();
    @Getter
    private final int maxNumber;
    @Getter
    private final int minNumber;

    // == Constructor AutoWired ==
    @Autowired
    public NumberGeneratorImpl(@MaxNumber int maxNumber, @MinNumber int minNumber) {
        this.maxNumber = maxNumber;
        this.minNumber = minNumber;
    }

    //Public methods
    @Override
    public int next() {
        return random.nextInt(maxNumber - minNumber) + minNumber;
    }

}
