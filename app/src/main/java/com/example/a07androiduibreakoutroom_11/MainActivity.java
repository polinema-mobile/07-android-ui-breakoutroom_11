package com.example.a07androiduibreakoutroom_11;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    EditText date;
    EditText nama;
    EditText nim;
    private String pilihan_jurusan;
    private String pilihan_gender;
    DatePickerDialog datePickerDialog;
    RadioGroup opsi;
    private Spinner spinner;
    private static final String[] paths = {"Akuntansi", "Teknologi Informasi", "Teknik Elektro", "Teknik Sipil", "Teknik Mesin"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nama = (EditText) findViewById(R.id.editText1);
        nim = (EditText) findViewById(R.id.editText2);

        // initiate the date picker and a button
        date = (EditText) findViewById(R.id.editText3);
        // perform click event on edit text

        spinner = (Spinner)findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_spinner_item,paths);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // calender class's instance and get current date , month and year from calender
                final Calendar c = Calendar.getInstance();
                int mYear = c.get(Calendar.YEAR); // current year
                int mMonth = c.get(Calendar.MONTH); // current month
                int mDay = c.get(Calendar.DAY_OF_MONTH); // current day
                // date picker dialog
                datePickerDialog = new DatePickerDialog(MainActivity.this,
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                // set day of month , month and year value in the edit text
                                date.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);

                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.show();
            }
        });

        opsi = (RadioGroup) findViewById(R.id.radioGroup);
        opsi.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.LakiLaki:
                        pilihan_gender = "Laki-Laki";
                        break;
                    case R.id.Perempuan:
                        pilihan_gender = "Perempuan";
                        break;
                }
            }
        });


        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent moveWithDataIntent = new Intent(MainActivity.this, MainActivity2.class);
                moveWithDataIntent.putExtra(MainActivity2.EXTRA_NAME, nama.getText().toString());
                moveWithDataIntent.putExtra(MainActivity2.EXTRA_NIM, Integer.parseInt(nim.getText().toString()));
                moveWithDataIntent.putExtra(MainActivity2.EXTRA_TGL, date.getText().toString());
                moveWithDataIntent.putExtra(MainActivity2.EXTRA_GENDER, pilihan_gender);
                moveWithDataIntent.putExtra(MainActivity2.EXTRA_JURUSAN, pilihan_jurusan);
                startActivity(moveWithDataIntent);
            }
        });

    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
        switch (position) {
            case 0:
                // Whatever you want to happen when the first item gets selected
                pilihan_jurusan = "Akuntansi";
//                Log.v("item", Integer.toString(position));
                break;
            case 1:
                // Whatever you want to happen when the second item gets selected
                pilihan_jurusan = "Teknologi Informasi";
                break;
            case 2:
                // Whatever you want to happen when the thrid item gets selected
                pilihan_jurusan = "Teknik Elektro";
                break;
            case 3:
                // Whatever you want to happen when the thrid item gets selected
                pilihan_jurusan = "Teknik Sipil";
                break;
            case 4:
                // Whatever you want to happen when the thrid item gets selected
                pilihan_jurusan = "Teknik Mesin";
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}