package com.khanadhoondo.khanadhoondo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class email extends AppCompatActivity implements View.OnClickListener {

    private EditText email;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email);
        email=(EditText)findViewById(R.id.Emailtxt);
        btn=(Button)findViewById(R.id.EmalBtn);
        btn.setOnClickListener(this);
    }

    private void CheckValidEmail(){

        if (emailValidator(email.getText().toString().trim())){
           // Intent intent=new Intent(email.this,password.class);
            //startActivity(intent);
        }
        else
        {
            finish();
            startActivity(getIntent());
        }
    }

    @Override
    public void onClick(View view) {
        CheckValidEmail();
    }

    public boolean emailValidator(String email)
    {
        Pattern pattern;
        Matcher matcher;
        final String EMAIL_PATTERN = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        pattern = Pattern.compile(EMAIL_PATTERN);
        matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
