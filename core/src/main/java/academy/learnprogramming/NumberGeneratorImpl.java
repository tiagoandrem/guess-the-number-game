package academy.learnprogramming;

import org.springframework.stereotype.Component;

import java.util.Random;


public class NumberGeneratorImpl implements NumberGenerator {

    // Fields
    private final Random random = new Random();

    public int maxNumber = 100;

    //Public methods
    @Override
    public int next() {
        return random.nextInt(maxNumber);
    }

    @Override
    public int getMaxNumeber() {
        return maxNumber;
    }
}
