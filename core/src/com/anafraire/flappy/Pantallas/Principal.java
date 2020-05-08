package com.anafraire.flappy.Pantallas;

import com.anafraire.flappy.Estados.AdminEstados;
import com.anafraire.flappy.Estados.Estado;
import com.anafraire.flappy.Juego;
import com.anafraire.flappy.Objetos.Pajaro;
import com.anafraire.flappy.Objetos.Tuberia;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

public class Principal extends Estado {

    private Pajaro pajaro;
    private Texture fondo2;
    private Texture suelo;
    private Texture pantallaFinal;

    private static final int ESPACIO_TUBERIAS = 125;    //Espacio entre una tuberia y otra
    private static final int CONTADOR_TUBERIAS = 5; //Numero de tubos diferentes que salen por pantalla
    private Array <Tuberia> tuberias;

    private Vector2 posicionSuelo1; //Posicion del suelo primera vez
    private Vector2 posicionSuelo2; //Posicion del suelo segunda vez
    private static final int SUELO_Y_OFFSET = -60;
    public static boolean gameover;

    public  int cont;
    private int cont2;
    private Sound marcador;

    private BitmapFont colorLetra;
    private BitmapFont fuente;

    public Principal(AdminEstados gsm) {
        super(gsm);
        pajaro = new Pajaro(50, 320);
        camara.setToOrtho(false, Juego.ANCHURA/2, Juego.ALTURA/2);
        fondo2 = new Texture("bg.png");
        suelo = new Texture("ground.png");
        pantallaFinal = new Texture("gameover.png");
        cont = 0;
        cont2 = 0;
        marcador = Gdx.audio.newSound(Gdx.files.internal("contador.mp3"));
        colorLetra = new BitmapFont();
        colorLetra.setColor(Color.BLACK);
        fuente = new BitmapFont(Gdx.files.internal("flappy.fnt"),Gdx.files.internal("flappy.png"), false);

        posicionSuelo1 = new Vector2(camara.position.x - camara.viewportWidth/2, SUELO_Y_OFFSET);    //Posicion del suelo
        //- camara.viewportWidth/2 = restar la pantalla para que la posicion este justo en el 0
        posicionSuelo2 = new Vector2((camara.position.x - camara.viewportWidth/2) + suelo.getWidth(), SUELO_Y_OFFSET);    //Posicion del suelo
        tuberias = new Array<>();
        gameover = false;

        for(int i = 1; i<= CONTADOR_TUBERIAS; i++){ //Agregar nuevas tuberias
                tuberias.add(new Tuberia(i * (ESPACIO_TUBERIAS + Tuberia.ANCHURA_TUBERIA)));
        }
    }

    @Override
    protected void handleInput() {  //Este metodo es el que hace que se cambie la pantalla inicial y aparezca el pajaro
        if(Gdx.input.justTouched()){
            if(gameover)
                gsm.set(new Principal(gsm));
            else
                pajaro.saltar();
        }
    }

    @Override
    public void update(float deltaTime) {
        handleInput();  //Si no añado este metodo aqui no identifica los toques en la pantalla
        updateSuelo();
        pajaro.update(deltaTime);

        if(!gameover) {
            camara.position.x = pajaro.getPosicion().x + 80;    //camara del juego
            //camara.position.y = camara.viewportHeight/2;
        }

        if(!gameover){
        for(int i=0; i < tuberias.size; i++) {
            Tuberia tuberia = tuberias.get(i);
            //Posicion del tubo de arriba
            if (camara.position.x - camara.viewportHeight / 2 > tuberia.getPosicionTopTuberia().x + tuberia.getTopTuberia().getWidth()) {
                tuberia.reposicion(tuberia.getPosicionTopTuberia().x + ((Tuberia.ANCHURA_TUBERIA + ESPACIO_TUBERIAS) * CONTADOR_TUBERIAS));
            }

            if (tuberia.colision(pajaro.getContorno())) {     //Cuando el pajaro choque
                //gsm.set(new EstadoJuego_Escena(gsm));     //Comenzamos de nuevo la partida
                gameover = true;
            }
            //System.out.println("posicion pajaro x: " + pajaro.getPosicion().x);
            //System.out.println("PAJARO: " + (int)pajaro.getPosicion().x + " POS TUBERIA" +(int)tuberia.getPosicionTopTuberia().x);
            if ((int) pajaro.getPosicion().x > (int) tuberias.get(cont2).posicionTopTuberia.x) {
                cont2 = cont2 + 1;
                cont = cont + 1;
                marcador.play(0.1f);
                if (cont2 == 5) { cont2 = 0; }

                //Manera 2: dividir la posicion de la tuberia entre 177 ya que las tuberias incrementan en 177
                //Manera 3: Coger la posicion del pajaro y dividir entre 177

                System.out.println("contador: " + cont);
                System.out.println("pos pajaro x" + (int)pajaro.getPosicion().x);
                System.out.println("pos tuberia x" + (int)tuberias.get(cont2).posicionTopTuberia.x);
            }
        }
            //contadorOK=false;
        }

        if((pajaro.getPosicion().y <= suelo.getHeight() + SUELO_Y_OFFSET)){   //Desaparecer el pajaro cuando toque el suelo
            gameover = true;
            //gsm.set(new EstadoJuego_Escena(gsm));   //Reiniciar partida cuando toque el suelo
        }
        camara.update(); 
    }

    @Override
    public void render(SpriteBatch spriteBatch) {   //Elementos en la pantalla de juego
        spriteBatch.setProjectionMatrix(camara.combined);   //Solo se dibujen los objetos que haya dentro del viewport(tamaño pantalla)
        spriteBatch.begin();
        //pantalla cuando está el pájaro
        spriteBatch.draw(fondo2, camara.position.x- (camara.viewportWidth/2), camara.position.y-(camara.viewportHeight/2));
        spriteBatch.draw(pajaro.getTextura(), pajaro.getPosicion().x, pajaro.getPosicion().y);

        if(gameover){
            spriteBatch.draw(pantallaFinal, camara.position.x - pantallaFinal.getWidth()/2, camara.position.y+75);
            fuente.draw(spriteBatch, String.valueOf(cont), camara.position.x + 85 - pantallaFinal.getWidth() / 2, camara.position.y + 180);
        }else{
            for (Tuberia tuberia : tuberias){
            // Primero se crea el tubo de la parte de arriba para que cuando se cree el tubo de abajo se pueda alinear con el de arriba
                spriteBatch.draw(tuberia.getTopTuberia(), tuberia.getPosicionTopTuberia().x, tuberia.getPosicionTopTuberia().y);//Tuberia superior
                spriteBatch.draw(tuberia.getDownTuberia(), tuberia.getPosicionDownTuberia().x, tuberia.getPosicionDownTuberia().y);//Tuberia inferior
            }

            spriteBatch.draw(suelo, posicionSuelo1.x, posicionSuelo1.y); //Mostrar el suelo por encima de los tubos
            spriteBatch.draw(suelo, posicionSuelo2.x, posicionSuelo2.y);
            fuente.draw(spriteBatch, String.valueOf(cont), camara.position.x + 85 - pantallaFinal.getWidth() / 2, camara.position.y + 180);
        }
        spriteBatch.end();
    }

    @Override
    public void dispose() { //Liberar espacio de la memoria
        //textura2.dispose();
        fondo2.dispose();
        suelo.dispose();
        pajaro.dispose();
        fuente.dispose();
        marcador.dispose();

        for(Tuberia tuberia : tuberias){
            tuberia.dispose();
        }
        //System.out.println("contador2 = " +cont);
        System.out.println("ESTADO DE JUEGO DISPONIBLE");

    }

    private void updateSuelo(){ //Poner el suelo infinito hacia la derecha sin ningun corte
        if(camara.position.x - (camara.viewportWidth/2) > posicionSuelo1.x + suelo.getWidth()){  //Inicio de nuestra camara
            posicionSuelo1.add(suelo.getWidth() * 2, 0);   //Agregar el ancho de nuestro suelo hacia la derecha
        }
        if(camara.position.x - (camara.viewportWidth/2) > posicionSuelo2.x + suelo.getWidth()){  //Inicio de nuestra camara
            posicionSuelo2.add(suelo.getWidth() * 2, 0);   //Agregar el ancho de nuestro suelo hacia la derecha
        }
    }



}
