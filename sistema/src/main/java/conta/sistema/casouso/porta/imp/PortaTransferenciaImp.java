package conta.sistema.casouso.porta.imp;

import conta.sistema.casouso.porta.PortaTransferencia;
import conta.sistema.dominio.modelo.Conta;

import java.math.BigDecimal;

public class PortaTransferenciaImp implements PortaTransferencia {

    @Override
    public Conta getConta(Integer numero) {
        return null;
    }

    @Override
    public void transferir(Integer contaDebito, Integer contaCredito, BigDecimal valorTransferencia) {

    }
}
