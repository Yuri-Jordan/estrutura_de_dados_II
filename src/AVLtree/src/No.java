/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AVLtree.src;

/**
 *
 * @author yuri
 */
public class No {

    private No filhoEsquerdo;
    private No filhoDireito;
    private No pai;
    
    private int chave;
    private int balanceamento;

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }
    private int altura;

    public No(int chave) {
        this.chave = chave;
        //this.setBalanceamento(0);
    }

    public No() {
    }

    public No getFilhoEsquerdo() {
        return filhoEsquerdo;
    }

    public void setFilhoEsquerdo(No filhoEsquerdo) {
        this.filhoEsquerdo = filhoEsquerdo;
    }

    public No getFilhoDireito() {
        return filhoDireito;
    }

    public void setFilhoDireito(No filhoDireito) {
        this.filhoDireito = filhoDireito;
    }

    public No getPai() {
        return pai;
    }

    public void setPai(No pai) {
        this.pai = pai;
    }

    public int getChave() {
        return chave;
    }

    public void setChave(int chave) {
        this.chave = chave;
    }

    public int getBalanceamento() {
        return balanceamento;
    }

    public void setBalanceamento(int balanceamento) {
        this.balanceamento = balanceamento;
    }
    
    
}
