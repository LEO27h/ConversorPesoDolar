package com.leonherrera.conversorpesodolar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText eValor,eResultado;
    Button bConvertir;
    RadioButton rDaP,rPaD;
    int band;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        eValor = (EditText) findViewById(R.id.valor);
        eResultado = (EditText) findViewById(R.id.Resultado);
        bConvertir = (Button)findViewById(R.id.Conversion);
        rDaP = (RadioButton) findViewById(R.id.USDaPesos);
        rPaD = (RadioButton) findViewById(R.id.PesosaUSD);

        bConvertir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double Valor1, Resultado1;
                Resultado1=0.0;
                Valor1 = Double.parseDouble(eValor.getText().toString());

                if(band==0)
                    Toast.makeText(MainActivity.this,"Seleccione conversión",Toast.LENGTH_SHORT).show();
                if(band==1)
                    Resultado1= Valor1/3000;
                if(band==2)
                    Resultado1= Valor1*3000;
                eResultado.setText(String.valueOf(Resultado1));

            }
        });
    }
    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.PesosaUSD:
                if (checked)
                    band =1;
                    // Pirates are the best
                    break;
            case R.id.USDaPesos:
                if (checked)
                    band=2;
                    // Ninjas rule
                    break;
        }
    }
}
