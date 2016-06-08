package org.openjdk.jcstress.tests;

import org.openjdk.jcstress.annotations.Actor;
import org.openjdk.jcstress.annotations.Description;
import org.openjdk.jcstress.annotations.Expect;
import org.openjdk.jcstress.annotations.JCStressTest;
import org.openjdk.jcstress.annotations.Outcome;
import org.openjdk.jcstress.infra.results.IntResult2;

public class ReorderingWithVolatileTest {
    @org.openjdk.jcstress.annotations.State
    public static class State extends StateHolder {
    }

    @JCStressTest
    @Description("Test correctness of observing state of two values one of which is volatile.")
    @Outcome(id = "[0, 0]", expect = Expect.ACCEPTABLE, desc = "T1 doesn't set any values for both variables, T2 observes only initial int values.")
    @Outcome(id = "[50, 100]", expect = Expect.ACCEPTABLE, desc = "T1 successfully set new values for both variables, T2 observes successfully observes new values.")
    @Outcome(id = "[50, 0]", expect = Expect.ACCEPTABLE, desc = "T1 successfully set new value for the first variable,  T2 observes observes new value of the first variable and initial value of the second variable.")
    @Outcome(id = "[0, 100]", expect = Expect.ACCEPTABLE, desc = "T1 sets new value for the second variable because reordering was occurred, first variable holds initial value, T2 observes new value of the second variable and initial value of the first one.")
    public static class ReorderingWithVolatile {
        @Actor
        public void actor1(State s) {
            s.setValues();
        }

        @Actor
        public void actor2(State s, IntResult2 r) {
            r.r1 = s.getA();
            r.r2 = s.getB();
        }
    }
}

class StateHolder {
    private volatile int a = 0;
    private int b = 0;

    public void setValues() {
        a = 50;
        b = 100;
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }
}