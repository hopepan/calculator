package com.hopegroup.education.calculator.maths.grade4;

import java.util.function.Supplier;

public class Oral {

    private static int columns = 4;

    public static void main(String[] args) {
        int len2X2 = 15;
        Supplier<String> mul3X2 = Oral::digit3XDigit2;
        Supplier<String> mul2X2 = Oral::digit2XDigit2;
        System.out.println(output(len2X2, columns, mul2X2));
        System.out.println();
        System.out.println();
        System.out.println(output(len2X2, columns, mul3X2));


    }

    private static String output(int len, int columns, Supplier<String> stringSupplier) {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<len/columns; i++) {
            for(int j=0; j<columns; j++) {
                sb.append(stringSupplier.get() + "            ");
            }
            sb.append("\n");
        }
        for(int i=0; i<len%columns; i++) {
            sb.append(stringSupplier.get() + "            ");
        }
        return sb.toString();
    }

    private static String digit3XDigit2() {
        int a = GenerateFactor.generate2Digit();
        int b = GenerateFactor.generate3Digit();

        Multiplication m = new Multiplication(a, b);
        return m.generate();
    }

    private static String digit2XDigit2() {
        int a = GenerateFactor.generate2Digit();
        int b = GenerateFactor.generate2Digit();

        Multiplication m = new Multiplication(a, b);
        return m.generate();
    }
}
