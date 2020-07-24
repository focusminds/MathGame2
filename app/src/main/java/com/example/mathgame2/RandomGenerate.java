package com.example.mathgame2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Random;

public class RandomGenerate extends AppCompatActivity {

    //ConstraintLayout cLa

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random_generate);
        Random randomnumber = new Random();
        int displayNum = randomnumber.nextInt(10-1)+1;
        int chooseNum = randomnumber.nextInt(2-0)+0;
        int negative,positive;
        int solution=0;
        LinearLayout linear_layout = (LinearLayout)findViewById(R.id.linear_layout);

        if(chooseNum == 0){
            negative = randomnumber.nextInt(0+15)-15;
            solution = displayNum-negative;
            for(int i=0;i<Math.abs(negative);i++){
                linear_layout.addView(getImageView(chooseNum));
            }

            //operand.setText("Negative : "+Integer.toString(negative));
        }
        else{
            positive = randomnumber.nextInt(16-0)+0;
            solution = displayNum-positive;
            for(int i=0;i<Math.abs(positive);i++){
                linear_layout.addView(getImageView(chooseNum));
            }

            //operand.setText("Positive : "+Integer.toString(positive));
        }

        //final EditText input = (EditText)findViewById(R.id.editText);
        ImageButton plus = (ImageButton)findViewById(R.id.PlusButton);
        ImageButton minus = (ImageButton)findViewById(R.id.MinusButton);
        final int soln=solution;
        Button kick = (Button)findViewById(R.id.button2);
        final int[] pluscnt = new int[1];
        final int[] minuscnt = new int[1];
        plus.setOnClickListener(new View.OnClickListener() {
            int cnt=0;
            public void onClick(View v) {
                TextView plus = (TextView)findViewById(R.id.plusCnt);
                cnt++;
                plus.setText(Integer.toString(cnt));
                pluscnt[0] =cnt;
            }
        });
        minus.setOnClickListener(new View.OnClickListener(){
            int cnt=0;
            public void onClick(View v){
                TextView minus =(TextView)findViewById(R.id.minusCnt);
                cnt++;
                minus.setText(Integer.toString(cnt));
                minuscnt[0] =cnt;
            }
        });

        kick.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                if(pluscnt[0] ==0){
                    checkAnswer(-1*(minuscnt[0]),soln);
                }
                else{
                    checkAnswer(pluscnt[0],soln);
                }
                //int answer = Integer.parseInt(input.getText().toString());
                //checkAnswer(answer,soln);
            }

        });
        TextView randomNum = (TextView)findViewById(R.id.textView3);
        randomNum.setText(Integer.toString(displayNum));
    }
    public void checkAnswer(int answer,int check){
        EditText result = (EditText)findViewById(R.id.result);
        if(answer == check){
            result.setText("Yaay! You scored a Goal!!!!!");
        }
        else{
            result.setText(Integer.toString(answer)+" "+Integer.toString(check)+" "+"Better Luck Next Time!!");
        }

    }
    private View getImageView(int imgSelect){
        ImageView iv = new ImageView(getApplicationContext());
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT);
        lp.setMargins(20,1, 10,10);
        iv.setLayoutParams(lp);
        iv.requestLayout();
        iv.getLayoutParams().height=30;
        iv.getLayoutParams().width=30;
        if(imgSelect==0){
            iv.setImageResource(R.drawable.minus);
        }
        else{
            iv.setImageResource(R.drawable.plus);
        }


        //iv.setImageResource(R.drawable.minus);
        return iv;
    }
}