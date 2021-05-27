/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco;

/**
 *
 * @author renato
 */
public class Conta {
    
    private int numero;
    private String nomeTitular;
    private double saldo;
    
    public void depositar(double valor){
        this.setSaldo(this.getSaldo() + valor);
    }
    
    public boolean sacar(double valor){
        if ((this.getSaldo() - valor) >= 0){
            this.setSaldo(this.getSaldo() - valor);
            return true;
        }
        return false;
    }
    
    public boolean transferir(Conta destino, double valor){
        if (this.sacar(valor)){
            destino.depositar(valor);
            return true;
        }
        return false;
    }
    

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNomeTitular() {
        return nomeTitular;
    }

    public void setNomeTitular(String nomeTitular) {
        this.nomeTitular = nomeTitular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Conta){
           Conta conta = (Conta)obj;
           if (this.getNumero() == conta.getNumero()){
               return true;
           }
           return false;
        }
        return false;
    }

    @Override
    public String toString() {
        String msg = "";
        msg += "Número da conta: " + this.getNumero() + "\n";
        msg += "Nome do títular: " + this.getNomeTitular()+ "\n";
        msg += "Saldo da conta: " + this.getSaldo()+ "\n\n";
        return msg; //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
