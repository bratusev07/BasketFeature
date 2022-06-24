package ru.bratusevd.basketfeature.ui.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import ru.bratusevd.basketfeature.MainActivity;
import ru.bratusevd.basketfeature.R;
import ru.bratusevd.basketfeature.ui.register.RegisterActivity;

public class LoginActivity extends AppCompatActivity {

    private EditText email;
    private EditText password;
    private Button login;
    private TextView register;

    private String logTag = "Login";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        makeLog("onCreate");
        findViews();
        setOnClick();
    }

    private void findViews(){
        makeLog("findView");
        email = findViewById(R.id.input_email);
        password = findViewById(R.id.input_password);
        login = findViewById(R.id.btn_login);
        register = findViewById(R.id.text_register);
    }

    private String getEmail(){
        makeLog("getEmail");
        return email.getText().toString();
    }

    private String getPassword(){
        makeLog("getPassword");
        return password.getText().toString();
    }

    private void setOnClick(){
        makeLog("setOnClick");
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginButton();
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registerButton();
            }
        });
    }

    private void loginButton(){
        makeLog("loginButton");
        int result = sendLoginRequest();
        if(result == 200) startActivity(new Intent(getApplicationContext(), MainActivity.class));
        else makeToast(getResources().getString(R.string.title_login_fail));
    }

    private int sendLoginRequest(){
        makeLog("sendLoginRequest");
        getEmail();
        getPassword();
        return 200;
    }

    private void registerButton(){
        makeLog("registerButton");
        startActivity(new Intent(getApplicationContext(), RegisterActivity.class));
    }

    private void makeToast(String message){
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

    private void makeLog(String message) {
        Log.d(logTag, message);
    }
}