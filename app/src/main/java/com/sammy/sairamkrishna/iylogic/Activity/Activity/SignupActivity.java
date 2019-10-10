package com.sammy.sairamkrishna.iylogic.Activity.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.sammy.sairamkrishna.iylogic.Activity.Base.BaseActivity;
import com.sammy.sairamkrishna.iylogic.R;

import static android.widget.Toast.LENGTH_LONG;

public class SignupActivity extends BaseActivity {
    LinearLayout lytContainer;
    EditText edtusername, edtemail, edtpwd, edtconfirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        final TextView txvusername = (TextView)findViewById(R.id.txv_username);
        TextView txvconemail = (TextView)findViewById(R.id.txv_email);
        TextView txvpwd = (TextView)findViewById(R.id.txv_pwd);
        TextView txvconfirm = (TextView)findViewById(R.id.txv_confirm);
        Button button = (Button)findViewById(R.id.button_signup);
        TextView txvsignin = (TextView)findViewById(R.id.txv_signup);

        edtusername = (EditText)findViewById(R.id.edt_username);
        edtemail = (EditText)findViewById(R.id.edt_email);
        edtpwd = (EditText)findViewById(R.id.edt_pwd);
        edtconfirm = (EditText)findViewById(R.id.edtconfirm_pwd);

        lytContainer = (LinearLayout)findViewById(R.id.lytContainer);

        txvsignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignupActivity.this, SigninActivity.class);
                startActivity(intent);
                finish();
            }
        });
       button.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               String userName = edtusername.getText().toString().trim();
               String email = edtemail.getText().toString().trim();
               String pwd = edtpwd.getText().toString().trim();
               String confPwd = edtconfirm.getText().toString().trim();
               if (userName.isEmpty() ) {

                   Toast.makeText(SignupActivity.this,"Input the username",LENGTH_LONG).show();

               } else if (email.isEmpty() ){
                   Toast.makeText(SignupActivity.this,"Input the email",LENGTH_LONG).show();

               } else if (!invaildEmail(email)) {
                   Toast.makeText(SignupActivity.this,"Invalid email",LENGTH_LONG).show();

               }  else if (pwd.isEmpty() ){
                   Toast.makeText(SignupActivity.this,"Input the password",LENGTH_LONG).show();

               } else if (!pwd.equals(confPwd) ) {
                   Toast.makeText(SignupActivity.this,"Invalid password",LENGTH_LONG).show();

               } else {
                   Intent intent = new Intent(SignupActivity.this, MainActivity.class);
                   startActivity(intent);

               }
//123

           }
       });
        lytContainer.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
                return false;
            }
        });

    }
}
