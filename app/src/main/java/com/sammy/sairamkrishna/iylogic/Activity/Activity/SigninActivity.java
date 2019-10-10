package com.sammy.sairamkrishna.iylogic.Activity.Activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.sammy.sairamkrishna.iylogic.Activity.Base.BaseActivity;
import com.sammy.sairamkrishna.iylogic.Activity.Constant.Constant;
import com.sammy.sairamkrishna.iylogic.R;

import java.util.ArrayList;

import static android.widget.Toast.LENGTH_LONG;
import static com.sammy.sairamkrishna.iylogic.Activity.Constant.Constant.email;

public class SigninActivity extends BaseActivity implements View.OnClickListener {

   private EditText editemail, pwd;
   private TextView textemail, textpwd,textwithqr,textforgot, textaccount;
   private Button button;
   LinearLayout lytContainer;
   SharedPreferences sharedPreferences;

    @Override
    protected  void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);

        final ArrayList<String> arrayList;
        setContentView(R.layout.activity_signin);

        lytContainer = (LinearLayout)findViewById(R.id.lytContainer);

        editemail = (EditText)findViewById(R.id.edt_email);
        pwd = (EditText)findViewById(R.id.edt_pwd);
        textemail = (TextView)findViewById(R.id.txv_email);
        textpwd = (TextView)findViewById(R.id.txv_pwd);
        textwithqr = (TextView)findViewById(R.id.txv_withqr);

        textaccount = (TextView)findViewById(R.id.txv_account);
        button =(Button)findViewById(R.id.button_signin);

        arrayList = new ArrayList<>();

        textwithqr.setOnClickListener(this);

        button.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {
                String email = editemail.getText().toString().trim();
                String password = pwd.getText().toString().trim();

              if(email.isEmpty()){

                 Toast.makeText(SigninActivity.this,"Input the data",LENGTH_LONG).show();
             }else if(!invaildEmail(email))  {
                  Toast.makeText(SigninActivity.this,"Invalid email",LENGTH_LONG).show();
            }
              else if(password.isEmpty()){
                  Toast.makeText(SigninActivity.this,"Input the password",LENGTH_LONG).show();
             }else{
                  Intent intent = new Intent(SigninActivity.this, MainActivity.class);
                  startActivity(intent);
                  finish();
              }


            }
        });
        textaccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SigninActivity.this, SignupActivity.class);
                startActivity(intent);
                finish();
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
        /*textforgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SigninActivity.this, ForgotActivity.class);
                startActivity(intent);
                finish();
            }
        });*/
    }

    @Override
    protected void onResume(){
        super.onResume();
        if (!invaildEmail(email)){
            Toast.makeText(SigninActivity.this,"Input the email",LENGTH_LONG).show();

        }
        else {
            editemail.setText(email);
        }




    }

    @Override
    public void onClick(View view) {

        Intent intent = new Intent(this,ScanActivity.class);
        startActivity(intent);
//        finish();
    }
}
