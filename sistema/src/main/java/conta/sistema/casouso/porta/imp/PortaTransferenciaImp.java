package conta.sistema.casouso.porta.imp;

import conta.sistema.casouso.porta.PortaTransferencia;
import conta.sistema.dominio.modelo.Conta;
import static conta.sistema.dominio.modelo.Erro.inexistente;
import static conta.sistema.dominio.modelo.Erro.mesmaConta;
import static conta.sistema.dominio.modelo.Erro.obrigatorio;
import conta.sistema.dominio.servico.Transferencia;
import conta.sistema.porta.ContaRepositorio;
import static java.util.Objects.isNull;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import javax.inject.Named;
import java.math.BigDecimal;

@Named
public class PortaTransferenciaImp implements PortaTransferencia {

    private final ContaRepositorio repositorio;
    private final Transferencia transferencia;

    @Inject
    public PortaTransferenciaImp(final ContaRepositorio repositorio, final Transferencia transferencia) {
        this.repositorio = repositorio;
        this.transferencia = transferencia;
    }

    @Override
    public Conta getConta(Integer numero) {
        return this.repositorio.get(numero);
    }

    @Override
    @Transactional
    public void transferir(Integer contaDebito, Integer contaCredito, BigDecimal valorTransferencia) {
        if (isNull(contaDebito)) {
            obrigatorio("Conta débito");
        }

        if (isNull(contaCredito)) {
            obrigatorio("Conta crédito");
        }

        if (isNull(valorTransferencia)) {
            obrigatorio("Valor transferência");
        }

        final Conta ctDebito = this.repositorio.get(contaDebito);
        if (isNull(ctDebito)) {
            inexistente("Conta débito");
        }

        final Conta ctCredito = this.repositorio.get(contaCredito);
        if (isNull(ctCredito)) {
            inexistente("Conta crédito");
        }

        if (ctCredito.equals(ctDebito)) {
            mesmaConta();
        }

        this.transferencia.transferir(valorTransferencia, ctDebito, ctCredito);
        repositorio.alterar(ctDebito);
        repositorio.alterar(ctCredito);
    }
}
