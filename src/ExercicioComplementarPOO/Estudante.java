public class Estudante {

    //Declarando atributos
    private String nome;
    private int matricula;
    private double nota1;
    private double nota2;
    private double nota3;

    //Criando construtor
    public Estudante(String nome, int matricula, double nota1, double nota2, double nota3) {
        this.nome = nome;
        this.matricula = matricula;
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.nota3 = nota3;
    }

    //Gerando geters e seters
    public String getNome() {
        return nome;
    }
    public int getMatricula() {
        return matricula;
    }
    public double getNota1() {
        return nota1;
    }
    public double getNota2() {
        return nota2;
    }
    public double getNota3() {
        return nota3;
    }

    //Metodo para calcular média
    public double calculaMedia() {
        double resultado = ((getNota1() + getNota2() + getNota3()) / 3);
        if (resultado >= 70){
            System.out.printf("Nota: %.2f \nStatus: Aprovado\n", resultado);
        }else { 
            System.out.printf("Nota: %.2f \nStatus: Reprovado\n", resultado);
        }
        return resultado;
    }

    //Criando um main para testar os valores
    public static void main(String[] args) {
        // Criando dos objetos para a classe Estutant
        Estudante estudante1 = new Estudante("Richard", 2023192, 75, 82, 90);
        Estudante estudante2 = new Estudante("Rick", 2023200, 55, 100, 43);
        Estudante estudante3 = new Estudante("Luna", 2023244, 60, 70, 80);

        // Exibir informações das pessoas
        System.out.println("\nAluno(a): " + estudante1.getNome() + "\nMatrícula: " + estudante1.getMatricula());
        estudante1.calculaMedia();

        System.out.println("\nAluno(a): " + estudante2.getNome() + "\nMatrícula: " + estudante2.getMatricula());
        estudante2.calculaMedia();

        System.out.println("\nAluno(a): " + estudante3.getNome() + "\nMatrícula: " + estudante3.getMatricula());
        estudante3.calculaMedia();
    }

}
