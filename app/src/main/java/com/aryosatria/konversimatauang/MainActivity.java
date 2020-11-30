package com.aryosatria.konversimatauang;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    EditText input_uang;
    Button rp_usd, rp_euro, rp_yen;
    TextView hasil_konversi;

    double angka;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (getSupportActionBar() !=null)
            getSupportActionBar().setTitle("Konversi Mata Uang");

        input_uang = (EditText) findViewById(R.id.uang_input);
        rp_usd = (Button) findViewById(R.id.rpusd);
        rp_euro = (Button) findViewById(R.id.rpeuro);
        rp_yen = (Button) findViewById(R.id.rpyen);
        hasil_konversi = (TextView) findViewById(R.id.hasil_konversi);
    }

    public boolean cek(){
        if (input_uang.getText().toString().isEmpty()){
            Toast.makeText(this, "Silahkan masukan jumblah uang", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    public void toYEN(View view){
        if (!cek()){
            return;
        }

        try {
            angka = Double.parseDouble(input_uang.getText().toString());
        }catch (Exception e){
            Toast.makeText(this, "Masukan angka", Toast.LENGTH_SHORT).show();
        }

        double hasil = angka/123;
        hasil_konversi.setText(NumberFormat.getCurrencyInstance(Locale.JAPAN).format(hasil));
        Toast.makeText(this, "1 Yen = Rp 123", Toast.LENGTH_SHORT).show();
    }

    public void toEuro(View view){
        if (!cek()){
            return;
        }

        try {
            angka = Double.parseDouble(input_uang.getText().toString());
        }catch (Exception e){
            Toast.makeText(this, "Masukan angka", Toast.LENGTH_SHORT).show();
        }

        double hasil = angka/17228;
        hasil_konversi.setText(NumberFormat.getCurrencyInstance(Locale.GERMANY).format(hasil));
        Toast.makeText(this, "1 Euro = 17.228", Toast.LENGTH_SHORT).show();
    }

    public void toUSD(View view){
        if (!cek()) {
            return;
        }

        try {
            angka = Double.parseDouble(input_uang.getText().toString());
        }catch (Exception e){
            Toast.makeText(this, "Masukan angka", Toast.LENGTH_SHORT).show();
        }

        double hasil = angka/14230;
        hasil_konversi.setText(NumberFormat.getCurrencyInstance(Locale.US).format(hasil));
        Toast.makeText(this, "U$S 14.230", Toast.LENGTH_SHORT).show();
    }
}