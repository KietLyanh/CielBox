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

public class RegisterActivity extends AppCompatActivity {
    private TextView backlogin;
    EditText editmail;
    EditText editpass1;
    EditText cfpass;
    EditText nameuser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        editmail = (EditText) findViewById(R.id.newusername) ;
        editpass1 = (EditText) findViewById(R.id.newpassword);
        cfpass = (EditText) findViewById(R.id.cfpassword) ;
        nameuser = (EditText)findViewById(R.id.name);
        backlogin = (TextView) findViewById(R.id.newbutton);
        backlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registeruser();
            }
        });
    }
    public static final Pattern EMAIL_ADDRESS = Pattern.compile(
            "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$"
    );

    private void registeruser() {
        String nameu = nameuser.getEditableText().toString().trim();
        String emailuser = editmail.getEditableText().toString().trim();
        String passuser = editpass1.getEditableText().toString().trim();
        String cfpassuser = cfpass.getEditableText().toString().trim();
        if(nameu.isEmpty()){
            Toast.makeText(this,"Name required",Toast.LENGTH_LONG).show();
        }
        else if(emailuser.isEmpty()){
            Toast.makeText(this,"Email required",Toast.LENGTH_LONG).show();
        }
        else if(!Patterns.EMAIL_ADDRESS.matcher(emailuser).matches()){
            Toast.makeText(this,"Email address wrong",Toast.LENGTH_LONG).show();
        }
        else if(passuser.isEmpty()){
            Toast.makeText(this,"Password required",Toast.LENGTH_LONG).show();
        }
        else if(cfpassuser.isEmpty()){
            Toast.makeText(this,"Confirm Password required",Toast.LENGTH_LONG).show();
        }
        else if(!passuser.equals(cfpassuser)){
            Toast.makeText(this,"Confirm Password wrong",Toast.LENGTH_LONG).show();
        }
        else {
            openActivity1();
            Toast.makeText(this,"Register Succesfully ",Toast.LENGTH_LONG).show();
        }
    }

    public void openActivity1(){
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
}