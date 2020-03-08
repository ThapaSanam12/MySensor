package com.e.mysensor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
TextView value1, value2, value3 ,value4 ,value5;
Button btnStart, btnReset;
CountDownTimer timer= null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        value1=findViewById(R.id.val1);
        value2=findViewById(R.id.val2);
        value3=findViewById(R.id.val3);
        value4=findViewById(R.id.val4);
        value5=findViewById(R.id.val5);
        btnReset=findViewById(R.id.btnReset);
        btnStart=findViewById(R.id.btnStart);

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, MainActivity.class));
            finish();
            }
        });

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Handler handler=new Handler();
                Runnable run =new Runnable() {
                    @Override
                    public void run() {
                        Log.i("Run", "Repeated for every 5 secs ");
                        handler.postDelayed(this, 5000);

                    }
                };
                }

            }
        });

    }
}
