package com.anafraire.mario.Objetos;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;

public class Animacion {

    private Array<TextureRegion> fotogramas;
    private float maxTiempoFotogramas;
    private float tiempoFotogramas;
    private int contFotogramas; // Numero de pajaros de la foto = 3
    private int fotograma;

    public Animacion(TextureRegion region, int contFotogramas, float cicloTiempo){
        fotogramas = new Array<TextureRegion>();
        int anchoFotograma = region.getRegionWidth() / contFotogramas;

        for (int i = 0; i < contFotogramas; i++) {  //Separar los pajaritos de la foto
            // region = x e y
            // x = inicio de la imagen en el eje X
            // y = margen vertical de la imagen
            // anchoFotograma = nuevo valor de x para la siguiente imagen
            // region.getRegionHeight() = valor final de x para cada imagen
            fotogramas.add(new TextureRegion(region, i*anchoFotograma, 0, anchoFotograma, region.getRegionHeight()));
        }
        this.contFotogramas = contFotogramas; //Numero de fotogramas
        maxTiempoFotogramas = cicloTiempo / contFotogramas;    //Ciclo completo de tiempo / numero de fotogramas
        fotograma = 0;  //Empezar por el primer fotograma
    }

}
