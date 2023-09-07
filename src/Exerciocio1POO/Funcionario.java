public class Funcionario {
    
    //Declarando atributos
    private String nome;
    private String sobrenome;
    private float salario;

    //Criando construtor
    public Funcionario(String nome, String sobrenome, float salario) {
        this.nome = nome; 
        this.sobrenome = sobrenome; 
        this.salario = salario; 
    }

    //Gerando geters e seters
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }
    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public float getSalario() {
        return salario;
    }
    public void setSalario(float salario) {
        this.salario = salario;
    }
    
    //Criando métodos extras
    public float getSalarioAnual() {
        return (float) salario*12;
    }
    public void concederAumento(float valor) {
        this.salario *= 1+(valor/100);
    }
}
