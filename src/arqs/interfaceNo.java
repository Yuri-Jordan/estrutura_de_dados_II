package arqs;


import AVLtree.src.no;

public interface interfaceNo {

    public abstract no getFilhoDireito();

    public abstract no getFilhoEsquerdo();

    public abstract no getPai();

    public abstract Object getChave();

    public abstract void setFilhoDireito(no fD);

    public abstract void setFilhoEsquerdo(no fE);

    public abstract void setPai(no pai);

    public abstract void setChave(Object ch);

}