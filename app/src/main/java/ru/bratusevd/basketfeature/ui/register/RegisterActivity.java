package ru.bratusevd.basketfeature.ui.register;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import ru.bratusevd.basketfeature.R;

public class RegisterActivity extends AppCompatActivity {

    private EditText surname;
    private EditText name;
    private EditText email;
    private EditText password;
    private Button register;

    private String logTag = "Register";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        makeLog("onCreate");
        findViews();
        setOnClick();
    }

    private void findViews() {
        makeLog("findViews");
        surname = findViewById(R.id.input_surname);
        name = findViewById(R.id.input_name);
        email = findViewById(R.id.input_reg_email);
        password = findViewById(R.id.input_reg_password);
        register = findViewById(R.id.btn_register);
    }

    private void setOnClick() {
        makeLog("setOnClick");
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registerButton();
            }
        });
    }

    private void registerButton() {
        makeLog("registerButton");
        getSurname();
        getName();
        getEmail();
        getPassword();

        if (sendRegisterRequest() == 200) {
            makeToast(getResources().getString(R.string.title_register_ok));
            finish();
        } else makeToast(getResources().getString(R.string.title_register_fail));
    }

    private String getSurname() {
        makeLog("getSurname");
        return surname.getText().toString();
    }

    private String getName() {
        makeLog("getName");
        return name.getText().toString();
    }

    private String getEmail() {
        makeLog("getEmail");
        return email.getText().toString();
    }

    private String getPassword() {
        makeLog("getPassword");
        return password.getText().toString();
    }

    private int sendRegisterRequest() {
        makeLog("sendRegisterRequest");
        return 200;
    }

    private void makeToast(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

    private void makeLog(String message) {
        Log.d(logTag, message);
    }
}