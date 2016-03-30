package com.bhuvanesh.myapps;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class CalculatorActivity extends AppCompatActivity {

    /*EditText et1, et2, result;    int num1, num2; */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        /*et1 = (EditText) findViewById(R.id.num1);
        et2 = (EditText) findViewById(R.id.num2);
        result = (EditText) findViewById(R.id.result);*/
    }

/*    public void getNumbers() throws NumberFormatException {
        num1 = Integer.parseInt(et1.getText().toString());
        num2 = Integer.parseInt(et2.getText().toString());
    }

    public void add(View view) {
        try {
            getNumbers();
            result.setText("" + (double) (num1 + num2));
        } catch (Exception ex) {
            Toast.makeText(this, "number not entered \n" + ex.toString(), Toast.LENGTH_SHORT).show();
        }
    }

    public void subtract(View view) {
        try {
            getNumbers();
            result.setText("" + (double) (num1 - num2));
        } catch (Exception ex) {
            Toast.makeText(this, "number not entered \n"+ex.toString(), Toast.LENGTH_SHORT).show();
        }
    }

    public void multiply(View view) {
        try {
            getNumbers();
            result.setText(""+(double)(num1*num2));
        } catch (NumberFormatException ex) {
            Toast.makeText(this, "number not entered \n"+ex.toString(), Toast.LENGTH_SHORT).show();
        }
    }

    public void division(View view) {
        try {
            getNumbers();
            try {
                result.setText(String.format("%s", (double)(num1 / num2)));
            } catch (ArithmeticException ex) {
                Toast.makeText(this, ""+ex.toString(), Toast.LENGTH_SHORT).show();
            }
        } catch (NumberFormatException ex) {
            Toast.makeText(this, "number not entered \n"+ex.toString(), Toast.LENGTH_SHORT).show();
        }

    }*/
}

