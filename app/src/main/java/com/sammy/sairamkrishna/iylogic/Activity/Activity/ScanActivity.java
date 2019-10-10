package com.sammy.sairamkrishna.iylogic.Activity.Activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.zxing.Result;
import com.sammy.sairamkrishna.iylogic.Activity.Constant.Constant;
import com.sammy.sairamkrishna.iylogic.R;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

import static android.Manifest.permission.CAMERA;

public class ScanActivity extends AppCompatActivity implements ZXingScannerView.ResultHandler {
    private static final int REQUEST_CAMERA = 1;
    private ZXingScannerView mScannerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mScannerView = new ZXingScannerView(this);

        setContentView(mScannerView);
        int currentapiVersion = Build.VERSION.SDK_INT;
        if(currentapiVersion >= android.os.Build.VERSION_CODES.M){

            if (checkPermission()){
                Toast.makeText(getApplicationContext(),"Permission already granted",Toast.LENGTH_LONG).show();
            } else {
                requestPermission();
            }
        }
    }

    @Override
    public void onResume(){
        super.onResume();
        int currentapiVersion = Build.VERSION.SDK_INT;
        if (currentapiVersion >= android.os.Build.VERSION_CODES.M){

            if (checkPermission()){

                if(mScannerView == null){
                    mScannerView = new ZXingScannerView(this);
                    setContentView(mScannerView);
                }

                mScannerView.setResultHandler(this);
                mScannerView.startCamera();
            } else {
                requestPermission();
            }
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mScannerView.stopCamera();
    }



    private boolean checkPermission(){
        return (ContextCompat.checkSelfPermission(getApplicationContext(),CAMERA) == PackageManager.PERMISSION_GRANTED);
    }

    private void requestPermission() {
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, REQUEST_CAMERA);
    }

    public void onRequestPermissionsResult (int requestCode, String permission[], int[] grantResults){
        switch (requestCode){
            case REQUEST_CAMERA:

                if(grantResults.length > 0){
                    boolean cameraAccepted = grantResults[0] == PackageManager.PERMISSION_GRANTED;
                    if (cameraAccepted){
                        Toast.makeText(getApplicationContext(),"Permission Granted,Now you can access camera",Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(getApplicationContext(),"Permission Denied,You cannot access and camera",Toast.LENGTH_LONG).show();
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){

                            if(shouldShowRequestPermissionRationale(CAMERA)){

                                showMessageOKCancel("You need to allow access to both the permissions",
                                        new DialogInterface.OnClickListener(){

                                    @Override

                                     public  void onClick(DialogInterface dialog , int which){

                                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                                            requestPermissions(new String[]{CAMERA},REQUEST_CAMERA);
                                        }
                                    }
                                });

                                return;
                            }
                        }


                    }
                }

                break;
        }
    }

    private void showMessageOKCancel(String message, DialogInterface.OnClickListener okListner){
        new AlertDialog.Builder(ScanActivity.this)
                .setMessage(message)
                .setPositiveButton("OK",okListner)
                .setNegativeButton("Cancel",null)
                .create()
                .show();
 }

    @Override
    public void handleResult(Result rawResult) {

        final String result = rawResult.getText();
        Log.d("QRCodeScanner", rawResult.getText());
        Log.d("QRCodeScanner", rawResult.getBarcodeFormat().toString());
        Constant.email=result;
        finish();

    }
}
