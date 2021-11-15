package conta.sistema.dominio.modelo;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

import java.math.BigDecimal;

@DisplayName("Regra de débito de conta")
class TesteDebitoConta {

    private BigDecimal cem = new BigDecimal(100);
    private Conta contaValida;

    @BeforeEach
    void preparar() {
        contaValida = new Conta(1, cem, "Rebeca");
    }

    @Test
    void execute() {
        String x = "";
    }
}