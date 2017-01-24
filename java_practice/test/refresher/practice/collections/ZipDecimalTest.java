package refresher.practice.collections;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import refresher.practice.helpers.LogIt;

import static org.junit.Assert.*;

/**
 * Created by clif on 1/15/17.
 */
public class ZipDecimalTest {

    private ZipDecimal zipper;
    private LogIt logger;

    @Before
    public void setUp() throws Exception {
        zipper = new ZipDecimal();
        logger = new LogIt(ZipDecimal.class.getName());
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void initialized(){
        Assert.assertNotNull(zipper);
        Assert.assertNotNull(logger);
    }

    @Test
    public void testEqualValue(){
        int A = 53;
        int B = 53;
        Assert.assertEquals(zipper.zipIt(A, B),5533);
    }

    @Test
    public void testUnequalValues(){
        int A = 567;
        int B = 1234;
        Assert.assertEquals(zipper.zipIt(A, B),5162734);

        A = 1234;
        B = 567;
        Assert.assertEquals(zipper.zipIt(A, B),1526374);
    }

    @Test
    public void testSingleValues(){
        int A = 1;
        int B = 2;
        Assert.assertEquals(zipper.zipIt(A, B),12);
    }

    @Test
    public void testMaximumSize(){
        int A = 99999;
        int B = 9999;
        Assert.assertEquals(zipper.zipIt(A, B),999999999);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testExceedsMaximumSize(){
        int A = 999999999;
        int B = 999999999;
        Assert.assertEquals(zipper.zipIt(A, B),-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNegativeArgument(){
        int A = -99999;
        int B = 9999;
        Assert.assertEquals(zipper.zipIt(A, B),-1);
    }



}