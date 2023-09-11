public class Triangulo {
    private double lado1;
    private double lado2;
    private double lado3;

    public Triangulo(double lado1, double lado2, double lado3){
        this.lado1 = lado1;
        this.lado2 = lado2;
        this.lado3 = lado3;
    }

    public double getLado1(){
        return lado1;
    }
    public double getLado2(){
        return lado2;
    }
    public double getLado3(){
        return lado3;
    }

    public void tipoTriangulo(){
        if (getLado1() + getLado2() > getLado3() && getLado1() + getLado3() > getLado2() && getLado3() + getLado2() > getLado1()){
            if (getLado1() == getLado2() && getLado2() == getLado3()){
                System.out.println("O triângulo é equilátero\n");
            }else if (getLado1() != getLado2() && getLado2() != getLado3()){
                System.out.println("O triângulo é escaleno\n");
            }else {
                System.out.println("O triângulo é isósceles\n");
            }
        }else {
            System.out.println("Não forma um triângulo\n");
        }
    }

    public static void main(String[] args) {
        // Criando objetos Triangulo de diferentes tipos        
        Triangulo equilatero = new Triangulo(3.0, 3.0, 3.0);
        Triangulo isosceles = new Triangulo(4.0, 4.0, 3.0);
        Triangulo escaleno = new Triangulo(3.0, 4.0, 5.0);
        Triangulo invalido = new Triangulo(1.0, 2.0, 3.0); // Não é possível formar um triângulo

        // Determinando e exibindo o tipo de triângulo
        System.out.println("Triângulo 1: ");
        equilatero.tipoTriangulo();
        System.out.println("Triângulo 2: ");
        isosceles.tipoTriangulo();
        System.out.println("Triângulo 3: ");
        escaleno.tipoTriangulo();
        System.out.println("Triângulo 4: ");
        invalido.tipoTriangulo();
    }

}
