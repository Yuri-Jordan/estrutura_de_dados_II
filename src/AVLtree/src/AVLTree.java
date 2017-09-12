package AVLtree.src;

public class AVLTree {

    No root;

    public AVLTree() {
        
    }

    public No getRoot() {
        return root;
    }

    public void setRoot(No root) {
        this.root = root;
    }

    
    
    
    
     public void inserir(int chave) {
        this.root = inserirNo(chave, this.root);
        
    }
    
    private No inserirNo(int chave, No root) {
        
        
        if(root == null){
            root = new No(chave);
            return root;
            
        } else if (chave < root.getChave()) {

            if (root.getFilhoEsquerdo() == null) {
                
                root.setFilhoEsquerdo(new No(chave));
                
                root.getFilhoEsquerdo().setPai(root);
                
                // sai conferindo a partir do nó acima do folha
                root = alterarFBinsercaoEsquerda(root);

            } else {
                inserirNo(chave, root.getFilhoEsquerdo());
            }
        } else if (chave > root.getChave()) {

            if (root.getFilhoDireito() == null) {

                root.setFilhoDireito(new No(chave));
                
                root.getFilhoDireito().setPai(root);
                
                // sai conferindo a partir do nó acima do folha
                root = alterarFBinsercaoDireita(root);

            } else {
                inserirNo(chave, root.getFilhoDireito());
            }
        } else {
            System.out.println("Nó existente!");
            return root = this.root;
        }
        
        return root;
    }
    
    private No alterarFBinsercaoDireita(No root){
        
        if(root != null){
        
            root.setBalanceamento(root.getBalanceamento() - 1);

            if(root.getBalanceamento() == 0)return root;

            // se nó estiver desbalanceado, confere que tipo de rotação se deve fazer
            else if(root.getBalanceamento() < -1 || root.getBalanceamento() > 1)
                root = conferirFBController(root);
            else
                if(root.getPai() != null)
                    alterarFBinsercaoDireita(root.getPai());
        }
        return root;
    }
    
    private No alterarFBinsercaoEsquerda(No root){
        
        if(root != null){
        
            root.setBalanceamento(root.getBalanceamento() + 1);

            if(root.getBalanceamento() == 0)return root;

            // nó estiver desbalanceado, confere que tipo de rotação se deve fazer
            else if(root.getBalanceamento() < -1 || root.getBalanceamento() > 1)
                root = conferirFBController(root);
            else
                alterarFBinsercaoEsquerda(root.getPai());
        }
        return root;
    }
    
    private No conferirFBController(No desbalanceado) {
        
        
        if(desbalanceado.getBalanceamento() == -2){
            
            if(desbalanceado.getFilhoDireito().getBalanceamento() <= 0)
                desbalanceado = rotEsquerdaSIMPLES(desbalanceado);
            else
                rotEsquerdaDUPLA(desbalanceado);
        }else if(desbalanceado.getBalanceamento() == 2){
            
            if(desbalanceado.getFilhoEsquerdo().getBalanceamento() >= 0)
                desbalanceado = rotDireitaSIMPLES(desbalanceado);
            else
                rotDireitaDUPLA(desbalanceado);
        }
        return desbalanceado;
    }

    public No buscarNo(int chave, No root) {

        No iterador = root;

        while (iterador != null) {

            if (iterador.getChave() == chave) {
                break;
            }

            if (iterador.getChave() < chave) {
                iterador = iterador.getFilhoDireito();
            } else {
                iterador = iterador.getFilhoEsquerdo();
            }

        }
        return iterador;

    }
    
    public void emOrdem(){
        emOrdem(this.root);
    }
    
    private void emOrdem(No root) {

        if (root == null) {
            return;
        } else {
            emOrdem(root.getFilhoEsquerdo());
            System.out.print(root.getChave() + " | ");
            emOrdem(root.getFilhoDireito());
        }
    }

    public No rotEsquerdaSIMPLES(No desbalanceado) {

        No aux = desbalanceado.getFilhoDireito();
        
        desbalanceado.setFilhoDireito(aux.getFilhoEsquerdo());
        
        aux.setFilhoEsquerdo(desbalanceado);
        
        desbalanceado.setPai(aux);
        
        // retorno do nó rotacionado para, se desejado, 
        // aproveitar esse método de rotSIMPLES para a rotDUPLA
        return aux;

    }

    public No rotDireitaSIMPLES(No desbalanceado) {

        No aux = desbalanceado.getFilhoEsquerdo();
        
        desbalanceado.setFilhoEsquerdo(aux.getFilhoDireito());
        
        aux.setFilhoDireito(desbalanceado);
        
        desbalanceado.setPai(aux);
        
        // retorno do nó rotacionado para, se desejado, 
        // aproveitar esse método de rotSIMPLES para a rotDUPLA
        return aux;

    }

    public void rotEsquerdaDUPLA(No desbalanceado) {

        // desbalanceado = nó raiz da sub-árvore direita do nó realmente desbalanceado
        desbalanceado.setFilhoEsquerdo(rotEsquerdaSIMPLES(desbalanceado.getFilhoEsquerdo()));

        desbalanceado.getPai().setFilhoDireito(rotDireitaSIMPLES(desbalanceado));
        
        desbalanceado.setFilhoEsquerdo(null);
    }

    public void rotDireitaDUPLA(No desbalanceado) {

        desbalanceado.setFilhoDireito(rotDireitaSIMPLES(desbalanceado.getFilhoDireito()));

        desbalanceado.getPai().setFilhoEsquerdo(rotEsquerdaSIMPLES(desbalanceado));

        desbalanceado.setFilhoDireito(null);
    }

    
    public int altura(No noot){
        
        
        if (root == null || (root.getFilhoEsquerdo() == null && root.getFilhoDireito()== null)) {
            return 0;
        }
        return Math.max(altura(root.getFilhoEsquerdo()), altura(root.getFilhoDireito())) + 1;
        
        
    }
   

}
