import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

class QuartoManager {
    public void reservarQuarto(int numeroQuarto, String dataEntrada, String dataSaida) {
        System.out.println("Quarto #" + numeroQuarto + " reservado para o período de " + dataEntrada + " a " + dataSaida);
    }

    public void cancelarReserva(int numeroQuarto) {
        // Lógica para cancelar a reserva
        // ...
        System.out.println("Reserva do quarto #" + numeroQuarto + " cancelada.");
    }

    public boolean verificarDisponibilidade(int numeroQuarto, String dataEntradaStr, String dataSaidaStr) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date dataEntrada = sdf.parse(dataEntradaStr);
        Date dataSaida = sdf.parse(dataSaidaStr);

        // Se não houver sobreposição, o quarto está disponível
        return true;
    }
    private double calcularValorHospedagem(int dias) {
        // Lógica para calcular o valor com base na quantidade de dias
        // Substitua esta lógica com a forma como você deseja calcular o valor da hospedagem
        double valorDiaria = 100.0; // Valor da diária
        return dias * valorDiaria;
    }

}