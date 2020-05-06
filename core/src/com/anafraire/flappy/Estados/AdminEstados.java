package com.anafraire.flappy.Estados;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Stack;

public class AdminEstados {
// Esta clase va a administrar todos los estados de nuestro juego a traves de una lista (estados)

    private Stack<Estado> estados; //Lista que almacena estados (estados = pantallas)

    public AdminEstados() {
        estados = new Stack<Estado>();
    }

    public void insertar(Estado estado){     //Insetar un estado a la lista
        estados.push(estado);   //push=insertar
    }

    public void pop(){  //Eliminar el ultimo estado de nuestra lista
        estados.pop().dispose();    //Quitamos el estado de la memoria
    }

    public void set(Estado estado){ //Recibe un estado y lo modifica
        estados.pop().dispose();    //Quitamos el estado de la memoria
        estados.push(estado);   //Diferente al metodo insertar
    }

    public void update(float deltaTime){    //El tiempo de ejecucion real del juego (frecuencia de actualizacion del juego)
        estados.peek().update(deltaTime);   //Selecciona el estado en el que nos encontramos en el momento y actualizalo con el deltaTime
    }

    public void render(SpriteBatch sb){     //Almacena las imagenes
        estados.peek().render(sb);  //Selecciona el estado en el que nos encontramos en el momento y actualizalo con el deltaTime
    }


}
