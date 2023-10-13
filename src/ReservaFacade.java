
public class ReservaFacade {
    private QuartoManager quartoManager;
    private HospedeManager hospedeManager;
    private PagamentoManager pagamentoManager;
    private DisponibilidadeManager disponibilidadeManager;

    public ReservaFacade() {
        this.quartoManager = new QuartoManager();
        this.hospedeManager = new HospedeManager();
        this.pagamentoManager = new PagamentoManager();
        this.disponibilidadeManager = new DisponibilidadeManager();
    }

    public void fazerReservaQuarto(int numeroQuarto, String dataEntrada, String dataSaida, String nomeHospede) {
        boolean disponivel = disponibilidadeManager.verificarDisponibilidade(numeroQuarto, dataEntrada, dataSaida);
        if(disponivel) {
            quartoManager.reservarQuarto(numeroQuarto, dataEntrada, dataSaida);
            hospedeManager.registrarHospede(nomeHospede);
        }
        else {
            System.out.println("O quarto #" + numeroQuarto + " não está disponivel.");
        }
    }

    public void cancelarReserva(int numeroQuarto) {
        quartoManager.cancelarReserva(numeroQuarto);
    }

    public void realizarPagamento(int numeroQuarto, double valor) {
        pagamentoManager.efetuarPagamento(numeroQuarto, valor);
    }

    public void verificarDisponibilidade(int numeroQuarto, String dataEntrada, String dataSaida) {
        boolean disponivel = disponibilidadeManager.verificarDisponibilidade(numeroQuarto, dataEntrada, dataSaida);
        if(disponivel){
            System.out.println("Quarto #" + numeroQuarto + " disponivel.");
        }
        else{
            System.out.println("Quarto #" + numeroQuarto + " indisponivel.");
        }
    }
}