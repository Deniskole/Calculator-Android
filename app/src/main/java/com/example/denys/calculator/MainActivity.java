package com.example.denys.calculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnZero, btnOne, btnTwo, btnThree, btnFour, btnFive, btnSix, btnSeven, btnEight, btnNine,
            btnPlus, btnMinus, btnMultiply, btnDivide, btnEquals, btnCancel;

    TextView display;

    private ArrayList<Float> mathResults = new ArrayList<Float>();

    private float leftTotal = 0;
    private float rightTotal = 0;

    private int currentOperation = 0;
    private int nextOperation = 0;

    private static final int PLUS = 1;
    private static final int MINUS = 2;
    private static final int MULTIPLY = 3;
    private static final int DIVIDE = 4;
    private static final int EQUALS = 0;

    private static final int CLEAR = 1;
    private static final int DONT_CLEAR = 0;
    private int clearDisplay = 0;
    private String formatParam = "%.3f";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display = (TextView) findViewById(R.id.display);

        btnZero = (Button) findViewById(R.id.btnZero);
        btnOne = (Button) findViewById(R.id.btnOne);
        btnTwo = (Button) findViewById(R.id.btnTwo);
        btnThree = (Button) findViewById(R.id.btnThree);
        btnFour = (Button) findViewById(R.id.btnFour);
        btnFive = (Button) findViewById(R.id.btnFive);
        btnSix = (Button) findViewById(R.id.btnSix);
        btnSeven = (Button) findViewById(R.id.btnSeven);
        btnEight = (Button) findViewById(R.id.btnEight);
        btnNine = (Button) findViewById(R.id.btnNine);

        btnPlus = (Button) findViewById(R.id.btnPlus);
        btnMinus = (Button) findViewById(R.id.btnMinus);
        btnMultiply = (Button) findViewById(R.id.btnMultiply);
        btnDivide = (Button) findViewById(R.id.btnDivide);
        btnEquals = (Button) findViewById(R.id.btnEquals);
        btnCancel = (Button) findViewById(R.id.btnCancel);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnZero:
                if (clearDisplay == CLEAR) {
                    display.setText("");
                }
                clearDisplay = DONT_CLEAR;
                display.append("0");
                break;
            case R.id.btnOne:
                if (clearDisplay == CLEAR) {
                    display.setText("");
                }
                clearDisplay = DONT_CLEAR;
                display.append("1");
                break;
            case R.id.btnTwo:
                if (clearDisplay == CLEAR) {
                    display.setText("");
                }
                clearDisplay = DONT_CLEAR;
                display.append("2");
                break;
            case R.id.btnThree:
                if (clearDisplay == CLEAR) {
                    display.setText("");
                }
                clearDisplay = DONT_CLEAR;
                display.append("3");
                break;
            case R.id.btnFour:
                if (clearDisplay == CLEAR) {
                    display.setText("");
                }
                clearDisplay = DONT_CLEAR;
                display.append("4");
                break;
            case R.id.btnFive:
                if (clearDisplay == CLEAR) {
                    display.setText("");
                }
                clearDisplay = DONT_CLEAR;
                display.append("5");
                break;
            case R.id.btnSix:
                if (clearDisplay == CLEAR) {
                    display.setText("");
                }
                clearDisplay = DONT_CLEAR;
                display.append("6");
                break;
            case R.id.btnSeven:
                if (clearDisplay == CLEAR) {
                    display.setText("");
                }
                clearDisplay = DONT_CLEAR;
                display.append("7");
                break;
            case R.id.btnEight:
                if (clearDisplay == CLEAR) {
                    display.setText("");
                }
                clearDisplay = DONT_CLEAR;
                display.append("8");
                break;
            case R.id.btnNine:
                if (clearDisplay == CLEAR) {
                    display.setText("");
                }
                clearDisplay = DONT_CLEAR;
                display.append("9");
                break;

            case R.id.btnPlus:
                calculatorEngine(PLUS);
                break;

            case R.id.btnMinus:
                calculatorEngine(MINUS);
                break;

            case R.id.btnMultiply:
                calculatorEngine(MULTIPLY);
                break;

            case R.id.btnDivide:
                calculatorEngine(DIVIDE);
                break;

            case R.id.btnEquals:
                String checkEmptyDisplay = display.getText().toString();
                if (!checkEmptyDisplay.isEmpty()) {
                    calculatorEngine(EQUALS);
                }
                break;

            case R.id.btnCancel:
                display.setText("0");
                leftTotal = 0;
                rightTotal = 0;
                mathResults.removeAll(mathResults);
                currentOperation = 0;
                nextOperation = 0;
                break;
        }
    }


    private void calculatorEngine(int operator) {

        mathResults.add(Float.parseFloat(display.getText().toString()));

        if (operator != EQUALS) {
            nextOperation = operator;
        } else if (operator == EQUALS) {
            nextOperation = 0;
        }


        switch (currentOperation) {
            case PLUS:
                leftTotal = mathResults.get(0);
                rightTotal = mathResults.get(1);

                mathResults.removeAll(mathResults);
                mathResults.add(leftTotal + rightTotal);

                display.setText(String.format(formatParam, mathResults.get(0)));
                break;

            case MINUS:
                leftTotal = mathResults.get(0);
                rightTotal = mathResults.get(1);

                mathResults.removeAll(mathResults);
                mathResults.add(leftTotal - rightTotal);

                display.setText(String.format(formatParam, mathResults.get(0)));
                break;

            case MULTIPLY:
                leftTotal = mathResults.get(0);
                rightTotal = mathResults.get(1);

                mathResults.removeAll(mathResults);
                mathResults.add(leftTotal * rightTotal);

                display.setText(String.format(formatParam, mathResults.get(0)));
                break;

            case DIVIDE:
                leftTotal = mathResults.get(0);
                rightTotal = mathResults.get(1);

                mathResults.removeAll(mathResults);
                mathResults.add(leftTotal / rightTotal);

                display.setText(String.format(formatParam, mathResults.get(0)));
                break;
        }

        clearDisplay = CLEAR;
        currentOperation = nextOperation;
        if (operator == EQUALS) {
            leftTotal = 0;
            rightTotal = 0;
            mathResults.removeAll(mathResults);
        }


    }

}
