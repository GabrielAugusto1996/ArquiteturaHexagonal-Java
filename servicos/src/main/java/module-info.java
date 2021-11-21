module conta.servicos {

    //usa conta.sistema
    requires conta.sistema;

    //usa spring
    requires javax.inject;
    requires spring.tx;
    requires spring.core;
    requires spring.beans;
    requires spring.context;
    requires java.sql;
    requires spring.jdbc;

    opens conta.servico.repositorio;
}