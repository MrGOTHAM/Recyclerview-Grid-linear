package com.example.work11.calendaran;

import android.os.Bundle;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.example.work11.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by anchaoguang on 2019-09-26.
 */
public class Calendar1 extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.animator1);
        initView();
    }
    public void initView(){
        Calendar c = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:dd");
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH) + 1;
        int day = c.get(Calendar.DAY_OF_MONTH);
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int currentTime = c.get(Calendar.MILLISECOND);
        String timeNow = sdf.format(c.getTime());



        Log.i("ancg","当前年份："+year +"  "+month+"  "+day +"    "+hour+"    "+currentTime);
        Log.i("ancg",""+timeNow );
    }
}
