package com.mycompany.proyectoed2parte1;

import java.util.ArrayList;
import java.util.Stack;
import model.ArbolDecision;
import model.Respuesta;
import trees.BinaryTree;
import util.Constants;
import util.Lector;


public class Main {

    public static void main(String[] args) {
        System.out.println(Lector.cargarListaPreguntas(Constants.rutaPreguntas));
        
        System.out.println(Lector.cargarListaRespuestas(Constants.rutaRespuestas));
        
        ArbolDecision arbol=new ArbolDecision();
        
        System.out.println(arbol.getArbol().inOrderRecursiveTraversal());
        
        ArrayList<String> respuestas = ArbolDecision.pedirRespuestas();
        
        
        System.out.println(arbol.recorrerArbolRespuestas(respuestas));
 
    }
    
    
    
   

    
    
}
