package edu.montana.esof322.homework.homework2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class Homework2 {

    static int invocationCount = 0;
    static StringBuilder output = new StringBuilder();

    // I Create Interface IDoAThing
    interface IDoAThing{
        void doIt();
    }

    static class ThingDoer implements IDoAThing{
        public void doIt() {
            output.append("Did it!\n");
        }
    }

    //create factory
    // Java naming conventions would be ThingDoerFactory (no points off)
    private static class ThingDoer_factory {
        public static IDoAThing create(){
            ThingDoer_proxy thingDoer = new ThingDoer_proxy(new ThingDoer());
            return thingDoer;
        }
    }

    // Java naming conventions would be ThingDoerProxy (no points off)
    static class ThingDoer_proxy implements IDoAThing{
        IDoAThing _proxied_object;

        public ThingDoer_proxy(IDoAThing proxied_object) {
            _proxied_object = proxied_object;
        }

        @Override
        public void doIt() {
            output.append("Did it!\n");
            invocationCount++;
        }
    }
    public void make_ThingDoer_proxy() {
        IDoAThing proxy = new ThingDoer_proxy(new ThingDoer());
    }
    //=======================================================================
    // Your boss wants to know how many times a method on a given class is
    // being invoked.  Your job is to take the the code above and refactor it
    // using some patterns to capture the needed information.
    //=======================================================================
    @Test
    void theAssignment() {
        // Step 1: extract an interface for ThingDoer, IDoAThing and
        //         replace the variable below with

        IDoAThing idat = new ThingDoer();

        // Step 2: replace this new expression with a factory to produce
        //         IDoAThings
        IDoAThing thingDoer = ThingDoer_factory.create();

        // Step 3: use the factory to insert a proxy object that wraps
        //         a ThingDoer and increments the invocationCount


        assertFalse(thingDoer instanceof ThingDoer);

        // do the thing a few times...
        thingDoer.doIt();
        thingDoer.doIt();
        thingDoer.doIt();

        // the proxy should have incremented the invocation count
        assertEquals(3, invocationCount);

        // output should still be the same since the proxy passed through
        // to the underlying ThingDoer
        assertEquals(output.toString(),
                "Did it!\nDid it!\nDid it!\n");
    }


}
