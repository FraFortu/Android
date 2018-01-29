package com.frafortu.cassaforte;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button[] buttons;
    private int password = 1234;

    TextView display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int i = 0;
        buttons = new Button[11];

        buttons[i++] = findViewById(R.id.number0);
        buttons[i++] = findViewById(R.id.number1);
        buttons[i++] = findViewById(R.id.number2);
        buttons[i++] = findViewById(R.id.number3);
        buttons[i++] = findViewById(R.id.number4);
        buttons[i++] = findViewById(R.id.number5);
        buttons[i++] = findViewById(R.id.number6);
        buttons[i++] = findViewById(R.id.number7);
        buttons[i++] = findViewById(R.id.number8);
        buttons[i++] = findViewById(R.id.number9);
        buttons[i++] = findViewById(R.id.delete);

        display = findViewById(R.id.text);

        Button ok = findViewById(R.id.ok);
        ok.setOnClickListener(event -> {
            if(isPasswordCorrect(display.getText().toString())) {
                Intent intent = new Intent(this,MainActivity2.class);
                intent.putExtra("password",password);
                startActivityForResult(intent,2);
            }
        });

        for(i = 0; i < buttons.length - 1; i++) {
            int val = i;
            buttons[val].setOnClickListener(view -> {
                display.setText(display.getText().toString() + buttons[val].getText());
                isPasswordCorrect(display.getText().toString());
            });
        }
        buttons[buttons.length - 1].setOnClickListener(view -> {
            if(display.getText().length() > 1) {
                display.setText(display.getText().toString().substring(0, (display.getText().length() - 1)));
                isPasswordCorrect(display.getText().toString());
            } else display.setText("");
        });
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
