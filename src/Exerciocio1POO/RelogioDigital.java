public class RelogioDigital {
    
    //Declarando atributos
    private int hora;
    private int minuto;
    
    //Criando construtor
    public RelogioDigital() {
        hora = 12;
        minuto = 20;
    }

    //Gerando geters e seters
    public int getHora() {
        return this.hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }
    public int getMinuto() {
        return this.minuto;
    }

    public void setMinuto(int minuto) {
        this.minuto = minuto;
    }

    //Criando métodos extras
    public void tick() {
        if (minuto == 59){
            minuto = 0;
            if (hora == 23){
                hora = 0;
            }else{
                hora++;
            }
        } else {
            minuto++;
        }
    }


}
