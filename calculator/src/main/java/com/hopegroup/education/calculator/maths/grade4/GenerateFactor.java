package com.hopegroup.education.calculator.maths.grade4;

public class GenerateFactor {

    public static int generate3Digit() {
        int max=1000,min=100;
        return (int) (Math.random()*(max-min)+min);
    }

    public static int generate2Digit() {
        int max=100,min=10;
        return (int) (Math.random()*(max-min)+min);
    }

    public static int generate1Digit() {
        int max=10,min=2;
        return (int) (Math.random()*(max-min)+min);
    }

    public static int generateRandomDigit() {
        int max = 1000, min = 2;
        return (int) (Math.random()*(max-min)+min);
    }

    public static void main(String[] args) {
        for(int i=0; i<10; i++){
            System.out.println(generate1Digit());
            System.out.println(generate2Digit());
            System.out.println(generate3Digit());
        }
    }
}
