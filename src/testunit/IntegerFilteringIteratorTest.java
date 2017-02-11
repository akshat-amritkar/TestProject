package testunit;

import main.FilteringIterator;
import main.IObjectTest;
import main.EvenNumberTest;
import main.OddNumberTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by amritkar on 2/9/2017.
 */
public class IntegerFilteringIteratorTest {

    private FilteringIterator myIterator;
    private IObjectTest myTest;
    private List<Integer> testList;

    @Before
    public void setup() {
        testList = Arrays.asList(10,33,44,50,21,13,32);
    }

    @After
    public void reset() {
        myIterator = null;
        myTest = null;
    }

    @Test
    public void testEvenNumber() {
        final List<Integer> compareList = new ArrayList<Integer>();
        final List<Integer> newList = new ArrayList<Integer>();
        for(int i=0; i<testList.size();i++) {
            if (testList.get(i)%2 == 0){
                compareList.add(testList.get(i));
            }
        }
        myTest = new EvenNumberTest();
        myIterator = new FilteringIterator(testList.iterator(), myTest);
        while (myIterator.hasNext()) {
            Integer element = (Integer) myIterator.next();
            newList.add(element);
        }
        Assert.assertTrue(compareList.equals(newList));
    }

    @Test
    public void testOddNumbers() {
        final List<Integer> compareList = new ArrayList<Integer>();
        final List<Integer> newList = new ArrayList<Integer>();
        for(int i=0; i<testList.size();i++) {
            if (testList.get(i)%2 == 1){
                compareList.add(testList.get(i));
            }
        }
        myTest = new OddNumberTest();
        myIterator = new FilteringIterator(testList.iterator(), myTest);
        while (myIterator.hasNext()) {
            Integer element = (Integer) myIterator.next();
            newList.add(element);
        }
        Assert.assertTrue(compareList.equals(newList));
    }
}
