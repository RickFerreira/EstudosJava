public class Personagem {
    private String nome;
    private int saude;
    private int experiencia;
    private boolean vida;
    private int danoMinimo;
    private int experienciaMaxima;

    public Personagem(String nome, int saude, int experiencia) {
        this.nome = nome;
        this.saude = saude;
        this.experiencia = experiencia;
        this.vida = true;
        this.danoMinimo = 10;
        this.experienciaMaxima = 1000;
    }

    public String getNome() {
        return nome;
    }
    public int getSaude() {
        return saude;
    }
    public int getExperiencia() {
        return experiencia;
    }
    public boolean getVida() {
        return vida;
    }

    public void sofrerDano(int pontosDeDano) {
        //Função para garantir que o dano mínimo será 10
        saude -= Math.max(pontosDeDano - experiencia / 100, danoMinimo);
        if (saude <= 0){
            saude = 0;
            vida = false;
        }
    }

    public void recuperarSaude(int pontosDeSaude) {
        if (getVida() == true) {
            saude += pontosDeSaude;
        }
    }

    public void ganharExperiencia(int pontosDeExperiencia) {
        experiencia += pontosDeExperiencia;
        if (experiencia > experienciaMaxima){
            experiencia = 1000;
        }
    }

    public static void main(String[] args) {
        Personagem personagem1 = new Personagem("Scorpion", 100, 500);
        Personagem personagem2 = new Personagem("Sub Zero", 100, 500);

        System.out.println("Começa a partida: \nPersonagem1:\nNome: " + personagem1.getNome() + " - Saúde: " + personagem1.getSaude() + " - Experiência: " + personagem1.getExperiencia() + " - Vida: " + personagem1.getVida());
        System.out.println("Personagem2:\nNome: " + personagem2.getNome() + " - Saúde: " + personagem2.getSaude() + " - Experiência: " + personagem2.getExperiencia() + " - Vida: " + personagem2.getVida());
        
        int i = 1;
        while (personagem1.getVida() == true && personagem2.getVida() == true){
            System.out.println("\nRodada " + i);
            
            personagem2.sofrerDano(60);
            System.out.println("\n* " + personagem1.getNome() +" causa 60 de dano no " + personagem2.getNome());
            personagem1.sofrerDano(40);
            System.out.println("* " + personagem2.getNome() +" causa 40 de dano no " + personagem1.getNome());
            System.out.println("Personagem1:\nNome: " + personagem1.getNome() + " - Saúde: " + personagem1.getSaude() + " - Experiência: " + personagem1.getExperiencia() + " - Vida: " + personagem1.getVida());
            System.out.println("Personagem2:\nNome: " + personagem2.getNome() + " - Saúde: " + personagem2.getSaude() + " - Experiência: " + personagem2.getExperiencia() + " - Vida: " + personagem2.getVida());

            personagem1.recuperarSaude(10);
            personagem1.ganharExperiencia(200);
            System.out.println("\n* " + personagem1.getNome() +" recupera 10 de saúde e ganha 200 de experiência");
            personagem2.recuperarSaude(20);
            personagem2.ganharExperiencia(100);
            System.out.println("* " + personagem2.getNome() +" recupera 20 de saúde e ganha 100 de experiência");       
            System.out.println("Personagem1:\nNome: " + personagem1.getNome() + " - Saúde: " + personagem1.getSaude() + " - Experiência: " + personagem1.getExperiencia() + " - Vida: " + personagem1.getVida());
            System.out.println("Personagem2:\nNome: " + personagem2.getNome() + " - Saúde: " + personagem2.getSaude() + " - Experiência: " + personagem2.getExperiencia() + " - Vida: " + personagem2.getVida());
            
            i++;
        }
        if (personagem1.getVida() == true && personagem2.getVida() == false){
            System.out.println("\n" + personagem1.getNome() + " ganhou!!");
        }else if (personagem2.getVida() == true && personagem1.getVida() == false){
            System.out.println("\n" + personagem2.getNome() + " ganhou!!");
        }else{
            System.out.println("Empatou!!");
        }
    }
}
        
