package com.example.complexpermissions;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.security.Permission;

public class MainActivity extends AppCompatActivity {
private Button btn;
    public static final int REQUEST_CODE=0;
    private int requestCode;
    private String[] permissions;
    private String[] permission1;
    private int[] grantResults;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn=findViewById(R.id.btn);
         btn.setOnClickListener(new View.OnClickListener() {

             @Override
             public void onClick(View v) {
             String [] permission={Manifest.permission.CAMERA,Manifest.permission.WRITE_EXTERNAL_STORAGE};

                 ActivityCompat.requestPermissions(MainActivity.this,permission,REQUEST_CODE);

             }
         });
    }
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        super.onRequestPermissionsResult(requestCode, permissions,grantResults);
        if (grantResults[0] == PackageManager.PERMISSION_GRANTED && grantResults[1]==PackageManager.PERMISSION_GRANTED) {
            showtoast("Both permission are granted");
        }else if (grantResults[0]==PackageManager.PERMISSION_DENIED &&grantResults[1]==PackageManager.PERMISSION_GRANTED){
            showtoast("Camera permission denied and Storage granted");
        }else if (grantResults[0] == PackageManager.PERMISSION_GRANTED && grantResults[1]==PackageManager.PERMISSION_DENIED){
            showtoast("Camera permission granted and Storage denied");
        }else {
            showtoast("Both are denied");
        }
    }
            private void showtoast(String message) {
                Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
            }
}