package com.rav.util;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author ravindu kaluarachchi
 */
public class Perceptron {

    /*private int NO_OF_INPUTS = 3;
    //private int NO_OF_TRAINING_INSTANCES_PER_INPUT = 100;
    private double[] inputs;*/
    private double[] weights;
    private double threshhold = 0.1;
    private double learningRate;

    public Perceptron(int noOfInputs,double learningRate) {
        this.weights = new double[noOfInputs];
        this.learningRate = learningRate;
    }
    
    public Perceptron(double[] weights,double learningRate) {
        this.weights = weights;
        this.learningRate = learningRate;
    }

    private double sum(double[] inputs) {
        double sum = 0;
        for (int i = 0; i < inputs.length; i++) {
            sum += inputs[i] * weights[i];
        }
        return sum;
    }

    private double transfer(double value) {
        System.out.println("transfer " + value);
        if (value > threshhold) {
            return 1;
        } else {
            return 0;
        }
    }
    
    private void updateWeights(double desiredOutput,double actualOutput){
        System.out.print(Arrays.toString(weights));
        for (int i = 0; i < weights.length; i++) {
          //  System.out.print(weights[i] + " + " + learningRate + " * " + " (" + desiredOutput + " - " + actualOutput + ")" + " * " + weights[i]);
            weights[i] = weights[i] + learningRate * (desiredOutput - actualOutput) * weights[i];
       //     System.out.println(" > " + weights[i]);
        }
       System.out.println(" --> " + Arrays.toString(weights));
    }
    
    public void train(double[] inputs,double desiredOutput){
        double output = process(inputs);
        updateWeights(desiredOutput, output);
    }
    
    public double process(double[] inputs){
        double sum = sum(inputs);
        double output = transfer(sum);
        return output;
    }
    
  
}

