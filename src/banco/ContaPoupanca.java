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
public class ContaPoupanca extends Conta{
    
    private int variacao;

    public ContaPoupanca() {
        
    }

    public ContaPoupanca(int numero, String nome, double saldo, int variacao) {
        super(numero, nome, saldo);
        this.variacao = variacao;
    }

    public int getVariacao() {
        return variacao;
    }

    public void setVariacao(int variacao) {
        this.variacao = variacao;
    }
    
    @Override
    public boolean sacar(double valor){
        if ((this.getSaldo() - valor) >= 0){
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
        msg += "Variação da conta: " + this.getVariacao()+ "\n\n";
        return msg; //To change body of generated methods, choose Tools | Templates.
    }
    
}
