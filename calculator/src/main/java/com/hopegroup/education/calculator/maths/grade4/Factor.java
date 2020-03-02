package com.hopegroup.education.calculator.maths.grade4;

public enum Factor {

    Multiplication("x", 0, "乘法"),
    Addition("+", 1, "加法"),
    Substraction("-", 2, "减法"),
    Division("÷", 1, "除法");

    private String value;

    private int type;

    private String desc;

    Factor(String value, int type, String desc) {
        this.value = value;
        this.type = type;
        this.desc = desc;
    }

    public String getValue() {
        return value;
    }

    public int getType() {
        return type;
    }

    public String getDesc() {
        return desc;
    }

    public static Factor getFactor(int type) {
        Factor factor = null;
        switch (type) {
            case 0:
                factor = Multiplication;
                break;
            case 1:
                factor = Addition;
                break;
            case 2:
                factor = Substraction;
                break;
            case 3:
                factor = Division;
                break;
            default:
                factor = Multiplication;
        }
        return factor;
    }
}
