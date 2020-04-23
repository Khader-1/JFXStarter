/*
 * license for Khaders team.
 * Khader[] khaders = new Khader[2];
 * khader[0] = new Khader(karaja.1.0.0);
 * khader[1] = new Khader(khudair.3.0.0);
 */
package khaders.jfx.Responsive.NavContainer;

import khaders.jfx.viewsHandler.CustomTransition;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

/**
 *
 * @author Khaders
 */
public class ContainerController implements Initializable {

    private final double duaration = 1;
    private final boolean startOpened = true;
    private final int maxWidth = 200;

    @FXML
    ScrollPane content;

    @FXML
    JFXHamburger ham;

    @FXML
    ScrollPane menu;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if (startOpened) {
            menu.setPrefWidth(maxWidth);
            menu.setMaxWidth(maxWidth);
            menu.setMinWidth(maxWidth);
            menu.setTranslateX(0);
        } else {
            menu.setPrefWidth(0);
            menu.setMinWidth(0);
            menu.setMaxWidth(0);
            menu.setTranslateX(- 1 * maxWidth);
        }
        HamburgerBackArrowBasicTransition t = new HamburgerBackArrowBasicTransition(ham);
        t.setRate(startOpened ? -1 : 1);
        t.setDelay(Duration.ONE);
        ham.setOnMouseClicked((event) -> {
            t.setRate(t.getRate() * -1);
            t.play();
            CustomTransition transition;
            if (t.getRate() > 0) {
                transition = CustomTransition.getTransition((frac) -> {
                    menu.setTranslateX((0 - frac) * maxWidth);
                    menu.setPrefWidth((1 - frac) * maxWidth);
                    menu.setMinWidth((1 - frac) * maxWidth);
                    menu.setMaxWidth((1 - frac) * maxWidth);

                });
            } else {
                transition = CustomTransition.getTransition((frac) -> {
                    menu.setTranslateX(((frac) - 1) * maxWidth);
                    menu.setPrefWidth((frac) * maxWidth);
                    menu.setMinWidth((frac) * maxWidth);
                    menu.setMaxWidth((frac) * maxWidth);

                });
            }
            transition.setCycleDuration(duaration * 1000);
            transition.play();
        });
    }

}
