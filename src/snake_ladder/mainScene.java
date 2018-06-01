package snake_ladder;

/**
 *
 * @author Ahmed Ehab
 */
import java.io.File;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class mainScene {

    Button start, inst, copyright, exit;
    File image, image2;
    Image IM, IM2;
    ImageView MV, MV2;
    Scene scene;
    Pane root;

    public mainScene() {
        start = new Button("Start");
        inst = new Button("Instructions");
        copyright = new Button("Copyright");
        exit = new Button("Exit");
        start.setLayoutX(190);
        start.setLayoutY(160);
        start.setMinSize(130, 30);
        start.setFont(Font.font("system", FontWeight.BOLD, FontPosture.REGULAR, 18));
        inst.setLayoutX(190);
        inst.setLayoutY(220);
        inst.setMinSize(130, 30);
        inst.setFont(Font.font("system", FontWeight.BOLD, FontPosture.REGULAR, 18));
        copyright.setLayoutX(190);
        copyright.setLayoutY(290);
        copyright.setMinSize(130, 30);
        copyright.setFont(Font.font("system", FontWeight.BOLD, FontPosture.REGULAR, 18));
        exit.setLayoutX(190);
        exit.setLayoutY(360);
        exit.setMinSize(130, 30);
        exit.setFont(Font.font("system", FontWeight.BOLD, FontPosture.REGULAR, 18));
        IM = new Image(getClass().getResource("ladder-and-snakes/main.jpg").toExternalForm());
        MV = new ImageView(IM);
        IM2 = new Image(getClass().getResource("ladder-and-snakes/logo.png").toExternalForm());
        MV2 = new ImageView(IM2);
        root = new Pane();
        MV.setFitHeight(615);
        MV.setFitWidth(615);
        MV2.setFitHeight(120);
        MV2.setFitWidth(250);
        MV2.setLayoutX(130);
        MV2.setLayoutY(30);
        root.getChildren().add(MV);
        root.getChildren().add(MV2);
        root.getChildren().add(start);
        root.getChildren().add(inst);
        root.getChildren().add(copyright);
        root.getChildren().add(exit);
        scene = new Scene(root, 500, 400);
    }

    public Scene getScene() {
        return scene;
    }

}
