package com.example.a07androiduibreakoutroom_11;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    EditText date;
    EditText nama;
    EditText nim;
    private String pilihan_jurusan;
    private String pilihan_gender;
    DatePickerDialog datePickerDialog;
    RadioGroup opsi;
    private Spinner spinner;
    private static final String[] paths = {"Akuntansi", "Teknologi Informasi", "Teknik Elektro", "Teknik Sipil", "Teknik Mesin"};

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

        Button button = findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent moveWithDataIntent = new Intent(MainActivity2.this, MainActivity2.class);
                moveWithDataIntent.putExtra(MainActivity2.EXTRA_NAME, nama.getText().toString());
                moveWithDataIntent.putExtra(MainActivity2.EXTRA_GENDER, pilihan_gender);
                moveWithDataIntent.putExtra(MainActivity2.EXTRA_JURUSAN, pilihan_jurusan);
                startActivity(moveWithDataIntent);
            }
        });
    }
}