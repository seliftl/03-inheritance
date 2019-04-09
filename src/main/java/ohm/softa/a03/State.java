package ohm.softa.a03;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class State {
    protected static final Logger logger = LogManager.getLogger();
    protected int t, duration;

    public State(int duration){
        this.duration=duration;
    }

    final State tick(Cat cat){
        t=t+1;

        if(duration < 1){
            return this;
        }

        if(t<duration){
            return this;
        }
        else {
            return this.successor(cat);
        }
    }

    public abstract State successor(Cat cat);
}
