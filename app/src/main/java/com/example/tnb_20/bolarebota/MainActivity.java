package com.example.tnb_20.bolarebota;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    // Variables para comprobar la velocidad
    float velocitadX = 40.0f;
    float velocitadY = 40.0f;
    float iniciX, iniciY;

    // Variables para hacer los calculos de tamaño
    int statusBar, width, height;

    // ArrayList de BolasRebotantes donde guardaremos las bolas
    ArrayList<BolaRebota> bolasRebotantes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Creamos la instancia, definimos el layout (RelativeLayout) y inicializamos el ArrayList de bolas
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RelativeLayout layout = findViewById(R.id.LayoutRelativo);
        bolasRebotantes = new ArrayList();

        // Conseguimos saber la medida de la pantalla para que las bolas no sobrepasen los limites y haya errores
        DisplayMetrics display = this.getBaseContext().getResources().getDisplayMetrics();
        width = display.widthPixels;
        height = display.heightPixels;

        // Con un bucle for generamos las imagenes, les definimos posicion y velocidad random y las añadimos tanto al layout como al ArrayList de bolas
        for (int x = 0; x < 4;x++){
            Random random = new Random();
            ImageView imagen = new ImageView(getApplicationContext());
            imagen.setImageResource((R.drawable.silladeruedas));
            int posX;
            int posY;
            if(x%2==0){
                posY = random.nextInt((height/2) - 500 ) + 500;
                posX = random.nextInt((width/2) - 500 ) + 500;
                velocitadX= random.nextInt(50-20)+0;
                velocitadY= random.nextInt(50-20)+0;
            }else{
                posY = random.nextInt((height/2) - 500 ) + 100;
                posX = random.nextInt((width/2) - 500 ) + 100;
                velocitadX= random.nextInt(50-20)+0;
                velocitadY= random.nextInt(50-20)+0;
            }

            velocitadX = random.nextInt(80 - 65)+65;
            Log.v("pos", (velocitadX+" "+velocitadY));

            imagen.setX(posX);
            imagen.setY(posY);

            layout.addView(imagen);

            bolasRebotantes.add(new BolaRebota(posX, posY, velocitadX, velocitadY, imagen, height, width));
        }

        // Definimos las variables para controlar los tiempos
        MyTimerTask myTask = new MyTimerTask();
        Timer myTimer = new Timer();

        myTimer.schedule(myTask, 1, 200);

        // Calculamos las dimensiones
        statusBar = getResources().getDimensionPixelSize(getResources().getIdentifier("status_bar_height", "dimen", "android"));
    }

    // Creamos una clase, hacemos un foreach dentro del run para iniciar la aplicacion con el numero de bolas correspondiente
    class MyTimerTask extends TimerTask {
        public void run() {
            for (BolaRebota br:bolasRebotantes) {
                br.moverBolaRebota();
            }
        }
    }
}