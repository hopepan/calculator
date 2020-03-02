package com.hopegroup.education.calculator.maths.grade4;

public class Calculation {

    private int first;

    private int second;

    private Factor operator;

    private String output;

    private int answer;

    public Calculation(int first, Factor operator, int second) {
        this.first = first;
        this.second = second;
        this.operator = operator;

        this.output = generate();
        this.answer = answer();
    }

    private String generate() {
        int max = Math.max(first, second);
        int len = String.valueOf(max).length();
        String formatter = "%" + len + "d";
        String str = new StringBuilder()
                .append(String.format(formatter, first))
                .append(" ")
                .append(operator.getValue())
                .append(" ")
                .append(String.format(formatter, second))
                .append(" = ").toString();
        return String.format("%-20s", str);
    }

    private int answer() {
        int answer = -1;
        switch (operator) {
            case Addition:
                answer = first + second;
                break;
            case Substraction:
                answer = first - second;
                break;
            case Multiplication:
                answer = first * second;
                break;
            case Division:
                answer = first / second;
                break;
        }
        return answer;
    }

    public int getFirst() {
        return first;
    }

    public int getSecond() {
        return second;
    }

    public Factor getOperator() {
        return operator;
    }

    public String getOutput() {
        return output;
    }

    public int getAnswer() {
        return answer;
    }
}
