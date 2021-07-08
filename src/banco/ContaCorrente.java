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
public class ContaCorrente extends Conta{
    
    private double limite;
    
    public ContaCorrente(){
        
    }
    
    public ContaCorrente(int numero, String nome, double saldo, double limite){
        super(numero, nome, saldo);
        
        this.limite = limite;
    }

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }
    
    @Override
    public boolean sacar(double valor){
        if (((this.getSaldo() + this.getLimite()) - valor) >= 0){
            this.setSaldo(this.getSaldo() - valor);
            return true;
        }
        return false;
    }
    
    @Override
    public boolean transferir(Conta destino, double valor){
        if (this.sacar(valor)){
            destino.depositar(valor);
            return true;
        }
        return false;
    }

    @Override
    public void depositar(double valor) {
        this.setSaldo(this.getSaldo() + valor);
    }
    
    @Override
    public String toString() {
        String msg = super.toString();
        msg += "Limite da conta: " + this.getLimite()+ "\n\n";
        return msg; //To change body of generated methods, choose Tools | Templates.
    }
    
}
