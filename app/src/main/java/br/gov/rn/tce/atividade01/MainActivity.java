package br.gov.rn.tce.atividade01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt = findViewById(R.id.contadorPing);
        txt.setText("1");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("Atividade01","Entrou no onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("Atividade01","Entrou no onResume()");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("Atividade01","Entrou no onStop()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("Atividade01","Entrou no onPause()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("Atividade01","Entrou no onRestart()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("Atividade01","Entrou no onDestroy)");
    }

    public void ping(View view) {

        int contador = Integer.parseInt(txt.getText().toString());

        Bundle b = new Bundle();
        b.putInt("contador", ++contador);

        Intent i = new Intent(this, MainActivity2.class);
        i.putExtras(b);

        startActivityForResult(i, 10);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == 10 && resultCode == RESULT_OK) {
            Bundle b = data.getExtras();
            txt.setText(String.valueOf(b.getInt("contador")));
        }
    }

    public void restart(View view) {
        txt.setText("0");
    }
}
