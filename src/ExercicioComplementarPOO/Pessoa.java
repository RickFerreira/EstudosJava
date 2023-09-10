public class Pessoa {
    
    //Declarando atributos
    private String nome;
    private int idade;
    private String endereco;

    //Criando construtor
    public Pessoa(String nome, int idade, String endereco) {
        this.nome = nome;
        this.idade = idade;
        this.endereco = endereco;
    }

    //Gerando geters
    public String getNome() {
        return nome;
    }
    public int getIdade() {
        return idade;
    }
    public String getEndereco() {
        return endereco;
    }

    //Criando métodos extras
    public void exibirInformacoes() {
        System.out.println("Nome: " + getNome());
        System.out.println("Idade: " + getIdade());
        System.out.println("Endereço: " + getEndereco());
    }

    //Criando um main para testar os valores
    public static void main(String[] args) {
        // Criando dos objetos para a classe Pessoa
        Pessoa pessoa1 = new Pessoa("Richard", 23, "Rua Barão do Rio Branco, 277");
        Pessoa pessoa2 = new Pessoa("Rick", 55, "Rua Divina da Conceição, 456");

        // Exibir informações das pessoas
        System.out.println("Pessoa 1:");
        pessoa1.exibirInformacoes();

        System.out.println("\nPessoa 2:");
        pessoa2.exibirInformacoes();
    }
}
