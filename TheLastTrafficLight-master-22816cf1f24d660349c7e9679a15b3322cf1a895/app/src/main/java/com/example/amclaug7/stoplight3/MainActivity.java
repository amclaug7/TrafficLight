package com.example.amclaug7.stoplight3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.graphics.Point;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    private TextView[][] textViews;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        buildGui();
    }

    public void buildGui(){
        Point size = new Point();
        getWindowManager().getDefaultDisplay().getSize(size);
        int w = size.x;
        int l = size.y;

        GridLayout gridLayout = new GridLayout(this);
        gridLayout.setColumnCount(1);
        gridLayout.setRowCount(4);

        textViews = new TextView[1][3];

        for(int col = 0; col < 1; col++){
            for(int row = 0; row < 3; row++){
                textViews[col][row] = new TextView(this);
                gridLayout.addView(textViews[col][row], w,((int) (l * .25)) );
            }
        }

        textViews[0][0].setBackgroundColor(Color.RED);
        textViews[0][0].setVisibility(View.VISIBLE);

        textViews[0][1].setBackgroundColor(Color.YELLOW);
        textViews[0][1].setVisibility(View.INVISIBLE);

        textViews[0][2].setBackgroundColor(Color.GREEN);
        textViews[0][2].setVisibility(View.INVISIBLE);

        button = new Button(this);

        ButtonHandler bh = new ButtonHandler();

        button.setOnClickListener(bh);
        button.setText("Press and See");
        button.setTextSize(20);
        button.setBackgroundColor(Color.GRAY);
        button.setEnabled(true);
        gridLayout.addView(button, w,((int) (l * .1)));

        setContentView(gridLayout);
    }

    public void update(int click){
        if(0 == (click % 3)){
            textViews[0][0].setVisibility(View.VISIBLE);
            textViews[0][1].setVisibility(View.INVISIBLE);
            textViews[0][2].setVisibility(View.INVISIBLE);}
        if(1 == (click % 3)){
            textViews[0][0].setVisibility(View.INVISIBLE);
            textViews[0][1].setVisibility(View.INVISIBLE);
            textViews[0][2].setVisibility(View.VISIBLE);}
        if(2 == (click % 3)){
            textViews[0][0].setVisibility(View.INVISIBLE);
            textViews[0][1].setVisibility(View.VISIBLE);
            textViews[0][2].setVisibility(View.INVISIBLE);}
    }

    int clicks = 0;

    private class ButtonHandler implements View.OnClickListener{
        public void onClick(View v){
            clicks++;
            update(clicks);
        }
    }
}

