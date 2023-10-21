import java.text.ParseException;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws ParseException {
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
                    fazerReserva(reservaFacade, scanner);
                    break;
                case 2:
                    cancelarReserva(reservaFacade, scanner);
                    break;
                case 3:
                    realizarPagamento(reservaFacade, scanner);
                    break;
                case 4:
                    verificarDisponibilidade(reservaFacade, scanner);
                    break;
                case 0:
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private static void fazerReserva(ReservaFacade reservaFacade, Scanner scanner) throws ParseException {
        System.out.print("Número do Quarto: ");
        int numeroQuarto = scanner.nextInt();

        System.out.print("Data de Entrada (dd/MM/yyyy): ");
        String dataEntradaStr = scanner.next();

        System.out.print("Data de Saída (dd/MM/yyyy): ");
        String dataSaidaStr = scanner.next();

        System.out.print("Nome do Hóspede: ");
        scanner.nextLine();
        String nomeHospede = scanner.nextLine();

        reservaFacade.fazerReservaQuarto(numeroQuarto, dataEntradaStr, dataSaidaStr, nomeHospede);
    }

    private static void cancelarReserva(ReservaFacade reservaFacade, Scanner scanner) {
        System.out.print("Número do Quarto: ");
        int numeroQuarto = scanner.nextInt();

        reservaFacade.cancelarReserva(numeroQuarto);
    }

    private static void realizarPagamento(ReservaFacade reservaFacade, Scanner scanner) {
        System.out.print("Número do Quarto: ");
        int numeroQuarto = scanner.nextInt();

        System.out.print("Data de Entrada (dd/MM/yyyy): ");
        String dataEntradaStr = scanner.next();

        System.out.print("Data de Saída (dd/MM/yyyy): ");
        String dataSaidaStr = scanner.next();

        try {
            reservaFacade.realizarPagamento(numeroQuarto, dataEntradaStr, dataSaidaStr);
        } catch (ParseException e) {
            System.err.println("Erro ao processar datas. Certifique-se de inserir no formato correto.");
        }
    }

    private static void verificarDisponibilidade(ReservaFacade reservaFacade, Scanner scanner) throws ParseException {
        System.out.print("Número do Quarto: ");
        int numeroQuarto = scanner.nextInt();

        System.out.print("Data de Entrada (dd/MM/yyyy): ");
        String dataEntradaStr = scanner.next();

        System.out.print("Data de Saída (dd/MM/yyyy): ");
        String dataSaidaStr = scanner.next();

        boolean disponivel = reservaFacade.verificarDisponibilidade(numeroQuarto, dataEntradaStr, dataSaidaStr);
        if (disponivel) {
            System.out.println("O quarto está disponível para as datas especificadas.");
        } else {
            System.out.println("O quarto não está disponível para as datas especificadas.");
        }
    }
}
