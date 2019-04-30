package com.example.andlabb.digitialclock;

import android.content.Intent;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextClock;
import android.widget.Toast;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    TextClock tc;
    TextToSpeech tt;
    Button b,a;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tc= (TextClock) findViewById(R.id.textClock);
        b= (Button) findViewById(R.id.button2);
        a= findViewById(R.id.set);
        tt= new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status != TextToSpeech.ERROR)
                {
                    tt.setLanguage(Locale.UK);
                }
            }
        });
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s=tc.getText().toString();
                tt.speak(s, TextToSpeech.QUEUE_FLUSH, null);
            }
        });
        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i;
                i = new Intent(MainActivity.this, alarm.class);
                startActivity(i);
            }
        });
    }
}















