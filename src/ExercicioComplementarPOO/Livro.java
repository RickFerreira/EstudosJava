public class Livro {
    
    //Declarando atributos
    private String titulo;
    private String autor;
    private double preco;

    //Criando construtor
    public Livro(String titulo, String autor, double preco) {
        this.titulo = titulo;
        this.autor = autor;
        this.preco = preco;
    }

    //Gerando geters e seters
    public String getTitulo() {
        return titulo;
    }
    public String getAutor() {
        return autor;
    }
    public double getPreco() {
        return preco;
    }

    //Criando um main para testar os valores
    public static void main(String[] args) {
        // Criando dos objetos para a classe livro
        Livro Livro1 = new Livro("Sherlock Holmes", "Richard Ferreira", 90.99);
        Livro Livro2 = new Livro("Vikings", "Rick Salviano", 7.98);

        // Exibir informações das pessoas
        System.out.println("\nTítulo: " + Livro1.getTitulo() + "\nAutor: " + Livro1.getAutor() + "\nPreço: R$ " + Livro1.getPreco());
        System.out.println("\nTítulo: " + Livro2.getTitulo() + "\nAutor: " + Livro2.getAutor() + "\nPreço: R$ " + Livro2.getPreco());
    }
}
