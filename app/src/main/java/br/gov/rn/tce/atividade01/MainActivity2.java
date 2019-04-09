package br.gov.rn.tce.atividade01;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    private TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        txt = findViewById(R.id.contadorPong);

        Bundle b = getIntent().getExtras();
        txt.setText(String.valueOf(b.getInt("contador")));

    }

    public void pong(View view) {
        int contador = Integer.parseInt(txt.getText().toString());

        Intent i = new Intent();

        Bundle b = new Bundle();
        b.putInt("contador", ++contador);
        i.putExtras(b);

        setResult(RESULT_OK, i);
        finish();
    }

    public void restart(View view) {
        txt.setText("0");
    }
}
