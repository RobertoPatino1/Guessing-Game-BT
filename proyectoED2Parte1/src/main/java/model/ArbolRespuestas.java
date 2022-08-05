/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.Stack;
import trees.BinaryTree;
import util.Constants;
import util.Lector;

/**
 *
 * @author josel
 */
public class ArbolRespuestas {
    private BinaryTree arbol;
    
    public ArbolRespuestas(){
        this.arbol=new BinaryTree();
        this.iniciarPreguntas();
        this.iniciarRespuestas();
    }

    public BinaryTree getArbol() {
        return arbol;
    }

    public void setArbol(BinaryTree arbol) {
        this.arbol = arbol;
    }
    
    
    
    public void iniciarPreguntas(){
        ArrayList<String> preguntas=Lector.cargarListaPreguntas(Constants.rutaPreguntas);
        for(String pregunta:preguntas){
            this.arbol.setLastLeaves(pregunta);
        }
    }
    
    public void iniciarRespuestas(){
        ArrayList<Respuesta> respuestas=Lector.cargarListaRespuestas(Constants.rutaRespuestas);
        for(Respuesta r:respuestas){
            this.setAnimal(r);
        }
    }
    
    
    public void setAnimal(Respuesta respuesta){
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
