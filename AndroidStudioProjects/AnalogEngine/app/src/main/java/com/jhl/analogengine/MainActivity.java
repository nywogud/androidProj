package com.jhl.analogengine;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //메인화면 진입 시 기본 세팅

        Button buttonSens = (Button) findViewById(R.id.sens);
        Button buttonGrap = (Button) findViewById(R.id.grap);
        Button buttonDesi = (Button) findViewById(R.id.desi);

        buttonSens.setBackgroundColor(Color.rgb(0, 0, 0));
        buttonGrap.setBackgroundColor(Color.rgb(104, 102, 102));
        buttonDesi.setBackgroundColor(Color.rgb(104, 102, 102));

        changeView(0);

        //'감성명함' 버튼 클릭
        buttonSens.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //클릭 시 버튼 색 변경
                buttonSens.setBackgroundColor(Color.rgb(0, 0, 0));
                buttonGrap.setBackgroundColor(Color.rgb(104, 102, 102));
                buttonDesi.setBackgroundColor(Color.rgb(104, 102, 102));

                //프레임레이아웃에 넣을 화면 불러오는 함수 호출
                changeView(0);
            }
        });

        //'그래픽명함' 버튼 클릭
        buttonGrap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonSens.setBackgroundColor(Color.rgb(104, 102, 102));
                buttonGrap.setBackgroundColor(Color.rgb(0, 0, 0));
                buttonDesi.setBackgroundColor(Color.rgb(104, 102, 102));

                //프레임레이아웃에 넣을 화면 불러오는 함수 호출
                changeView(1);
            }
        });

        //'디자인쿠폰' 버튼 클릭
        buttonDesi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonSens.setBackgroundColor(Color.rgb(104, 102, 102));
                buttonGrap.setBackgroundColor(Color.rgb(104, 102, 102));
                buttonDesi.setBackgroundColor(Color.rgb(0, 0, 0));

                //프레임레이아웃에 넣을 화면 불러오는 함수 호출
                changeView(2);
            }
        });


    }

    //화면 전환 함수 정의
    //파라미터는 0,1,2
    //각각 감성명함, 그래픽 명함, 디자인 쿠폰 화면으로 전환
    private void changeView(int index) {
        //LayoutInflater
        LayoutInflater layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.frame);

        //기존 화면이 정의 돼 있는 경우 화면 제거
        if(frameLayout.getChildCount()>0){
            frameLayout.removeViewAt(0);
        }

        View view = null;
        //파라미터인 index 번호에 따라 다른 layout 호출
        switch (index){

            case 0:
                view = layoutInflater.inflate(R.layout.activity_sens, frameLayout, false);
                break;
            case 1:
                view = layoutInflater.inflate(R.layout.activity_grap, frameLayout, false);
                break;
            case 2:
                view = layoutInflater.inflate(R.layout.activity_desi, frameLayout, false);
                break;
        }

        if (view != null){
            frameLayout.addView(view);
        }

    }

}