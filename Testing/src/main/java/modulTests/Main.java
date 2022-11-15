package modulTests;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
       new Main().run();
    }

    private void run() {
        System.out.println(calcSystem(1.5));
        System.out.println(steps(2,1,10));
        double[] arrY = Main.functionArrayFiller();
        double[] arrX = Main.argumentArrayFiller();
        System.out.println("Max index arrY: "+getMaxIndex(arrY));
        System.out.println("Max index arrX: "+getMaxIndex(arrX));
        System.out.println("Min index arrY: "+getMinIndex(arrY));
        System.out.println("Min index arrX: "+getMinIndex(arrX));
        System.out.println("Max element arrX: "+getMaxElement(arrX));
        System.out.println("Max element arrY: "+getMaxElement(arrY));
        System.out.println("Min element arrX: "+getMinElement(arrX));
        System.out.println("Min element arrY: "+getMinElement(arrY));
    }


    public static double calcSystem(double x) {
        double a = 1.5;
        if(x>=0.8&&x<1.7){
            return Math.PI*x*x - (7/(x*x));
        } else if (x == 1.7) {
            return a*x*x*x + 7*Math.sqrt(x);
        } else if (x >1.7 && x<=2  ) {
            return Math.log(x+7*Math.sqrt(x));
        } else if (x < 0.8) {
            System.out.println("Error! Too little number");
        } else if (x>2) System.out.println("Error! Too large number ");
        return Double.NaN;
    }

    public static double steps(double step, double start, double end){
        return (int)((end-start)/step)+1 ;
    }

    public static double[] argumentArrayFiller(){
        double[] argumentArr = new double[(int)steps(0.005, 0.8,2)];
        argumentArr[0] = 0.8;
        for (int i = 0; i < argumentArr.length-1; i++) {
           argumentArr[i+1]=argumentArr[i]+0.005;
        }
        return argumentArr;
    }

    public static double[] functionArrayFiller(){
        double[] functionArr = new double[(int) steps(0.005, 0.8,2)];
        double[] argumentArr = argumentArrayFiller();
        for (int i = 0;  i< argumentArr.length; i++) {
           functionArr[i] = calcSystem(argumentArr[i]);
        }
        return functionArr;
        }

        public static int getMaxIndex(double[] arr){
            int maxIndex = 0;
            for (int i = 0; i < arr.length; i++) {
                if(arr[i]> arr[maxIndex]) maxIndex = i;
            } return maxIndex;
        }

    public static int getMinIndex(double[] arr){
        int minIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] < arr[minIndex]){
                minIndex =  i;
            }
        } return minIndex;
    }

    public static double getMaxElement(double[] arr){
        Arrays.sort(arr);
        return arr[arr.length-1];
    }

    public static double getMinElement(double[] arr){
        Arrays.sort(arr);
        return arr[0];
    }

    }




