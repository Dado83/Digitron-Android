package es.hol.fairplay.digitron;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.math.BigDecimal;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button b1, b2, b3, b4, b5, b6, b7, b8, b9, b0, plus, min, div, multi, equals, dot, C, AC, neg, root;
    TextView disp, pastOp;
    Model m;
    private boolean equalsState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setIcon(R.drawable.icon);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_HOME | ActionBar.DISPLAY_SHOW_TITLE);
        setContentView(R.layout.activity_main);

        m = new Model();
        b0 = (Button) findViewById(R.id.b0);
        b1 = (Button) findViewById(R.id.b1);
        b2 = (Button) findViewById(R.id.b2);
        b3 = (Button) findViewById(R.id.b3);
        b4 = (Button) findViewById(R.id.b4);
        b5 = (Button) findViewById(R.id.b5);
        b6 = (Button) findViewById(R.id.b6);
        b7 = (Button) findViewById(R.id.b7);
        b8 = (Button) findViewById(R.id.b8);
        b9 = (Button) findViewById(R.id.b9);
        plus = (Button) findViewById(R.id.plus);
        min = (Button) findViewById(R.id.min);
        div = (Button) findViewById(R.id.div);
        multi = (Button) findViewById(R.id.multi);
        neg = (Button) findViewById(R.id.neg);
        root = (Button) findViewById(R.id.root);
        equals = (Button) findViewById(R.id.eq);
        dot = (Button) findViewById(R.id.dot);
        C = (Button) findViewById(R.id.C);
        AC = (Button) findViewById(R.id.AC);
        disp = (TextView) findViewById(R.id.display);
        pastOp = (TextView) findViewById(R.id.past);

        b0.setOnClickListener(this);
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
        b5.setOnClickListener(this);
        b6.setOnClickListener(this);
        b7.setOnClickListener(this);
        b8.setOnClickListener(this);
        b9.setOnClickListener(this);
        plus.setOnClickListener(this);
        min.setOnClickListener(this);
        div.setOnClickListener(this);
        multi.setOnClickListener(this);
        neg.setOnClickListener(this);
        root.setOnClickListener(this);
        equals.setOnClickListener(this);
        dot.setOnClickListener(this);
        C.setOnClickListener(this);
        AC.setOnClickListener(this);
        disp.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        try {
           /* if (equalsState) {
                disp.setText("");
                equalsState = false;
            } else {

            }*/
            if (disp.getText().equals("NO DATA")) {
                disp.setText("");
            }
                switch (v.getTag().toString()) {
                    case "0":
                            if (disp.getText().equals("")) {
                                disp.setText("");
                            } else {
                                disp.setText(disp.getText() + "0");
                            }
                        break;
                    case "1":

                        disp.setText(disp.getText() + "1");
                        break;
                    case "2":
                        disp.setText(disp.getText() + "2");
                        break;
                    case "3":
                        disp.setText(disp.getText() + "3");
                        break;
                    case "4":
                        disp.setText(disp.getText() + "4");
                        break;
                    case "5":
                        disp.setText(disp.getText() + "5");
                        break;
                    case "6":
                        disp.setText(disp.getText() + "6");
                        break;
                    case "7":
                        disp.setText(disp.getText() + "7");
                        break;
                    case "8":
                        disp.setText(disp.getText() + "8");
                        break;
                    case "9":
                        disp.setText(disp.getText() + "9");
                        break;
                    case ".":
                        disp.setText(disp.getText() + ".");
                        dot.setEnabled(false);
                        break;
                    case "+":
                        if (m.getOperand() == 'x') {
                            m.plus(Double.parseDouble("" + disp.getText()), disp, pastOp);
                            dot.setEnabled(true);
                        } else {
                            equals.performClick();
                            m.plus(Double.parseDouble("" + disp.getText()), disp, pastOp);
                            dot.setEnabled(true);
                        }
                        break;
                    case "-":
                        if (m.getOperand() == 'x') {
                            m.minus(Double.parseDouble("" + disp.getText()), disp, pastOp);
                            dot.setEnabled(true);
                        } else {
                            equals.performClick();
                            m.minus(Double.parseDouble("" + disp.getText()), disp, pastOp);
                            dot.setEnabled(true);
                        }
                        break;
                    case "x":
                        if (m.getOperand() == 'x') {
                            m.multi(Double.parseDouble("" + disp.getText()), disp, pastOp);
                            dot.setEnabled(true);
                        } else {
                            equals.performClick();
                            m.multi(Double.parseDouble("" + disp.getText()), disp, pastOp);
                            dot.setEnabled(true);
                        }
                        break;
                    case "/":
                        if (m.getOperand() == 'x') {
                            m.divide(Double.parseDouble("" + disp.getText()), disp, pastOp);
                            dot.setEnabled(true);
                        } else {
                            equals.performClick();
                            m.divide(Double.parseDouble("" + disp.getText()), disp, pastOp);
                            dot.setEnabled(true);
                        }
                        break;
                    case "c":
                        if (disp.getText().equals("")) {

                        } else {
                            disp.setText(disp.getText().subSequence(0, disp.getText().length() - 1));
                        }
                        break;
                    case "ac":
                        disp.setText("");
                        pastOp.setText("");
                        m.setDouble();
                        dot.setEnabled(true);
                        break;
                    case "=":
                        BigDecimal bd = new BigDecimal(m.opResult(Double.parseDouble("" + disp.getText()), disp, pastOp));
                        bd = bd.setScale(2, BigDecimal.ROUND_HALF_EVEN);
                        disp.setText("" + bd);
                        dot.setEnabled(false);
                        equalsState = true;
                        //AC.performClick();
                        break;
                    case "neg":
                        disp.setText("" + Double.parseDouble("" + disp.getText()) * -1);
                        break;
                    case "root":
                        //BigDecimal bdR = new BigDecimal(m.squareRoot(Double.parseDouble("" + disp.getText()), pastOp, disp));
                        //bdR = bdR.setScale(2, BigDecimal.ROUND_HALF_EVEN);
                        disp.setText("" + m.squareRoot(Double.parseDouble("" + disp.getText()), pastOp, disp));
                        dot.setEnabled(true);
                        break;
                    default:
                        break;
                }
            }catch(NumberFormatException e){
                disp.setText("NO DATA");
            }

        if (v.getTag().toString().equals("d")){
            Intent i = new Intent(MainActivity.this, About.class);
            startActivity(i);
        }

        }
}
