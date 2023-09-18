import java.time.LocalDate;
 
public class Reserva {
    private int numeroQuarto;
    private String nomeHospede;
    private double valorDiaria;
    private LocalDate dataCheckIn;
    private LocalDate dataCheckOut;

    public Reserva(int numeroQuarto, String nomeHospede, double valorDiaria, LocalDate dataCheckIn,
            LocalDate dataCheckOut) {
        this.numeroQuarto = numeroQuarto;
        this.nomeHospede = nomeHospede;
        this.valorDiaria = valorDiaria;
        this.dataCheckIn = dataCheckIn;
        this.dataCheckOut = dataCheckOut;
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


    public void setNumeroQuarto(int numeroQuarto) {
        this.numeroQuarto = numeroQuarto;
    }
    public void setNomeHospede(String nomeHospede) {
        this.nomeHospede = nomeHospede;
    }
    public void setValorDiaria(double valorDiaria) {
        this.valorDiaria = valorDiaria;
    }
    public void setDataCheckIn(LocalDate dataCheckIn) {
        this.dataCheckIn = dataCheckIn;
    }
    public void setDataCheckOut(LocalDate dataCheckOut) {
        this.dataCheckOut = dataCheckOut;
    }


    public void cancelarReserva() {
        this.dataCheckIn = null;
        this.dataCheckOut = null;
    }

    public int calcularNumeroDiarias() {
        return (int) dataCheckIn.until(dataCheckOut).getDays();
    }

    public double aplicarDesconto() {
        int numeroDiarias = calcularNumeroDiarias();
        double desconto = 0.0;
        //Desconto de 10% pra quem passa 7 dias ou mais, ou de 5% para 3 dias ou mais
        if (numeroDiarias >= 7) {
            desconto = 0.1;
        } else if (numeroDiarias >= 3) {
            desconto = 0.05;
        }

        return valorDiaria * numeroDiarias * (1 - desconto);
    }


    public static void main(String[] args) {
        LocalDate checkIn = LocalDate.of(2023, 9, 10);
        LocalDate checkOut = LocalDate.of(2023, 9, 20);
        Reserva reserva = new Reserva(101, "Richard", 100.0, checkIn, checkOut);

        System.out.println("\nHospede:" + reserva.getNomeHospede());
        System.out.println("Número de diárias: " + reserva.calcularNumeroDiarias());
        System.out.println("Valor total da reserva: " + reserva.aplicarDesconto());

    }

}
