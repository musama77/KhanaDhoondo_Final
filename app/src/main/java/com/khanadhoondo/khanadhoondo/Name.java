package com.khanadhoondo.khanadhoondo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Name extends AppCompatActivity implements View.OnClickListener{

    private DatabaseReference databaseReference;
    private EditText Firstname, Lastname;
    private Button NameBtn;
    private FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name);

        databaseReference= FirebaseDatabase.getInstance().getReference();

        Firstname=(EditText)findViewById(R.id.FirstName);
        Lastname=(EditText)findViewById(R.id.LastName);
        NameBtn=(Button)findViewById(R.id.NameBtn);

        NameBtn.setOnClickListener(this);

    }


    private void Save_to_database(){
        String firstname=Firstname.getText().toString().trim();
        String lastname=Lastname.getText().toString().trim();
        Toast.makeText(this,firstname, Toast.LENGTH_SHORT).show();

        Savedatabase savedatabase=new Savedatabase(firstname,lastname);
        user=FirebaseAuth.getInstance().getCurrentUser();

        databaseReference.setValue(savedatabase);
        Toast.makeText(this, "YourData is saved", Toast.LENGTH_SHORT).show();
        Intent i =new Intent(Name.this,email.class);
        startActivity(i);
    }

    @Override
    public void onClick(View view) {
        if (view==NameBtn){
            Save_to_database();
            Toast.makeText(this, "Saving Data", Toast.LENGTH_SHORT).show();
        }
    }
}
