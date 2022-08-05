package com.mycompany.proyectoed2parte1;

import java.util.ArrayList;
import java.util.Stack;
import model.ArbolRespuestas;
import model.Respuesta;
import trees.BinaryTree;
import util.Constants;
import util.Lector;


public class Main {

    public static void main(String[] args) {
        System.out.println(Lector.cargarListaPreguntas(Constants.rutaPreguntas));
        
        System.out.println(Lector.cargarListaRespuestas(Constants.rutaRespuestas));
        
        ArbolRespuestas arbol=new ArbolRespuestas();
        
        System.out.println(arbol.getArbol().inOrderRecursiveTraversal());
        
        ArrayList<String> respuestas = ArbolRespuestas.pedirRespuestas();
        
        
        System.out.println(arbol.recorrerArbolRespuestas(respuestas));
 
    }
    
    
    
   

    
    
}
