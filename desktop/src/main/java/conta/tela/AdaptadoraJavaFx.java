package conta.tela;

import conta.dsv.Build2;
import javafx.application.Application;
import javafx.stage.Stage;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AdaptadoraJavaFx extends Application {

    private ApplicationContext applicationContext;

    @Override
    public void init() throws Exception {
        System.out.println("Iniciando o spring...");
        this.applicationContext = new AnnotationConfigApplicationContext(Build2.class);
    }

    @Override
    public void start(Stage stage) throws Exception {
        var form = this.applicationContext.getBean(TransferenciaFrm.class);

        form.mostrar(stage);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
