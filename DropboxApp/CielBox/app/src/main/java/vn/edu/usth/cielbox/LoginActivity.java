package vn.edu.usth.cielbox;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Pattern;

public class LoginActivity extends AppCompatActivity {
    EditText editgmail;
    EditText editpass;

    private TextView login;
    private TextView register;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editgmail = (EditText) findViewById(R.id.username);
        editpass = (EditText) findViewById(R.id.password);

        login = (TextView) findViewById(R.id.button);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                confirmuser();
            }
        });

        register = (TextView) findViewById(R.id.register);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity3();
            }
        });

    }
    public static final Pattern EMAIL_ADDRESS = Pattern.compile(
            "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$"
    );

    private void confirmuser() {
        String emailuser = editgmail.getEditableText().toString().trim();
        String passuser = editpass.getEditableText().toString().trim();
        if(emailuser.isEmpty()){
            Toast.makeText(this,"Email required",Toast.LENGTH_LONG).show();
        }
        else if(!Patterns.EMAIL_ADDRESS.matcher(emailuser).matches()){
            Toast.makeText(this,"Email address wrong",Toast.LENGTH_LONG).show();
        }
        else if(passuser.isEmpty()){
            Toast.makeText(this,"Password required",Toast.LENGTH_LONG).show();
        }
        else {
            openActivity2();
            Toast.makeText(this,"Login Succesfully ",Toast.LENGTH_LONG).show();
        }
    }

    public void openActivity2() {
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }
    public void openActivity3() {
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }
}