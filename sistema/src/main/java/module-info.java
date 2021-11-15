module conta.sistema {

    // usa spring
    requires javax.inject;
    requires spring.tx;

    // expondo porta de entrada (driver)
    exports conta.sistema.casouso.porta;

    // expondo sistema negocio
    exports conta.sistema.dominio.servico;
    exports conta.sistema.dominio.modelo;

    // expondo adaptadores de saídas (driven)
    exports conta.sistema.porta;
    exports conta.adaptador;

    // abre reflexao spring
    opens conta.sistema.casouso.porta;
    opens conta.sistema.dominio.servico;
    opens conta.adaptador;

}