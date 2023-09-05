public class Circulo {
    
    //Declarando atributos
    private float raio;

    //Criando construtor
    public Circulo(float raio) {
        this.raio = raio;
    }

    //Gerando geters e seters
    public float getRaio() {
        return this.raio;
    }

    public void setRaio(float raio) {
        this.raio = raio;
    }

    //Criando métodos extras
    public float getArea() {
        return (float) (3.14159 * Math.pow(raio, 2));
    }

    public float getCircunferencia() {
        return (float) (2 * 3.14159 * raio);
    }

}
