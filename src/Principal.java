import java.util.Scanner;

public class Principal {
    public static void pressEnter() {
        System.out.println("Pressione Enter para continuar...");
        try {
            while (System.in.read() != '\n') {

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        double saldo = 1599.99;
        String nome = "Lucas Soares";
        String tipoConta = "Corrente";
        String mensagemInicial = String.format("""
                ******************************
                Bem vindo a sua conta bancária!
                
                Nome: %s
                Tipo de conta: %s
                Saldo: R$ %.2f
                
                ****************************** """, nome, tipoConta, saldo);
        System.out.println(mensagemInicial);
        int opcao = 0;
        while (opcao != 4) {
            String menu = """
                    Selecione uma das seguintes opções para continuar:
                    
                      1 - Consultar saldo
                      2 - Transferir valor
                      3 - Receber valor
                      4 - Sair
                    
                    Digite o número da opção desejada: """;

            System.out.println(menu);
            Scanner leitura = new Scanner(System.in);
            opcao = leitura.nextInt();
            switch (opcao) {
                case 1:
                    String msgSaldo = String.format("""
                            
                            Seu saldo é de: R$ %.2f
                            
                            """, saldo);
                    System.out.println(msgSaldo);
                    pressEnter();
                    break;
                case 2:
                    System.out.println("""
                            
                            Digite o valor que deseja transferir:
                            """);
                    double valorTransferencia = leitura.nextDouble();
                    if (valorTransferencia <= saldo) {
                        saldo -= valorTransferencia;
                        String msgTransferencia = String.format("""
                                
                                Transferência realizada com sucesso!
                                Seu saldo atual é de R$ %.2f
                                
                                """, saldo);
                        System.out.println(msgTransferencia);
                        pressEnter();
                        break;
                    } else {

                        String msgSaldoInsuficiente = String.format("""
                                
                                Não há saldo suficiente para concluir a transferência. 
                                Seu saldo atual é de R$ %.2f
                                
                                """, saldo);

                        System.out.println(msgSaldoInsuficiente);
                        pressEnter();
                        break;
                    }

                case 3:
                    System.out.println("""
                            
                            Digite o valor do depósito:
                            """);
                    double valorRecebido = leitura.nextDouble();
                    saldo += valorRecebido;

                    System.out.println("""
                            
                            Foram recebidos R$ """ + valorRecebido + """
                            
                            Seu saldo após o deposito é de: R$ """ + saldo);
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