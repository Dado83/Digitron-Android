package es.hol.fairplay.digitron;

import android.widget.TextView;

import java.math.BigDecimal;

/**
 * Created by Dado on 27.12.2016.
 */

public class Model {
    private double numA = 0;
    private char operand = 'x';

    public void setDouble(){
        numA = 0;
    }

    public char getOperand(){
        return operand;
    }

    public void plus(double i, TextView t, TextView l) {
        l.setText(t.getText() + "+");
        numA = i;
        BigDecimal bd = new BigDecimal(numA);
        bd = bd.setScale(2, BigDecimal.ROUND_HALF_EVEN);
        numA = bd.doubleValue();
        operand = '+';
        t.setText("");
    }

    public void minus(double i, TextView t, TextView l) {
        l.setText(t.getText() + "-");
        numA = i;
        BigDecimal bd = new BigDecimal(numA);
        bd = bd.setScale(2, BigDecimal.ROUND_HALF_EVEN);
        numA = bd.doubleValue();
        operand = '-';
        t.setText("");
    }

    public void multi(double i, TextView t, TextView l) {
        l.setText(t.getText() + "*");
        numA = i;
        BigDecimal bd = new BigDecimal(numA);
        bd = bd.setScale(2, BigDecimal.ROUND_HALF_EVEN);
        numA = bd.doubleValue();
        operand = '*';
        t.setText("");
    }

    public void divide(double i, TextView t, TextView l) {
        l.setText(t.getText() + "/");
        numA = i;
        BigDecimal bd = new BigDecimal(numA);
        bd = bd.setScale(2, BigDecimal.ROUND_HALF_EVEN);
        numA = bd.doubleValue();
        operand = '/';
        t.setText("");
    }

    public double squareRoot(double i, TextView l, TextView t) {
        numA = Math.sqrt(i);
        BigDecimal bd = new BigDecimal(numA);
        bd = bd.setScale(2, BigDecimal.ROUND_HALF_EVEN);
        l.setText("Kvadratni korijen broja "+ t.getText() + " je: "+ bd);
        numA = bd.doubleValue();
        return numA;
    }

    public double opResult(double i, TextView t, TextView l) {

        switch (operand) {
            case '+':
                numA += i;
                break;
            case '-':
                numA -= i;
                break;
            case '*':
                numA *= i;
                break;
            case '/':
                numA /= i;
                break;
            default:
                break;
        }
        if (operand=='x') {

        } else {
            BigDecimal bd = new BigDecimal(numA);
            bd = bd.setScale(2, BigDecimal.ROUND_HALF_EVEN);
            l.setText(l.getText()+""+t.getText()+ "="+ bd);
            operand = 'x';
        }
        return numA;
    }
}
