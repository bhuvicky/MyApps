package com.bhuvanesh.myapps;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class GreetUserActivity extends AppCompatActivity {

    EditText et;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_greet_user);

        et = (EditText) findViewById(R.id.editText);
        tv = (TextView) findViewById(R.id.greetUserResult);
    }

    public void greetUser(View view) {
        tv.setText("Hi "+et.getText()+"...! How are you?");
    }
}
