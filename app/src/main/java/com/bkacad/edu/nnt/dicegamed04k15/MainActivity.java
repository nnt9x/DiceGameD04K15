package com.bkacad.edu.nnt.dicegamed04k15;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private ImageView imgDice;
    private Button btnSet;
    private TextView tvResult;

    // Bien count, total
    private int total = 0;
    private int count = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        // Bind id
        imgDice = findViewById(R.id.imgDice);
        btnSet = findViewById(R.id.btnReset);
        tvResult = findViewById(R.id.tvResult);
    }

    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    public void randomDice(View view) {
        if (count > 0) {
            // Buoc 1: Random 1 - 6
            // Buoc 2: Set anh tuong ung voi so random
            int rd = getRandomNumber(1, 6);
            switch (rd) {
                case 1:
                    imgDice.setImageDrawable(getDrawable(R.drawable.dice1));
                    break;
                case 2:
                    imgDice.setImageDrawable(getDrawable(R.drawable.dice2));
                    break;
                case 3:
                    imgDice.setImageDrawable(getDrawable(R.drawable.dice3));
                    break;
                case 4:
                    imgDice.setImageDrawable(getDrawable(R.drawable.dice4));
                    break;
                case 5:
                    imgDice.setImageDrawable(getDrawable(R.drawable.dice5));
                    break;
                case 6:
                    imgDice.setImageDrawable(getDrawable(R.drawable.dice6));
                    break;
            }
            // Cong rd voi total
            total = total + rd;
            // Giam count
            count--;
        }
        if(count == 0){
            // Hien thi ket qua, hien thi them nut reset
            tvResult.setText("Total: " + total);
            btnSet.setVisibility(View.VISIBLE);
        }
    }

    public void resetDice(View view) {
        // Reset total, count, hinh mac dinh va an nut reset
        total = 0;
        count = 3;
        imgDice.setImageDrawable(getDrawable(R.drawable.dice0));
        btnSet.setVisibility(View.INVISIBLE);
        tvResult.setText("Total: ?");
    }
}