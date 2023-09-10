public class Calculadora {
 
     //Criando métodos soma
     public double soma(double a, double b) {
        return a+b;
     }
    //Criando métodos subtração
     public double subtracao(double a, double b) {
        return a-b;
     }
    //Criando métodos multiplicacao
     public double multiplicacao(double a, double b) {
        return a*b;
     }
    //Criando métodos subtração
     public double divisao(double a, double b) {
        //Observando a divisão por 0
        if (b == 0) {
            System.out.println("\nErro: Divisão por zero");
            return Double.NaN; // Retorna NaN
        }
        return a/b;
     }
 
     //Criando um main para testar os valores
     public static void main(String[] args) {
         //Criando dos objetos calculadora para testar valores
         Calculadora calculadora1 = new Calculadora();
 
         //Testando métodos das operações
         double resultSom = calculadora1.soma(5, 5);
         System.out.println("Soma = " + resultSom);

         double resultSub = calculadora1.subtracao(20, 5);
         System.out.println("\nSubtração = " + resultSub);

         double resultMul = calculadora1.multiplicacao(10, 5);
         System.out.println("\nMultiplicação = " + resultMul);

         double resultDiv = calculadora1.divisao(30, 0);
         System.out.println("\nDivisão = " + resultDiv);
     }
}
