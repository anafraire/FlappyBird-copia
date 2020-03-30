package com.anafraire.mario.Estados;

import com.anafraire.mario.FlappyBird;
import com.anafraire.mario.Objetos.Pajaro;
import com.anafraire.mario.Objetos.Tuberia;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

public class EstadoJuego_Escena extends Estado{

    private Pajaro pajaro;
    private Texture fondo2;
    //private Tuberia tuberia;
    private static final int ESPACIO_TUBERIAS = 125;
    private static final int CONTADOR_TUBERIAS = 5;
    private Array <Tuberia> tuberias;
    private Texture suelo;
    private Vector2 posicionSuelo1; //Posicion del suelo primera vez
    private Vector2 posicionSuelo2; //Posicion del suelo segunda vez
    private static final int SUELO_Y_OFFSET = -90;

    public EstadoJuego_Escena(AdminEstadosJuego gsm) {
        super(gsm);
        pajaro = new Pajaro(50, 200);
        camara.setToOrtho(false, FlappyBird.ANCHURA/2, FlappyBird.ALTURA/2);
        fondo2 = new Texture("mario.jpg");
        suelo = new Texture("ground.png");
        posicionSuelo1 = new Vector2(camara.position.x - camara.viewportWidth/2, SUELO_Y_OFFSET);    //Posicion del suelo
        posicionSuelo2 = new Vector2((camara.position.x - camara.viewportWidth/2) + suelo.getWidth(), SUELO_Y_OFFSET);    //Posicion del suelo
        tuberias = new Array<>();

        for(int i = 1; i<= CONTADOR_TUBERIAS; i++){ //Agregar nuevas tuberias
            tuberias.add(new Tuberia(i * (ESPACIO_TUBERIAS + Tuberia.ANCHURA_TUBERIA)));
        }
    }

    @Override
    protected void handleInput() {
        if(Gdx.input.justTouched()){
            pajaro.saltar();
        }
    }

    @Override
    public void update(float deltaTime) {
        handleInput();
        updateSuelo();
        pajaro.update(deltaTime);

        camara.position.x = pajaro.getPosicion().x + 80;    //camara del juego

        for(int i=0; i < tuberias.size; i++){
            Tuberia tuberia = tuberias.get(i);

            //Posicion del tubo de arriba
            if(camara.position.x - (camara.viewportHeight/2) > tuberia.getPosicionTopTuberia().x + tuberia.getTopTuberia().getWidth()){
                tuberia.reposicion(tuberia.getPosicionTopTuberia().x + (Tuberia.ANCHURA_TUBERIA + ESPACIO_TUBERIAS) * CONTADOR_TUBERIAS);
            }

            if(tuberia.colision(pajaro.getContorno())){     //Cuando el pajaro choque
                gsm.set(new EstadoJuego_Escena(gsm));     //Comenzamos de nuevo la partida
            }
        }
        if(pajaro.getPosicion().y <= suelo.getHeight() + SUELO_Y_OFFSET){   //Desaparecer el pajaro cuando toque el suelo
            gsm.set(new EstadoJuego_Escena(gsm));   //Reiniciar partida cuando toque el suelo
        }
        camara.update();
    }

    @Override
    public void render(SpriteBatch spriteBatch) {   //Elementos en la pantalla de juego
        spriteBatch.setProjectionMatrix(camara.combined);
        spriteBatch.begin();
        //pantalla cuando está el pájaro
        spriteBatch.draw(fondo2, camara.position.x- (camara.viewportWidth/2), camara.position.y- (camara.viewportHeight/2));
        spriteBatch.draw(pajaro.getPajaro(), pajaro.getPosicion().x, pajaro.getPosicion().y);

        for (Tuberia tuberia : tuberias){
            spriteBatch.draw(tuberia.getTopTuberia(), tuberia.getPosicionTopTuberia().x, tuberia.getPosicionTopTuberia().y);//Tuberia superior
            spriteBatch.draw(tuberia.getDownTuberia(), tuberia.getPosicionDownTuberia().x, tuberia.getPosicionDownTuberia().y);//Tuberia inferior
        }
        spriteBatch.draw(suelo, posicionSuelo1.x, posicionSuelo1.y);
        spriteBatch.draw(suelo, posicionSuelo2.x, posicionSuelo2.y);
        spriteBatch.end();
    }

    @Override
    public void dispose() { //Liberar espacio de la memoria
        fondo2.dispose();
        suelo.dispose();
        pajaro.dispose();
        for(Tuberia tuberia : tuberias){
            tuberia.dispose();
        }
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
