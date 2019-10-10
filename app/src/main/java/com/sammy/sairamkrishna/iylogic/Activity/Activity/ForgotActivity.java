package com.sammy.sairamkrishna.iylogic.Activity.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.sammy.sairamkrishna.iylogic.R;

public class ForgotActivity extends AppCompatActivity {

    EditText editemail;
    TextView txtemail;
    Button buttonsubmit;
    TextView txtback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot);

        editemail = (EditText)findViewById(R.id.edt_email);
        txtemail = (TextView)findViewById(R.id.txv_email);
        txtback = (TextView)findViewById(R.id.txv_back);
        buttonsubmit = (Button)findViewById(R.id.btn_submit);

        txtback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ForgotActivity.this, SignupActivity.class);
                startActivity(intent);
                finish();
            }
        });


    }


}
