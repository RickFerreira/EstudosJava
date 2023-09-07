import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PontoLinhaTest {

    @Test
    void testPonto() {
        Ponto p = new Ponto(4.5, 6.7);
        assertEquals(4.5, p.getX());
        assertEquals(6.7, p.getY());

        p.setX(3.4);
        p.setY(5.6);

        assertEquals(3.4, p.getX());
        assertEquals(5.6, p.getY());

        p.setXY(7.8, 8.9);

        assertEquals(7.8, p.getX());
        assertEquals(8.9, p.getY());
    }

    @Test
    void testLinha() {
        Ponto p1 = new Ponto(4.5, 6.7);
        Ponto p2 = new Ponto(7.8, 8.9);

        Linha ln = new Linha(p1, p2);

        assertEquals(4.5, ln.getInicio().getX());
        assertEquals(6.7, ln.getInicio().getY());
        assertEquals(7.8, ln.getFim().getX());
        assertEquals(8.9, ln.getFim().getY());

        ln.setInicio(new Ponto(8.9, 1.5));
        ln.setFim(new Ponto(6.4, 9.4));

        assertEquals(8.9, ln.getInicio().getX());
        assertEquals(1.5, ln.getInicio().getY());
        assertEquals(6.4, ln.getFim().getX());
        assertEquals(9.4, ln.getFim().getY());
    }

    @Test
    void testComprimento() {
        Ponto p1 = new Ponto(4.5, 6.7);
        Ponto p2 = new Ponto(7.8, 8.9);

        Linha ln = new Linha(p1, p2);

        assertEquals(3.966, ln.getComprimento(), 0.001);
    }
}
