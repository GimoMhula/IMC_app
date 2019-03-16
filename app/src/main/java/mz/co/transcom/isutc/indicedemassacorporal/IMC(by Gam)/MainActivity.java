package mz.co.transcom.isutc.indicedemassacorporal;

import android.annotation.SuppressLint;
import android.support.annotation.ColorInt;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText peso, altura;
    TextView resultado_kg, resultado_calculo;
    Button botao_calcular;
    Button botao_limpar_campos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        peso = findViewById(R.id.peso_editText);
        altura = findViewById(R.id.altura_editText);

        resultado_kg = findViewById(R.id.resultado_calculo_peso_textView);
        resultado_calculo = findViewById(R.id.resultado_textView);

        botao_calcular = findViewById(R.id.calculo_btn);

        botao_calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                classificacao_de_imc();
            }
        });

        botao_limpar_campos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                peso.setText("");
                altura.setText("");
                resultado_kg.setText("0.0 Kg");
                resultado_calculo.setText("----------");
            }
        });

    }


    public double calcular_imc(){

        double altura = Double.parseDouble(this.altura.getText().toString());
        double peso = Double.parseDouble(this.peso.getText().toString());
        if(altura<=0.5 || altura>2.5){
            this.altura.setText("Altura invalida, insira novamente");


        }
        else if (peso<=2 || peso>450){
            this.peso.setText("Peso invalida, insira novamente");

        }
        else {return  (peso/(Math.pow(altura,2)));
        }
        return 0;
    }

    @SuppressLint("ResourceAsColor")
    public void classificacao_de_imc(){
        try {

            resultado_kg.setText(calcular_imc()+"  KG");

            if (calcular_imc()< 16){
                resultado_calculo.setText("Magreza Grave ");
            }
            else if (calcular_imc()>=16 && calcular_imc()<17){
                resultado_calculo.setText("Magreza Moderada");
            }

            else if (calcular_imc()>=17 && calcular_imc()<18.5){
                resultado_calculo.setText("Magreza Leve");
            }

            else if (calcular_imc()>=18.5 && calcular_imc()<25){
                resultado_calculo.setText("Saudavel");

            }

            else if (calcular_imc()>=25 && calcular_imc()<30){
                resultado_calculo.setText("Sobrepeso");

            }

            else if (calcular_imc()>=30 && calcular_imc()<35){
                resultado_calculo.setText("Obesidade Grau I");

            }

            else if (calcular_imc()>=35 && calcular_imc()<40){
                resultado_calculo.setText("Obesidade Grau II");

            }

            else if (calcular_imc()>=40){
                resultado_calculo.setText("Obesidade Grau III");

            }

            altura.setText("");
            peso.setText("");
        }catch (Exception e){
            Toast.makeText(this, " Por favor preencha todos os campos!!!", Toast.LENGTH_LONG).show();
        }
    }



}
