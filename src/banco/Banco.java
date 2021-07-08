/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco;

import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;

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
        
        int opcao = -1;
        
        do{
            String menu = "0 - Sair\n";
            menu += "1 - Adicionar conta\n";
            menu += "2 - Mostrar todas as contas\n";
            menu += "3 - Excluir conta\n";
            menu += "4 - Sacar\n";
            menu += "5 - Depositar\n";
            menu += "6 - Transferir\n";
            menu += "\nEscolha uma opção:";
            
            try{
                opcao = Integer.parseInt(JOptionPane.showInputDialog(menu));
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
                    case 5:{
                        depositarNaConta();
                        break;
                    }
                    case 6:{
                        transferenciaDeFundos();
                        break;
                    }
                    default:{
                        if (opcao != 0){
                            JOptionPane.showMessageDialog(null, "Opção inválida");
                        }
                        break;
                    }
                }                                  
            }catch(NumberFormatException ex){
                JOptionPane.showMessageDialog(null, "Opção inválida");
            }
        }while(opcao != 0);
        
    }
    
    private static void adicionarConta(){
        
        int opcao = -1;
        
        do{
            String menu = "0 - Voltar\n";
            menu += "1 - Conta Corrente\n";
            menu += "2 - Conta Poupança\n";
            menu += "\nEscolha uma opção:";
            
            try{
                opcao = Integer.parseInt(JOptionPane.showInputDialog(menu));
                switch (opcao){
                    case 1:{
                        ContaCorrente conta = new ContaCorrente();
                        System.out.print("Informe o número:");
                        conta.setNumero(entrada.nextInt());
                        entrada.nextLine();
                        System.out.print("Informe o nome:");
                        conta.setNomeTitular(entrada.nextLine());
                        System.out.print("Informe o saldo:");
                        conta.setSaldo(entrada.nextDouble());
                        System.out.print("Informe o limite:");
                        conta.setLimite(entrada.nextDouble());
                        banco.add(conta);
                        opcao = 0;
                        break;
                    }
                    case 2:{
                        ContaPoupanca conta = new ContaPoupanca();
                        System.out.print("Informe o número:");
                        conta.setNumero(entrada.nextInt());
                        entrada.nextLine();
                        System.out.print("Informe o nome:");
                        conta.setNomeTitular(entrada.nextLine());
                        System.out.print("Informe o saldo:");
                        conta.setSaldo(entrada.nextDouble());
                        System.out.print("Informe a variação:");
                        conta.setVariacao(entrada.nextInt());
                        banco.add(conta);
                        opcao = 0;
                        break;
                    }
                    default:{
                        if (opcao != 0){
                            JOptionPane.showMessageDialog(null, "Opção inválida");
                        }
                        break;
                    }
                }
            }catch(NumberFormatException ex){
                JOptionPane.showMessageDialog(null, "Opção inválida");
            }
            
            
        }while(opcao != 0);

        
        
        //adicionando a conta criada na lista
        
    }
    
    private static void mostrarTodasContas(){
        String msg = "";
        for (Conta conta : banco) {
            msg += conta.toString();
        }
        JOptionPane.showMessageDialog(null, msg);
    }
    
    private static int buscarIndiceConta(String complemento){
        Conta conta = new ContaCorrente();
        conta.setNumero(Integer.parseInt(JOptionPane.showInputDialog("Informe o número da conta "+complemento+":")));
        return banco.indexOf(conta);
    }
    
    private static void excluirConta(){
        int posicao = buscarIndiceConta("que deseja excluir");
        
        if (posicao >= 0){
            if (JOptionPane.showConfirmDialog(null, 
                    "Deseja realmente excluir essa conta?") == JOptionPane.YES_OPTION){
                banco.remove(posicao);
                JOptionPane.showMessageDialog(null, "Conta excluída com sucesso");
            }
        }else{
            JOptionPane.showMessageDialog(null, "Conta não encontrada");
        } 
    }
    
    private static void sacarDaConta(){
        int posicao = buscarIndiceConta("que deseja sacar");
        
        if (posicao >= 0) {
            
            double valor = Double.parseDouble(JOptionPane.showInputDialog("Informe o valor que deseja sacar:"));
            
            if (banco.get(posicao).sacar(valor)){
                JOptionPane.showMessageDialog(null, "Saque realizado com sucesso!");
            }else{
                JOptionPane.showMessageDialog(null, "Saldo insuficiente!");
            }
        }else{
            JOptionPane.showMessageDialog(null, "Conta não encontrada!");
        }
    }
    
    private static void depositarNaConta(){
        int posicao = buscarIndiceConta("que deseja depositar");
        
        if (posicao >= 0) {
            System.out.print("Informe o valor que deseja depositar:");
            double valor = entrada.nextDouble();
            banco.get(posicao).depositar(valor);
        }else{
            System.out.println("Conta não encontrada!");
        }
    }
    
    private static void transferenciaDeFundos(){
        int posOrigem = buscarIndiceConta("de origem");
        if (posOrigem >= 0) {
            int posDestino = buscarIndiceConta("de destino");
            if (posDestino >= 0) {
                System.out.print("Informe o valor que deseja transferir:");
                double valor = entrada.nextDouble();
                if (banco.get(posOrigem).transferir(banco.get(posDestino), valor)){
                    System.out.println("Transferência realizada com sucesso");
                }else{
                    System.out.println("A Transferência não pôde ser realizada");
                }
            }else{
                System.out.println("Conta de destino não encontrada!");
            }
        }else{
            System.out.println("Conta de origem não encontrada!");
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
