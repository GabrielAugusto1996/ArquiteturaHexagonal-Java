package conta.sistema.dominio.modelo;

import java.math.BigDecimal;

import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

@DisplayName("Regra de crédito de conta")
class TesteCreditoConta {

    private final BigDecimal cem = new BigDecimal(100);
    private Conta contaValida;

    @BeforeEach
    void preparar() {
        contaValida = new Conta(1, cem, "Rebeca");
    }

    @Test
    @DisplayName("valor credito nulo como obrigatório")
    void teste1() {
        Assertions.assertThrows(NegocioException.class, () -> contaValida.creditar(null), "Valor crédito é obrigatório.");
    }

    @Test
    @DisplayName("valor credito menor ou igual a 0")
    void teste2() {
        Assertions.assertThrows(NegocioException.class, () -> contaValida.creditar(BigDecimal.ZERO), "Valor crédito é obrigatório.");
    }

    @Test
    @DisplayName("valor credito creditado com sucesso")
    void teste3() {
        contaValida.creditar(BigDecimal.TEN);
        assertEquals(new BigDecimal(110), contaValida.getSaldo());
    }
}