import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Reserva {
    private int numeroQuarto;
    private String nomeHospede;
    private double valorDiaria;
    private LocalDate dataCheckIn;
    private LocalDate dataCheckOut;
    private int minDiarias;
    private int maxDiarias;

    public Reserva(int numeroQuarto, String nomeHospede, double valorDiaria, LocalDate dataCheckIn,
            LocalDate dataCheckOut) {
        this.numeroQuarto = numeroQuarto;
        this.nomeHospede = nomeHospede;
        this.valorDiaria = valorDiaria;
        this.dataCheckIn = dataCheckIn;
        this.dataCheckOut = dataCheckOut;
        this.minDiarias = minDiarias;
        this.maxDiarias = maxDiarias;
    }

    public int getNumeroQuarto() {
        return numeroQuarto;
    }
    public String getNomeHospede() {
        return nomeHospede;
    }
    public double getValorDiaria() {
        return valorDiaria;
    }
    public LocalDate getDataCheckIn() {
        return dataCheckIn;
    }
    public LocalDate getDataCheckOut() {
        return dataCheckOut;
    }

    public boolean reservar(LocalDate dataCheckOut){
        if (dataCheckIn.isBefore(dataCheckOut) && isValidReservationPeriod(dataCheckOut)) {
            this.dataCheckOut = dataCheckOut;
            return true;
        }
        return false;
    }

    public boolean cancelarReserva(){
        if (this.dataCheckOut != null) {
            this.dataCheckOut = null;
            return true;
        }
        return false;
    }

    public double calcularDias(){
        if (dataCheckOut == null) {
            return 0.0;
        }
        long numDiarias = ChronoUnit.DAYS.between(dataCheckIn, dataCheckOut);
        double desconto = calcularDesconto(numDiarias);
        return (numDiarias * valorPorDiaria) - desconto;
    }

    private boolean isValidReservationPeriod(LocalDate checkOutDate) {
        long numDiarias = ChronoUnit.DAYS.between(dataCheckIn, checkOutDate);
        return numDiarias >= minDiarias && numDiarias <= maxDiarias;
    }

    private double calcularDesconto(long numDiarias) {
        // Implemente a lógica de desconto aqui, se necessário
        // Exemplo: 10% de desconto para mais de 5 diárias
        if (numDiarias > 5) {
            return 0.1 * (numDiarias * valorPorDiaria);
        }
        return 0.0;
    }

    public LocalDate getCheckOutDate() {
        return dataCheckOut;
    }

}
