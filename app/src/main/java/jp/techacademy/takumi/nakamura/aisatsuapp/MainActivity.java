package jp.techacademy.takumi.nakamura.aisatsuapp;

import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView tTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(this);
        tTextView = (TextView) findViewById(R.id.textView);


    }

    private void showTimePickerDialog() {
        TimePickerDialog timePickerDialog = new TimePickerDialog(this,

                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        Log.d("UI_PARTS", String.valueOf(hourOfDay) + ":" + String.valueOf(minute));
                        if (hourOfDay >= 2 && hourOfDay < 10) {
                            TextView textView = (TextView) findViewById(R.id.textView);
                            textView.setText("おはよう");

                        } else if (hourOfDay >= 10 && hourOfDay < 18) {
                            TextView textView = (TextView) findViewById(R.id.textView);
                            textView.setText("こんにちは");

                        } else if (hourOfDay >= 18 && hourOfDay <= 24) {
                            TextView textView = (TextView) findViewById(R.id.textView);
                            textView.setText("こんばんは");
                        } else if(hourOfDay>=0&&hourOfDay<2) {
                            TextView textView = (TextView) findViewById(R.id.textView);
                            textView.setText("こんばんは");
                        }else {
                            TextView textView = (TextView) findViewById(R.id.textView);
                            textView.setText("エラー");

                        }
                    }
                },
                13,
                0, true);
        timePickerDialog.show();


    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button1) {
            showTimePickerDialog();

        }


    }

}

