import java.io.IOException;
import java.util.Scanner;


public class Principal {
    public static void pressEnter() throws IOException {
        System.out.println("Pressione Enter para continuar...");
        System.in.read();
    }

    public static void main(String[] args) throws IOException {

        ContaBancaria conta = new ContaBancaria();
        conta.setNumeroConta(55956);
        conta.setSaldo(1599.99);
        conta.setTitular("Tony Stark");
        conta.setTipoConta("Corrente");


        String mensagemInicial = String.format("""
                ******************************
                Bem vindo a sua conta bancária!
                
                Nome: %s
                Tipo de conta: %s
                Número da conta: %s
                Saldo: R$ %.2f
                
                ******************************""", conta.getTitular(), conta.getTipoConta(), conta.getNumeroConta(), conta.getSaldo());
        System.out.println(mensagemInicial);
        int opcao = 0;
        while (opcao != 4) {
            String menu = """
                    Selecione uma das seguintes opções para continuar:
                    
                      1 - Consultar saldo
                      2 - Transferir valor
                      3 - Receber valor
                      4 - Sair
                    
                    Digite o número da opção desejada:""";

            System.out.println(menu);
            Scanner leitura = new Scanner(System.in);
            opcao = leitura.nextInt();
            switch (opcao) {
                case 1:
                    String msgSaldo = String.format("""
                            
                            Seu saldo é de: R$ %.2f
                            
                            """, conta.getSaldo());
                    System.out.println(msgSaldo);
                    pressEnter();
                    break;
                case 2:
                    System.out.println("""
                            
                            Digite o valor que deseja transferir:
                            """);
                    double valorTransferencia = leitura.nextDouble();
                    conta.transferencia(valorTransferencia);
                    pressEnter();
                    break;
                case 3:
                    System.out.println("""
                            
                            Digite o valor do depósito:
                            """);
                    double valorRecebido = leitura.nextDouble();
                    conta.deposito(valorRecebido);
                    pressEnter();
                    break;

                case 4:
                    System.out.println("""
                            
                            Obrigado por utilizar nossos serviços!
                            
                            """);
                    break;
            }
        }
    }
}