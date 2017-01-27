package com.prototype.joint.findmyseat;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class LoginScreen extends AppCompatActivity implements View.OnClickListener {
    private CheckBox chk1;
    private Button login_btn, user_reg;
    private String username, password;
    private EditText editTextUsername, editTextPassword;
    private SharedPreferences loginPreferences;
    private SharedPreferences.Editor loginPrefsEditor;
    private Boolean saveLogin;
    final static int  GO_TO_ROOMS = 1;
    final static int  NEW_USE = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // initializing all class entities
        setContentView(R.layout.activity_login_screen);
        editTextUsername = (EditText) findViewById(R.id.username);
        editTextPassword = (EditText) findViewById(R.id.password);
        chk1 = (CheckBox) findViewById(R.id.checkBox2);
        editTextUsername = (EditText) findViewById(R.id.username);
        editTextPassword = (EditText) findViewById(R.id.password);
        chk1 = (CheckBox) findViewById(R.id.checkBox2);
        loginPreferences = getSharedPreferences("loginPrefs", MODE_PRIVATE);
        loginPrefsEditor = loginPreferences.edit();
        login_btn = (Button)findViewById(R.id.press_to_login);
        login_btn.setOnClickListener(this);
        user_reg = (Button)findViewById(R.id.new_user_press);
        user_reg.setOnClickListener(this);
        // Checking if the user has pre-saved details
        saveLogin = loginPreferences.getBoolean("saveLogin", false);
        if (saveLogin) {
            editTextUsername.setText(loginPreferences.getString("username", ""));
            editTextPassword.setText(loginPreferences.getString("password", ""));
            chk1.setChecked(true);
        }
    }

    public void onClick(View view) {
        if (view == user_reg)
        {
            moveToNextScreen(NEW_USE);
        }
        // Saving the data the user just gave abut himself
        if (view == login_btn) {

            username = editTextUsername.getText().toString();
            password = editTextPassword.getText().toString();

            if (chk1.isChecked()) {
                loginPrefsEditor.putBoolean("saveLogin", true);
                loginPrefsEditor.putString("username", username);
                loginPrefsEditor.putString("password", password);
                loginPrefsEditor.commit();
            } else {
                loginPrefsEditor.clear();
                loginPrefsEditor.commit();
            }

           moveToNextScreen(GO_TO_ROOMS);
        }
    }

    public void moveToNextScreen(int moveDest) {
        if (moveDest == GO_TO_ROOMS){
            startActivity(new Intent(LoginScreen.this, MainActivity.class)); // mapDisplay
            LoginScreen.this.finish();
        }
        else if(moveDest == NEW_USE)
        {
            startActivity(new Intent(LoginScreen.this, Profile.class));
            LoginScreen.this.finish();
        }
    }

}
