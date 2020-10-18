package com.example.stas.stasabipolster;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

//Основное активити, там где идёт главная настройка данных.
import com.example.stas.stasabipolster.edit.edit1;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnIgor, btnYurak, btnVasil, btnOlex, btnJanek, btnLembit, btnHanno, btnMarko, btnJuro, btnRuslan, btnDmitro, btnNew, btnNew0_2, btnNew0_3,btnNadalReset;
    private Button Igormin, Yurakmin, Vasilmin, Olexmin, Janekmin, Lembitmin, Hannomin, Markomin, YuroPmin, Ruslanmin, Dmitromin, Newminn, Newmin0_2, Newmin0_3;
    private TextView txIgor, txYurak, txVasil, txOlex, txJanek, txLembit, txHanno, txMarko, txJuro, txRuslan, txDmitro, progNum, txName, txNew0_2, txNew0_3;

    Button btn_Reset, btnSave, btnLoad;
    private static int totalScore_Igor;
    private static int totalScore_Yurak;
    private static int totalScore_Vasil;
    private static int totalScore_Olex;
    private static int totalScore_Janek;
    private static int totalScore_Lembit;
    private static int totalScore_Hanno;
    private static int totalScore_Marko;
    private static int totalScore_Juro;
    private static int totalScore_Ruslan;
    private static int totalScore_Dmitro;
    private static int totalScore_NAME;
    private static int totalScore_NAME0_2;
    private static int totalScore_NAME0_3;
    public static HashMap<String,Integer> nadalCounter = new HashMap<>();

    SharedPreferences sPref;
    public static boolean state; // использую для того , использованно ли было изменение имяни или нет.
    public static String changeName;
    ArrayList<String> names = new ArrayList<>();
    public static ArrayList<Button> btnNames = new ArrayList<>(); // для кнопок
    public static ArrayList<Button> btnMinus = new ArrayList<>(); // для кнопок
    ArrayList<TextView> texts = new ArrayList<>(); // для значений
    private static final String TAG = "MainActivity";
    private String nameIgor, nameJurak, nameVasil, nameOlex, nameJanek, nameLembit, nameHanno, nameMarko, nameJuroP, nameRuslan, nameDmitro, nameNew, nameNew0_2, nameNew0_3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        names.clear();
        btnNames.clear();
        texts.clear();
        Log.d(TAG, " Вызван onCreate");
        /*Обявление кнопок*/
        btnIgor = findViewById(R.id.btnIgor1);
        btnYurak = findViewById(R.id.btnYurak1);
        btnVasil = findViewById(R.id.btnVasil1);
        btnOlex = findViewById(R.id.btnOlex1);
        btnJanek = findViewById(R.id.btnJanek1);
        btnLembit = findViewById(R.id.btnLembit1);
        btnHanno = findViewById(R.id.btnHanno1);
        btnMarko = findViewById(R.id.btnMarko1);
        btnJuro = findViewById(R.id.btnYuro1);
        btnRuslan = findViewById(R.id.btnRuslan1);
        btnDmitro = findViewById(R.id.btnDmitro1);
        btnNew = findViewById(R.id.btnNew1);
        btnNew0_2 = findViewById(R.id.btnNew0_2);
        btnNew0_3 = findViewById(R.id.btnNew0_3);
        btnNadalReset = findViewById(R.id.btnNadalReset);
        btnNadalReset.setOnClickListener(this);

        //Кнопки минусов
        Igormin = findViewById(R.id.Igormin);
        Yurakmin = findViewById(R.id.Yurakmin);
        Vasilmin = findViewById(R.id.Vasilmin);
        Olexmin = findViewById(R.id.Olexmin);
        Janekmin = findViewById(R.id.Janekmin);
        Lembitmin = findViewById(R.id.Lembitmin);
        Hannomin = findViewById(R.id.Hannomin);
        YuroPmin = findViewById(R.id.YuroPmin);
        Ruslanmin = findViewById(R.id.Ruslanmin);
        Dmitromin = findViewById(R.id.Dmitromin);
        Markomin = findViewById(R.id.Markomin);
        Newminn = findViewById(R.id.Newmin);
        Newmin0_2 = findViewById(R.id.Newmin0_2);
        Newmin0_3 = findViewById(R.id.Newmin0_3);

        Igormin.setOnClickListener(this);
        Yurakmin.setOnClickListener(this);
        Vasilmin.setOnClickListener(this);
        Olexmin.setOnClickListener(this);
        Janekmin.setOnClickListener(this);
        Lembitmin.setOnClickListener(this);
        Hannomin.setOnClickListener(this);
        YuroPmin.setOnClickListener(this);
        Ruslanmin.setOnClickListener(this);
        Dmitromin.setOnClickListener(this);
        Markomin.setOnClickListener(this);
        Newminn.setOnClickListener(this);
        Newmin0_2.setOnClickListener(this);
        Newmin0_3.setOnClickListener(this);


        txName = findViewById(R.id.txName1);
        txIgor = findViewById(R.id.txIgor1);
        txYurak = findViewById(R.id.txYurak1);
        txVasil = findViewById(R.id.txVasil1);
        txOlex = findViewById(R.id.txOlex1);
        txJanek = findViewById(R.id.txJanek1);
        txLembit = findViewById(R.id.txLembit1);
        txHanno = findViewById(R.id.txHanno1);
        txMarko = findViewById(R.id.txMarko1);
        txJuro = findViewById(R.id.txYuro1);
        txRuslan = findViewById(R.id.txRuslan1);
        txDmitro = findViewById(R.id.txDmitro1);
        txNew0_2 = findViewById(R.id.txNew0_2);
        txNew0_3 = findViewById(R.id.txNew0_3);
        progNum = findViewById(R.id.progNum1);

        //Кнопки управления
        btn_Reset = findViewById(R.id.btn_Reset);
        btn_Reset.setOnClickListener(this);
        btnSave = findViewById(R.id.btnSave);
        btnSave.setOnClickListener(this);
        btnLoad = findViewById(R.id.btnLoad);
        btnLoad.setOnClickListener(this);

        listadds(); // добавление в листы такие как -  names/btnNames/texts

        for (int i = 0; i < btnNames.size(); i++) {
            btnNames.get(i).setOnClickListener(this);
            registerForContextMenu(btnNames.get(i));
        }
        loadText(); // загрузка значений
        loadName();//загрузка имён
        if (state) {
            onChangeName(state); // для сохранения нового имени!
            Intent i = new Intent(this, OutViewActivity.class);
            i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(i);
        }
        OnloadNadalValues();
        //onChangeName(state);// если было изменено имя, то заходит сюда что бы сохранить данные.

    }

    private void OnloadNadalValues() {
        nadalCounter.clear();
        Map<String, ?> map = new HashMap<>();
        sPref = getSharedPreferences("NadalSave",MODE_PRIVATE);
        map = sPref.getAll();
        for (Map.Entry<String,?> pair : map.entrySet()){ //загружаем все данные в nadalCounter, после в OutViewActivity считывает данные и загружмет их.
            nadalCounter.put(pair.getKey(), (Integer) pair.getValue());
        }
    }

    private void listadds() {
        names.add(nameNew = btnNew.getText().toString());
        names.add(nameIgor = btnIgor.getText().toString());
        names.add(nameJurak = btnYurak.getText().toString());
        names.add(nameVasil = btnVasil.getText().toString());
        names.add(nameOlex = btnOlex.getText().toString());
        names.add(nameJanek = btnJanek.getText().toString());
        names.add(nameLembit = btnLembit.getText().toString());
        names.add(nameHanno = btnHanno.getText().toString());
        names.add(nameMarko = btnHanno.getText().toString());
        names.add(nameJuroP = btnJuro.getText().toString());
        names.add(nameRuslan = btnRuslan.getText().toString());
        names.add(nameDmitro = btnDmitro.getText().toString());
        names.add(nameNew0_2 = btnNew0_2.getText().toString());
        names.add(nameNew0_3 = btnNew0_3.getText().toString());

        btnNames.add(btnNew);
        btnNames.add(btnIgor);
        btnNames.add(btnYurak);
        btnNames.add(btnVasil);
        btnNames.add(btnOlex);
        btnNames.add(btnJanek);
        btnNames.add(btnLembit);
        btnNames.add(btnHanno);
        btnNames.add(btnMarko);
        btnNames.add(btnJuro);
        btnNames.add(btnRuslan);
        btnNames.add(btnDmitro);
        btnNames.add(btnNew0_2);
        btnNames.add(btnNew0_3);

        texts.add(txName);
        texts.add(txIgor);
        texts.add(txYurak);
        texts.add(txVasil);
        texts.add(txOlex);
        texts.add(txJanek);
        texts.add(txLembit);
        texts.add(txHanno);
        texts.add(txMarko);
        texts.add(txJuro);
        texts.add(txRuslan);
        texts.add(txDmitro);
        texts.add(txNew0_2);
        texts.add(txNew0_3);
        texts.add(progNum);
    }

    public void onChangeName(boolean st) {
        if (st) {
            try {
                Intent intent = getIntent();
                if (btnNew.getText().toString().equals(changeName)) {
                    nameNew = intent.getStringExtra(changeName);
                    methodToSaveName(btnNew, nameNew, "SAVE1");
                } else if (btnIgor.getText().toString().equals(changeName)) {
                    nameIgor = intent.getStringExtra(changeName);
                    methodToSaveName(btnIgor, nameIgor, "SAVE2");
                } else if (btnYurak.getText().toString().equals(changeName)) {
                    nameJurak = intent.getStringExtra(changeName);
                    methodToSaveName(btnYurak, nameJurak, "SAVE3");
                } else if (btnVasil.getText().toString().equals(changeName)) {
                    nameVasil = intent.getStringExtra(changeName);
                    methodToSaveName(btnVasil, nameVasil, "SAVE4");
                } else if (btnOlex.getText().toString().equals(changeName)) {
                    nameOlex = intent.getStringExtra(changeName);
                    methodToSaveName(btnOlex, nameOlex, "SAVE5");
                } else if (btnJanek.getText().toString().equals(changeName)) {
                    nameJanek = intent.getStringExtra(changeName);
                    methodToSaveName(btnJanek, nameJanek, "SAVE6");
                } else if (btnLembit.getText().toString().equals(changeName)) {
                    nameLembit = intent.getStringExtra(changeName);
                    methodToSaveName(btnLembit, nameLembit, "SAVE7");
                } else if (btnHanno.getText().toString().equals(changeName)) {
                    nameHanno = intent.getStringExtra(changeName);
                    methodToSaveName(btnHanno, nameHanno, "SAVE8");
                } else if (btnMarko.getText().toString().equals(changeName)) {
                    nameMarko = intent.getStringExtra(changeName);
                    methodToSaveName(btnMarko, nameMarko, "SAVE9");
                } else if (btnJuro.getText().toString().equals(changeName)) {
                    nameJuroP = intent.getStringExtra(changeName);
                    methodToSaveName(btnJuro, nameJuroP, "SAVE10");
                } else if (btnRuslan.getText().toString().equals(changeName)) {
                    nameRuslan = intent.getStringExtra(changeName);
                    methodToSaveName(btnRuslan, nameRuslan, "SAVE11");
                } else if (btnDmitro.getText().toString().equals(changeName)) {
                    nameDmitro = intent.getStringExtra(changeName);
                    methodToSaveName(btnDmitro, nameDmitro, "SAVE12");
                } else if (btnNew0_2.getText().toString().equals(changeName)) {
                    nameNew0_2 = intent.getStringExtra(changeName);
                    methodToSaveName(btnNew0_2, nameNew0_2, "SAVE13");
                } else if (btnNew0_3.getText().toString().equals(changeName)) {
                    nameNew0_3 = intent.getStringExtra(changeName);
                    methodToSaveName(btnNew0_3, nameNew0_3, "SAVE14");
                }
            } catch (Exception e) {
                e.printStackTrace();
                Log.d(TAG, "onChangeName: Блок ошибки!");
            }
            state = false;
            changeName = null;
        }

    }

    private void methodToSaveName(Button b, String s, String key) {
        b.setText(s);
        sPref = getSharedPreferences("SaveNames", MODE_PRIVATE);
        SharedPreferences.Editor editor = sPref.edit();
        editor.putString(key, s);
        editor.apply();
    }

    private void loadName() {
        //Log.d(TAG, "loadName: зашли в загрузку имён");
        sPref = getSharedPreferences("SaveNames", MODE_PRIVATE);
        String s = "";
        String s1 = "";
        StringBuilder key = new StringBuilder("SAVE1");
        for (int i = 0; i < btnNames.size(); i++) {
            s1 = key.toString();
            s = sPref.getString(s1, "");
            if (s == null || s.length() < 1) {//если s пустая , тогда даём новое значение key
                key.delete(4, key.length());
                key.append(i + 2);
            } else { // если s не пустая , тогда посылаем имя на нужную кнопку
                btnNames.get(i).setText(s);
                key.delete(4, key.length());
                key.append(i + 2);
            }
        }

    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

        switch (v.getId()) {
            case R.id.btnNew1:
                getMenuInflater().inflate(R.menu.menunewname, menu);
                changeName = btnNew.getText().toString();
                break;
            case R.id.btnIgor1:
                getMenuInflater().inflate(R.menu.menunewname, menu);
                changeName = btnIgor.getText().toString();
                break;
            case R.id.btnYurak1:
                getMenuInflater().inflate(R.menu.menunewname, menu);
                changeName = btnYurak.getText().toString();
                break;
            case R.id.btnVasil1:
                getMenuInflater().inflate(R.menu.menunewname, menu);
                changeName = btnVasil.getText().toString();
                break;
            case R.id.btnOlex1:
                getMenuInflater().inflate(R.menu.menunewname, menu);
                changeName = btnOlex.getText().toString();
                break;
            case R.id.btnJanek1:
                getMenuInflater().inflate(R.menu.menunewname, menu);
                changeName = btnJanek.getText().toString();
                break;
            case R.id.btnLembit1:
                getMenuInflater().inflate(R.menu.menunewname, menu);
                changeName = btnLembit.getText().toString();
                break;
            case R.id.btnHanno1:
                getMenuInflater().inflate(R.menu.menunewname, menu);
                changeName = btnHanno.getText().toString();
                break;
            case R.id.btnMarko1:
                getMenuInflater().inflate(R.menu.menunewname, menu);
                changeName = btnMarko.getText().toString();
                break;
            case R.id.btnYuro1:
                getMenuInflater().inflate(R.menu.menunewname, menu);
                changeName = btnJuro.getText().toString();
                break;
            case R.id.btnRuslan1:
                getMenuInflater().inflate(R.menu.menunewname, menu);
                changeName = btnRuslan.getText().toString();
                break;
            case R.id.btnDmitro1:
                getMenuInflater().inflate(R.menu.menunewname, menu);
                changeName = btnDmitro.getText().toString();
                break;
            case R.id.btnNew0_2:
                getMenuInflater().inflate(R.menu.menunewname, menu);
                changeName = btnNew0_2.getText().toString();
                break;
            case R.id.btnNew0_3:
                getMenuInflater().inflate(R.menu.menunewname, menu);
                changeName = btnNew0_3.getText().toString();
                break;
        }
        super.onCreateContextMenu(menu, v, menuInfo);

    }


    @Override
    public boolean onContextItemSelected(MenuItem item) {
        Intent intent;
        switch (item.getItemId()) {
            case R.id.item22:
                intent = new Intent(this, edit1.class);
                startActivity(intent);
                break;
        }
        return super.onContextItemSelected(item);
    }


    @Override
    protected void onResume() {
        super.onResume();
        sPref = getSharedPreferences("ScorePref", MODE_PRIVATE);
        totalScore_Igor = sPref.getInt("SAVE1", 0);
        totalScore_Yurak = sPref.getInt("SAVE2", 0);
        totalScore_Vasil = sPref.getInt("SAVE3", 0);
        totalScore_Olex = sPref.getInt("SAVE4", 0);
        totalScore_Janek = sPref.getInt("SAVE5", 0);
        totalScore_Lembit = sPref.getInt("SAVE6", 0);
        totalScore_Hanno = sPref.getInt("SAVE7", 0);
        totalScore_Marko = sPref.getInt("SAVE8", 0);
        totalScore_Juro = sPref.getInt("SAVE9", 0);
        totalScore_Ruslan = sPref.getInt("SAVE10", 0);
        totalScore_Dmitro = sPref.getInt("SAVE11", 0);
        totalScore_NAME = sPref.getInt("SAVE12", 0);
        totalScore_NAME0_2 = sPref.getInt("SAVE13", 0);
        totalScore_NAME0_3 = sPref.getInt("SAVE14", 0);
        txIgor.setText(String.valueOf(totalScore_Igor));
        txYurak.setText(String.valueOf(totalScore_Yurak));
        txVasil.setText(String.valueOf(totalScore_Vasil));
        txOlex.setText(String.valueOf(totalScore_Olex));
        txJanek.setText(String.valueOf(totalScore_Janek));
        txLembit.setText(String.valueOf(totalScore_Lembit));
        txHanno.setText(String.valueOf(totalScore_Hanno));
        txMarko.setText(String.valueOf(totalScore_Marko));
        txJuro.setText(String.valueOf(totalScore_Juro));
        txRuslan.setText(String.valueOf(totalScore_Ruslan));
        txDmitro.setText(String.valueOf(totalScore_Dmitro));
        txName.setText(String.valueOf(totalScore_NAME));
        txNew0_2.setText(String.valueOf(totalScore_NAME0_2));
        txNew0_3.setText(String.valueOf(totalScore_NAME0_3));
    }


    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.btnNadalReset:
                nadalCounter.clear();
                sPref = getSharedPreferences("NadalSave",MODE_PRIVATE);
                SharedPreferences.Editor editor2 = sPref.edit();
                editor2.clear().apply();
                break;
            case R.id.btnIgor1:
                totalScore_Igor++;
                txIgor.setText(String.valueOf(totalScore_Igor));
                addInNadal(btnIgor.getText().toString());
                break;
            case R.id.btnYurak1:
                totalScore_Yurak++;
                txYurak.setText(String.valueOf(totalScore_Yurak));
                addInNadal(btnYurak.getText().toString());
                break;
            case R.id.btnVasil1:
                totalScore_Vasil++;
                txVasil.setText(String.valueOf(totalScore_Vasil));
                addInNadal(btnVasil.getText().toString());
                break;
            case R.id.btnOlex1:
                totalScore_Olex++;
                txOlex.setText(String.valueOf(totalScore_Olex));
                addInNadal(btnOlex.getText().toString());
                break;
            case R.id.btnJanek1:
                totalScore_Janek++;
                txJanek.setText(String.valueOf(totalScore_Janek));
                addInNadal(btnJanek.getText().toString());
                break;
            case R.id.btnLembit1:
                totalScore_Lembit++;
                txLembit.setText(String.valueOf(totalScore_Lembit));
                addInNadal(btnLembit.getText().toString());
                break;
            case R.id.btnHanno1:
                totalScore_Hanno++;
                txHanno.setText(String.valueOf(totalScore_Hanno));
                addInNadal(btnHanno.getText().toString());
                break;
            case R.id.btnMarko1:
                totalScore_Marko++;
                txMarko.setText(String.valueOf(totalScore_Marko));
                addInNadal(btnMarko.getText().toString());
                break;
            case R.id.btnYuro1:
                totalScore_Juro++;
                txJuro.setText(String.valueOf(totalScore_Juro));
                addInNadal(btnJuro.getText().toString());
                break;
            case R.id.btnRuslan1:
                totalScore_Ruslan++;
                txRuslan.setText(String.valueOf(totalScore_Ruslan));
                addInNadal(btnRuslan.getText().toString());
                break;
            case R.id.btnDmitro1:
                totalScore_Dmitro++;
                txDmitro.setText(String.valueOf(totalScore_Dmitro));
                addInNadal(btnDmitro.getText().toString());
                break;
            case R.id.btnNew1:
                totalScore_NAME++;
                txName.setText(String.valueOf(totalScore_NAME));
                addInNadal(btnNew.getText().toString());
                break;
            case R.id.btnNew0_2:
                totalScore_NAME0_2++;
                txNew0_2.setText(String.valueOf(totalScore_NAME0_2));
                addInNadal(btnNew0_2.getText().toString());
                break;
            case R.id.btnNew0_3:
                totalScore_NAME0_3++;
                txNew0_3.setText(String.valueOf(totalScore_NAME0_3));
                addInNadal(btnNew0_3.getText().toString());
                break;
            case R.id.Igormin:
                if (totalScore_Igor > 0)
                    totalScore_Igor--;
                txIgor.setText(String.valueOf(totalScore_Igor));
                removeFromNadal(btnIgor.getText().toString());
                break;
            case R.id.Yurakmin:
                if (totalScore_Yurak > 0)
                    totalScore_Yurak--;
                txYurak.setText(String.valueOf(totalScore_Yurak));
                removeFromNadal(btnYurak.getText().toString());
                break;
            case R.id.Vasilmin:
                if (totalScore_Vasil > 0)
                    totalScore_Vasil--;
                txVasil.setText(String.valueOf(totalScore_Vasil));
                removeFromNadal(btnVasil.getText().toString());
                break;
            case R.id.Olexmin:
                if (totalScore_Olex > 0)
                    totalScore_Olex--;
                txOlex.setText(String.valueOf(totalScore_Olex));
                removeFromNadal(btnOlex.getText().toString());
                break;
            case R.id.Janekmin:
                if (totalScore_Janek > 0)
                    totalScore_Janek--;
                txJanek.setText(String.valueOf(totalScore_Janek));
                removeFromNadal(btnJanek.getText().toString());
                break;
            case R.id.Lembitmin:
                if (totalScore_Lembit > 0)
                    totalScore_Lembit--;
                txLembit.setText(String.valueOf(totalScore_Lembit));
                removeFromNadal(btnLembit.getText().toString());
                break;
            case R.id.Hannomin:
                if (totalScore_Hanno > 0)
                    totalScore_Hanno--;
                txHanno.setText(String.valueOf(totalScore_Hanno));
                removeFromNadal(btnHanno.getText().toString());
                break;
            case R.id.Markomin:
                if (totalScore_Marko > 0)
                    totalScore_Marko--;
                txMarko.setText(String.valueOf(totalScore_Marko));
                removeFromNadal(btnMarko.getText().toString());
                break;
            case R.id.YuroPmin:
                if (totalScore_Juro > 0)
                    totalScore_Juro--;
                txJuro.setText(String.valueOf(totalScore_Juro));
                removeFromNadal(btnJuro.getText().toString());
                break;
            case R.id.Ruslanmin:
                if (totalScore_Ruslan > 0)
                    totalScore_Ruslan--;
                txRuslan.setText(String.valueOf(totalScore_Ruslan));
                removeFromNadal(btnRuslan.getText().toString());
                break;
            case R.id.Dmitromin:
                if (totalScore_Dmitro > 0)
                    totalScore_Dmitro--;
                txDmitro.setText(String.valueOf(totalScore_Dmitro));
                removeFromNadal(btnDmitro.getText().toString());
                break;
            case R.id.Newmin:
                if (totalScore_NAME > 0)
                    totalScore_NAME--;
                txName.setText(String.valueOf(totalScore_NAME));
                removeFromNadal(btnNew.getText().toString());
                break;
            case R.id.Newmin0_2:
                if (totalScore_NAME0_2 > 0) {
                    totalScore_NAME0_2--;
                    txNew0_2.setText(String.valueOf(totalScore_NAME0_2));
                    removeFromNadal(btnNew0_2.getText().toString());
                }
                break;
            case R.id.Newmin0_3:
                if (totalScore_NAME0_3 > 0) {
                    totalScore_NAME0_3--;
                    txNew0_3.setText(String.valueOf(totalScore_NAME0_3));
                    removeFromNadal(btnNew0_3.getText().toString());
                }
                break;

            case R.id.btnSave:
                sPref = getSharedPreferences("ScorePref", MODE_PRIVATE);
                SharedPreferences.Editor editor = sPref.edit();
                editor.putInt("SAVE1", totalScore_Igor);
                editor.putInt("SAVE2", totalScore_Yurak);
                editor.putInt("SAVE3", totalScore_Vasil);
                editor.putInt("SAVE4", totalScore_Olex);
                editor.putInt("SAVE5", totalScore_Janek);
                editor.putInt("SAVE6", totalScore_Lembit);
                editor.putInt("SAVE7", totalScore_Hanno);
                editor.putInt("SAVE8", totalScore_Marko);
                editor.putInt("SAVE9", totalScore_Juro);
                editor.putInt("SAVE10", totalScore_Ruslan);
                editor.putInt("SAVE11", totalScore_Dmitro);
                editor.putInt("SAVE12", totalScore_NAME);
                editor.putInt("SAVE13", totalScore_NAME0_2);
                editor.putInt("SAVE14", totalScore_NAME0_3);
                editor.apply();
                Toast.makeText(MainActivity.this, "Text is Saved", Toast.LENGTH_SHORT).show();
                progress();
                intent = new Intent(this, OutViewActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                break;
            case R.id.btn_Reset:
                txIgor.setText(String.valueOf(totalScore_Igor = 0));
                txYurak.setText(String.valueOf(totalScore_Yurak = 0));
                txVasil.setText(String.valueOf(totalScore_Vasil = 0));
                txOlex.setText(String.valueOf(totalScore_Olex = 0));
                txJanek.setText(String.valueOf(totalScore_Janek = 0));
                txLembit.setText(String.valueOf(totalScore_Lembit = 0));
                txHanno.setText(String.valueOf(totalScore_Hanno = 0));
                txJuro.setText(String.valueOf(totalScore_Juro = 0));
                txRuslan.setText(String.valueOf(totalScore_Ruslan = 0));
                txDmitro.setText(String.valueOf(totalScore_Dmitro = 0));
                txMarko.setText(String.valueOf(totalScore_Marko = 0));
                txName.setText(String.valueOf(totalScore_NAME = 0));
                txNew0_2.setText(String.valueOf(totalScore_NAME0_2 = 0));
                txNew0_3.setText(String.valueOf(totalScore_NAME0_3 = 0));
                progress();
                btnSave.callOnClick();
                intent = new Intent(this, OutViewActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);

                break;
            case R.id.btnLoad:
                sPref = getSharedPreferences("ScorePref", MODE_PRIVATE);
                totalScore_Igor = sPref.getInt("SAVE1", 0);
                totalScore_Yurak = sPref.getInt("SAVE2", 0);
                totalScore_Vasil = sPref.getInt("SAVE3", 0);
                totalScore_Olex = sPref.getInt("SAVE4", 0);
                totalScore_Janek = sPref.getInt("SAVE5", 0);
                totalScore_Lembit = sPref.getInt("SAVE6", 0);
                totalScore_Hanno = sPref.getInt("SAVE7", 0);
                totalScore_Marko = sPref.getInt("SAVE8", 0);
                totalScore_Juro = sPref.getInt("SAVE9", 0);
                totalScore_Ruslan = sPref.getInt("SAVE10", 0);
                totalScore_Dmitro = sPref.getInt("SAVE11", 0);
                totalScore_NAME = sPref.getInt("SAVE12", 0);
                totalScore_NAME0_2 = sPref.getInt("SAVE13", 0);
                totalScore_NAME0_3 = sPref.getInt("SAVE14", 0);
                txIgor.setText(String.valueOf(totalScore_Igor));
                txYurak.setText(String.valueOf(totalScore_Yurak));
                txVasil.setText(String.valueOf(totalScore_Vasil));
                txOlex.setText(String.valueOf(totalScore_Olex));
                txJanek.setText(String.valueOf(totalScore_Janek));
                txLembit.setText(String.valueOf(totalScore_Lembit));
                txHanno.setText(String.valueOf(totalScore_Hanno));
                txMarko.setText(String.valueOf(totalScore_Marko));
                txJuro.setText(String.valueOf(totalScore_Juro));
                txRuslan.setText(String.valueOf(totalScore_Ruslan));
                txDmitro.setText(String.valueOf(totalScore_Dmitro));
                txName.setText(String.valueOf(totalScore_NAME));
                txNew0_2.setText(String.valueOf(totalScore_NAME0_2));
                txNew0_3.setText(String.valueOf(totalScore_NAME0_3));
                Toast.makeText(MainActivity.this, "Text is Loaded", Toast.LENGTH_SHORT).show();
                //loadText();
                intent = new Intent(this, OutViewActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                break;


        }

    }

    private void removeFromNadal(String name) {
        sPref = getSharedPreferences("NadalSave",MODE_PRIVATE);
        SharedPreferences.Editor editor = sPref.edit();
        if (nadalCounter.containsKey(name)){
            int nadalCount = nadalCounter.get(name);
            if (nadalCount == 0){
                nadalCounter.put(name,nadalCount);
                nadalCounter.put(name,nadalCount);
                editor.putInt(name,nadalCount);
                editor.apply();
            }else {
                nadalCount--;
                nadalCounter.put(name, nadalCount);
                editor.putInt(name,nadalCount);
                editor.apply();
            }
        }
    }

    private void addInNadal(String name) {
        sPref = getSharedPreferences("NadalSave",MODE_PRIVATE);
        SharedPreferences.Editor editor = sPref.edit();
        if (nadalCounter.containsKey(name)){
         int nadalCount = nadalCounter.get(name);
         nadalCount++;
         nadalCounter.put(name,nadalCount);
         editor.putInt(name,nadalCount);
         editor.apply();
        }else {
            nadalCounter.put(name,1);
            editor.putInt(name,1);
            editor.apply();
        }
        //nadalCounter.put(name,count);
    }


    public void loadText() {
        sPref = getSharedPreferences("ScorePref", MODE_PRIVATE);
        totalScore_Igor = sPref.getInt("SAVE1", 0);
        totalScore_Yurak = sPref.getInt("SAVE2", 0);
        totalScore_Vasil = sPref.getInt("SAVE3", 0);
        totalScore_Olex = sPref.getInt("SAVE4", 0);
        totalScore_Janek = sPref.getInt("SAVE5", 0);
        totalScore_Lembit = sPref.getInt("SAVE6", 0);
        totalScore_Hanno = sPref.getInt("SAVE7", 0);
        totalScore_Marko = sPref.getInt("SAVE8", 0);
        totalScore_Juro = sPref.getInt("SAVE9", 0);
        totalScore_Ruslan = sPref.getInt("SAVE10", 0);
        totalScore_Dmitro = sPref.getInt("SAVE11", 0);
        totalScore_NAME = sPref.getInt("SAVE12", 0);
        totalScore_NAME0_2 = sPref.getInt("SAVE13", 0);
        totalScore_NAME0_3 = sPref.getInt("SAVE14", 0);
        txIgor.setText(String.valueOf(totalScore_Igor));
        txYurak.setText(String.valueOf(totalScore_Yurak));
        txVasil.setText(String.valueOf(totalScore_Vasil));
        txOlex.setText(String.valueOf(totalScore_Olex));
        txJanek.setText(String.valueOf(totalScore_Janek));
        txLembit.setText(String.valueOf(totalScore_Lembit));
        txHanno.setText(String.valueOf(totalScore_Hanno));
        txMarko.setText(String.valueOf(totalScore_Marko));
        txJuro.setText(String.valueOf(totalScore_Juro));
        txRuslan.setText(String.valueOf(totalScore_Ruslan));
        txDmitro.setText(String.valueOf(totalScore_Dmitro));
        txName.setText(String.valueOf(totalScore_NAME));
        txNew0_2.setText(String.valueOf(totalScore_NAME0_2));
        txNew0_3.setText(String.valueOf(totalScore_NAME0_3));
        progress();

    }

    public void progress() {
        int kokku = totalScore_Igor + totalScore_Yurak + totalScore_Vasil + totalScore_Olex +
                totalScore_Janek + totalScore_Lembit + totalScore_Hanno + totalScore_Marko +
                totalScore_Juro + totalScore_Ruslan + totalScore_Dmitro + totalScore_NAME+totalScore_NAME0_2+totalScore_NAME0_3;
        progNum.setText(String.valueOf(kokku));
    }
}



