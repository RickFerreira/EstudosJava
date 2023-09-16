import java.util.ArrayList;
import java.util.List;

public class Postagem {
    private String texto;
    private String data;
    private String autor;
    private int curtidas;
    private List<String> usuariosQueCurtiram;

    public Postagem(String texto, String data, String autor) {
        this.texto = texto;
        this.data = data;
        this.autor = autor;
        this.curtidas = 0;
        this.usuariosQueCurtiram = new ArrayList<>();
    }

    public String getTexto() {
        return texto;
    }
    public String getData() {
        return data;
    }
    public String getAutor() {
        return autor;
    }
    public int getCurtidas() {
        return curtidas;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
    public void setData(String data) {
        this.data = data;
    }
    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void curtir(String usuario) {
        if (!usuariosQueCurtiram.contains(usuario)) {
            curtidas++;
            usuariosQueCurtiram.add(usuario);
        }
    }
    public void descurtir(String usuario) {
        if (!usuariosQueCurtiram.contains(usuario)) {
            curtidas--;
            usuariosQueCurtiram.add(usuario);
        }
    }
    
    public static void main(String[] args) {
        Postagem postagem = new Postagem("Hello world!!", "15/09/2023", "Richard");

        System.out.println("Curtida inicial = " + postagem.getCurtidas());

        postagem.curtir("Usuario1");
        System.out.println("\nCurtidas após Usuario1 curtir = " + postagem.getCurtidas());
        postagem.curtir("Usuario1");
        System.out.println("Curtidas após Usuario1 tentar curtir novamente = " + postagem.getCurtidas());

        postagem.curtir("Usuario2");
        System.out.println("\nCurtidas após Usuario2 curtir = " + postagem.getCurtidas());
        postagem.descurtir("Usuario2");
        System.out.println("Curtidas após Usuario2 tentar descurtir dessa vez = " + postagem.getCurtidas());
    
        postagem.descurtir("Usuario3");
        System.out.println("\nCurtidas após Usuario3 descurtir = " + postagem.getCurtidas());
        postagem.descurtir("Usuario3");
        System.out.println("Curtidas após Usuario3 tentar descurtir novamente = " + postagem.getCurtidas());
    }

}
