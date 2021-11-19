package conta.dsv;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({
        "conta.dsv",
        "conta.tela",
        "conta.sistema",
        "conta.adaptador"
})
public class Build2 {
    //Build2: Adaptador JavaFx -> Sistema <- Adaptador Mock
}
