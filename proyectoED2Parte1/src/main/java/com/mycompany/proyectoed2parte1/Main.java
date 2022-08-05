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

        ArbolDecision arbol=new ArbolDecision();
                
        ArrayList<String> respuestas = ArbolDecision.pedirRespuestas();
        
        System.out.println(arbol.recorrerArbolRespuestas(respuestas));
 
    }
    
    
    
   

    
    
}
