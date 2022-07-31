package com.mycompany.proyectoed2parte1;

import java.util.ArrayList;
import java.util.Stack;
import model.Respuesta;
import trees.BinaryTree;
import util.Constants;
import util.Lector;


public class Main {

    public static void main(String[] args) {
        System.out.println(Lector.cargarListaPreguntas(Constants.rutaPreguntas));
        
        System.out.println(Lector.cargarListaRespuestas(Constants.rutaRespuestas));
        
        BinaryTree<String> tree=new BinaryTree("Nivel 0");
        tree.setLastLeaves("Nivel 1");
        tree.setLastLeaves("Nivel 2");
        ArrayList<String> lista=new ArrayList();
        lista.add("no");
        lista.add("si");
        lista.add("si");
        Respuesta respuesta=new Respuesta("perro",lista);
        setAnimal(respuesta,tree);
        
        System.out.println(tree.inOrderRecursiveTraversal());
 
    }
    public static void setAnimal(Respuesta respuesta,BinaryTree<String> arbol){
        ArrayList<String> lista=respuesta.getRespuestas();
        Stack<BinaryTree<String>> s = new Stack<>();
        s.push(arbol);
        int index=0;
        while(!s.isEmpty()){
            BinaryTree<String> tmp=s.pop();
            if(tmp.isLeaf()){
                if(lista.get(index).equals("si")){
                    BinaryTree<String> tmpLeft=new BinaryTree(respuesta.getAnimal());
                    tmp.setLeft(tmpLeft);
                }
                else if(lista.get(index).equals("no")){
                    BinaryTree<String> tmpRight=new BinaryTree(respuesta.getAnimal());
                    tmp.setRight(tmpRight);
                }
            }
            else if(lista.get(index).equals("si")){
                s.push(tmp.getLeft());
                index++;
            }
            else if(lista.get(index).equals("no")){
                s.push(tmp.getRight());
                index++;
            }
        
        }
    }
    
    
}
