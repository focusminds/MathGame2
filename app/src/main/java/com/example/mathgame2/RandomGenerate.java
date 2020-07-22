package com.example.mathgame2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class RandomGenerate extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random_generate);
        Random randomnumber = new Random();
        int displayNum = randomnumber.nextInt(10-1)+1;
        int chooseNum = randomnumber.nextInt(2-0)+0;
        int negative,positive;
        int solution=0;
        TextView operand = (TextView)findViewById(R.id.textView2);
        if(chooseNum == 0){
            negative = randomnumber.nextInt(0+15)-15;
            solution = displayNum-negative;
            operand.setText("Negative : "+Integer.toString(negative));
        }
        else{
            positive = randomnumber.nextInt(16-0)+0;
            solution = displayNum-positive;
            operand.setText("Positive : "+Integer.toString(positive));
        }

        final EditText input = (EditText)findViewById(R.id.editText);
        final int soln=solution;
        Button kick = (Button)findViewById(R.id.button2);
        kick.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                int answer = Integer.parseInt(input.getText().toString());
                checkAnswer(answer,soln);
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
            result.setText("Better Luck Next Time!!");
        }

    }
}