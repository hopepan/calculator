package com.hopegroup.education.calculator.maths.grade4;

import java.util.*;
import java.util.function.Function;

public class Oral {

    private static List<Integer> answers = new ArrayList<>();

    public static void main(String[] args) {
        generateDoc();

    }

    private static void generateDoc() {
        final int THREE_WITH_TWO = 1;
        final int TWO_WITH_ONE = 2;
        final int TWO_WITH_TWO = 3;
        final int THREE_WITH_ONE = 4;
        final int len = 8;
        final int columns = 4;
        final boolean random = false;
        final Integer[] t = {
                TWO_WITH_ONE,
                TWO_WITH_ONE,
                TWO_WITH_TWO,
                TWO_WITH_TWO,
                THREE_WITH_TWO,
                THREE_WITH_TWO,
                TWO_WITH_TWO,
                THREE_WITH_TWO,
                THREE_WITH_ONE,
                THREE_WITH_TWO
        };
        final Factor[] o = {
                Factor.Multiplication,
                Factor.Division,
                Factor.Addition,
                Factor.Substraction,
                Factor.Addition,
                Factor.Substraction,
                Factor.Multiplication,
                Factor.Multiplication,
                Factor.Division,
                Factor.Division
        };
        final int randomLen = 10;

        List<Integer> types;
        List<Factor> operators;
        if(random) {
            types = new ArrayList<>(randomLen);
            operators = new ArrayList<>(randomLen);
            for(int i=0; i<randomLen; i++) {
                types.add(generateType());
                operators.add(getOperator());
            }
        } else {
            types = Arrays.asList(t);
            operators = Arrays.asList(o);
        }

        final Function<Factor, String> threeWithTwo = Oral::digit3WithDigit2;
        final Function<Factor, String> twoWithOne = Oral::digit2WithDigit1;
        final Function<Factor, String> twoWithTwo = Oral::digit2WithDigit2;
        final Function<Factor, String> threeWithOne = Oral::digit3WithDigit1;

        final Map<Integer, Function<Factor, String>> typesMap = new HashMap<>();
        typesMap.put(1, threeWithTwo);
        typesMap.put(2, twoWithOne);
        typesMap.put(3, twoWithTwo);
        typesMap.put(4, threeWithOne);

        System.out.println("起始时间___________  结束时间_______________  错题数____________  完成日期______________");
        for (int i=0; i<types.size(); i++) {
            System.out.println("计算下列"  + operators.get(i).getDesc() + "算式");
            System.out.println(output(len, columns, typesMap.get(types.get(i)), operators.get(i)));
        }

        System.out.println(outputAnswer(len, columns));
    }

    private static String outputAnswer(int len, int columns) {
        StringBuilder sb = new StringBuilder();
        int k = 0;
        int size = answers.size();
        for(int i=0; i<size/columns; i++) {
            for(int j=0; j<columns; j++) {
                sb.append(answers.get(k++)).append("        ");
                if(k % len == 0) {
                    sb.append("\n");
                }
            }
            sb.append("\n");
        }
        for(int i=0; i<size%columns; i++) {
            sb.append(answers.get(k++));
        }
        return sb.toString();
    }

    private static String output(int len, int columns, Function<Factor, String> stringFunction, Factor operator) {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<len/columns; i++) {
            for(int j=0; j<columns; j++) {
                sb.append(stringFunction.apply(operator));
            }
            sb.append("\n");
        }
        for(int i=0; i<len%columns; i++) {
            sb.append(stringFunction.apply(operator));
        }
        return sb.toString();
    }

    private static String digit3WithDigit2(Factor operator) {
        int a = GenerateFactor.generate3Digit();
        int b = GenerateFactor.generate2Digit();

        if(Factor.Division.equals(operator)) {
            a = divide(b, 3);
        }

        Calculation m = new Calculation(a, operator, b);
        answers.add(m.getAnswer());
        return m.getOutput();
    }

    private static String digit3WithDigit1(Factor operator) {
        int a = GenerateFactor.generate3Digit();
        int b = GenerateFactor.generate1Digit();

        if(Factor.Division.equals(operator)) {
            a = divide(b, 3);
        }

        Calculation m = new Calculation(a, operator, b);
        answers.add(m.getAnswer());
        return m.getOutput();
    }

    private static String digit2WithDigit2(Factor operator) {
        int a = GenerateFactor.generate2Digit();
        int b = GenerateFactor.generate2Digit();

        if(Factor.Division.equals(operator)) {
            a = divide(b, 2);
        } else if(Factor.Substraction.equals(operator)) {
            a = substract(a, b);
        }

        Calculation m = new Calculation(a, operator, b);
        answers.add(m.getAnswer());
        return m.getOutput();
    }

    private static String digit2WithDigit1(Factor operator) {
        int a = GenerateFactor.generate2Digit();
        int b = GenerateFactor.generate1Digit();

        if(Factor.Division.equals(operator)) {
            a = divide(b, 2);
        }

        Calculation m = new Calculation(a, operator, b);
        answers.add(m.getAnswer());
        return m.getOutput();
    }

    private static int divide(int b, int len) {
        int a;
        int c = 0;
        do {
            c = GenerateFactor.generateRandomDigit();
            a = b * c;
        } while (a < Math.pow(10, len-1) || a > Math.pow(10, len));
        return a;
    }

    private static int substract(int a, int b) {
        int c = a;
        int len = String.valueOf(a).length();
        while (c < b) {
            if(len == 1) {
                c = GenerateFactor.generate1Digit();
            } else if(len == 2) {
                c = GenerateFactor.generate2Digit();
            } else if(len == 3) {
                c = GenerateFactor.generate3Digit();
            }
        }
        return c;
    }

    private static int generateType() {
        int max=5,min=1;
        return (int) (Math.random()*(max-min)+min);
    }

    private static Factor getOperator() {
        int len = Factor.values().length;
        int type = GenerateFactor.generate2Digit() % len;
        return Factor.getFactor(type);
    }
}
