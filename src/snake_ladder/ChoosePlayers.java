
package snake_ladder;

import java.io.File;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

/**
 *
 * @author Ahmed Ehab
 */
public class ChoosePlayers {

    Scene choose;
    Button back, nxt;
    TextField player1, player2;
    ToggleGroup group, group2, group3;
    RadioButton single, multi, r1, b1, r2, b2;
    Label L1, L2;
    Text wr;
    Pane root2;
    File background;
    Image IM;
    boolean temp;
    ImageView IV;

    public ChoosePlayers() {
        
        IM = new Image(getClass().getResource("ladder-and-snakes/Snakes-and-Ladders-Logo.png").toExternalForm());
        IV = new ImageView(IM);
        IV.setLayoutX(-75);
        IV.setLayoutY(-34);
        IV.setOpacity(0.8);
        IV.setFitHeight(460);
        IV.setFitWidth(700);

        wr = new Text("");
        wr.setFont(Font.font("system", FontWeight.EXTRA_BOLD, FontPosture.REGULAR, 18));
        wr.setFill(Color.WHITE);
        wr.setStyle("-fx-stroke: red;");
        wr.setLayoutX(2);
        wr.setLayoutY(390);
        wr.setVisible(false);

        group = new ToggleGroup();
        group2 = new ToggleGroup();
        group3 = new ToggleGroup();

        r1 = new RadioButton();
        b1 = new RadioButton();
        r2 = new RadioButton();
        b2 = new RadioButton();

        r1.setToggleGroup(group2);
        b1.setToggleGroup(group2);
        r1.setLayoutX(60);
        r1.setLayoutY(200);
        b1.setLayoutX(60);
        b1.setLayoutY(270);
        r1.setDisable(true);
        b1.setDisable(true);

        r2.setToggleGroup(group3);
        b2.setToggleGroup(group3);
        r2.setLayoutX(300);
        r2.setLayoutY(200);
        b2.setLayoutX(300);
        b2.setLayoutY(270);
        r2.setDisable(true);
        b2.setDisable(true);

        Label red = new Label("Red");
        Label blue = new Label("Blue");
        Label red2 = new Label("Red");
        Label blue2 = new Label("Blue");
        red.setLayoutX(100);
        red.setLayoutY(260);
        red.setFont(Font.font("system", FontWeight.BOLD, FontPosture.REGULAR, 24));
        red.setTextFill(Color.WHITE);
        blue.setLayoutX(100);
        blue.setLayoutY(190);
        blue.setFont(Font.font("system", FontWeight.BOLD, FontPosture.REGULAR, 24));
        blue.setTextFill(Color.WHITE);
        red2.setLayoutX(340);
        red2.setLayoutY(260);
        red2.setFont(Font.font("system", FontWeight.BOLD, FontPosture.REGULAR, 24));
        red2.setTextFill(Color.WHITE);
        blue2.setLayoutX(340);
        blue2.setLayoutY(190);
        blue2.setFont(Font.font("system", FontWeight.BOLD, FontPosture.REGULAR, 24));
        blue2.setTextFill(Color.WHITE);

        back = new Button("Back");
        back.setLayoutX(40);
        back.setLayoutY(320);
        back.setMinSize(130, 30);
        back.setFont(Font.font("system", FontWeight.BOLD, FontPosture.REGULAR, 18));

        nxt = new Button("Next");
        nxt.setLayoutX(350);
        nxt.setLayoutY(320);
        nxt.setMinSize(130, 30);
        nxt.setFont(Font.font("system", FontWeight.BOLD, FontPosture.REGULAR, 18));
        nxt.setDisable(true);

        player1 = new TextField();
        player1.setLayoutX(40);
        player1.setLayoutY(130);
        player1.setOnKeyTyped((KeyEvent event) -> {
            nxt.setDisable(false);
            r1.setDisable(false);
            b1.setDisable(false);
        });

        player2 = new TextField();
        player2.setLayoutX(280);
        player2.setLayoutY(130);
        player2.setDisable(true);
        player2.setOpacity(0.0);

        player2.setOnKeyTyped((KeyEvent event) -> {
            nxt.setDisable(false);
            r2.setDisable(false);
            b2.setDisable(false);
        });

        L1 = new Label("Player1 Name");
        L1.setLayoutX(40);
        L1.setLayoutY(100);
        L1.setFont(Font.font("system", FontWeight.BOLD, FontPosture.REGULAR, 18));
        L1.setTextFill(Color.web("white"));
        L1.setStyle("-fx-Stroke : black;");

        L2 = new Label("Player2 Name");
        L2.setLayoutX(280);
        L2.setLayoutY(100);
        L2.setDisable(true);
        L2.setOpacity(0.0);
        L2.setFont(Font.font("system", FontWeight.BOLD, FontPosture.REGULAR, 18));
        L2.setTextFill(Color.web("white"));
        L1.setStyle("-fx-Stroke : black;");

        single = new RadioButton("Single Player");
        single.setToggleGroup(group);
        single.setSelected(true);
        single.setLayoutX(40);
        single.setLayoutY(50);
        single.setFont(Font.font("system", FontWeight.BOLD, FontPosture.REGULAR, 18));
        single.setTextFill(Color.web("white"));

        multi = new RadioButton("MuiltiPlayer");
        multi.setToggleGroup(group);
        multi.setLayoutX(280);
        multi.setLayoutY(50);
        multi.setFont(Font.font("system", FontWeight.BOLD, FontPosture.REGULAR, 18));
        multi.setTextFill(Color.web("white"));

        back.setOnAction(e -> {

        });
        single.setOnAction((ActionEvent event) -> {
            L2.setDisable(true);
            player2.setDisable(true);
            player2.setOpacity(0.0);
            L2.setOpacity(0.0);
            r2.setDisable(true);
            r2.setSelected(false);
            b2.setDisable(true);
            b2.setSelected(false);
            player2.setText(null);
        });
        multi.setOnAction((ActionEvent event) -> {
            L2.setDisable(false);
            player2.setDisable(false);
            player2.setOpacity(1.0);
            L2.setOpacity(1.0);
        });

        root2 = new Pane();
        root2.getChildren().add(IV);
        root2.getChildren().add(back);
        root2.getChildren().add(L1);
        root2.getChildren().add(L2);
        root2.getChildren().add(player1);
        root2.getChildren().add(player2);
        root2.getChildren().add(single);
        root2.getChildren().add(multi);
        root2.getChildren().add(nxt);
        root2.getChildren().add(red);
        root2.getChildren().add(r1);
        root2.getChildren().add(b1);
        root2.getChildren().add(r2);
        root2.getChildren().add(b2);
        root2.getChildren().add(blue);
        root2.getChildren().add(blue2);
        root2.getChildren().add(red2);
        root2.getChildren().add(wr);
        choose = new Scene(root2, 500, 400);
    }

    public boolean CheckRadio() {
        temp = !multi.isSelected();
        return ((r1.isSelected() || b1.isSelected()) && (temp || (multi.isSelected() && (r2.isSelected() || b2.isSelected()))));
    }

    public boolean Check_nxt() {
        return (r1.isSelected() && r2.isSelected()) || ((b1.isSelected()) && b2.isSelected());
    }

    public void Warning() {
        wr.setText("Warning : You can't choose the same color for both players");
        wr.setVisible(true);
    }

    public void WarningRadio() {
        wr.setText("Warning : You should choose a color for each player");
        wr.setVisible(true);
    }

    public void WarningText() {
        wr.setText("Warning : You can't write symbols in name field");
        wr.setVisible(true);
    }

    public boolean CheckText(String s) {
        Pattern p = Pattern.compile("[^a-zA-Z0-9]");
        return (p.matcher(s).find());
    }

    public Scene getScene() {
        return choose;
    }

    public int getplayer1coin() {
        if (r1.isSelected()) {
            return 0;
        }
        return 1;
    }

    public String getPlayer1() {
        return player1.getText();
    }

    public String getPlayer2() {
        String str;
        if (null == player2.getText()) {
            str = "Computer";
        } else {
            str = player2.getText();
        }
        return str;
    }
}
