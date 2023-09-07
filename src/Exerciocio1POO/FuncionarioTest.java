import static org.junit.jupiter.api.Assertions.assertEquals;

public class FuncionarioTest {
    @org.junit.jupiter.api.Test
    void testNome() {
        Funcionario e = new Funcionario("Antonio", "Dias", 25_000f);

        // O nome deve ser igual ao atribuído na instanciação
        String nome = e.getNome();
        assertEquals("Antonio", nome);

        // O nome pode ser redefinido
        e.setNome("José");
        assertEquals("José", e.getNome());
    }

    @org.junit.jupiter.api.Test
    void testSobrenome() {
        Funcionario e = new Funcionario("Antonio", "Dias", 25_000f);

        // O sobrenome deve ser igual ao atribuído na instanciação
        String sobrenome = e.getSobrenome();
        assertEquals("Dias", sobrenome);

        // O sobrenome pode ser redefinido
        e.setSobrenome("Santos");
        assertEquals("Santos", e.getSobrenome());
    }

    @org.junit.jupiter.api.Test
    void testSalario() {
        Funcionario e = new Funcionario("Antonio", "Dias", 25_000f);

        // O salário deve ser igual ao atribuído na instanciação
        float salario = e.getSalario();
        assertEquals(25_000f, salario);

        // O salário pode ser redefinido
        e.setSalario(23_456f);
        assertEquals(23_456f, e.getSalario());

        assertEquals(281_472, e.getSalarioAnual());
    }

    @org.junit.jupiter.api.Test
    void testAumento() {
        Funcionario e = new Funcionario("Antonio", "Dias", 25_000f);

        e.concederAumento(50);
        assertEquals(37_500f, e.getSalario());
    }
}
