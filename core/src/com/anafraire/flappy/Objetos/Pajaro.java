package com.anafraire.flappy.Objetos;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

public class Pajaro {

    private static final int GRAVEDAD = -15;
    private Vector3 posicion;
    private Vector3 velocidad;
    private static final int V_MOVIMIENTO = 100;    //  Velocidad de movimiento
    private Rectangle contorno;
    private Animacion pajaros;
    private Texture textura;
    private Sound aleteo;
    public boolean parar;

    public Pajaro(int x, int y) {
        posicion = new Vector3 (x, y, 0);
        velocidad = new Vector3 (0, 0, 0);
        //pajaro = new Texture("bird.png");

        textura = new Texture("birdanimation.png");
        pajaros = new Animacion(new TextureRegion(textura), 3, 0.5f);
        contorno = new Rectangle(x, y, textura.getWidth()/3, textura.getHeight());
        aleteo = Gdx.audio.newSound(Gdx.files.internal("sfx_wing.ogg"));
        parar = false;
    }

    public void update(float deltaTime) {   //Identifica todas las acciones que hacemos
        pajaros.update(deltaTime);  //Actualizar los fotogramas
        if(posicion.y > 0){ //El pajaro va a estar siempre encima de y=0 para aparecer en la pantalla
            velocidad.add(0, GRAVEDAD, 0);
        }
        velocidad.add(0, GRAVEDAD, 0);  //El objeto caerá a la velocidad de la gravedad
        velocidad.scl(deltaTime);  //Actualiza cada segundo

        if(!parar){
            //Velocidad en y   //Por cada segundo se va a mover V_MOVIMIENTO =100 pixeles
            posicion.add(V_MOVIMIENTO * deltaTime, velocidad.y, 0);
        }
        if(posicion.y < 0){ //Limitar la pantalla 1
            posicion.y = 0;
        }

        velocidad.scl(1/deltaTime); //Actualiza cada segundo que pasa del deltaTime
        contorno.setPosition(posicion.x, posicion.y);
    }

    //Obtener el contorno del rectangulo
    public Rectangle getContorno(){
        return contorno;
    }

    public Vector3 getPosicion() {
        return posicion;
    }

    public TextureRegion getTextura() {
        return pajaros.getFotograma();
    }

    public void saltar(){
        velocidad.y = 300;
        aleteo.play(0.2f);
    }

    public void dispose() {
        textura.dispose();
        aleteo.dispose();
    }
}
