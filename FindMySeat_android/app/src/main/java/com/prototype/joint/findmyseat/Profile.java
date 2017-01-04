package com.prototype.joint.findmyseat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class Profile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        final EditText nameInput = (EditText)findViewById(R.id.nameInput);
        nameInput.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Log.v("EditText value=", nameInput.getText().toString());
            }
        });

        final EditText emailInput = (EditText)findViewById(R.id.emailInput);
        emailInput.setOnClickListener(new View.OnClickListener(){
            @Override
            public  void onClick(View view){
                Log.v("EditText value=", emailInput.getText().toString());
            }
        });

        final EditText phoneInput = (EditText)findViewById(R.id.phoneInput);
        phoneInput.setOnClickListener(new View.OnClickListener(){
            @Override
            public  void onClick(View view){
                Log.v("EditText value=", phoneInput.getText().toString());
            }
        });
    }
}
