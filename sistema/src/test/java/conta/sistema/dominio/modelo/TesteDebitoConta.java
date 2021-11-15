package conta.sistema.dominio.modelo;

import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

@DisplayName("Regra de débito de conta")
class TesteDebitoConta {

    private final BigDecimal cem = new BigDecimal(100);
    private Conta contaValida;

    @BeforeEach
    void preparar() {
        contaValida = new Conta(1, cem, "Rebeca");
    }

    @Test
    @DisplayName("valor debito nulo como obrigatório")
    void teste1() {
        Assertions.assertThrows(NegocioException.class, () -> contaValida.debitar(null), "Valor débito é obrigatório.");
    }

    @Test
    @DisplayName("valor debito menor ou igual a 0")
    void teste2() {
        Assertions.assertThrows(NegocioException.class, () -> contaValida.debitar(BigDecimal.ZERO), "Valor débito é obrigatório.");
    }

    @Test
    @DisplayName("valor debito debitado com sucesso")
    void teste3() {
        contaValida.debitar(BigDecimal.TEN);
        assertEquals(new BigDecimal(90), contaValida.getSaldo());
    }
}