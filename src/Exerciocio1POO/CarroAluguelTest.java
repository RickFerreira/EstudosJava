import static org.junit.jupiter.api.Assertions.*;

public class CarroAluguelTest {

    @org.junit.jupiter.api.Test
    void testeCriacao() {
        CarroAluguel carro = new CarroAluguel(59.9f);

        assertEquals(59.9f, carro.getValorPorKm());

        carro.setValorPorKm(69.9f);

        assertEquals(69.9f, carro.getValorPorKm());
        assertEquals(0, carro.getDistanciaPercorrida());
        assertTrue(carro.isDisponivel());
        assertFalse(carro.hasSinistro());
    }

    @org.junit.jupiter.api.Test
    void testeAluguel() {
        CarroAluguel carro = new CarroAluguel(59.9f);

        assertDoesNotThrow(carro::alugar);

        Exception exception = assertThrows(CarroIndisponivelException.class, carro::alugar);

        String expectedMessage = "O carro está indisponível.";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @org.junit.jupiter.api.Test
    void testeDevolucao() {
        CarroAluguel carro = new CarroAluguel(59.9f);

        // Um carro disponível não pode ser devolvido
        Exception exception = assertThrows(CarroDisponivelException.class, carro::devolver);

        String expectedMessage = "O carro está disponível.";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));

        // Um carro alugado, com sinistro, mas sem distância percorrida, pode ser devolvido normalmente e
        // sem sinistro
        assertDoesNotThrow(carro::alugar);
        carro.setSinistro(true);
        assertDoesNotThrow(carro::devolver);
        assertFalse(carro.hasSinistro());

        // Um carro alugado e com distância percorrida lançará exceção ao ser devolvido sem ser pago
        assertDoesNotThrow(carro::alugar);
        assertDoesNotThrow(() -> carro.setDistanciaPercorrida(10));

        Exception exception2 = assertThrows(CarroNaoPagoException.class, carro::devolver);

        String expectedMessage2 = "O carro não foi pago.";
        String actualMessage2 = exception2.getMessage();

        assertTrue(actualMessage2.contains(expectedMessage2));

        // O valor do débito é valorPorKm * distanciaPercorrida
        assertEquals(599f, carro.getDebito());
        carro.setSinistro(true);
        // Se houver sinistro, o valor do débito é valorPorKm * distanciaPercorrida + 60%
        assertEquals(958.4f, carro.getDebito());

        assertDoesNotThrow(carro::pagar);

        assertDoesNotThrow(carro::devolver);
        assertEquals(0, carro.getDistanciaPercorrida());
        assertEquals(0, carro.getDebito());
        assertTrue(carro.isDisponivel());
        assertFalse(carro.hasSinistro());
    }

    @org.junit.jupiter.api.Test
    void testePagar() {
        CarroAluguel carro = new CarroAluguel(35.95f);

        assertDoesNotThrow(carro::alugar);

        assertDoesNotThrow(() -> carro.setDistanciaPercorrida(110));

        // O valor do débito é valorPorKm * distanciaPercorrida
        assertEquals(3954.5f, carro.getDebito());
        carro.setSinistro(true);
        // Se houver sinistro, o valor do débito é valorPorKm * distanciaPercorrida + 60%
        assertEquals(6327.2f, carro.getDebito());

        assertFalse(carro.isDisponivel());
        assertDoesNotThrow(carro::pagar);
        assertDoesNotThrow(carro::devolver);
        assertEquals(0, carro.getDistanciaPercorrida());
        assertEquals(0, carro.getDebito());
        assertTrue(carro.isDisponivel());
        assertFalse(carro.hasSinistro());
    }

    @org.junit.jupiter.api.Test
    void testeSetDistancia() {
        CarroAluguel carro = new CarroAluguel(35.95f);

        carro.setDistanciaPercorrida(110);
        assertEquals(3954.5, carro.getDebito());
    }
}
