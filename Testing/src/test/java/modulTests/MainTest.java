package modulTests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
   Main main;

   @BeforeEach
   void setUp(){
       main = new Main();
   }
    @Test
    public void testCalcSystem(){

       assertEquals(Double.NaN, Main.calcSystem(0));
       assertEquals(Double.NaN, Main.calcSystem(180));
       assertEquals(Double.NaN, Main.calcSystem(240));
       assertEquals(16.49638336728371, Main.calcSystem(1.7));
       assertEquals(-3.858407346410207, Main.calcSystem(1));
       assertEquals(2.476495956915243, Main.calcSystem(2));
    }



    @Test
    public void  testSteps(){
       assertEquals(5, Main.steps(2,1,10));
       assertEquals(10, Main.steps(1,1,10));
       assertEquals(241, Main.steps(0.005,0.8,2));
    }


    @Test
    public void testArgumentArrayFiller() {
        double[] array = Main.argumentArrayFiller();
        assertEquals(1.6999999999999853, array[180]);
        assertEquals(1.999999999999979 , array[240]);
        assertEquals(0.8, array[0]);
    }

    @Test
    public void testFunctionArrayFiller() {
        double[] array = Main.functionArrayFiller();
        assertEquals(6.657057440154581, array[180]);
        assertEquals(2.4764959569152367 , array[240]);
        assertEquals(-8.92688070170253, array[0]);
    }

    @Test
    public void testGetMaxIndex() {
       double[] arrY = Main.functionArrayFiller();
       double[] arrX = Main.argumentArrayFiller();
       assertEquals(240, Main.getMaxIndex(arrX));
       assertEquals(180, Main.getMaxIndex(arrY));

    }

    @Test
    public void testGetMinIndex() {
        double[] arrY = Main.functionArrayFiller();
        double[] arrX = Main.argumentArrayFiller();
        assertEquals(0, Main.getMinIndex(arrX));
        assertEquals(0, Main.getMinIndex(arrY));
    }

    @Test
    public void testGetMaxElement() {
        double[] arrY = Main.functionArrayFiller();
        double[] arrX = Main.argumentArrayFiller();
        assertEquals(6.657057440154581, Main.getMaxElement(arrY));
        assertEquals(1.999999999999979, Main.getMaxElement(arrX));
    }

    @Test
    public void testGetMinElement() {
        double[] arrY = Main.functionArrayFiller();
        double[] arrX = Main.argumentArrayFiller();
        assertEquals(-8.92688070170253, Main.getMinElement(arrY));
        assertEquals(0.8, Main.getMinElement(arrX));
    }
}