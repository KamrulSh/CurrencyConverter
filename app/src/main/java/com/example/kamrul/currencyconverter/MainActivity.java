package com.example.kamrul.currencyconverter;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        convertFixedData();
    }

    final double USDTOEURO = 0.88;
    final double USDTOTAKA = 84.57;
    final double USDTOBTC = 0.000084;

    Button convertBtn;
    Button clearBtn;

    private EditText txtUSDollers;
    private EditText txtEuros;
    private EditText txtTaka;
    private EditText txtBtc;

    public void convertFixedData() {

        txtUSDollers = findViewById(R.id.inputUSD);
        txtUSDollers.setHint("Enter US doller");

        txtEuros = findViewById(R.id.resultEuro);
        txtTaka = findViewById(R.id.resultTaka);
        txtBtc = findViewById(R.id.resultBtc);

        convertBtn = findViewById(R.id.convertBtn);
        clearBtn = findViewById(R.id.clearBtn);

        convertBtn.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ShowToast")
            @Override
            public void onClick(View view) {
                try {
                    String usdStr = txtUSDollers.getText().toString();
                    double usd = Double.parseDouble(usdStr);

                    String euroStr = String.valueOf(usd*USDTOEURO);
                    String takaStr = String.valueOf(usd*USDTOTAKA);
                    String btcStr = String.valueOf(usd*USDTOBTC);

                    txtEuros.setText(euroStr);
                    txtTaka.setText(takaStr);
                    txtBtc.setText(btcStr);
                }

                catch (Exception excep) {
                    Toast.makeText(view.getContext(), "Invalid data !!!", Toast.LENGTH_LONG);
                }

            }
        });

        clearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtUSDollers.getText().clear();
                txtEuros.getText().clear();
                txtTaka.getText().clear();
            }
        });

    }

}
