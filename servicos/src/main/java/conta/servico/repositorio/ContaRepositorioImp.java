package conta.servico.repositorio;

import conta.sistema.dominio.modelo.Conta;
import conta.sistema.dominio.modelo.NegocioException;
import conta.sistema.porta.ContaRepositorio;
import static java.util.Objects.isNull;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;

public class ContaRepositorioImp implements ContaRepositorio {

    private static final String ERROR = "Erro inesperado de acesso ao banco de dados.";

    private final JdbcTemplate jdbcTemplate;

    @Inject
    public ContaRepositorioImp(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Conta get(Integer numero) {
        if (isNull(numero)) {
            return null;
        }

        var sql = "SELECT * FROM conta WHERE numero = ?";
        var parameters = new Object[]{numero};

        RowMapper<Conta> orm = (resultSet, nm) ->
                new Conta(resultSet.getInt(1), resultSet.getBigDecimal(2), resultSet.getString(3));

        try {
            var lista = jdbcTemplate.query(sql, parameters, orm);

            return lista.isEmpty() ? null : lista.get(0);
        } catch (Exception exception) {
            throw new NegocioException(ERROR);
        }
    }

    @Override
    @Transactional
    public void alterar(Conta conta) {
        if (isNull(conta)) {
            throw new NegocioException("A conta é obrigatória.");
        }

        var sql = "UPDATE conta SET saldo=?, correntista=? WHERE numero=?";
        var parameters = new Object[]{conta.getSaldo(), conta.getCorrentista(), conta.getNumero()};

        try {
            jdbcTemplate.update(sql, parameters);
        } catch (Exception exception) {
            throw new NegocioException(ERROR);
        }
    }
}
