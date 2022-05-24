package com.example.styleproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.text.AllCapsTransformationMethod;

import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.fonts.FontStyle;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener, RadioGroup.OnCheckedChangeListener, View.OnClickListener, CompoundButton.OnCheckedChangeListener {

    private EditText edtTexto;
    private TextView txtTexto;
    private ImageButton imageButton;
    private SeekBar seekBar;
    private CheckBox chkNegr;
    private CheckBox chkItal;
    private CheckBox chkMaius;
    private RadioButton rdVermelho;
    private RadioButton rdVerde;
    private RadioButton rdAzul;
    private RadioGroup group;
    private  TextView textview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtTexto = findViewById(R.id.edtTexto);
        txtTexto = findViewById(R.id.txtTexto);
        imageButton = findViewById(R.id.imageButton);
        seekBar = findViewById(R.id.seekBar);
        chkItal = findViewById(R.id.chkItal);
        chkNegr = findViewById(R.id.chkNegr);
        chkMaius = findViewById(R.id.chkMaius);
        rdVermelho = findViewById(R.id.rdVermelho);
        rdVerde = findViewById(R.id.rdVerde);
        rdAzul = findViewById(R.id.rdAzul);
        group = findViewById(R.id.group);
        textview = findViewById(R.id.textview);

        imageButton.setOnClickListener(this);
        seekBar.setOnSeekBarChangeListener(this);
        group.setOnCheckedChangeListener(this);
        chkItal.setOnCheckedChangeListener(this);
        chkNegr.setOnCheckedChangeListener(this);
        chkMaius.setOnCheckedChangeListener(this);

    }

    @Override
    public void onClick(View v) {
        txtTexto.setText(edtTexto.getText());

    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        txtTexto.setTextSize(progress);
        textview.setText("" + progress + "sp");
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        boolean Vercheckted = ((RadioButton) rdVermelho).isChecked();
        boolean Verdcheckted = ((RadioButton) rdVerde).isChecked();
        boolean Azucheckted = ((RadioButton) rdAzul).isChecked();

        if (Vercheckted){
            txtTexto.setTextColor(Color.RED);
        } else if (Verdcheckted){
            txtTexto.setTextColor(Color.GREEN);
        }else if (Azucheckted){
            txtTexto.setTextColor(Color.BLUE);
        }
    }
    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        boolean checkedI = ((CheckBox) chkItal).isChecked();
        boolean checkedN = ((CheckBox) chkNegr).isChecked();
        boolean checkedM = ((CheckBox) chkMaius).isChecked();
        int style = 0;

        //utilizaçao de operadores ternario para substituir os if-else.
        style|=(checkedN?Typeface.BOLD:Typeface.NORMAL);
        style|=(checkedI?Typeface.ITALIC:Typeface.NORMAL);
        Typeface typeface = Typeface.create(Typeface.SERIF, style);
        txtTexto.setTypeface(typeface);

       if (checkedM == true) {
           txtTexto.setAllCaps(true);
       }else if (checkedM == false){
           txtTexto.setAllCaps(false);
       }
    }
}