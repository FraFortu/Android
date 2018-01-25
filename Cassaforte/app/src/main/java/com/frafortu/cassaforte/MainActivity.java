package com.frafortu.cassaforte;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private String toDisplay;
    private Button[] buttons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int i = 0;
        buttons = new Button[11];
        toDisplay = "";

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

        TextView display = findViewById(R.id.textView);

        for(i = 0; i < buttons.length - 1; i++) {
            int val = i;
            buttons[val].setOnClickListener(view -> {
                toDisplay += buttons[val].getText();
            });
        }
        buttons[buttons.length - 1].setOnClickListener(view -> {
            toDisplay = toDisplay.substring(0,toDisplay.length() - 1);
        });
    }
}
