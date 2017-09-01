
import AVLtree.src.No;
import java.util.List;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Yuri
 */
public class AVLTree implements interfaceAVL{
    
    No root;
    
    public No getRoot() {
        return root;
    }

    public void setRoot(No root) {
        this.root = root;
    }
    
    
    @Override
    public No incluir(Object key) {
        
        No novo =  new No((int) key);
        
        if(this.root == null){ 
            this.root = novo;
        }
        else{
        }
        
    }

    @Override
    public boolean isEmpty() {
        
    }

    @Override
    public No remover(Object key) {
        
    }
    
 
    
    public List<No> inOrder(){};
    
    
    public void rotEsquerdaSIMPLES(){};
    public void rotDireitaSIMPLES(){};
    
    public void rotEsquerdaDUPLA(){};
    public void rotDireitaDUPLA(){};

    
    
}