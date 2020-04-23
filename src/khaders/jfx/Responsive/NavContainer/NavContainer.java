/*
 * license for Khaders team.
 * Khader[] khaders = new Khader[2];
 * khader[0] = new Khader(karaja.1.0.0);
 * khader[1] = new Khader(khudair.3.0.0);
 */
package khaders.jfx.Responsive.NavContainer;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Khaders
 */
public class NavContainer extends Application {
    Router router = new Router();
    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = router.view("container");
        loader.setController(new ContainerController());
        Parent root = loader.load();
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
