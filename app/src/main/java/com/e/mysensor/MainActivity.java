package com.e.mysensor;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
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
        value1 = findViewById(R.id.val1);
        value2 = findViewById(R.id.val2);
        value3 = findViewById(R.id.val3);
        value4 = findViewById(R.id.val4);
        value5 = findViewById(R.id.val5);
        btnReset = findViewById(R.id.btnReset);
        btnStart = findViewById(R.id.btnStart);

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
                final Handler handler = new Handler();
                final Runnable run = new Runnable() {
                    @Override
                    public void run() {
                        Log.i("Run", "Repeated for every 5 secs ");
                        handler.postDelayed(this, 5000);

                    }
                };
                handler.post(run);

                new CountDownTimer(120000, 5000) {

                    @Override
                    public void onTick(long millisUntilFinished) {
                        int result1 = Integer.parseInt(value1.getText().toString()) + 1;
                        int result2 = Integer.parseInt(value2.getText().toString()) - 1;
                        int result3 = Integer.parseInt(value3.getText().toString()) + 2;
                        int result4 = Integer.parseInt(value4.getText().toString()) - 2;
                        int result5 = Integer.parseInt(value5.getText().toString()) + 3;

                        value1.setText(Integer.toString(result1));
                        value2.setText(Integer.toString(result2));
                        value3.setText(Integer.toString(result3));
                        value4.setText(Integer.toString(result4));
                        value5.setText(Integer.toString(result5));
                        if ((result1 < 15 || result1 > 35) || (result2 < 15 || result2 > 35)
                                || (result3 < 15 || result3 > 35) || (result4 < 15 || result4 > 35) || (result5 < 15 || result5 > 35)
                        ) {
                            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                            builder.setMessage("Value1: " + result1 + "\n" + "Value2: " + result2
                                    + "\n" + "Value3: " + result3 + "\n" + "Value4: " + result4
                                    + "\n" + "Value5: " + result5).setTitle("Alert").setTitle("Alert").setPositiveButton("Reset", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int i) {
                                    Intent intent = new Intent(MainActivity.this, MainActivity.class);
                                    startActivity(intent);
                                }
                            });
                            AlertDialog alertDialog = builder.create();
                            alertDialog.show();
                        }


                    }

                    @Override
                    public void onFinish() {
                        handler.removeCallbacks(run);

                    }
                }
                        .start();
                btnStart.setEnabled(false);

            }
        });

    }
}
