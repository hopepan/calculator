package com.hopegroup.education.calculator.maths.grade4;

public class Multiplication {

    private int first;

    private int second;

    public Multiplication(int first, int second) {
        this.first = first;
        this.second = second;
    }

    public String generate() {
        int max = Math.max(first, second);
        int len = String.valueOf(max).length();
        String formatter = "%" + len + "d";
        return new StringBuilder()
                .append(String.format(formatter, first))
                .append(" X ")
                .append(String.format(formatter, second))
                .append(" =          ").toString();
    }
}
