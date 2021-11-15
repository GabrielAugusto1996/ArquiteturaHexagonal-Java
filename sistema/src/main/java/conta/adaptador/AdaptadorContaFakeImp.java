package conta.adaptador;

import conta.sistema.dominio.modelo.Conta;
import conta.sistema.dominio.modelo.NegocioException;
import conta.sistema.porta.ContaRepositorio;
import static java.util.Objects.isNull;

import javax.inject.Named;
import java.util.HashMap;
import java.util.Map;

@Named
public class AdaptadorContaFakeImp implements ContaRepositorio {

    private Map<Integer, Conta> banco = new HashMap<>();

    @Override
    public Conta get(Integer numero) {
        System.out.println("Fake Banco de Dados -> Conta get(Integer numero)");
        return banco.get(numero);
    }

    @Override
    public void alterar(Conta conta) {
        System.out.println("Fake Banco de Dados -> void alterar(Conta conta)");
        var ct = banco.get(conta.getNumero());

        if (!isNull(ct)) {
            banco.put(conta.getNumero(), conta);
        } else {
            throw new NegocioException("Conta inexistente: " + conta.getNumero());
        }
    }
}
