package com.jhl.analogengine;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

//앱 실행 시 인트로 보여주는 layout 화면 노출. 1초 후 메인 화면으로 이동.
public class IntroActivity extends Activity {

    Handler handler = new Handler();

    Runnable r = new Runnable() {

        @Override
        public void run() {
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
            finish();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
    }

    @Override
    protected void onResume(){
        super.onResume();
        handler.postDelayed(r, 1000);
        //1초 뒤에 러너블 객체 실행
    }

    @Override
    protected void onPause(){
        super.onPause();
        handler.removeCallbacks(r);//화면 벗어나면 예약 취소
    }
}