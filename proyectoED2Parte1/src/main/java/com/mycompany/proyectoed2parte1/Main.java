package com.mycompany.proyectoed2parte1;

import util.Constants;
import util.Lector;


public class Main {

    public static void main(String[] args) {
        System.out.println(Lector.cargarListaPreguntas(Constants.rutaPreguntas));
        
        System.out.println(Lector.cargarListaRespuestas(Constants.rutaRespuestas));
        
        
    }
    
}
