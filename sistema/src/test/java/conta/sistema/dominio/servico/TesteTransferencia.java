package conta.sistema.dominio.servico;

import conta.sistema.dominio.modelo.Conta;
import conta.sistema.dominio.modelo.NegocioException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

@DisplayName("Regra de transferência")
class TesteTransferencia {

    @Test
    @DisplayName("Valor transferencia deverá ser obrigatório")
    void teste1() {
        Assertions.assertThrows(NegocioException.class, () -> {
            new Transferencia().transferir(null, null, null);
        }, "Valor da transferência é obrigatório.");
    }

    @Test
    @DisplayName("Conta débito deverá ser obrigatório")
    void teste2() {
        Assertions.assertThrows(NegocioException.class, () -> {
            new Transferencia().transferir(BigDecimal.TEN, null, null);
        }, "Conta débito é obrigatório.");
    }

    @Test
    @DisplayName("Conta crédito deverá ser obrigatório")
    void teste3() {
        Assertions.assertThrows(NegocioException.class, () -> {
            new Transferencia().transferir(BigDecimal.TEN, new Conta(), null);
        }, "Conta crédito é obrigatório.");
    }

    @Test
    @DisplayName("Transferencia realizada com sucesso")
    void teste4() {
        final BigDecimal valorTransferencia = BigDecimal.TEN;
        final Conta contaDebito = new Conta(350, new BigDecimal(100), "João");
        final Conta contaCredito = new Conta(300, new BigDecimal(50), "Maria");

        new Transferencia().transferir(valorTransferencia, contaDebito, contaCredito);

        Assertions.assertEquals(new BigDecimal(90), contaDebito.getSaldo());
        Assertions.assertEquals(new BigDecimal(60), contaCredito.getSaldo());
    }
}