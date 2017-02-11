package main;

/**
 * Created by amritkar on 2/9/2017.
 */
public class OddNumberTest implements IObjectTest {
    public boolean test(Object o) {
        final Integer i = (Integer)o;
        return i%2==1;
    }
}
