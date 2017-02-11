package main;

/**
 * Created by amritkar on 2/9/2017.
 * This test checks if a number is Even. This can only intake integers
 */
public class EvenNumberTest implements IObjectTest {
    public boolean test(Object o) {
        final Integer i = (Integer)o;
        return i%2==0;
    }
}
