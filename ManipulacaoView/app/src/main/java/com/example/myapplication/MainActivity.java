package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText edtNome;
    private EditText edtEmail;
    private EditText edtTel;
    private Switch swtNotif;
    private RadioGroup rdgSexo;
    private RadioButton rdbMasc;
    private RadioButton rdbFemin;
    private CheckBox chkMusica;
    private CheckBox chkCinema;
    private CheckBox chkEsporte;
    private CheckBox chkGastronomia;
    private Button btnLimpar;
    private Button btnExibir;
    private LinearLayout lblDados;
    private TextView txtNome;
    private TextView txtEmail;
    private TextView txtTelefone;
    private TextView txtSexo;
    private TextView txtNotif;
    private TextView txtPref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtNome = findViewById(R.id.edtNome);
        edtEmail = findViewById(R.id.edtEmail);
        edtTel = findViewById(R.id.edtTelefone);
        swtNotif = findViewById(R.id.swtNotif);
        rdgSexo = findViewById(R.id.rdgSexo);
        rdbMasc = findViewById(R.id.rdbMasc);
        rdbFemin = findViewById(R.id.rdbFemin);
        chkMusica = findViewById(R.id.chkMusica);
        chkCinema = findViewById(R.id.chkCinema);
        chkEsporte = findViewById(R.id.chkEsporte);
        chkGastronomia = findViewById(R.id.chkGastronomia);

        btnLimpar = findViewById(R.id.btnLimpar);
        btnExibir = findViewById(R.id.btnExibir);

        btnLimpar.setOnClickListener(this);
        btnExibir.setOnClickListener(this);

        lblDados = findViewById(R.id.lblDados);
        txtNome = findViewById(R.id.txtNome);
        txtEmail = findViewById(R.id.txtEmail);
        txtTelefone = findViewById(R.id.txtTelefone);
        txtSexo = findViewById(R.id.txtSexo);
        txtPref = findViewById(R.id.txtPref);
        txtNotif = findViewById(R.id.txtNotif);

    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.btnExibir){
            lblDados.setVisibility(View.VISIBLE);
            txtNome.setText("Nome: " + edtNome.getText().toString());
            txtEmail.setText("E-mail: " + edtEmail.getText().toString());
            txtTelefone.setText("Telefone: " +edtTel.getText().toString());

            if (swtNotif.isChecked())
                txtNotif.setText("Notificação: " + swtNotif.getTextOn());
            else
                txtNotif.setText("Notificação: " + swtNotif.getTextOff());

            int idrdbSelecionado = rdgSexo.getCheckedRadioButtonId();
            if (idrdbSelecionado > 0){
                RadioButton rdbSelecionado = findViewById(idrdbSelecionado);
                txtSexo.setText("Sexo: " + rdbSelecionado.getText().toString());
            }

            String pref="";
            if (chkMusica.isChecked())
                pref = chkMusica.getText().toString();
            if (chkCinema.isChecked()) {
                pref += " ";
                pref += chkCinema.getText().toString();
            }
            if(chkEsporte.isChecked()){
                pref += " ";
                pref += chkEsporte.getText().toString();
            }
            if(chkGastronomia.isChecked()){
                pref += " ";
                pref += chkGastronomia.getText().toString();
            }
            txtPref.setText("Preferências: " + pref);

        }else if (view.getId() == R.id.btnLimpar){
            edtNome.setText("");
            edtEmail.setText("");
            edtTel.setText("");
            swtNotif.setChecked(false);
            rdgSexo.clearCheck();
            chkMusica.setChecked(false);
            chkCinema.setChecked(false);
            chkEsporte.setChecked(false);
            chkGastronomia.setChecked(false);
            lblDados.setVisibility(View.INVISIBLE);

        }
    }
}