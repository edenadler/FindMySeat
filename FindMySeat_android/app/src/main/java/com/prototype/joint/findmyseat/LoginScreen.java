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
    private Button login_btn;
    private String username, password;
    private EditText editTextUsername, editTextPassword;
    private SharedPreferences loginPreferences;
    private SharedPreferences.Editor loginPrefsEditor;
    private Boolean saveLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // initializing all class entities
        login_btn = (Button)findViewById(R.id.login_button);
        if(login_btn != null) {
        login_btn.setOnClickListener(this);
       }
        setContentView(R.layout.activity_login_screen);
        editTextUsername = (EditText) findViewById(R.id.username);
        editTextPassword = (EditText) findViewById(R.id.password);
        chk1 = (CheckBox) findViewById(R.id.checkBox2);
        editTextUsername = (EditText) findViewById(R.id.username);
        editTextPassword = (EditText) findViewById(R.id.password);
        chk1 = (CheckBox) findViewById(R.id.checkBox2);
        loginPreferences = getSharedPreferences("loginPrefs", MODE_PRIVATE);
        loginPrefsEditor = loginPreferences.edit();

        // Checking if the user has pre-saved details
        saveLogin = loginPreferences.getBoolean("saveLogin", false);
        if (saveLogin) {
            editTextUsername.setText(loginPreferences.getString("username", ""));
            editTextPassword.setText(loginPreferences.getString("password", ""));
            chk1.setChecked(true);
        }
    }

    public void onClick(View view) {
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

           moveToNextScreen();
        }
    }

    public void moveToNextScreen() {
        startActivity(new Intent(LoginScreen.this, MainActivity.class));
        LoginScreen.this.finish();

    }

}
