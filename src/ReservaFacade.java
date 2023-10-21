import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReservaFacade {
    public static List<DadosReserva> reservas = new ArrayList<>();

    PagamentoManager pagamentoManager = new PagamentoManager();
    QuartoManager quartoManager = new QuartoManager();
    public void fazerReservaQuarto(int numeroQuarto, String dataEntradaStr, String dataSaidaStr, String nomeHospede) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date dataEntrada = sdf.parse(dataEntradaStr);
        Date dataSaida = sdf.parse(dataSaidaStr);

        DadosReserva reserva = new DadosReserva(numeroQuarto, dataEntradaStr, dataSaidaStr, nomeHospede);
        reservas.add(reserva);

        // Aqui você pode adicionar a lógica adicional necessária para lidar com a reserva
    }

    public void cancelarReserva(int numeroQuarto) {
        reservas.removeIf(reserva -> reserva.getNumeroQuarto() == numeroQuarto);

        // Lógica adicional para cancelar a reserva
    }

    public void realizarPagamento(int numeroQuarto, String dataEntradaStr, String dataSaidaStr) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            pagamentoManager.realizarPagamento(numeroQuarto, dataEntradaStr, dataSaidaStr, reservas);
        }
         catch (ParseException e) {
            // Trate a exceção ou registre-a
            e.printStackTrace(); // Exemplo de registro de exceção
        }
    }

    private double calcularValorHospedagem(int dias) {
        // Lógica para calcular o valor com base na quantidade de dias
        // Substitua esta lógica com a forma como você deseja calcular o valor da hospedagem
        double valorDiaria = 100.0; // Valor da diária
        return dias * valorDiaria;
    }

    public boolean verificarDisponibilidade(int numeroQuarto, String dataEntradaStr, String dataSaidaStr) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date dataEntrada = sdf.parse(dataEntradaStr);
        Date dataSaida = sdf.parse(dataSaidaStr);

        for (DadosReserva reserva : reservas) {
            // Verificar se o quarto coincide com o número fornecido
            if (reserva.getNumeroQuarto() == numeroQuarto) {
                // Verificar se as datas da nova reserva se sobrepõem com as datas de uma reserva existente
                Date dataReservaEntrada = sdf.parse(reserva.getDataEntradaStr());
                Date dataReservaSaida = sdf.parse(reserva.getDataSaidaStr());

                if ((dataEntrada.after(dataReservaEntrada) && dataEntrada.before(dataReservaSaida))
                        || (dataSaida.after(dataReservaEntrada) && dataSaida.before(dataReservaSaida))
                        || (dataEntrada.before(dataReservaEntrada) && dataSaida.after(dataReservaSaida))) {
                    // Existe uma sobreposição de datas, o quarto não está disponível
                    return false;
                }
            }
        }

        // Se não houver sobreposição, o quarto está disponível
        return true;
    }

}
