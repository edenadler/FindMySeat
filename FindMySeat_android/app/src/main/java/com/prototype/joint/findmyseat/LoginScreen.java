package com.prototype.joint.findmyseat;

import android.content.Intent;
import android.support.annotation.StringDef;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

public class LoginScreen extends AppCompatActivity {
    private CheckBox chk1;
    private String username, password;
    private EditText editTextUsername,editTextPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);
        editTextUsername = (EditText)findViewById(R.id.username);
        editTextPassword = (EditText)findViewById(R.id.password);
        chk1 = (CheckBox)findViewById(R.id.checkBox2);
        chk1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

            }
        });

    }
}
