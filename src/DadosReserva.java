import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DadosReserva {
    private int numeroQuarto;
    private String dataEntradaStr;
    private String dataSaidaStr;
    private String nomeHospede;

    public DadosReserva(int numeroQuarto, String dataEntradaStr, String dataSaidaStr, String nomeHospede) {
        this.numeroQuarto = numeroQuarto;
        this.dataEntradaStr = dataEntradaStr;
        this.dataSaidaStr = dataSaidaStr;
        this.nomeHospede = nomeHospede;
    }

    public int getNumeroQuarto() {
        return numeroQuarto;
    }

    public void setNumeroQuarto(int numeroQuarto) {
        this.numeroQuarto = numeroQuarto;
    }

    public String getDataEntradaStr() {
        return dataEntradaStr;
    }

    public void setDataEntradaStr(String dataEntradaStr) {
        this.dataEntradaStr = dataEntradaStr;
    }

    public String getDataSaidaStr() {
        return dataSaidaStr;
    }

    public void setDataSaidaStr(String dataSaidaStr) {
        this.dataSaidaStr = dataSaidaStr;
    }

    public String getNomeHospede() {
        return nomeHospede;
    }

    public void setNomeHospede(String nomeHospede) {
        this.nomeHospede = nomeHospede;
    }
}
