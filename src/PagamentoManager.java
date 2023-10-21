import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

class PagamentoManager {
    void realizarPagamento(int numeroQuarto, String dataEntradaStr, String dataSaidaStr, List<DadosReserva> reservas) throws ParseException
    {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date dataEntrada = sdf.parse(dataEntradaStr);
            Date dataSaida = sdf.parse(dataSaidaStr);

            for (DadosReserva reserva : reservas) {
                if (reserva.getNumeroQuarto() == numeroQuarto
                        && dataEntradaStr.equals(reserva.getDataEntradaStr())
                        && dataSaidaStr.equals(reserva.getDataSaidaStr())) {
                    // Calcular o valor com base na diferença entre as datas de entrada e saída
                    long diff = dataSaida.getTime() - dataEntrada.getTime();
                    int dias = (int) (diff / (24 * 60 * 60 * 1000)) + 1; // Adiciona 1 para incluir o dia de partida
                    double valor = calcularValorHospedagem(dias);

                    // Aqui você pode adicionar lógica adicional, como a emissão de uma fatura
                    System.out.println("Valor da hospedagem: R$" + valor);
                }
            }
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
}