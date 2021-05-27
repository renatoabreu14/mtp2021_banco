/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author renato
 */
public class Banco {
    
    private static ArrayList<Conta> banco = new ArrayList<>();
    private static Scanner entrada = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        int opcao;
        
        do{
            String menu = "0 - Sair\n";
            menu += "1 - Adicionar conta\n";
            menu += "2 - Mostrar todas as contas\n";
            menu += "3 - Excluir conta\n";
            menu += "4 - Sacar\n";
            menu += "\nEscolha uma opção:";
            System.out.print(menu);
            opcao = entrada.nextInt();
            
            switch (opcao){
                case 1:{
                    adicionarConta();
                    break;
                }
                case 2:{
                    mostrarTodasContas();
                    break;
                }
                case 3:{
                    excluirConta();
                    break;
                }
                case 4:{
                    sacarDaConta();
                    break;
                }
                default:{
                    if (opcao != 0){
                        System.out.println("Opção inválida");
                    }
                    break;
                }
            }
        
        }while(opcao != 0);
        
    }
    
    private static void adicionarConta(){
        Conta conta = new Conta();
        System.out.print("Informe o número:");
        conta.setNumero(entrada.nextInt());
        entrada.nextLine();
        System.out.print("Informe o nome:");
        conta.setNomeTitular(entrada.nextLine());
        System.out.print("Informe o saldo:");
        conta.setSaldo(entrada.nextDouble());
        //adicionando a conta criada na lista
        banco.add(conta);
    }
    
    private static void mostrarTodasContas(){
        for (Conta conta : banco) {
            System.out.println(conta.toString());
        }
    }
    
    private static void excluirConta(){
        System.out.print("Informe o número da conta que deseja excluir:");
        Conta conta = new Conta();
        conta.setNumero(entrada.nextInt());
        
        int posicao = banco.indexOf(conta);
        if (posicao >= 0){
            banco.remove(posicao);
            System.out.println("Conta excluída com sucesso");
        }else{
            System.out.println("Conta não encontrada");
        } 
    }
    
    private static void sacarDaConta(){
        System.out.print("Informe o número da conta que deseja sacar:");
        Conta contaSaque = new Conta();
        contaSaque.setNumero(entrada.nextInt());
        int posicao = banco.indexOf(contaSaque);
        
        if (posicao >= 0) {
            System.out.print("Informe o valor que deseja sacar:");
            double valor = entrada.nextDouble();
            if (banco.get(posicao).sacar(valor)){
                System.out.println("Saque realizado com sucesso!");
            }else{
                System.out.println("Saldo insuficiente!");
            }
        }else{
            System.out.println("Conta não encontrada!");
        }
    }
}

/*
private static ArrayList<Conta> lista = new ArrayList<>();

   
    public static void main(String[] args) {
        // TODO code application logic here
        
        
        Scanner entrada = new Scanner(System.in);
        
        Conta c1 = new Conta();
        System.out.print("Informe o número:");
        c1.setNumero(entrada.nextInt());
        entrada.nextLine();
        System.out.print("Informe o nome:");
        c1.setNomeTitular(entrada.nextLine());
        System.out.print("Informe o saldo:");
        c1.setSaldo(entrada.nextDouble());
        
        lista.add(c1);
        
        lista.set(0, c1);
        
        System.out.println(c1.getNomeTitular());
        
        Conta c2 = new Conta();
        System.out.print("Informe o número:");
        c2.setNumero(entrada.nextInt());
        entrada.nextLine();
        System.out.print("Informe o nome:");
        c2.setNomeTitular(entrada.nextLine());
        System.out.print("Informe o saldo:");
        c2.setSaldo(entrada.nextDouble());
        
        lista.add(c2);
        
        System.out.print("Saldo inicial c1: ");
        System.out.println(c1.getSaldo());
        System.out.print("Saldo inicial c2: ");
        System.out.println(c2.getSaldo());
        
        System.out.print("Informe o valor para depósito:");
        c1.depositar(entrada.nextDouble());
        
        System.out.print("Saldo após depósito c1: ");
        System.out.println(c1.getSaldo());
        
        System.out.print("Informe o valor do saque:");
        double saque = entrada.nextDouble();
        if (c1.sacar(saque)){
            System.out.println("Saque realizado com sucesso!");
        }else{
            System.out.println("O saque não pôde ser realizado!");
        }
        
        System.out.print("Saldo após saque c1: ");
        System.out.println(c1.getSaldo());
        
        System.out.print("Informe o valor da transferência:");
        double tranferencia = entrada.nextDouble();
        if (c1.transferir(c2, tranferencia)){
            System.out.println("Transferência realizada com sucesso!");
        }else{
            System.out.println("A transferência não pôde ser realizada!");
        }
        
        System.out.print("Saldo após transferência c1: ");
        System.out.println(c1.getSaldo());
        System.out.print("Saldo após transferência c2: ");
        System.out.println(c2.getSaldo());
        
        System.out.print("Informe o valor da transferência:");
        tranferencia = entrada.nextDouble();
        if (c2.transferir(c1, tranferencia)){
            System.out.println("Transferência realizada com sucesso!");
        }else{
            System.out.println("A transferência não pôde ser realizada!");
        }
        
        System.out.print("Saldo após transferência c1: ");
        System.out.println(c1.getSaldo());
        System.out.print("Saldo após transferência c2: ");
        System.out.println(c2.getSaldo());
        
        System.out.println("Informe o indice:");
        int indice = entrada.nextInt();
        mostrarTitular(indice);
        mostrarTotosTitulares();
        
        
    }
    
    private static void mostrarTitular(int indice){
        Conta conta = lista.get(indice);
        System.out.println(conta.getNomeTitular());
    } 
    
    private static void mostrarTotosTitulares(){
        for (int indice = 0; indice < lista.size(); indice++){
            System.out.println(lista.get(indice).getNomeTitular());
        }
        
        for (Conta conta : lista) {
            System.out.println(conta.getNomeTitular());
        }
    } 

*/
