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
    public void calcSystem(){

       assertEquals(Double.NaN, main.calcSystem(0));
       assertEquals(Double.NaN, main.calcSystem(180));
       assertEquals(Double.NaN, main.calcSystem(240));
        assertEquals(16.49638336728371, main.calcSystem(1.7));
        assertEquals(-3.858407346410207, main.calcSystem(1));
        assertEquals(2.476495956915243, main.calcSystem(2));
    }



    @Test
    public void  steps(){
       assertEquals(5, main.steps(2,1,10));
       assertEquals(10, main.steps(1,1,10));
       assertEquals(241, main.steps(0.005,0.8,2));
    }


    @Test
    public void argumentArrayFiller() {
        double[] array = Main.argumentArrayFiller();
        assertEquals(1.6999999999999853, array[180]);
        assertEquals(1.999999999999979 , array[240]);
        assertEquals(0.8, array[0]);
    }

    @Test
    public void functionArrayFiller() {
        double[] array = Main.functionArrayFiller();
        assertEquals(6.657057440154581, array[180]);
        assertEquals(2.4764959569152367 , array[240]);
        assertEquals(-8.92688070170253, array[0]);
    }

    @Test
    public void getMaxIndex() {
       double[] arrY = Main.functionArrayFiller();
       double[] arrX = Main.argumentArrayFiller();
       assertEquals(240, main.getMaxIndex(arrX));
       assertEquals(180, main.getMaxIndex(arrY));

    }

    @Test
    public void getMinIndex() {
        double[] arrY = Main.functionArrayFiller();
        double[] arrX = Main.argumentArrayFiller();
        assertEquals(0, main.getMinIndex(arrX));
        assertEquals(0, main.getMinIndex(arrY));
    }

    @Test
    public void getMaxElement() {
        double[] arrY = Main.functionArrayFiller();
        double[] arrX = Main.argumentArrayFiller();
        assertEquals(6.657057440154581, main.getMaxElement(arrY));
        assertEquals(1.999999999999979, main.getMaxElement(arrX));
    }

    @Test
    public void getMinElement() {
        double[] arrY = Main.functionArrayFiller();
        double[] arrX = Main.argumentArrayFiller();
        assertEquals(-8.92688070170253, main.getMinElement(arrY));
        assertEquals(0.8, main.getMinElement(arrX));
    }
}