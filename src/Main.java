import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ReservaFacade reservaFacade = new ReservaFacade();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Selecione a operação:");
            System.out.println("1. Fazer Reserva");
            System.out.println("2. Cancelar Reserva");
            System.out.println("3. Realizar Pagamento");
            System.out.println("4. Verificar Disponibilidade");
            System.out.println("0. Sair");

            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Número do Quarto: ");
                    int numeroQuarto = scanner.nextInt();

                    System.out.print("Data de Entrada (dd/MM/yyyy): ");
                    String dataEntrada = scanner.next();

                    System.out.print("Data de Saída (dd/MM/yyyy): ");
                    String dataSaida = scanner.next();

                    System.out.print("Nome do Hóspede: ");
                    String nomeHospede = scanner.next();

                    reservaFacade.fazerReservaQuarto(numeroQuarto, dataEntrada, dataSaida, nomeHospede);
                    System.out.println();
                    break;
                case 2:
                    System.out.print("Número do Quarto: ");
                    int numeroQuarto1 = scanner.nextInt();
                    reservaFacade.cancelarReserva(numeroQuarto1);
                    System.out.println();
                    break;
                case 3:
                    System.out.print("Número do Quarto: ");
                    int numeroQuarto2 = scanner.nextInt();
                    System.out.print("Valor a ser pago: R$  ");
                    double valor = scanner.nextInt();
                    reservaFacade.realizarPagamento(numeroQuarto2, valor);
                    System.out.println();
                    break;
                case 4:
                    System.out.print("Número do Quarto: ");
                    int numeroQuarto3 = scanner.nextInt();

                    System.out.print("Data de Entrada (dd/MM/yyyy): ");
                    String dataEntrada1 = scanner.next();

                    System.out.print("Data de Saída (dd/MM/yyyy): ");
                    String dataSaida1 = scanner.next();
                    reservaFacade.verificarDisponibilidade(numeroQuarto3, dataEntrada1, dataSaida1);
                    System.out.println();
                    break;
                case 0:
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    System.out.println();
            }
        }
    }
}