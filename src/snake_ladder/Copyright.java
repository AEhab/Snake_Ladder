
package snake_ladder;

import java.io.File;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

/**
 *
 * @author Osama Hesham
 */
public class Copyright {

    Scene scene;
    Button back;
    Pane inst;
    File file;
    Image BG;
    ImageView Back;
    Label x1, x2, x3, x4, x5, x6;
    Text x7;

    public Copyright() {
        back = new Button();
        back.setText("Back");

        inst = new Pane();

        BG = new Image(getClass().getResource("ladder-and-snakes/sal.jpg").toExternalForm());
        Back = new ImageView(BG);
        Back.fitHeightProperty().bind(inst.heightProperty());
        Back.fitWidthProperty().bind(inst.widthProperty());
        back.setLayoutX(415);
        back.setLayoutY(250);
        back.setMinSize(60, 40);
        back.setStyle("-fx-font:Bold 20 system;");
        Back.setOpacity(.5);

        x1 = new Label("** The game of Snakes and 'Ladders originated in India as a game based on\n    morality called Vaikuntapaali or Paramapada Sopanam. ");
        x2 = new Label("** The game made its way to Britain in the late 1800s as people travelled\n    around the British Empire at the time.");
        x3 = new Label("** It seems that the original Indian version of the game dates back as far\n    as the l6th century. ");
        x4 = new Label("** The ladders represented virtues such as generosity, faith, humility etc.,");
        x5 = new Label("** The snakes represented vices such as anger, murder, theft etc. ");
        x6 = new Label("** Snakes and Ladders has been enjoyed by children for many, many years.\n   We hope that this version, based on an original game dating from the 1920s\n   will bring hours of fun as it is played today.");

        x1.setFont(new Font("system", 14));
        x1.setTextAlignment(TextAlignment.LEFT);
        x2.setFont(new Font("system", 14));
        x2.setTextAlignment(TextAlignment.LEFT);
        x3.setFont(new Font("system", 14));
        x3.setTextAlignment(TextAlignment.LEFT);
        x4.setFont(new Font("system", 14));
        x4.setTextAlignment(TextAlignment.LEFT);
        x5.setFont(new Font("system", 14));
        x5.setTextAlignment(TextAlignment.LEFT);
        x6.setFont(new Font("system", 14));
        x6.setTextAlignment(TextAlignment.LEFT);

        x1.setLayoutX(20);
        x1.setLayoutY(5);
        x2.setLayoutX(20);
        x2.setLayoutY(50);
        x3.setLayoutX(20);
        x3.setLayoutY(95);
        x4.setLayoutX(20);
        x4.setLayoutY(135);
        x5.setLayoutX(20);
        x5.setLayoutY(165);
        x6.setLayoutX(20);
        x6.setLayoutY(195);

        x1.setWrapText(false);
        x2.setWrapText(false);
        x3.setWrapText(false);
        x4.setWrapText(false);
        x5.setWrapText(false);
        x6.setWrapText(false);

        x7 = new Text("The ladder to Salvation");
        x7.setLayoutX(125);
        x7.setLayoutY(280);
        x7.setFont(Font.font("system", FontWeight.BOLD, FontPosture.REGULAR, 25));
        x7.setStyle("-fx-stroke: red;");
        x7.setTextAlignment(TextAlignment.LEFT);

        inst.getChildren().add(Back);
        inst.getChildren().add(back);
        inst.getChildren().add(x1);
        inst.getChildren().add(x2);
        inst.getChildren().add(x3);
        inst.getChildren().add(x4);
        inst.getChildren().add(x5);
        inst.getChildren().add(x6);
        inst.getChildren().add(x7);

        scene = new Scene(inst, 500, 300);
    }

    public Scene getScene() {

        return scene;
    }

}
