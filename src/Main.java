
import AVLtree.src.AVLTree;
import AVLtree.src.No;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Yuri
 */
public class Main {

    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        
        AVLTree avlt = new AVLTree();
        System.out.println("============== AVL Teste ==============\n");
        char ch;
        
        do {
            
            System.out.println("\n============== AVL Operações ==========\n");
            System.out.println("1. Inserir nó");
            System.out.println("2. Buscar nó");
            System.out.println("3. Altura");
            
            System.out.println("\n0. Sair");


            int entrada = scan.nextInt();
            switch (entrada) {
                case 1:
                    
                    System.out.println("Digite um inteiro para inserir");
                    avlt.inserir(scan.nextInt());
                    break;
                    
                case 2:
                    
                    System.out.println("Digite um inteiro para buscar");
                    int chave = scan.nextInt();
                    
                    No resultado = avlt.buscarNo(chave, avlt.getRoot());
                    
                    if(resultado != null){
                        System.out.println("Resultado : " + resultado.getChave());
                        break;
                    }
                    System.out.println("Nó não existe");
                    
                case 3:
                    System.out.println("Resultado : " + avlt.altura(avlt.getRoot()));
                    break;
                    
                case 0:
                    
                    System.exit(0);
                    
                default:
                    
                    System.out.println("Entrada inválida\n");
                    break;
            }
           
            System.out.print("\nEm Ordem : ");
            avlt.emOrdem();
            
        } while (true);
         
    }

}
