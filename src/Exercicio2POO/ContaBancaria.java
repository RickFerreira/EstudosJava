import java.time.LocalTime;

public class ContaBancaria {
    private String numeroConta;
    private String titular;
    private double saldo;
    private double limiteChequeEspecial;
    private LocalTime horarioLimiteSaqueInicio;
    private LocalTime horarioLimiteSaqueFim;

    public ContaBancaria(String numeroConta, String titular, double limiteChequeEspecial) {
        this.numeroConta = numeroConta;
        this.titular = titular;
        this.saldo = 0;
        this.limiteChequeEspecial = limiteChequeEspecial;
        this.horarioLimiteSaqueInicio = LocalTime.of(7, 0); // Horário de início dos saques permitidos
        this.horarioLimiteSaqueFim = LocalTime.of(18, 0);   // Horário de término dos saques permitidos
    }

    public String getNumeroConta() {
        return numeroConta;
    }    
    public String getTitular() {
        return titular;
    }
    public double getSaldo() {
        return saldo;
    }

    public void deposito(double valor) {
        this.saldo = getSaldo() + valor;
    }
    public void saque(double valor) throws ContaBancaria.saldoIndisponivelException, ContaBancaria.horarioIndisponivelException {
        LocalTime agora = LocalTime.now();
        
        // Verifica se o horário atual está dentro do horário permitido para saques
        if (agora.isBefore(horarioLimiteSaqueInicio) || agora.isAfter(horarioLimiteSaqueFim) && valor > 100.0) {
            throw new horarioIndisponivelException("O horário não permite saque");
        }

        // Verifica se o valor do saque é maior que o saldo disponível
        if (valor > (saldo + limiteChequeEspecial)) {
            throw new saldoIndisponivelException("Não há saldo suficiente");
        }
        saldo -= valor;
    }

    public class saldoIndisponivelException extends Exception {
        public saldoIndisponivelException(String message) {
            super(message);
        }
    }
    public class horarioIndisponivelException extends Exception {
        public horarioIndisponivelException(String message) {
            super(message);
        }
    }

    public static void main(String[] args) throws ContaBancaria.saldoIndisponivelException, ContaBancaria.horarioIndisponivelException {
        ContaBancaria conta1 = new ContaBancaria("12345-6", "Richard", 5000.00);
         
        System.out.println("\nOlá, " + conta1.getTitular() + " seu saldo é: R$ " + conta1.getSaldo() + "\n");

        conta1.deposito(1000.00);
        System.out.println("Deposito de R$ 1000");
        System.out.println(conta1.getTitular() + " seu saldo é: R$ " + conta1.getSaldo() + "\n");

        conta1.saque(600.0);
        System.out.println("Saque de R$ 600");
        System.out.println(conta1.getTitular() + " seu saldo é: R$ " + conta1.getSaldo() + "\n");

        System.out.println("Saque de R$ 2000");
        conta1.saque(2000.0);
        System.out.println(conta1.getTitular() + " seu saldo é: R$ " + conta1.getSaldo() + "\n");

        System.out.println("Saque de R$ 2000");
        conta1.saque(2000.0);
        System.out.println(conta1.getTitular() + " seu saldo é: R$ " + conta1.getSaldo() + "\n");

        conta1.deposito(5000.00);
        System.out.println("Deposito de R$ 5000");
        System.out.println(conta1.getTitular() + " seu saldo é: R$ " + conta1.getSaldo() + "\n");

        System.out.println("Saque de R$ 3000");
        conta1.saque(3000.0);
        System.out.println(conta1.getTitular() + " seu saldo é: R$ " + conta1.getSaldo() + "\n");

        System.out.println("Saque de R$ 5000");
        conta1.saque(5000.0);
        System.out.println(conta1.getTitular() + " seu saldo é: R$ " + conta1.getSaldo() + "\n");
    }
}
