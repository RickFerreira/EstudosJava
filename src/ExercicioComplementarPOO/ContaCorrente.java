public class ContaCorrente {
    //Declarando atributos
    private int numero;
    private double saldo;
    private String titular;

    //Criando construtor
    public ContaCorrente(int numero, double saldo, String titular) {
        this.numero = numero;
        this.saldo = saldo;
        this.titular = titular;
    }

    //Gerando geters e seters
    public int getNumero() {
        return numero;
    }
    public double getSaldo() {
        return saldo;
    }
    public String getTitular() {
        return titular;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    //Metodo para realizar deposito
    public void deposito(double valor) {
        setSaldo(getSaldo() + valor);
        System.out.println("Deposito de R$" + valor + " realizado com sucesso.");
    }

    //Metodo para realizar saque
    public void saque(double valor) {
        if (valor <= getSaldo()){
            setSaldo(getSaldo()- valor);
            System.out.println("Saque de R$" + valor + " realizado com sucesso.");
        } else {
            System.out.println("Saque de R$" + valor + " não realizado. Saldo insuficiente!!");
        }
    }

    // Método para realizar uma transferência
    public void transferencia(ContaCorrente contaDestino, double valor) {
        if (valor <= getSaldo()){
            setSaldo(getSaldo()- valor);
            contaDestino.deposito(valor);
            System.out.println("Transferência de R$" + valor + " para a conta de " + contaDestino.titular + " número " +contaDestino.numero);
        } else {
            System.out.println("Tranferência de R$" + valor + " não realizada. Saldo insuficiente!!");        }
    }

    //Criando um main para testar os valores
    public static void main(String[] args) {
        // Criando os objetos para a classe Estutant
        ContaCorrente conta1 = new ContaCorrente(12345, 100.00, "Richard");
        ContaCorrente conta2 = new ContaCorrente(54321, 1300.00, "Rick");
        
        //Exibindo saldos
        System.out.println("\nO saldo inicial de " + conta1.getTitular() + " é: R$ " + conta1.getSaldo());
        System.out.println("O saldo inicial de " + conta2.getTitular() + " é: R$ " + conta2.getSaldo() + "\n");


        conta1.deposito(1000.00);
        System.out.println("O saldo de " + conta1.getTitular() + " é: R$ " + conta1.getSaldo() + "\n");

        conta2.saque(600.0);
        System.out.println("O saldo de " + conta2.getTitular() + " é: R$ " + conta2.getSaldo() + "\n");

        conta1.saque(2000.0); // Tentativa de saque com valor maior que o saldo
        System.out.println("O saldo de " + conta1.getTitular() + " é: R$ " + conta1.getSaldo() + "\n");

        conta1.transferencia(conta2, 300.0);
        System.out.println("O saldo de : " + conta1.getTitular() + " é: R$ " + conta1.getSaldo());
        System.out.println("O saldo de : " + conta2.getTitular() + " é: R$ " + conta2.getSaldo() + "\n");

        conta1.transferencia(conta2, 3000.0); //Tentativa de tranferência com um valor maior que o saldo
        System.out.println("O saldo de : " + conta1.getTitular() + " é: R$ " + conta1.getSaldo());
        System.out.println("O saldo de : " + conta2.getTitular() + " é: R$ " + conta2.getSaldo() + "\n");
    }
}
