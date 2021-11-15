package conta.sistema.dominio.servico;

import conta.sistema.dominio.modelo.Conta;
import static conta.sistema.dominio.modelo.Erro.obrigatorio;
import static java.util.Objects.isNull;

import javax.inject.Named;
import java.math.BigDecimal;

@Named
public class Transferencia {

    public void transferir(BigDecimal valorTransferencia, Conta contaDebito, Conta contaCredito) {
        validarParametros(valorTransferencia, contaDebito, contaCredito);
        contaDebito.debitar(valorTransferencia);
        contaCredito.creditar(valorTransferencia);
    }

    private void validarParametros(BigDecimal valorTransferencia, Conta contaDebito, Conta contaCredito) {
        if (isNull(valorTransferencia)) {
            obrigatorio("Valor da transferência");
        }
        if (isNull(contaDebito)) {
            obrigatorio("Conta débito");
        }
        if (isNull(contaCredito)) {
            obrigatorio("Conta crédito");
        }
    }
}
