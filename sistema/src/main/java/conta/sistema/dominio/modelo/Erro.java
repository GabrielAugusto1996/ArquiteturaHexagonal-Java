package conta.sistema.dominio.modelo;

public class Erro {

    private Erro(){}

    public static void obrigatorio(String nome) {
        throw new NegocioException(nome + " é obrigatório.");
    }

    public static void inexistente(String nome) {
        throw new NegocioException(nome + " é inexistente.");
    }

    public static void saldoInsuficiente() {
        throw new NegocioException("O saldo é insuficiente.");
    }

    public static void mesmaConta() {
        throw new NegocioException("Conta Debito e Crédito devem ser diferentes.");
    }
}
