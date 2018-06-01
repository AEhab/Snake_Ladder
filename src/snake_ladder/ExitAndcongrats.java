
package snake_ladder;

import java.io.File;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

/**
 *
 * @author Osama Hesham
 */
public class ExitAndcongrats {

    Scene scene;
    Button exit;
    Button back;
    File file,file2;
    Pane inst;
    Image BG,BG2;
    ImageView Back,Back2;
    Label x1;

      public ExitAndcongrats(boolean ex, boolean won, boolean loose) {
           this(ex, won, loose,"");
      }
    public ExitAndcongrats(boolean ex, boolean won, boolean loose,String str) {

        if (ex == true && won == false && loose == false) {
            exit = new Button();
            exit.setText("Exit");
            back = new Button();
            back.setText("Back");

            inst = new Pane();
                   
            BG =  new Image(getClass().getResource("ladder-and-snakes/oo.jpg").toExternalForm());
            Back = new ImageView(BG);
            Back.fitHeightProperty().bind(inst.heightProperty());
            Back.fitWidthProperty().bind(inst.widthProperty());
            exit.setLayoutX(20);
            exit.setLayoutY(100);
            back.setLayoutX(345);
            back.setLayoutY(100);
            exit.setMinSize(52, 26);
            back.setMinSize(52, 26);

            inst.getChildren().add(Back);
            inst.getChildren().add(exit);
            inst.getChildren().add(back);

            scene = new Scene(inst, 400, 160);
        }

        if (ex == false && won == true && loose == false) {
            exit = new Button();
            exit.setText("Exit");
            back = new Button();
            back.setText("Play Again");
            x1 = new Label();
            x1.setText(str+" Won ^_^");
            x1.setLayoutX(150);
            x1.setLayoutY(10);
            x1.setStyle("-fx-font:Bold 20 system; ");
            x1.setTextFill(Color.web("white"));
            inst = new Pane();
           
            BG = new Image(getClass().getResource("ladder-and-snakes/onn.gif").toExternalForm());
            Back = new ImageView(BG);
            Back.setFitHeight(200);
            Back.setFitWidth(450);
            exit.setLayoutX(209);
            exit.setLayoutY(135);
            back.setLayoutX(286);
            back.setLayoutY(135);
            exit.setMinSize(52, 26);
            back.setMinSize(52, 26);

            inst.getChildren().add(Back);
            inst.getChildren().add(exit);
            inst.getChildren().add(back);
            inst.getChildren().add(x1);
            scene = new Scene(inst, 400, 160);
        }
        if (ex == false && won == false && loose == true) {
            exit = new Button();
            exit.setText("Exit");
            back = new Button();
            back.setText("Play Again");

            inst = new Pane();
           
            BG = new Image(getClass().getResource("ladder-and-snakes/hardluck.jpg").toExternalForm());
            Back = new ImageView(BG);
            Back.setFitHeight(180);
            Back.setFitWidth(210);
            
            BG2 = new Image(getClass().getResource("ladder-and-snakes/hardluck2.jpg").toExternalForm());
            Back2 = new ImageView(BG2);
            Back2.setFitHeight(170);
            Back2.setFitWidth(200);
            Back2.setLayoutX(210);
            exit.setLayoutX(209);
            exit.setLayoutY(135);
            back.setLayoutX(286);
            back.setLayoutY(135);
            exit.setMinSize(52, 26);
            back.setMinSize(52, 26);

            inst.getChildren().add(Back);
            inst.getChildren().add(Back2);
            inst.getChildren().add(exit);
            inst.getChildren().add(back);
            
            scene = new Scene(inst, 400, 160);
        }
    }

    public Scene getScene() {

        return scene;
    }
}
