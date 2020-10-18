package com.example.stas.stasabipolster;

import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
// Это первое активити , где идёт ввод пароля.

public class OutViewActivity extends MainActivity implements View.OnClickListener {
    private static final String TAG = "OutViewActivity";
    private EditText editText;
    ArrayList<Button> buttonsList = new ArrayList<>();
    ArrayList<TextView> textList = new ArrayList<>();
    ArrayList<TextView> nadalList = new ArrayList<>();
    private ConstraintLayout constraintLayout;
    private Button setting, btnIgor2, btnYurak2, btnVasil2, btnOlex2, btnJanek2, btnLembit2, btnHanno2, btnMarko2, btnJuro2, btnRuslan2, btnDmitro2,btnNew1_0, btnNew1_2, btnNew1_3;
    private TextView txIgor2, txYurak2, txVasil2, txOlex2, txJanek2, txLembit2, txHanno2, txMarko2, txJuro2, txRuslan2, txDmitro2, progNum2, txName1_0,txName1_2,txName1_3,txMonth;
    private TextView nadalIgor, nadalYurak, nadalVasil, nadalOlex, nadalJanek, nadalLembit, nadalHanno, nadalMarko, nadalJuro, nadalRuslan, nadalDmitro, nadalName1_0, nadalNew1_2, nadalNew1_3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_out_view);
        constraintLayout = findViewById(R.id.Rev);

        btnIgor2 = findViewById(R.id.btnIgor);
        btnYurak2 = findViewById(R.id.btnYurak);
        btnVasil2 = findViewById(R.id.btnVasil);
        btnOlex2 = findViewById(R.id.btnOlex);
        btnJanek2 = findViewById(R.id.btnJanek);
        btnLembit2 = findViewById(R.id.btnLembit);
        btnHanno2 = findViewById(R.id.btnHanno);
        btnMarko2 = findViewById(R.id.btnMarko);
        btnJuro2 = findViewById(R.id.btnYuro);
        btnRuslan2 = findViewById(R.id.btnRuslan);
        btnDmitro2 = findViewById(R.id.btnDmitro);
        btnNew1_0 = findViewById(R.id.btnNew);
        btnNew1_2 = findViewById(R.id.btnNew1_2);
        btnNew1_3 = findViewById(R.id.btnNew1_3);

        txName1_0 = findViewById(R.id.txName);
        txIgor2 = findViewById(R.id.txIgor);
        txYurak2 = findViewById(R.id.txYurak);
        txVasil2 = findViewById(R.id.txVasil);
        txOlex2 = findViewById(R.id.txOlex);
        txJanek2 = findViewById(R.id.txJanek);
        txLembit2 = findViewById(R.id.txLembit);
        txHanno2 = findViewById(R.id.txHanno);
        txMarko2 = findViewById(R.id.txMarko);
        txJuro2 = findViewById(R.id.txYuro);
        txRuslan2 = findViewById(R.id.txRuslan);
        txDmitro2 = findViewById(R.id.txDmitro);
        txName1_2 = findViewById(R.id.txNew1_2);
        txName1_3 = findViewById(R.id.txNew1_3);


        nadalDmitro = findViewById(R.id.textView9);
        nadalHanno = findViewById(R.id.textView8);
        nadalIgor = findViewById(R.id.IgorNadal);
        nadalJanek = findViewById(R.id.textView5);
        nadalJuro = findViewById(R.id.textView10);
        nadalLembit = findViewById(R.id.textView);
        nadalMarko = findViewById(R.id.textView12);
        nadalName1_0 = findViewById(R.id.textView6);
        nadalNew1_2 = findViewById(R.id.textView7);
        nadalNew1_3 = findViewById(R.id.textView13);
        nadalOlex = findViewById(R.id.textView4);
        nadalRuslan = findViewById(R.id.textView11);
        nadalVasil = findViewById(R.id.textView3);
        nadalYurak = findViewById(R.id.textView2);
        addNadalList();

        txMonth = findViewById(R.id.nameOfMonth);
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE MMMM yyyy",Locale.ENGLISH);
            String date = dateFormat.format(new Date());
            String [] date1 = date.split(" ");
            txMonth.setText(String.valueOf(date1[1]));
        } catch (Exception e) {
            e.printStackTrace();
        }

        progNum2 = findViewById(R.id.progNum);

        editText = findViewById(R.id.editText);
        setting = findViewById(R.id.btnSettings);
        setting.setOnClickListener(this);

        buttonsList.add(btnNew1_0);
        buttonsList.add(btnIgor2);
        buttonsList.add(btnYurak2);
        buttonsList.add(btnVasil2);
        buttonsList.add(btnOlex2);
        buttonsList.add(btnJanek2);
        buttonsList.add(btnLembit2);
        buttonsList.add(btnHanno2);
        buttonsList.add(btnMarko2);
        buttonsList.add(btnJuro2);
        buttonsList.add(btnRuslan2);
        buttonsList.add(btnDmitro2);
        buttonsList.add(btnNew1_2);
        buttonsList.add(btnNew1_3);

        textList.add(txName1_0);
        textList.add(txIgor2);
        textList.add(txYurak2);
        textList.add(txVasil2);
        textList.add(txOlex2);
        textList.add(txJanek2);
        textList.add(txLembit2);
        textList.add(txHanno2);
        textList.add(txMarko2);
        textList.add(txJuro2);
        textList.add(txRuslan2);
        textList.add(txDmitro2);
        textList.add(txName1_2);
        textList.add(txName1_3);
        textList.add(progNum2);
        setNameandViewOnPossitions();
    }

    private void addNadalList() {
        nadalList.add(nadalName1_0);
        nadalList.add(nadalIgor);
        nadalList.add(nadalYurak);
        nadalList.add(nadalVasil);
        nadalList.add(nadalOlex);
        nadalList.add(nadalJanek);
        nadalList.add(nadalLembit);
        nadalList.add(nadalHanno);
        nadalList.add(nadalMarko);
        nadalList.add(nadalJuro);
        nadalList.add(nadalRuslan);
        nadalList.add(nadalDmitro);
        nadalList.add(nadalNew1_2);
        nadalList.add(nadalNew1_3);
    }

    private void setNameandViewOnPossitions() {
        Log.d(TAG, "setNameandViewOnPossitions: " + buttonsList.size());
            for (int i = 0; i < buttonsList.size(); i++) {
                buttonsList.get(i).setText(btnNames.get(i).getText().toString());
            }
            for (int i = 0; i < textList.size(); i++) {
                textList.get(i).setText(texts.get(i).getText().toString());
            }


        try {
            for (int i = 0; i < buttonsList.size(); i++) { // загрузка недельных данных
                String s = String.valueOf(nadalCounter.get(buttonsList.get(i).getText().toString()));
                Log.d(TAG, "setNameandViewOnPossitions:  s = " + s);
                if (s == null || s.equals("null")){
                    Log.d(TAG, "setNameandViewOnPossitions:  заходим в null");
                    nadalList.get(i).setText("0");
                }else{
                    Log.d(TAG, "setNameandViewOnPossitions:  заходим в else");
                    nadalList.get(i).setText(String.valueOf(nadalCounter.get(buttonsList.get(i).getText().toString())));
                }
            }
        } catch (Exception e) {
            Log.d(TAG, "setNameandViewOnPossitions: " + e.getMessage());
            e.printStackTrace();
        }
    }



    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.btnSettings:
                String s = String.valueOf(editText.getText());
                if (s.equals("889")) {
                    intent = new Intent(this, MainActivity.class);
                    startActivity(intent);
                    editText.setText("");
                } else {
                    Toast.makeText(this, "Доступ закрыт!", Toast.LENGTH_LONG).show();
                    editText.setText("");
                }
                break;
        }

    }
}
