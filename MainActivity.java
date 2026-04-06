package com.example.currencyconverter;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    RadioGroup currencyGroup;
    Button nextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        currencyGroup = findViewById(R.id.currencyGroup);
        nextButton = findViewById(R.id.nextButton);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int selectedId = currencyGroup.getCheckedRadioButtonId();

                if (selectedId != -1) {
                    RadioButton rb = findViewById(selectedId);
                    String selectedCurrency = rb.getText().toString();

                    Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                    intent.putExtra("Currency", selectedCurrency);
                    startActivity(intent);
                }
            }
        });
    }
}