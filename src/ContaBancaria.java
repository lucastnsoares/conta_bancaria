public class ContaBancaria {
    private int numeroConta;
    private double saldo;
    private String titular;
    private String tipoConta;

    public String getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(String tipoConta) {
        this.tipoConta = tipoConta;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(int numeroConta) {
        this.numeroConta = numeroConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String nome) {
        this.titular = nome;
    }

    public void transferencia(double valorTransferencia) {
        if (valorTransferencia <= saldo) {
            saldo -= valorTransferencia;
            String msgTransferencia = String.format("""
                    
                    Transferência realizada com sucesso!
                    Seu saldo atual é de R$ %.2f
                    
                    """, saldo);
            System.out.println(msgTransferencia);
        } else {
            String msgSaldoInsuficiente = String.format("""
                    
                    Não há saldo suficiente para concluir a transferência.
                    Seu saldo atual é de R$ %.2f
                    
                    """, saldo);

            System.out.println(msgSaldoInsuficiente);
        }
    }

    public void deposito(double valorRecebido) {
        this.saldo += valorRecebido;

        String msgDeposito = String.format("""
                
                Depósito realizado com sucesso!
                Foram recebidos R$ %.2f
                
                Seu saldo após o deposito é de: R$ %.2f
                """, valorRecebido, this.saldo);

        System.out.println(msgDeposito);

    }
}


