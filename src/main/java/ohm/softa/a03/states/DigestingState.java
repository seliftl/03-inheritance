package ohm.softa.a03.states;

import ohm.softa.a03.Cat;
import ohm.softa.a03.State;

public class DigestingState extends State {
    int remainingTime;
    public DigestingState(int duration, int remainingTime) {
        super(duration);
        this.remainingTime=remainingTime;
    }

    @Override
    public State successor(Cat cat) {
        if(remainingTime>duration) {
            logger.info("Getting in a playful mood!");
            return new PlayfulState(remainingTime - duration);
        }
        else {
            logger.info("I was fed too late");
            return new DeathState();
        }
    }
}
