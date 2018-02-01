package com.frafortu.cassaforte;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //private Button[] buttons;
    private int password = 1234;

    TextView display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int i = 0;
        //buttons = new Button[11];

       /* buttons[i++] = findViewById(R.id.number0);
        buttons[i++] = findViewById(R.id.number1);
        buttons[i++] = findViewById(R.id.number2);
        buttons[i++] = findViewById(R.id.number3);
        buttons[i++] = findViewById(R.id.number4);
        buttons[i++] = findViewById(R.id.number5);
        buttons[i++] = findViewById(R.id.number6);
        buttons[i++] = findViewById(R.id.number7);
        buttons[i++] = findViewById(R.id.number8);
        buttons[i++] = findViewById(R.id.number9);
        buttons[i++] = findViewById(R.id.delete);*/

        display = findViewById(R.id.text);
        Button b = new Button(this);
        b.setOnClickListener(event -> {
            if(event.getId() == R.id.number0) {
                display.setText(((String) display.getText() + "0"));
            } else if(event.getId() ==  R.id.number1) {
                display.setText(((String) display.getText() + R.id.number1));
            } else if(event.getId() ==  R.id.number2) {
                display.setText(((String) display.getText() + R.id.number2));
            } else if(event.getId() ==  R.id.number3) {
                display.setText(((String) display.getText() + R.id.number3));
            } else if(event.getId() ==  R.id.number4) {
                display.setText(((String) display.getText() + R.id.number4));
            } else if(event.getId() ==  R.id.number5) {
                display.setText(((String) display.getText() + R.id.number5));
            } else if(event.getId() ==  R.id.number6) {
                display.setText(((String) display.getText() + R.id.number6));
            } else if(event.getId() ==  R.id.number7) {
                display.setText(((String) display.getText() + R.id.number7));
            } else if(event.getId() ==  R.id.number8) {
                display.setText(((String) display.getText() + R.id.number8));
            } else if(event.getId() ==  R.id.number9) {
                display.setText(((String) display.getText() + R.id.number9));
            } else if(event.getId() ==  R.id.delete) {
                display.setText(((String)display.getText()).substring(0, (display.getText().length() - 1)));
            }
            if(isPasswordCorrect((String) display.getText())) {
                Intent intent = new Intent(this,MainActivity2.class);
                intent.putExtra("password", password);
                startActivityForResult(intent,2);
            }
        });

        /*Button ok = findViewById(R.id.ok);
        ok.setOnClickListener(event -> {
            if(isPasswordCorrect((String) display.getText())) {
                Intent intent = new Intent(this,MainActivity2.class);
                intent.putExtra("password", password);
                startActivityForResult(intent,2);
            }
        });

        for(i = 0; i < buttons.length - 1; i++) {
            int val = i;
            buttons[val].setOnClickListener(view -> {
                display.setText(((String) display.getText() + buttons[val].getText()));
                isPasswordCorrect((String) display.getText());
            });
        }
        buttons[buttons.length - 1].setOnClickListener(view -> {
            if(display.getText().length() > 1) {
                display.setText(((String)display.getText()).substring(0, (display.getText().length() - 1)));
                isPasswordCorrect((String) display.getText());
            } else display.setText("");
        });*/
    }
    public boolean isPasswordCorrect(String text) {
        if(Integer.parseInt(text) == password) {
            display.setTextColor(getResources().getColor(R.color.green));
            return true;
        } else{
            display.setTextColor(getResources().getColor(R.color.red));
            return false;
        }
    }
}
