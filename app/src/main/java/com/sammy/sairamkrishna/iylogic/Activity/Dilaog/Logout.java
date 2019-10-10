package com.sammy.sairamkrishna.iylogic.Activity.Dilaog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.sammy.sairamkrishna.iylogic.Activity.Activity.MainActivity;
import com.sammy.sairamkrishna.iylogic.Activity.Activity.SigninActivity;
import com.sammy.sairamkrishna.iylogic.Activity.Constant.Constant;
import com.sammy.sairamkrishna.iylogic.R;

import static com.sammy.sairamkrishna.iylogic.Activity.Constant.Constant.c;


public class Logout extends Dialog implements
        android.view.View.OnClickListener {


    public Dialog d;
    public Button ok, cancel;

    public Logout(Activity a) {
        super(a);
        // TODO Auto-generated constructor stub
        c = a;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView( R.layout.pop_dialog);
        ok = (Button) findViewById(R.id.txv_okay);
        cancel = (Button) findViewById(R.id.txv_cancel);
        ok.setOnClickListener(this);
        cancel.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.txv_okay:

                Intent intent = new Intent(c,SigninActivity.class);
                c.startActivity(intent);



                break;
            case R.id.txv_cancel:
                dismiss();
                break;
        }

    }
}
