import static org.junit.jupiter.api.Assertions.*;

class EstudanteTest {

    @org.junit.jupiter.api.Test
    void testNome() {
        Estudante e = new Estudante("Antonio", 12345);

        // O nome deve ser igual ao atribuído na instanciação
        String nome = e.getNome();
        assertEquals("Antonio", nome);

        // O nome pode ser redefinido
        e.setNome("Maria");
        assertEquals("Maria", e.getNome());
    }

    @org.junit.jupiter.api.Test
    void testMatricula() {
        Estudante e = new Estudante("Antonio", 12345);

        // A matrícula deve ser igual à atribuído na instanciação
        int matricula = e.getMatricula();
        assertEquals(12345, matricula);

        // A matrícula pode ser redefinida
        e.setMatricula(12346);
        assertEquals(12346, e.getMatricula());
    }
}