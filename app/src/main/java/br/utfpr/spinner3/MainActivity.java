package br.utfpr.spinner3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Spinner spinnerPaises;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //instancia spinner.
        spinnerPaises = findViewById(R.id.spinnerPaises);

        popularSpinnerPaises();
    }

    private void popularSpinnerPaises() {
        String[] nomes = getResources().getStringArray(R.array.nomes_paises);
        TypedArray bandeiras = getResources().obtainTypedArray(R.array.bandeiras_paises);

        ArrayList<Pais> paises = new ArrayList<Pais>();

        //Popula array paises
        for(int i=0; i < nomes.length; i++) paises.add(new Pais(nomes[i], bandeiras.getDrawable(i)));

        PaisesAdapter paisesAdapter = new PaisesAdapter(this, paises);

        spinnerPaises.setAdapter(paisesAdapter);

    }

    public void mostrarPaisSelecionado(View view){
        Pais pais = (Pais) spinnerPaises.getSelectedItem();

        Toast.makeText(this,
                getString(R.string.o_pais_foi_selecionado, pais.getNome()),
                Toast.LENGTH_SHORT).show();
    }
}