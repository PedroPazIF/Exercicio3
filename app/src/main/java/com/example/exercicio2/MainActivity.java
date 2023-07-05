package com.example.exercicio2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.exercicio2.databinding.ActivityMainBinding;

import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private  ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnLimpar.setOnClickListener(this);
        binding.btnExibir.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {

        if(v.getId() == R.id.btnLimpar){
            binding.edtNome.setText("");
            binding.edtEmail.setText("");
            binding.rdbF.setChecked(false);
            binding.rdbM.setChecked(false);
            binding.chkCinema.setChecked(false);
            binding.chkEsporte.setChecked(false);
            binding.chkGastronomia.setChecked(false);
            binding.chkMusica.setChecked(false);
            binding.swtNotification.setChecked(false);
            binding.lblDados.setVisibility(View.INVISIBLE);
        } else if (v.getId() == R.id.btnExibir){
            Toast.makeText(this, "Exibir", Toast.LENGTH_LONG).show();
            binding.lblDados.setVisibility(View.VISIBLE);
            binding.txtNome.setText("Nome: " + binding.edtNome.getText().toString());
            binding.txtEmail.setText("Email: " + binding.edtEmail.getText().toString());


            if (binding.swtNotification.isChecked()){
                binding.txtNotificacao.setText("Notificação " + binding.swtNotification.getTextOn());

            }else
                binding.txtNotificacao.setText("Notificação " + binding.swtNotification.getTextOff());
        }
        int idrdbselecionado = binding.rdgSexo.getCheckedRadioButtonId();
        if (idrdbselecionado > 0) {
            RadioButton rdbselecionado = findViewById(idrdbselecionado);
            binding.txtSexo.setText("Sexo: " + rdbselecionado.getText().toString());
        }

        String pref = "";
        if (binding.chkMusica.isChecked()){
            pref = binding.chkMusica.getText().toString();
            if (binding.chkCinema.isChecked()){
                pref += " ";
                pref += binding.chkCinema.getText().toString();
            }
            if (binding.chkGastronomia.isChecked()){
                pref += " ";
                pref += binding.chkGastronomia.getText().toString();
            }
            if (binding.chkEsporte.isChecked()){
                pref += " ";
                pref += binding.chkEsporte.getText().toString();
            }
            binding.txtPref.setText("Preferencias: " + pref);
        }
    }
}