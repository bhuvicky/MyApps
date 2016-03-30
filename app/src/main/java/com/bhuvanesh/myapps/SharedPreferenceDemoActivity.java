package com.bhuvanesh.myapps;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SharedPreferenceDemoActivity extends AppCompatActivity {

    EditText etName, etNumber;
    TextView tvName, tvNumber;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    private static final String My_PREF = "My Pref";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preference_demo);
        etName = (EditText) findViewById(R.id.etName);
        etNumber = (EditText) findViewById(R.id.etNumber);
        tvName = (TextView) findViewById(R.id.tvName);
        tvNumber = (TextView) findViewById(R.id.tvNumber);

        preferences = getSharedPreferences(My_PREF, Context.MODE_PRIVATE);

            tvName.setText(preferences.getString("name", "NA"));
            tvNumber.setText(preferences.getString("number", "NA"));


    }

    public void saveData(View view) {
        editor = preferences.edit();
        editor.putString("name", etName.getText().toString());
        editor.putString("number", etNumber.getText().toString());
        editor.commit();
        Toast.makeText(getBaseContext(), "saved", Toast.LENGTH_SHORT).show();
    }
}
