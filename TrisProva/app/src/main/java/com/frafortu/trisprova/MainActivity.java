package com.frafortu.trisprova;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button[][] buttons = new Button[3][3];
        int row = 0;
        int column = 0;
        buttons[row][column++] = findViewById(R.id.button);
        buttons[row][column++] = findViewById(R.id.button4);
        buttons[row++][column] = findViewById(R.id.button5);
        column = 0;
        buttons[row][column++] = findViewById(R.id.button6);
        buttons[row][column++] = findViewById(R.id.button7);
        buttons[row++][column] = findViewById(R.id.button8);
        column = 0;
        buttons[row][column++] = findViewById(R.id.button9);
        buttons[row][column++] = findViewById(R.id.button11);
        buttons[row][column] = findViewById(R.id.button10);
        TrisManagement tris = new TrisManagement(buttons);
        tris.gioca();
    }
    public class TrisManagement {
        private Random generator = new Random();
        private Button[][] buttons;
        private boolean[][] haveBeenClicked;
        public TrisManagement(Button[][] btns) {
            this.buttons = btns;
            this.haveBeenClicked = new boolean[buttons[0].length][buttons.length];
            for(int i = 0; i < haveBeenClicked.length; i++) {
                for(int j = 0; j < haveBeenClicked[i].length; j++) {
                    haveBeenClicked[i][j] = false;
                }
            }
        }
        public void gioca() {
            for(int i = 0; i < buttons.length; i++) {
                for(int j = 0; j < buttons[i].length; j++) {
                    int selRow = i;
                    int selCol = j;
                    buttons[selRow][selCol].setOnClickListener((View view) -> {
                        if(haveBeenClicked[selRow][selCol] == false) {
                            ((Button) view).setText("X");
                            haveBeenClicked[selRow][selCol] = true;
                            try {
                                TimeUnit.SECONDS.sleep(4);
                                while(true) {
                                    int riga = generator.nextInt(3);
                                    int colonna = generator.nextInt(3);
                                    if (haveBeenClicked[riga][colonna] == false) {
                                        buttons[riga][colonna].setText("O");
                                        haveBeenClicked[riga][colonna] = true;
                                        break;
                                    }
                                }
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        } else {
                            Toast.makeText(MainActivity.this, "Can't click", Toast.LENGTH_LONG).show();
                        }
                    });
                }
            }
        }
        public String victoryConditionRow() {
            boolean vinceXRiga[] = new boolean[buttons[0].length], vinceORiga[] = new boolean[buttons[0].length];
            boolean vinceXCol[] = new boolean[buttons[0].length], vinceOCol[] = new boolean[buttons[0].length];
            boolean vinceXDiag[] = new boolean[buttons[0].length], vinceODiag[] = new boolean[buttons[0].length];
            for(int row = 0; row < buttons.length; row++) {
                for(int column = 0; column < buttons[row].length; column++) {
                    if(buttons[row][column].getText().equals("X")) {
                    } else if (buttons[row][column].getText().equals("O")) {
                    }
                }
            }
            return "ciao";
        }
    }
}
