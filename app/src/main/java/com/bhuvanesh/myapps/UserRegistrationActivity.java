package com.bhuvanesh.myapps;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.regex.Pattern;

public class UserRegistrationActivity extends AppCompatActivity {

    EditText etName, etEmail, etPassword, etReTypePswd;
    Spinner spinYear, spinMonth, spinDate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_registration);

        etName       = (EditText) findViewById(R.id.etName);
        etEmail      = (EditText) findViewById(R.id.etEmail);
        etPassword   = (EditText) findViewById(R.id.etPassword);
        etReTypePswd = (EditText) findViewById(R.id.etReTypePswd);
        spinYear     = (Spinner) findViewById(R.id.spinYear);
        spinMonth    = (Spinner) findViewById(R.id.spinMonth);
        spinDate     = (Spinner) findViewById(R.id.spinDate);

        etName.addTextChangedListener(this.new MyTextWatcher(etName));
        etEmail.addTextChangedListener(this.new MyTextWatcher(etEmail));
        etPassword.addTextChangedListener(this.new MyTextWatcher(etPassword));
        etReTypePswd.addTextChangedListener(this.new MyTextWatcher(etReTypePswd));

        ArrayAdapter adapterYear = ArrayAdapter.createFromResource(this, R.array.year, R.layout.support_simple_spinner_dropdown_item);
        ArrayAdapter adapterMonth = ArrayAdapter.createFromResource(this, R.array.month, R.layout.support_simple_spinner_dropdown_item);
        ArrayAdapter adapterDate = ArrayAdapter.createFromResource(this, R.array.date, R.layout.support_simple_spinner_dropdown_item);

        spinYear.setAdapter(adapterDate);
        spinMonth.setAdapter(adapterMonth);
        spinDate.setAdapter(adapterYear);
    }

    public void register(View view) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_EMAIL, "ssbhuvaneshwar@gmail.com");
        intent.putExtra(Intent.EXTRA_TEXT, "Registration successful");
        intent.putExtra(Intent.EXTRA_SUBJECT, "Intent Mail:");
        intent.setType("message/rfc822");
        //Intent chooser = Intent.createChooser(intent, "select one to send mail");
        startActivity(intent);
    }

    class MyTextWatcher implements TextWatcher {

        View view;
        MyTextWatcher(View view) {
            this.view = view;
        }
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {}

        @Override
        public void afterTextChanged(Editable s) {
            switch (view.getId()) {
                case R.id.etName:
                    if(!(s.toString().matches("[a-zA-Z]+")))
                        etName.setError("only alphabets are allowed");
                    break;
                case R.id.etEmail:
                    if(!(isValidEmail(s)))
                        etEmail.setError("invalid email");
                    break;
                case R.id.etPassword:
                    int length = 0;
                    if(pswdLength(s) == 8) {
                        Toast toast = Toast.makeText(getBaseContext(), "strength: Good", Toast.LENGTH_SHORT);
                        toast.setGravity(Gravity.CENTER, 0, 0);
                        toast.show();
                    }
                    else if(pswdLength(s) < 8)
                        etPassword.setError("strength: Too Short");
                    break;
                case R.id.etReTypePswd:
                    if(!(isPswdMatch(s)))
                        etReTypePswd.setError("Password Not Match");
            }
        }

        public int pswdLength(Editable s) {
            return s.toString().length();
        }

        public boolean isValidEmail(Editable s) {
            String regex = "[^.][[a-z][A-Z] \\d [._]]{5,}";
            return Pattern.matches(regex, s.toString());
        }

        public boolean isPswdMatch(Editable s) {
            return etPassword.getText().toString().equals(s.toString());
        }
    }
}
