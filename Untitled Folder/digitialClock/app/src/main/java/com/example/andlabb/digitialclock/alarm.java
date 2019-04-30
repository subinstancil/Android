package com.example.andlabb.digitialclock;

import android.content.Intent;
import android.provider.AlarmClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;

public class alarm extends AppCompatActivity {
    Button b;
    TimePicker timepicker;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);
        b = findViewById(R.id.SetAlarm);
        timepicker = (TimePicker) findViewById(R.id.timePicker);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int hour = timepicker.getCurrentHour();
                int min = timepicker.getCurrentMinute();
                Intent i = new Intent(AlarmClock.ACTION_SET_ALARM);
                i.putExtra(AlarmClock.EXTRA_HOUR, hour);
                i.putExtra(AlarmClock.EXTRA_MINUTES, min);
                i.putExtra(AlarmClock.EXTRA_SKIP_UI, true);
                startActivity(i);
            }
        });
    }
}
