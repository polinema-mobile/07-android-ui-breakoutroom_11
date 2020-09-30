package com.example.a07androiduibreakoutroom_11;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    public static final String EXTRA_NAME = "extra_name";
    public static final String EXTRA_NIM = "extra_nim";
    public static final String EXTRA_TGL = "extra_tgl";
    public static final String EXTRA_GENDER = "extra_gender";
    public static final String EXTRA_JURUSAN = "extra_jurusan";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        TextView tvDataReceived = findViewById(R.id.tv_data_received);

        String name = getIntent().getStringExtra(EXTRA_NAME);
        int nim = getIntent().getIntExtra(EXTRA_NIM, 0);
        String date = getIntent().getStringExtra(EXTRA_TGL);
        String gender = getIntent().getStringExtra(EXTRA_GENDER);
        String jurusan = getIntent().getStringExtra(EXTRA_JURUSAN);


        String text = "Nama : " + name + ",\nNim : " + nim + ",\nTanggal Lahir : " + date + ",\nJenis Kelamin : "+ gender + ",\nJurusan : " + jurusan;
        tvDataReceived.setText(text);
    }
}