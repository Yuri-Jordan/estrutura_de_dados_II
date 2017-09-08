package AVLtree.src;

import AVLtree.src.No;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Yuri
 */
public class AVLTree {

    No root;

    public AVLTree() {
        this.root = new No();
    }

    public No getRoot() {
        return root;
    }

    public void setRoot(No root) {
        this.root = root;
    }

    public void inserirNo(int chave, No root) {

        No novo = new No(chave);

        if (root == null) {
            root = novo;
        } else if (novo.getChave() < root.getChave()) {

            if (root.getFilhoEsquerdo() == null) {

                novo.setPai(root);
                root.setFilhoEsquerdo(novo);
                balancearAVL(root);

            } else {
                inserirNo(novo.getChave(), root.getFilhoEsquerdo());
            }
        } else if (novo.getChave() > root.getChave()) {

            if (root.getFilhoDireito() == null) {

                novo.setPai(root);
                root.setFilhoDireito(novo);
                balancearAVL(root);

            } else {
                inserirNo(novo.getChave(), root.getFilhoDireito());
            }
        } else {
            System.out.println("Nó existente!");
        }
    }

    public No buscarNo(int chave, No root) {
        
        if(root == null) return null;
        else{
            
            if(root.getChave() < chave)
                buscarNo(chave, root.getFilhoDireito());
            
            else if(root.getChave() > chave)
                buscarNo(chave, root.getFilhoEsquerdo());
        }
        return root;
    }

    public boolean isEmpty(){ 
        return this.root == null;
    }
    
    public No remover(int chave) {
        
        No novo = buscarNo(chave, this.root);
        
        if(novo != null){
        }
        
        return null;
    }

    public void preOrdem(No root) {

        if (root == null) return;
        
        System.out.println(root.getChave());
        
        preOrdem(root.getFilhoEsquerdo());
        
        preOrdem(root.getFilhoDireito());
    }
    
    
    public void rotEsquerdaSIMPLES() {
    }

    
    public void rotDireitaSIMPLES() {
    }

    
    
    public void rotEsquerdaDUPLA() {
    }

    
    public void rotDireitaDUPLA() {
    }

}
