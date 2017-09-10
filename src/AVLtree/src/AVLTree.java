package AVLtree.src;

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
        
        // se AVL vazia novo nó = ROOT
        if (isEmpty()) {
            this.root = novo;
            
        } else if (novo.getChave() < root.getChave()) {

            if (root.getFilhoEsquerdo() == null) {

                novo.setPai(root);
                root.setFilhoEsquerdo(novo);
                
                // sai conferindo a partir do nó acima do folha
                alterarFBinsercaoEsquerda(root);

            } else {
                inserirNo(novo.getChave(), root.getFilhoEsquerdo());
            }
        } else if (novo.getChave() > root.getChave()) {

            if (root.getFilhoDireito() == null) {

                novo.setPai(root);
                root.setFilhoDireito(novo);
                
                // sai conferindo a partir do nó acima do folha
                alterarFBinsercaoDireita(root);

            } else {
                inserirNo(novo.getChave(), root.getFilhoDireito());
            }
        } else {
            System.out.println("Nó existente!");
        }
    }
    
    private void alterarFBinsercaoDireita(No root){
        
        if(root == null) return;
        
        root.setBalanceamento(root.getBalanceamento() - 1);
        
        if(root.getBalanceamento() == 0)return;
        
        // nó estiver desbalanceado, confere que tipo de rotação se deve fazer
        else if(root.getBalanceamento() < -1 || root.getBalanceamento() > 1)
            conferirFBController(root);
        else
            alterarFBinsercaoDireita(root.getPai());
    }
    
    private void alterarFBinsercaoEsquerda(No root){
        
        if(root == null) return;
        
        root.setBalanceamento(root.getBalanceamento() + 1);
        
        if(root.getBalanceamento() == 0)return;
        
        // nó estiver desbalanceado, confere que tipo de rotação se deve fazer
        else if(root.getBalanceamento() < -1 || root.getBalanceamento() > 1)
            conferirFBController(root);
        else
            alterarFBinsercaoDireita(root.getPai());
    }
    
    private void conferirFBController(No root) {
        
        
        if(root.getBalanceamento() == -2){
            
            if(root.getFilhoDireito().getBalanceamento() <= 0)
                rotEsquerdaSIMPLES(root);
            else
                rotEsquerdaDUPLA(root);
        }else if(root.getBalanceamento() == 2){
            
            if(root.getFilhoEsquerdo().getBalanceamento() >= 0)
                rotDireitaSIMPLES(root);
            else
                rotDireitaDUPLA(root);
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

        if (isEmpty()) {
            return;
        }

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

        if (desbalanceado.getFilhoDireito() != null) {
            desbalanceado.getFilhoDireito().setPai(desbalanceado);
        }

        aux.setFilhoEsquerdo(desbalanceado);

        // tira referência PAI do nó auxiliar
        aux.setPai(desbalanceado.getPai());

        desbalanceado.setPai(aux);

        // resolver referência esquerda ou direita do pai do auxiliar(possível novo ROOT)
        if (aux.getPai() != null) {

            // se auxiliar não for o novo ROOT, precisa resolver referância:
            // direita do pai dele
            if (aux.getPai().getFilhoDireito() == desbalanceado) {
                aux.getPai().setFilhoDireito(aux);
            } // esquerda do pai dele
            else if (aux.getPai().getFilhoEsquerdo() == desbalanceado) {
                aux.getPai().setFilhoEsquerdo(aux);
            }
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

        if (desbalanceado.getFilhoEsquerdo() != null) {
            desbalanceado.getFilhoEsquerdo().setPai(desbalanceado);
        }

        aux.setFilhoDireito(desbalanceado);

        // tira referência PAI do nó auxiliar
        aux.setPai(desbalanceado.getPai());

        desbalanceado.setPai(aux);

        // resolver referência esquerda ou direita do pai do auxiliar(possível novo ROOT)
        if (aux.getPai() != null) {

            // se auxiliar não for o novo ROOT, precisa resolver referância:
            // direita do pai dele
            if (aux.getPai().getFilhoDireito() == desbalanceado) {
                aux.getPai().setFilhoDireito(aux);
            } // esquerda do pai dele
            else if (aux.getPai().getFilhoEsquerdo() == desbalanceado) {
                aux.getPai().setFilhoEsquerdo(aux);
            }
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
        
        desbalanceado.setFilhoEsquerdo(null);
    }

    public void rotDireitaDUPLA(No desbalanceado) {

        desbalanceado.setFilhoDireito(rotDireitaSIMPLES(desbalanceado.getFilhoDireito()));

        desbalanceado.getPai().setFilhoEsquerdo(rotEsquerdaSIMPLES(desbalanceado));

        desbalanceado.setFilhoDireito(null);
    }

    

   

}
