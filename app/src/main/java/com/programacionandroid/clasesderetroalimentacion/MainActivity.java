package com.programacionandroid.clasesderetroalimentacion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void abriractivities(View view){
        Intent intent = new Intent(this,principal.class);
        startActivity(intent);
    }
    public void abrirurl(View view){
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("https://www.youtube.com/"));
        startActivity(intent);
    }
    public void abrirpackage(View view){
        PackageManager packagemanager = getPackageManager();
        try {
            Intent intent = packagemanager.getLaunchIntentForPackage("com.google.android.youtube");
            if (intent == null){
                throw new PackageManager.NameNotFoundException();
            }
            intent.addCategory(Intent.CATEGORY_LAUNCHER);
            startActivity(intent);
        }catch(PackageManager.NameNotFoundException e){
            Intent intent2 = new Intent(this,principal.class);
            startActivity(intent2);
        }
    }
}