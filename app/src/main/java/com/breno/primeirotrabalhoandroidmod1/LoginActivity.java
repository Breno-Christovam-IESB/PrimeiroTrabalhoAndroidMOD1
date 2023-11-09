package com.breno.primeirotrabalhoandroidmod1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private Button bt_login;
    private EditText et_login, et_password;
    private TextView tv_email, tv_password;

    private String EMAIL = "Breno";

//    private String PASSWORD = "123"; // caso queira colocar uma senha.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        et_login = findViewById(R.id.et_login);

//        et_password = findViewById(R.id.et_password);

        bt_login = findViewById(R.id.bt_login);

//        tv_email = findViewById(R.id.tv_email);
//
//        tv_password = findViewById(R.id.tv_password);

        bt_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(LoginActivity.this, "Nome: " + et_login.getText() + "\nSenha: " + et_password.getText(), Toast.LENGTH_SHORT).show();

//                  tv_email.setText(et_login.getText());
//                  tv_password.setText(et_password.getText());

                String iptLogin = et_login.getText().toString().trim();
//                String iptPassword = et_password.getText().toString().trim();

                if(iptLogin.equals(EMAIL)) {
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    intent.putExtra("KEY_EMAIL", iptLogin);
//                    intent.putExtra("KEY_NUMBER", 123);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(LoginActivity.this, "Credenciais inválidas ", Toast.LENGTH_SHORT).show();
                }


//                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
//                startActivity(intent);
//                finish();
//                if(login()) {
//                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
//                    startActivity(intent);
//                } else {
//                    Toast.makeText(LoginActivity.this, "Credenciais inválidas ", Toast.LENGTH_SHORT).show();
//                }
            }
        });
    }
//    private Boolean login() {
//        if(et_login.getText().equals(EMAIL) && et_password.getText().equals(PASSWORD)) {
//            return true;
//        } else
//        return false;
//    }
}