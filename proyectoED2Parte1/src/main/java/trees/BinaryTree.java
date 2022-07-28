
package trees;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
public class BinaryTree<E> {

    private BinaryNode<E> root;

    public BinaryTree(E rootContent) {
        this.root = new BinaryNode<>(rootContent);
    }

    public E getRootContent() {
        return this.root.getContent();
    }

    public BinaryTree() {
        this.root = null;
    }


    public void setRootContent(E content) {
        this.root = new BinaryNode<>(content);
    }

    private BinaryNode<E> getRoot() {
        return root;
    }

    private void setRoot(BinaryNode<E> root) {
        this.root = root;
    }

    public void setLeft(BinaryTree tree) {
        this.root.setLeft(tree);
    }

    public void setRight(BinaryTree tree) {
        this.root.setRight(tree);
    }

    public BinaryTree<E> getLeft() {
        return this.root.getLeft();
    }

    public BinaryTree<E> getRight() {
        return this.root.getRight();
    }
    
    
    
    public boolean isEmpty(){
        return this.root==null;
    }
    
    public boolean isLeaf(){
        //Retorna true si el arbol que lo invoca es una hoja
        if(!this.isEmpty()){
            return this.root.getLeft()==null && this.root.getRight()==null;
        }
        return false;   //En este caso el arbol esta vacio y se retorna false
    }
    
    public int countLeavesRecursive(){
        if(this.isEmpty()){
            return 0;
        }else if(this.isLeaf()){
            return 1;
        }else{
            int leftLeaves = 0;
            int rightLeaves = 0;
            
            if(this.root.getLeft()!=null){
                leftLeaves = this.root.getLeft().countLeavesRecursive();
            }
            if(this.root.getRight()!=null){
                rightLeaves = this.root.getRight().countLeavesRecursive();
            }
            return leftLeaves+rightLeaves;
        }
    }
    
    
    public int countLeavesIterative(){
        if(this.isEmpty()){
            return 0;
        }
        
        int leaves = 0;
        Stack<BinaryTree<E>> s = new Stack<>();
        s.push(this);
        while(!s.isEmpty()){
            //Se saca al arbol
            BinaryTree<E> subtree = s.pop();
            if(subtree.isLeaf()){
                leaves++;
            }
            if(subtree.getRoot().getLeft()!=null){
                s.push(subtree.getRoot().getLeft());
            }
            if(subtree.getRoot().getRight()!=null){
                s.push(subtree.getRoot().getRight());
            }
        }
        return leaves;
    }
    
    
    
    /*
    ###############################
    METODOS DE RECORRIDO RECURSIVOS
    ###############################
    */
    
    public LinkedList<E> preOrderRecursiveTraversal(){
        LinkedList<E> result = new LinkedList<>();
        if(!this.isEmpty()){
            result.add(this.getRootContent());
        }
        
        if(this.getLeft()!=null){
            result.addAll(this.getLeft().preOrderRecursiveTraversal());
        }
        if(this.getRight()!=null){
            result.addAll(this.getRight().preOrderRecursiveTraversal());
        }
        
        return result;
                
    }
    
    public LinkedList<E> inOrderRecursiveTraversal(){
        LinkedList<E> result = new LinkedList<>();
        if(!this.isEmpty()){
            if(this.getLeft()!=null){
                result.addAll(this.getLeft().inOrderRecursiveTraversal());
            }
            if(this.root!=null){
                result.add(this.getRootContent());
            }
            if(this.getRight()!=null){
                result.addAll(this.getRight().inOrderRecursiveTraversal());
                
            }
        }
        
        return result;
        
    }
    
    public LinkedList<E> postOrderRecursiveTraversal(){
        LinkedList<E> result = new LinkedList<>();
        if(!this.isEmpty()){
            if(this.getLeft()!=null){
                result.addAll(this.getLeft().postOrderRecursiveTraversal());
            }
            if(this.getRight()!=null){
                result.addAll(this.getRight().postOrderRecursiveTraversal());
            }
            if(this.root!=null){
                result.add(this.getRootContent());
            }
        }
        
        return result;
        
    }
    
    
    
    public LinkedList<E> preOrderIterativeTraversal(){
        LinkedList<E> result = new LinkedList<>();
        Stack<BinaryTree<E>> s = new Stack<>();
        
        s.push(this);
        
        while(!s.isEmpty()){
            BinaryTree<E> subtree = s.pop();
            
            if(!subtree.isEmpty()){
                result.add(subtree.getRootContent());
            }
            
            if(subtree.getRight()!=null){
                s.push(subtree.getRight());
            }
            if(subtree.getLeft()!=null){
                s.push(subtree.getLeft());
            }
        }
        
        return result;
    }
    
    
    public LinkedList<E> inOrdereIterativeTraversal(){
        LinkedList<E> result = new LinkedList<>();
        Stack<BinaryTree<E>> s = new Stack<>();

        BinaryTree<E> subtree = this;
        while(!s.isEmpty()||subtree!=null){
            if(subtree!=null){
                s.push(subtree);
                subtree = subtree.getLeft();
            }else{
                subtree = s.pop();
                result.add(subtree.getRootContent());
                subtree = subtree.getRight();
            }
        }
        
        return result;
    }
    
    
    

    
    
    public LinkedList<E> breadthTraversal(){
        LinkedList<E> result = new LinkedList<>();
        Queue<BinaryTree<E>> q = new LinkedList<>();
        
        q.offer(this);
        while(!q.isEmpty()){
            BinaryTree<E> subtree = q.poll();
            
            if(!subtree.isEmpty()){
                result.add(subtree.getRootContent());
            }
            if(subtree.getLeft()!=null){
                q.offer(subtree.getLeft());
            }
            if(subtree.getRight()!=null){
                q.offer(subtree.getRight());
            }
        }
        return result;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    /*
    ##############################
    Metodos del taller
    ##############################
    */
    
    public int countDescendantsRecursive(){
        if(this.isEmpty()){
            return 0;
        }
        
        
        int descendants = 0;   
        if(this.getLeft()!=null){
            descendants++;
            descendants+=this.getLeft().countDescendantsRecursive();
        }
        if(this.getRight()!=null){
            descendants++; 
            descendants+=this.getRight().countDescendantsRecursive();
        }

        return descendants;      
        
    }
    
    public int countDescendansIterative(){
        if(this.isEmpty()){
            return 0;
        }
        int descendants = 0;

        Queue<BinaryTree<E>> q = new LinkedList<>();
        q.offer(this);
        
        while(!q.isEmpty()){
            BinaryTree<E> tree = q.poll();
            
            if(tree.getLeft()!=null){
                descendants++;
                q.offer(tree.getLeft());
            }
            if(tree.getRight()!=null){
                descendants++;
                q.offer(tree.getRight());
            }
            
        }
        
        return descendants;
    }
    
    
    
    /*
    @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
    METODOS DE PRACTICA PARA LA LECCION
    @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
    */
    
    
    //1. Implementar el metodo sumar pares que suma todos los pares de un arbol pasado como parametro
    
    public static int sumarPares(BinaryTree<Integer> tree){
        //Debemos usar una implementacion iterativa
        int suma = 0;
        Stack<BinaryTree<Integer>> s = new Stack<>();
        //Solo se debe comprobar que el arbol al que se hace pop sea par, si lo es. Sumamos su contenido a suma
        s.push(tree);
        while(!s.isEmpty()){
            BinaryTree<Integer> subtree = s.pop();
            
            if(!subtree.isEmpty()){
                if(subtree.getRootContent() % 2 == 0){
                    //En este caso el numero es par:
                    suma+=subtree.getRootContent();
                }
                if(subtree.getLeft()!=null){
                    s.push(subtree.getLeft());
                }
                if(subtree.getRight()!=null){
                    s.push(subtree.getRight());
                }
            }
        }
        
        return suma;
    }
    
    
//    public BinaryTree<Integer> findIntersection(BinaryTree<Integer> tree2){
//        /*
//        La idea es comparar los 2 arboles, RECURSIVAMENTE y si ambos son iguales en algun
//        campo, se crea el nodo y se lo almacena al arbol resultante???
//        */
//        if(this.isEmpty()|| tree2.isEmpty()){
//            return null;    //No hay interseccion
//        }
//        
//        //Si ninguno de los 2 es vacio
//        //Es xq existe una interseccion entre los
//        BinaryTree<Integer> result = new BinaryTree<>((int) this.getRootContent()+tree2.getRootContent());
//
//        if(this.getLeft()!=null && tree2.getLeft()!=null){
//            result.setLeft(this.getLeft().findIntersection(tree2.getLeft()));
//        }
//        if(this.getRight()!=null && tree2.getRight()!=null){
//            result.setRight(this.getRight().findIntersection(tree2.getRight()));
//        }
//
//        return result;
//        
//    }
    
    public boolean isMirror(BinaryTree<E> arbol){
        /*
        La funcion determina si arbol es espejo de this. Es decir: El left de this es el 
        right de arbol, y el right de this es el left de arbol. EXACTAMENTE CON EL MISMO CONTENIDO
        */
        if(this.isEmpty() || arbol.isEmpty()){
            return false;
        }
        boolean retorno = false;
        //Caso contrario ninguno esta vacio
        if(this.getRootContent().equals(arbol.getRootContent())){
            retorno =  true;
        }else{
            retorno =  false;
        }
            
            if(this.getLeft()!=null && arbol.getRight()!=null)
                retorno =  this.getLeft().isMirror(arbol.getRight());

            if(this.getRight()!=null && arbol.getRight()!=null)
                retorno =  this.getRight().isMirror(arbol.getLeft());
                
        return retorno;    
        
        

    }

    public static LinkedList<Integer> largestValueInEachLevel(BinaryTree<Integer> tree){
        LinkedList<Integer> result = new LinkedList<>();
        Queue<BinaryTree<Integer>> q = new LinkedList<>();
        if(!tree.isEmpty()){
            q.offer(tree);
            
        }
        int max = Integer.MIN_VALUE;
        while(!q.isEmpty()){
            BinaryTree<Integer> subtree = q.poll();
//            int max = Integer.MIN_VALUE;
            System.out.println(max);
            if(max<subtree.getRootContent()){
                max = subtree.getRootContent();
            }
            
            if(subtree.getLeft()!=null){
                q.offer(subtree.getLeft());
            }
            if(subtree.getRight()!=null){
                q.offer(subtree.getRight());
            }
            
            result.add(max);
            
            
            
        }
        
        return result;
        
        
    }
    
    public int countNodesWithOnlyChild(){
        if(this.isEmpty()){
            return 0;
        }
        if(this.getLeft()!=null && this.getRight()==null){
            //Solo tiene 1 hijo
            return 1;
        }else if(this.getRight()!=null && this.getLeft()==null){
            return 1;
        }
        
        //Caso contrario, es xq tiene 2 hijos
        else{
            //Continuamos con las llamadas recursivas
            int leftOnlyChildNodes = 0;
            int rightOnlyChildNodes = 0;
            
            if(this.getLeft()!=null){
                leftOnlyChildNodes = this.getLeft().countNodesWithOnlyChild();
            }
            if(this.getRight()!=null){
                rightOnlyChildNodes = this.getRight().countNodesWithOnlyChild();
            }
            
            return leftOnlyChildNodes+rightOnlyChildNodes;
        }
        
    }
    
    
    
    public BinaryTree<Integer> findIntersection(BinaryTree<Integer> tree2){
        
        //Me encargo de la raiz
        if(this.isEmpty() || tree2.isEmpty()){
            return null;    //No existe interseccion en ese punto
        }
        
        BinaryTree<Integer> result = new BinaryTree<>((int)this.getRootContent()+tree2.getRootContent());
        
        if(this.getLeft()!=null && tree2.getLeft()!=null){
            result.setLeft(this.getLeft().findIntersection(tree2.getLeft()));
        }
        if(this.getRight()!=null && tree2.getRight()!=null){
            result.setRight(this.getRight().findIntersection(tree2.getRight()));
        }
        
        return result;
    }
    
    
    
    public BinaryTree<E> getMin(Comparator<E> cmp){
        if(this.isEmpty()){
            return null;
        }else if(this.isLeaf()){
            return this;
        }else{
            //Definimos como el nodo minimo a this
            BinaryTree<E> minTree = this;
            if(this.getLeft()!=null){
                //Creamos otra variable para comparar con el min. En este caso con el izquierdo
                BinaryTree<E> minLeftTree = this.getLeft().getMin(cmp);
                
                //Vemos la comparacion entre ellos
                if(cmp.compare(minLeftTree.getRootContent(), minTree.getRootContent())<0){
                    minTree = minLeftTree;
                }
                
            }
            if(this.getRight()!=null){
                BinaryTree<E> minRightTree = this.getRight().getMin(cmp);
                if(cmp.compare(minRightTree.getRootContent(), minTree.getRootContent())<0){
                    minTree = minRightTree;
                }
            }
            
            return minTree;
            
        }
        
    }
    public BinaryTree<E> getMax(Comparator<E> cmp){
        if(this.isEmpty()){
            return null;
        }else if(this.isLeaf()){
            return this;
        }else{
            //Definimos como el nodo minimo a this
            BinaryTree<E> maxTree = this;
            if(this.getLeft()!=null){
                //Creamos otra variable para comparar con el min. En este caso con el izquierdo
                BinaryTree<E> maxLeftTree = this.getLeft().getMax(cmp);
                
                //Vemos la comparacion entre ellos
                if(cmp.compare(maxLeftTree.getRootContent(), maxTree.getRootContent())>0){
                    maxTree = maxLeftTree;
                }
                
            }
            if(this.getRight()!=null){
                BinaryTree<E> maxRightTree = this.getRight().getMax(cmp);
                if(cmp.compare(maxRightTree.getRootContent(), maxTree.getRootContent())>0){
                    maxTree = maxRightTree;
                }
            }
            
            return maxTree;
            
        }
        
        
        
        
    }
    
    
    //Metodos para obtener el minimo y el maximo de forma iterativa
    public BinaryTree<E> getMinIterative(Comparator<E> cmp){
        Stack<BinaryTree<E>> s = new Stack<>();
        if(this.isEmpty()){
            return null;
        }else if(this.isLeaf()){
            return this;
        }else{
            s.push(this);
            BinaryTree<E> minTree = this;
            while(!s.isEmpty()){
                BinaryTree<E> subtree = s.pop();
                if(cmp.compare(subtree.getRootContent(), minTree.getRootContent())<0){
                    //El derecho es menor al OG, por lo tanto cambio el valor de la variable min
                    minTree = subtree;
                }
                
                if(subtree.getRight()!=null){
                    s.push(subtree.getRight());
                }
                if(subtree.getLeft()!=null){
                    s.push(subtree.getLeft());
                }
                
            }
            
            return minTree;
        }
    }
    
    
    
}
