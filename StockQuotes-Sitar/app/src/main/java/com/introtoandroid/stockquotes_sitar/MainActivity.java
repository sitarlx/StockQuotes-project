package com.introtoandroid.stockquotes_sitar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    EditText et;
    TextView symbolAnswer;
    TextView nameAnswer;
    TextView priceAnswer;
    TextView timeAnswer;
    TextView changeAnswer;
    TextView rangeAnswer;
    Stock userStock;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et = findViewById(R.id.editText);
        String stringET = et.getText().toString();
        symbolAnswer = findViewById(R.id.symbolAns);
        nameAnswer = findViewById(R.id.nameAns);
        priceAnswer = findViewById(R.id.priceAns);
        timeAnswer = findViewById(R.id.timeAns);
        changeAnswer = findViewById(R.id.changeAns);
        rangeAnswer = findViewById(R.id.rangeAns);
        userStock = new Stock(stringET);
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        switch (keyCode) {
            case KeyEvent.KEYCODE_ENTER:
                try {
                    userStock.load();
                    symbolAnswer.setText(userStock.getSymbol());
                    nameAnswer.setText(userStock.getName());
                    priceAnswer.setText(userStock.getLastTradePrice());
                    timeAnswer.setText(userStock.getLastTradeTime());
                    changeAnswer.setText(userStock.getChange());
                    rangeAnswer.setText(userStock.getRange());
                } catch (IOException e) {
                    Toast.makeText(MainActivity.this, "Error in retrieving stock symbol.", Toast.LENGTH_LONG).show();
                }
                return true;
            default:
                return super.onKeyUp(keyCode, event);
        }
    }

}
