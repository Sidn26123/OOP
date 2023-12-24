
package view.family;

import view.calculator.*;

class CalculatorServiceFamily {
    private double num1;
    private double num2;
    private char mathSymbol;

    public char getMathSymbol() {
        return mathSymbol;
    }

    public void setMathSymbol(char mathSymbol) {
        this.mathSymbol = mathSymbol;
    }


    public void setNum1(double num1) {
        this.num1 = num1;
    }

    public void setNum2(double num2) {
        this.num2 = num2;
    }

    public double add(){
        return this.num1 + this.num2;
    }

    public double subtract(){
        return this.num1 - this.num2;
    }

    public double multiply(){
        return this.num1 * this.num2;
    }

    public double divide(){
        if(num2 != 0){
            double num = this.num1/this.num2;
            return Math.round(num * 10.0) / 10.0;
        }
        return 0;
    }
}
