package design.jhenrique.advinhenumero;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnKeyListener {

    EditText numero;
    TextView mensagem;
    View.OnKeyListener ouvinte;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        numero.setOnKeyListener(ouvinte);
    }

    @Override
    public boolean onKey(View v, int keyCode, KeyEvent event) {
       if(keyCode == KeyEvent.KEYCODE_ENTER &&
               event.getAction() != KeyEvent.ACTION_DOWN){
           verificaPapite();
           return true;
       }
       return false;
    }

    private void verificaPapite() {
        numero   = (EditText)findViewById(R.id.numero);
        mensagem = (TextView)findViewById(R.id.mensagem);
        int aleatorio = (int) Math.random();
        int nro = Integer.parseInt(numero.getText().toString());

        if(nro == aleatorio){
                mensagem.setText("Acertou mizeravi");
        } else if(nro > aleatorio){
            mensagem.setText("Valor acima do alvo");
        } else if (nro < aleatorio){
            mensagem.setText("Valor abaixo do alvo");
        }


    }
}
