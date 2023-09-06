public class CarroAluguel {
    
    //Declarando atributos
    private float valorPorKm;
    private int distanciaPercorrida;
    private boolean disponivel;
    private boolean sinistro;
    private float debito;

    //Criando construtor
    public CarroAluguel(float valorPorKm) {
        this.valorPorKm = valorPorKm; //pegando o valor passado
        //Atribuindo valores
        this.distanciaPercorrida = 0;
        this.disponivel = true;
        this.sinistro = false;
        this.debito = 0;
    }

    //Gerando geters e seters
    public float getValorPorKm() {
        return valorPorKm; //retorna o valor cobrado por km
    }
    public void setValorPorKm(float valor) {
        this.valorPorKm = valor; //define o valor cobrado por km
    }

    
    public float getDistanciaPercorrida() {
        return this.distanciaPercorrida; //retorna a distância percorrida pelo carro
    }
    public void setDistanciaPercorrida(int distancia) {
        this.distanciaPercorrida = distancia; //define a distância percorrida pelo carro
    }

    //Criando métodos extras
    public void alugar() throws CarroIndisponivelException {
        //muda o estado de um carro de “disponivel” para “indisponível”
        if (!disponivel) {
            //Exceção para avisar que o carro não está disponível
            throw new CarroIndisponivelException("O carro está indisponível.");
        }
        //Tornando indisponível o carro alugado
        disponivel = false;
    }

    public void devolver() throws CarroDisponivelException, CarroNaoPagoException {
        //devolve um carro alugado, tornando-o disponível novamente
        if (disponivel) {
            //Exceção para avisar que o carro já está disponível, então não pode ser devolvido
            throw new CarroDisponivelException("O carro está disponível.");
        }
        
        if (debito > 0) {
            //Exceção para avisar que o carro ainda tem debitos, então não pode ser devolvido
            throw new CarroNaoPagoException("O carro não foi pago.");
        }
        
        disponivel = true;
        sinistro = false;
        distanciaPercorrida = 0;
    }

    public boolean isDisponivel() {
        //retorna o estado do carro, true para disponivel e false para indisponivel
        return disponivel;
    }

    public boolean hasSinistro() {
        //retorna true, quando houve sinistro e o seguro precisa ser acionado
        return sinistro;
    }

    public float getDebito() {
        //retorna o valor a ser pago pelo aluguel do carro
        float totalDebito = valorPorKm * distanciaPercorrida;
        //soma-se mais 60% do débito ao valor total, se há sinistro
        if (sinistro) {
            totalDebito *= 1.6;
            sinistro = false; // Zerando o sinistro depois de pago
        }
        return totalDebito;
    }

    public void pagar() throws CarroDisponivelException {
        //Um carro disponível não pode ser pago
        if (disponivel) {
            throw new CarroDisponivelException("O carro está disponível.");
        }
        //Zerando os debitos do carro
        debito = 0;
    }
}
