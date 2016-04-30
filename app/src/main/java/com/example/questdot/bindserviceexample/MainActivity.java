package com.example.questdot.bindserviceexample;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements ServiceConnection {

    Button btnBind,btnUnbind;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnBind=(Button)findViewById(R.id.btnBind);
        btnUnbind=(Button)findViewById(R.id.btnUnbind);

        btnBind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bindService(new Intent(MainActivity.this,MyService.class),MainActivity.this, Context.BIND_AUTO_CREATE);
            }
        });
        btnUnbind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                unbindService(MainActivity.this);
            }
        });
    }


    @Override
    public void onServiceConnected(ComponentName name, IBinder service) {
        System.out.println("Service Connected");
    }

    @Override
    public void onServiceDisconnected(ComponentName name) {
        System.out.println("Service Disconnected");

    }
}
