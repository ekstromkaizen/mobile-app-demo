package com.example.currencyconverter;

import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    EditText inputUsd, inputOther;
    Button usdToOtherButton, otherToUsdButton, returnButton;
    TextView currencyLabel;

    double rate = 1.0;
    String currency;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        inputUsd = findViewById(R.id.inputUsd);
        inputOther = findViewById(R.id.inputOther);
        usdToOtherButton = findViewById(R.id.usdToOther);
        otherToUsdButton = findViewById(R.id.otherToUsd);
        returnButton = findViewById(R.id.returnButton);
        currencyLabel = findViewById(R.id.currencyLabel);

        currency = getIntent().getStringExtra("Currency");
        currencyLabel.setText("Selected Currency: " + currency);

        if(currency.equals("YEN")) rate = 109.94;
        else if (currency.equals("CAD")) rate = 1.26;
        else if (currency.equals("EUR")) rate = 0.85;

        usdToOtherButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double usd = Double.parseDouble(inputUsd.getText().toString());
                double result = usd * rate;
                inputOther.setText(String.valueOf(result));
            }
        });

        otherToUsdButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double other = Double.parseDouble(inputOther.getText().toString());
                double result = other / rate;
                inputUsd.setText(String.valueOf(result));
            }
        });

        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}