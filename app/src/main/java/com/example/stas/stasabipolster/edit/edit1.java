package com.example.stas.stasabipolster.edit;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.stas.stasabipolster.MainActivity;
import com.example.stas.stasabipolster.OutViewActivity;
import com.example.stas.stasabipolster.R;

public class edit1 extends MainActivity implements View.OnClickListener {
    private EditText etText;
    private Button btnEdit;
    private static final String TAG = "edit1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit1);
        etText = findViewById(R.id.etText);
        btnEdit = findViewById(R.id.btnEdit);
        btnEdit.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        state = true;
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra(changeName,etText.getText().toString());
        startActivity(intent);

    }
}


