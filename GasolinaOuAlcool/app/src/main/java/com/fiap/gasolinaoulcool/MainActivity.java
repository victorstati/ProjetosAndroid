package com.fiap.gasolinaoulcool;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText editPrecoAlcool;
    private EditText editPrecoGasolina;
    private TextView textResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editPrecoAlcool = findViewById(R.id.editPrecoAlcool);
        editPrecoGasolina = findViewById(R.id.editPrecoGasolina);
        textResultado = findViewById(R.id.textResultado);
    }

    public void calcularPreco(View view){
        // recuperar valores digitados
        String precoAlcool = editPrecoAlcool.getText().toString();
        String precoGasolina = editPrecoGasolina.getText().toString();

        // validar campos digitados
        Boolean camposValidados = this.validarCampos(precoAlcool, precoGasolina);
        if(camposValidados){
            this.calcularMelhorPreco(precoAlcool, precoGasolina);
        }else{
            textResultado.setText("Preencha os preços primeiro!");
        }
    }


    public void calcularMelhorPreco(String pAlcool, String pGasolina){
        // converter strings para numero
        double precoAlcool = Double.parseDouble(pAlcool);
        double precoGasolina = Double.parseDouble(pGasolina);

        /*
        Faz calculo (pAlcool / pGasolina)
        Se resiltado >= 7  melhor gasolina senao Alccol
         */
        double resultadoPreco = precoAlcool / precoGasolina;
        if(resultadoPreco >= 7){
            textResultado.setText("Melhor utilizar Gasolina!");
        }else{
            textResultado.setText("Melhor utilizar Álcool!");
        }
    }


    public boolean validarCampos(String pAlcool, String pGasolina){
        boolean camposValidados = true;
        if(pAlcool == null || pAlcool.equals("")){
            camposValidados = false;
        }else if(pGasolina == null || pGasolina.equals("")){
            camposValidados = false;
        }

        return camposValidados;
    }
}
