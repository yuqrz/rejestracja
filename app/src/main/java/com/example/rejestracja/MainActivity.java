package com.example.rejestracja;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.util.Patterns;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText email;
    private EditText password;
    private EditText passwordd;
    private Button button;
    private TextView msg;


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        passwordd = findViewById(R.id.passwordd);
        button = findViewById(R.id.button);
        msg = findViewById(R.id.msg);

        button.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {

                String Email = email.getText().toString().trim();
                String Password = password.getText().toString().trim();
                String PasswordAgain = passwordd.getText().toString().trim();

                if (Email.isEmpty()) {
                    msg.setText("Proszę wprowadzdić adres e-mail");
                } else if (!Patterns.EMAIL_ADDRESS.matcher(Email).matches()) {
                    msg.setText("Nieprawidłowy adres e-mail");
                } else if (Password.isEmpty()) {
                    msg.setText("Proszę wprowadzić hasło");
                } else if (PasswordAgain.isEmpty()) {
                    msg.setText("Proszę ponownie wprowadzić hasło");
                } else if (!PasswordAgain.matches(Password)) {
                    msg.setText("Hasła się różnią");
                } else {
                    msg.setText("Witaj " + Email);
                }
            }
        });
    }
}