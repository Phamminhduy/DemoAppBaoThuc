package com.example.phamm.demoappbaothuc;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    Button btnHengio,btnDung;
    TimePicker timePicker;
    TextView txtHienThi;
    Calendar calendar;
    AlarmManager alarmManager;
    PendingIntent pending;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AnhXa();
        calendar  = Calendar.getInstance();
        alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        Intent intent = new Intent(MainActivity.this,AlarmReceiver.class);

    }
    private void AnhXa(){
        btnHengio  = (Button) findViewById(R.id.btnDatGio);
        btnDung    = (Button) findViewById(R.id.btnDung);
        timePicker = (TimePicker) findViewById(R.id.timePicker);
        txtHienThi = (TextView) findViewById(R.id.textView);

    }
    public void onPlay(View view){
        AnhXa();
        calendar.set(Calendar.HOUR_OF_DAY,timePicker.getCurrentHour());
        calendar.set(Calendar.MINUTE,timePicker.getCurrentMinute());
        int gio = timePicker.getCurrentHour();
        int phut = timePicker.getCurrentMinute();

        String string_gio = String.valueOf(gio);
        String string_phut = String.valueOf(phut);

        if(gio>12){
            string_gio=String.valueOf( gio-12);
        }
        if(phut<10){
            string_phut = "0"+String.valueOf(phut);
        }
        Intent intent = new Intent(MainActivity.this,AlarmReceiver.class);
        intent.putExtra("extra","on");
        pending=PendingIntent.getBroadcast(MainActivity.this,0,intent,PendingIntent.FLAG_UPDATE_CURRENT);
        alarmManager.set(AlarmManager.RTC_WAKEUP,calendar.getTimeInMillis(),pending);
        txtHienThi.setText("Bạn Đã Đặt Giờ Là: "+string_gio+" : "+string_phut);
    }
    public void onStop(View view){
        AnhXa();
        txtHienThi.setText("Dừng Báo Thức");
        alarmManager.cancel(pending);
        Intent intent = new Intent(MainActivity.this,AlarmReceiver.class);
        intent.putExtra("extra","off");
        sendBroadcast(intent);
    }
}
