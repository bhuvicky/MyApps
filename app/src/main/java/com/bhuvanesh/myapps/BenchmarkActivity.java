package com.bhuvanesh.myapps;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.graphics.Color;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import static java.lang.System.currentTimeMillis;

public class BenchmarkActivity extends AppCompatActivity implements Communicator {

    private static int[] array;
    private static int arraySize;
    int flag;
    ProgressBar progress;
    EditText etArraySize;
    TextView tvArrayStatus;
    TextView tvbubbleSortResult, tvSelecitonSortResult, tvInsertionSortResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_benchmark);

        etArraySize           = (EditText)findViewById(R.id.size);
        tvArrayStatus         = (TextView)findViewById(R.id.tvArrayStatus);
        tvbubbleSortResult    = (TextView) findViewById(R.id.tvBubbleSortResult);
        tvSelecitonSortResult = (TextView) findViewById(R.id.tvSelectionSortResult);
        tvInsertionSortResult = (TextView) findViewById(R.id.tvInsertSortResult);

    }

    public void complexity(View v) {
        MyAlertDialog dialog = MyAlertDialog.newInstance(1);
        dialog.show(getFragmentManager(), "choose complexity");
    }

    public void chooseAlgorithm(View v) {
        MyAlertDialog dialog = MyAlertDialog.newInstance(2);
        dialog.show(getFragmentManager(), "algorithm");
    }

    @Override
    public void generateArray(int which) {
        try {
            arraySize = Integer.parseInt(etArraySize.getText().toString());
            array = new int[arraySize];
            switch (flag) {
                case 1:
                    for (int i = 0; i < arraySize; i++)
                        array[i] = i + 1;
                    break;
                case 2:
                    for (int i = 0; i < arraySize; i++)
                        array[i] = (int) (Math.random() * 1000);
                    break;
                case 3:
                    int temp = arraySize;
                    for (int i = 0; i < arraySize; i++)
                        array[i] = temp--;
                    break;
            }
            tvArrayStatus.setVisibility(View.INVISIBLE);
            Toast.makeText(this, "Array Generated", Toast.LENGTH_SHORT).show();
        } catch (Exception ex) {
            Toast.makeText(this, "Enter the Array Size", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void benchMark(ArrayList selectedAlgorithms) {

        /*for (int i=0; i<selectedAlgorithms.size(); i++) {*/
            switch (selectedAlgorithms.size()/*selectedAlgorithms.get(i).toString()*/) {
                case 1: new BackgroundTask(this).execute(array.clone());    break;
                case 2: new BackgroundTask(this).execute(array.clone());    break;
                case 3:
                    Log.d("progress", "in case 3");
                    new BackgroundTask(this).execute(array.clone(), array.clone(), array.clone());
                    break;
            }


    }



}
