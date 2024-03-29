package com.example.modul3;

import static android.widget.Toast.LENGTH_LONG;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements TextWatcher {
    AutoCompleteTextView ac;
    public String[] stringdataprodi = {"Teknik Informatika", "Sistem Informasi", "Desain Komunikasi Visual", "Manajemen Informatika", "Teknik Sipil"};
    EditText lv;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ac = (AutoCompleteTextView) findViewById(R.id.dataautocomplete);
        ac.addTextChangedListener(this);
        ac.setAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, stringdataprodi));
    }

    public void pilihprodi(View v) {
        lv = (EditText) findViewById(R.id.datalistview);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Data Program Studi Fakultas Ilmu Komputer");
        builder.setItems(stringdataprodi, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int item) {
                lv.setText(stringdataprodi[item]);
                dialog.dismiss();
            }
        }).show();
    }

    public void onTextChanged(CharSequence s, int start, int before, int count) {
    }

    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
    }

    public void afterTextChanged(Editable s) {
    }

    public void onPause() {
        super.onPause();
        Toast.makeText(this, "Posisi sedang pause", LENGTH_LONG).show();
        LinearLayout linearLayout = findViewById(R.id.linearParent);
        // Ubah warna latar belakang LinearLayout
        linearLayout.setBackgroundColor(getResources().getColor(R.color.red));
    }
}
