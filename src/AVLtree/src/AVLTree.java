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

        if (isEmpty()) {

            novo.setBalanceamento(0);
            root = novo;
            return;

        } else if (novo.getChave() < root.getChave()) {

            if (root.getFilhoEsquerdo() == null) {

                novo.setPai(root);
                root.setFilhoEsquerdo(novo);
                novo.setBalanceamento(0);
                conferirFB(root);

            } else {
                inserirNo(novo.getChave(), root.getFilhoEsquerdo());
            }
        } else if (novo.getChave() > root.getChave()) {

            if (root.getFilhoDireito() == null) {

                novo.setPai(root);
                root.setFilhoDireito(novo);
                novo.setBalanceamento(0);
                conferirFB(root);

            } else {
                inserirNo(novo.getChave(), root.getFilhoDireito());
            }
        } else {
            System.out.println("Nó existente!");
        }
    }

    public No buscarNo(int chave, No root) {

        if (root == null) {
            return null;
        } else if (root.getChave() < chave) {
            buscarNo(chave, root.getFilhoDireito());
        } else if (root.getChave() > chave) {
            buscarNo(chave, root.getFilhoEsquerdo());
        }
        return root;
    }


    public No removerNo(int chave) {

        No novo = buscarNo(chave, this.root);

        if (novo != null) {
        }

        return null;
    }

    public void preOrdem(No root) {

        if (isEmpty())
            return;

        System.out.println(root.getChave());

        preOrdem(root.getFilhoEsquerdo());

        preOrdem(root.getFilhoDireito());
    }
    
    public boolean isEmpty() {
        return this.root == null;
    }

    public No rotEsquerdaSIMPLES(No desbalanceado) {
        
        No aux = desbalanceado.getFilhoDireito();
        
        // tira a referência direita do nó desbalanceado
        // sem perder referência dos nós a esquerda do rotacionado(maiores que o desbalanceado)
        desbalanceado.setFilhoDireito(aux.getFilhoEsquerdo());
        
        if(desbalanceado.getFilhoDireito() != null)
            desbalanceado.getFilhoDireito().setPai(desbalanceado);
        
        aux.setFilhoEsquerdo(desbalanceado);
        
        // tira referência PAI do nó auxiliar
        aux.setPai(desbalanceado.getPai());
        
        desbalanceado.setPai(aux);
        
        // resolver referência esquerda ou direita do pai do auxiliar(possível novo ROOT)
        if(aux.getPai() != null){
            
            // se auxiliar não for o novo ROOT, precisa resolver referância:
            
            // direita do pai dele
            if(aux.getPai().getFilhoDireito() == desbalanceado)
                aux.getPai().setFilhoDireito(aux);
            
            // esquerda do pai dele
            else if(aux.getPai().getFilhoEsquerdo() == desbalanceado)
                aux.getPai().setFilhoEsquerdo(aux);
        }
        
        balancear(desbalanceado);
        balancear(aux);
        
        // retorno do nó rotacionado para, se desejado, aproveitar esse método de rotSIMPLES para a rotDUPLA
        return aux;
        
    }

    public No rotDireitaSIMPLES(No desbalanceado) {
        
        No aux = desbalanceado.getFilhoEsquerdo();
        
        // tira a referência esquerda do nó desbalanceado
        // sem perder a referência dos nós à direita do rotacionado(menores que o desbalanceado)
        desbalanceado.setFilhoEsquerdo(aux.getFilhoDireito());
        
        if(desbalanceado.getFilhoEsquerdo()!= null)
            desbalanceado.getFilhoEsquerdo().setPai(desbalanceado);
        
        aux.setFilhoDireito(desbalanceado);
        
        // tira referência PAI do nó auxiliar
        aux.setPai(desbalanceado.getPai());
        
        desbalanceado.setPai(aux);
        
        // resolver referência esquerda ou direita do pai do auxiliar(possível novo ROOT)
        if(aux.getPai() != null){
            
            // se auxiliar não for o novo ROOT, precisa resolver referância:
            
            // direita do pai dele
            if(aux.getPai().getFilhoDireito() == desbalanceado)
                aux.getPai().setFilhoDireito(aux);
            
            // esquerda do pai dele
            else if(aux.getPai().getFilhoEsquerdo() == desbalanceado)
                aux.getPai().setFilhoEsquerdo(aux);
        }
        
        balancear(desbalanceado);
        balancear(aux);
        
        // retorno do nó rotacionado para, se desejado, aproveitar esse método de rotSIMPLES para a rotDUPLA
        return aux;
        
    }

    public void rotEsquerdaDUPLA(No desbalanceado) {
        
        // desbalanceado = nó raiz da sub-árvore direita do nó realmente desbalanceado
        desbalanceado.setFilhoEsquerdo(rotEsquerdaSIMPLES(desbalanceado.getFilhoEsquerdo()));
        
        desbalanceado.getPai().setFilhoDireito(rotDireitaSIMPLES(desbalanceado));
    }

    public void rotDireitaDUPLA(No desbalanceado) {
        
        desbalanceado.setFilhoDireito(rotDireitaSIMPLES(desbalanceado.getFilhoDireito()));
        
        desbalanceado.getPai().setFilhoEsquerdo(rotEsquerdaSIMPLES(desbalanceado));
        
    }

}
