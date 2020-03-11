package com.anafraire.mario.Estados;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Stack;

public class AdminEstadosJuego {
// Esta clase va a administrar todos los estados de nuestro juego a traves de una lista (estados)

    private Stack<Estado> estados; //Lista que almacena estados

    public AdminEstadosJuego() {
        estados = new Stack<Estado>();
    }

    public void insertar(Estado estado){     //Insetar un estado a la lista
        estados.push(estado);   //ppush=insertar
    }

    public void pop(){  //Eliminar el ultimo estado de nuestra lista
        estados.pop();
    }

    public void set(Estado estado){ //Reemplaza un estado
        estados.pop();
        estados.push(estado);   //Diferente al metodo insertar
    }

    public void update(float deltaTime){    //El tiempo de ejecucion real del juego
        estados.peek().update(deltaTime);   //Actualizar el estado en el que nos encontramos
    }

    public void render(SpriteBatch sb){     //Almacena las imagenes
        estados.peek().render(sb);
    }


}
