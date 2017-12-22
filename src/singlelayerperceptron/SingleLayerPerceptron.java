package singlelayerperceptron;

import com.rav.util.Perceptron;
import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author ravindu kaluarachchi
 */
public class SingleLayerPerceptron {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        double inputs[][] = generateRandom(0, 50,51,100, 3, 100);
        /*{
                    { 10,20,30},{ 15,25,33},{ 40,20,36},{ 13,20,31},{ 10,25,36},
                    { 60,70,80},{ 90,80,88},{ 60,80,90},{ 70,77,88},{ 67,88,83},
            
                    };*/
        double[] outputs = new double[100];
        for (int i = 0; i < 51; i++) {
            outputs[i] = 0;
        }
        for (int i = 51; i < 100; i++) {
            outputs[i] = 1;
        }
        double weights[] = { 0.5,0.5,0.5};
        Perceptron perceptron = new Perceptron(weights, 0.7);
        for (int i = 0; i < inputs.length; i++) {
            perceptron.train(inputs[i], outputs[i]);
        }
        
        System.out.println("0 > " + perceptron.process(new double[]{30,44,35}));
        System.out.println("0 > " + perceptron.process(new double[]{10,10,10}));
        System.out.println("0 > " + perceptron.process(new double[]{40,44,38}));
        System.out.println("1 > " + perceptron.process(new double[]{70,74,85}));
        System.out.println("1 > " + perceptron.process(new double[]{30,84,55}));
    }
    
    static double[][] generateRandom(double start1,double end1,double start2,double end2,int arrayLength,int dataSize){
        Random r = new Random();
        double[][] data = new double[dataSize][arrayLength];
        int i = 0;
        for (i = 0; i < dataSize/2; i++) {            
            double[] d = new double[arrayLength];
            for (int j = 0; j < arrayLength; j++) {
                d[j] = start1 + r.nextDouble() * (end1 - start1);
            }
            data[i] = d;
        }
        
        for (; i < dataSize; i++) {            
            double[] d = new double[arrayLength];
            for (int j = 0; j < arrayLength; j++) {
                d[j] = start2 + r.nextDouble() * (end2 - start2);
            }
            data[i] = d;
        }
        return data;
    }
    
     
}
