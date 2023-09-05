public class Estudante {

    //Declarando atributos
    private String nome;
    private int matricula;

    //Criando construtor
    public Estudante(String nome, int matricula) {
        this.nome = nome;
        this.matricula = matricula;
    }

    //Gerando geters e seters
    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getMatricula() {
        return this.matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

}
