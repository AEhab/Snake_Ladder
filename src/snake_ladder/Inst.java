package snake_ladder;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

/**
 *
 * @author Osama Hesham
 */
public class Inst {

    Scene scene;
    Button back;
    Pane inst;
    Image BG;
    ImageView Back;
    Label x1, x2, x3, x4, x5, x6, x7, x8;

    public Inst() {
        back = new Button();
        back.setText("Back");
        inst = new Pane();
        
        BG = new Image(getClass().getResource("ladder-and-snakes/inst.jpg").toExternalForm());
        Back = new ImageView(BG);
        Back.fitHeightProperty().bind(inst.heightProperty());
        Back.fitWidthProperty().bind(inst.widthProperty());
        back.setLayoutX(415);
        back.setLayoutY(250);
        back.setMinSize(60, 40);
        back.setStyle("-fx-font:Bold 20 system;");
        Back.setOpacity(.55);

        x1 = new Label("** The objective of the game is to be the first player to reach the finish\n    position.");
        x2 = new Label("** You will travel from base to top, right, then left and so on.");
        x3 = new Label("** The Player moves no. of boxes from the current position as the dice shows.");
        x4 = new Label("** Both players will get chance to roll the dice alternatively.");
        x5 = new Label("** The top of the snake is head and bottom of the snake is tail.");
        x6 = new Label("** If a coin lands at the tip of the snake's head, then the coin slides down\n    to the box at the snake's tail.");
        x7 = new Label("** If a coin lands on a box that is at the base of a ladder, then the coin\n    moves to the box at the top of the ladder and then continues.");
        x8 = new Label("** The first player to box finish is the winner but you must have the correct\n   number on the dice to land on the finish.");

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
        x7.setFont(new Font("system", 14));
        x7.setTextAlignment(TextAlignment.LEFT);
        x8.setFont(new Font("system", 14));
        x8.setTextAlignment(TextAlignment.LEFT);

        x1.setLayoutX(20);
        x1.setLayoutY(1);
        x2.setLayoutX(20);
        x2.setLayoutY(45);
        x3.setLayoutX(20);
        x3.setLayoutY(70);
        x4.setLayoutX(20);
        x4.setLayoutY(95);
        x5.setLayoutX(20);
        x5.setLayoutY(117);
        x6.setLayoutX(20);
        x6.setLayoutY(140);
        x7.setLayoutX(20);
        x7.setLayoutY(180);
        x8.setLayoutX(20);
        x8.setLayoutY(220);

        x1.setWrapText(false);
        x2.setWrapText(false);
        x3.setWrapText(false);
        x4.setWrapText(false);
        x5.setWrapText(false);
        x6.setWrapText(false);
        x7.setWrapText(false);
        x8.setWrapText(false);

        inst.getChildren().add(Back);
        inst.getChildren().add(back);
        inst.getChildren().add(x1);
        inst.getChildren().add(x2);
        inst.getChildren().add(x3);
        inst.getChildren().add(x4);
        inst.getChildren().add(x5);
        inst.getChildren().add(x6);
        inst.getChildren().add(x7);
        inst.getChildren().add(x8);

        scene = new Scene(inst, 500, 300);

    }

    public Scene getScene() {

        return scene;
    }
}
