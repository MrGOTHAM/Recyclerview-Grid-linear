package com.example.work11.animators;

import android.animation.IntEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.example.work11.R;

import java.sql.Wrapper;

/**
 * Created by anchaoguang on 2019-09-25.
 */
public class Animation1 extends AppCompatActivity {
    public static final String TAG = "Animation1";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.animator1);
        initView();
    }

    public void initView(){
        final Button mButton = findViewById(R.id.animator1_button);
               mButton.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View v) {
                   performAnimator(mButton,100,500);

                   }
               });
    }
    public void performAnimator(final View target, final int start, final int end){
        ValueAnimator valueAnimator = ValueAnimator.ofInt(1,100);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            private IntEvaluator mEvaluator = new IntEvaluator();

            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int currentValue = (int) valueAnimator.getAnimatedValue();
                Log.i(TAG,"currentValue ========"+currentValue);

                float fraction = valueAnimator.getAnimatedFraction();
                target.getLayoutParams().width = mEvaluator.evaluate(fraction,start,end);
                target.requestLayout();
            }
        });
        valueAnimator.setDuration(5000).start();

    }
}
