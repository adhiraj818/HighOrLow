package com.google.highorlow;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int random = (int)(Math.random() * 20 + 1);
    int n,x=4;

    EditText edt;
    TextView txt;

    public  void onclickenter(View view)
    {
        String s,s1;

        edt =(EditText)findViewById(R.id.etxt);
        txt=(TextView)findViewById(R.id.txt2);
        s=edt.getText().toString();
        s1=txt.getText().toString();

        n=Integer.parseInt(s);
        if(n==random)
        {
            edt.setText("");
            Toast.makeText(this,"click reset for New Game",Toast.LENGTH_LONG).show();
            txt.setText("!!You Won!!");

        }
        else if(n<random)
        {

            if(x<1)
            {
                Toast.makeText(this,"GAME OVER\nclick reset to start a new game"+s,Toast.LENGTH_LONG).show();
                txt.setText("YOU LOOSE");
                x=4;
            }
            else
           {
                Toast.makeText(this, "guess a no. greater than" + s, Toast.LENGTH_LONG).show();
                s1 = txt.getText().toString();
                txt.setText("Attempt Left::"+x);
                x--;
           }

        }
        else if(n>random)
        {
            if(x<1)
            {
                Toast.makeText(this,"GAME OVER\nclick reset to start a new game"+s,Toast.LENGTH_LONG).show();
                txt.setText("YOU LOOSE");
                x=4;
            }
            else
           {
                Toast.makeText(this, "guess a no. smaller than" +s, Toast.LENGTH_LONG).show();
                s1 = txt.getText().toString();
                txt.setText("Attempt Left::"+x);
                x--;
           }
        }
        else
        {
            txt.setText("");
        }
    }

    public void onclickreset(View view)
    {
        int rand = (int)(Math.random() * 20 + 1);
        random=rand;
        txt=(TextView)findViewById(R.id.txt2);
        txt.setText("Attempt Left::5");
        x=4;

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
