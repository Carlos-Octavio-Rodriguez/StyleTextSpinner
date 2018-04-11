package com.tecmm.tequila.styletextspinner;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    TextView texto;
    Spinner mySpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        texto = (TextView) findViewById(R.id.txt);
        mySpinner = (Spinner) findViewById(R.id.mySpinner);

        //Opciones de spinner
        String opciones[] = {"Cursiva" ,"Negrita", "Cursiva y negrita"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, opciones);
        mySpinner.setAdapter(adapter);

        //Evento de spinner
        mySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String opcion =
                        mySpinner.getSelectedItem().toString();
                if(opcion.equals("Negrita"))
                    texto.setTypeface(null, Typeface.BOLD);
                else if(opcion.equals("Cursiva"))
                    texto.setTypeface(null, Typeface.ITALIC);
                else if(opcion.equals("Cursiva y negrita"))
                    texto.setTypeface(null, Typeface.BOLD_ITALIC);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
