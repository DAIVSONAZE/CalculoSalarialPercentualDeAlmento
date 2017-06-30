package usuario.app.calculodesalario;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.*;
import android.view.*;
import android.widget.*;
import android.app.Activity;


public class SalarioActivity extends AppCompatActivity {


   EditText InputValorSalario;
    RadioGroup GrupoRadio;
    Button btCalcularNewSal ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salario);

        InputValorSalario = (EditText) findViewById(R.id.edsalario);
        GrupoRadio = (RadioGroup) findViewById(R.id.radioGroup);
        btCalcularNewSal = (Button) findViewById(R.id.btcalcular);

        btCalcularNewSal.setOnClickListener(new View.OnClickListener(){

            public void onClick(View arg0){
                double salario = Double.parseDouble(InputValorSalario.getText().toString());

                int op = GrupoRadio.getCheckedRadioButtonId();

                double novo_salario = 0;

                if (op == R.id.rb40){
                    novo_salario = salario + (salario * 0.4);

                }else if (op == R.id.rb45){
                    novo_salario = salario + (salario * 0.45);

                }else{

                    novo_salario = salario + (salario * 0.5);
                }

                AlertDialog.Builder dialogoCalcSal = new AlertDialog.Builder(SalarioActivity.this);
                dialogoCalcSal.setTitle("Novo Salário");
                dialogoCalcSal.setMessage("Seu novo salário é de R$ " + novo_salario);
                dialogoCalcSal.setNeutralButton("OK", null);
                dialogoCalcSal.show();


            }
        });
    }
}
