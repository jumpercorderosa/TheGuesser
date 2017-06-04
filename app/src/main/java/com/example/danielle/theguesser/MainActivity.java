package com.example.danielle.theguesser;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AlertDialog;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View;
import java.util.Random;
import android.content.DialogInterface;


public class MainActivity extends AppCompatActivity {

    //cria objetos para receber os elementos da página
    private EditText etPalpite;
    private Button btnChute;
    private TextView tvUltimoChute;

    private int chuteJogador;
    private int chuteMaquina;

    private Random numeroRandomico = new Random();

    //private int[] sonsErro = {R.raw.chavez_ai_que_burro_da_zero, R.raw.errou_faustao, R.raw.errou_rude, R.raw.que_pena_voce_errou};
    //private int[] sonsAcertou = {R.raw.you_win};

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //Fala qual é o layout desta página
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Encontra os componentes por ID via R Class
        btnChute = (Button) findViewById(R.id.btnChutar);
        etPalpite = (EditText) findViewById(R.id.etNumeroChute);
        tvUltimoChute = (TextView) findViewById(R.id.tvUltimoChute);

        //gera um número randomico
        chuteMaquina = numeroRandomico.nextInt(11);
    }

    public void chutar(View v) {

        //obtem palpite do jogador
        String auxChute = etPalpite.getText().toString();

        if(auxChute.isEmpty()) {
            Toast.makeText(this, "Informe seu chute!!!", Toast.LENGTH_SHORT).show();
        } else {
            chuteJogador = Integer.parseInt(auxChute);

            if(chuteJogador == chuteMaquina) {
                showAlert("Você ganhou!");
                //executarSomAcertou();
            } if(chuteJogador > chuteMaquina) {
                showAlert("Tente um número menor");
                //executarSomErrou();
            } if (chuteJogador < chuteMaquina) {
                showAlert("Tente um número maior");
                //executarSomErrou();
            }
        }
    }

    private void showAlert(String mensagem) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("O Adivinho");
        builder.setMessage(mensagem)
                .setCancelable(false)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        etPalpite.setText("");
                        dialog.dismiss();
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();
    }

    /*
    private void executarSom(int resourceID) {
        MediaPlayer player = new MediaPlayer().create(this, resourceID);
        player.start();
    }

    private void executarSomAcertou() {
        int indice = numeroRandomico.nextInt(sonsAcertou.length);
        executarSom(sonsAcertou[indice]);
    }

    private void executarSomErrou() {
        int indice = numeroRandomico.nextInt(sonsErro.length);
        executarSom(sonsErro[indice]);
    }
    */
}
