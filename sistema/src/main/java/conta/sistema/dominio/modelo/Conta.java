package conta.sistema.dominio.modelo;

import static conta.sistema.dominio.modelo.Erro.obrigatorio;
import static conta.sistema.dominio.modelo.Erro.saldoInsuficiente;
import static java.util.Objects.isNull;

import java.math.BigDecimal;

public class Conta {

    private Integer numero;
    private BigDecimal saldo;
    private String correntista;

    public Conta() {
        this.numero = 0;
        this.saldo = BigDecimal.ZERO;
        this.correntista = "não informado";
    }

    public Conta(Integer numero, BigDecimal saldo, String correntista) {
        this.numero = numero;
        this.saldo = saldo;
        this.correntista = correntista;
    }

    public void creditar(BigDecimal valorCredito) throws NegocioException {
        if (isNull(valorCredito) || BigDecimal.ZERO.compareTo(valorCredito) <= 0) {
            obrigatorio("Valor crédito");
        }

        saldo = saldo.add(valorCredito);
    }

    public void debitar(BigDecimal valorDebito) throws NegocioException {
        if (isNull(valorDebito) || BigDecimal.ZERO.compareTo(valorDebito) <= 0) {
            obrigatorio("Valor debito");
        }

        if (valorDebito.compareTo(saldo) > 0) {
            saldoInsuficiente();
        }

        saldo = saldo.subtract(valorDebito);
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public String getCorrentista() {
        return correntista;
    }

    public void setCorrentista(String correntista) {
        this.correntista = correntista;
    }

    @Override
    public String toString() {
        return "Conta{" +
                "numero=" + numero +
                ", saldo=" + saldo +
                ", correntista='" + correntista + '\'' +
                '}';
    }
}
