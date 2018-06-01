package snake_ladder;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;


/**
 *
 * @author Ahmed Ehab - Loay Akram
 */
public class Snake_Ladder extends Application {
     
      Stage Secondry, third, fourth;
    int num;
    ExitAndcongrats exit;

    @Override

    public void start(Stage primaryStage) {

        mainScene Main = new mainScene();   //main scene
        ChoosePlayers Choose = new ChoosePlayers(); //choose players
        Copyright copyright = new Copyright(); //copyright window
        Inst inst = new Inst(); // Instructions Window
        Playgrounds playground = new Playgrounds(); //choose play ground
        Secondry = new Stage();
        third = new Stage();
        fourth = new Stage();
        primaryStage.setTitle("Snake and Ladder");
        primaryStage.setScene(Main.getScene());
        primaryStage.setResizable(false);
        primaryStage.show();

        Main.start.setOnAction((ActionEvent e) -> {
            primaryStage.hide();
            Secondry.setTitle("Choose A Player");
            Choose.player1.setText(null);
            Choose.player2.setText(null);
            Choose.player2.setDisable(true);
            Choose.player2.setOpacity(0.0);
            Choose.L2.setDisable(true);
            Choose.L2.setOpacity(0.0);
            Choose.b2.setDisable(true);
            Choose.r2.setDisable(true);
            Choose.nxt.setDisable(true);
            Choose.single.setSelected(true);
            Secondry.setScene(Choose.getScene());
            Secondry.setResizable(false);
            Secondry.show();
        });
        
        
        Main.inst.setOnAction((ActionEvent e) -> {
            primaryStage.hide();
            Secondry.setTitle("Instructions");
            Secondry.setScene(inst.getScene());
            Secondry.setResizable(false);
            Secondry.show();
        });
        Main.copyright.setOnAction((ActionEvent e) -> {
            primaryStage.hide();
            Secondry.setTitle("Copy Rights");
            Secondry.setScene(copyright.getScene());
            Secondry.setResizable(false);
            Secondry.show();
        });
        Main.exit.setOnAction((ActionEvent e) -> {
            Secondry.setTitle("      Do You Want To Exit?");
            Secondry.setAlwaysOnTop(true);
            exit = new ExitAndcongrats(true,false,false); // exit window
            exit.exit.setOnAction((ActionEvent event) -> {
                Secondry.close();
                primaryStage.close();
            });
            exit.back.setOnAction((ActionEvent event) -> {
                primaryStage.show();
                Secondry.close();
            });
            Secondry.setScene(exit.getScene());
            Secondry.setResizable(false);
            Secondry.show();
        });
        Choose.back.setOnAction((ActionEvent e) -> {
            Choose.r1.setSelected(false);
            Choose.b1.setSelected(false);
            Choose.r2.setSelected(false);
            Choose.b2.setSelected(false);
            //Choose.r1.setDisable(true);
            Choose.multi.setSelected(false);
            primaryStage.show();
            Secondry.close();
        });
        Choose.nxt.setOnAction((ActionEvent e) -> {
            if(Choose.Check_nxt()){
                Choose.Warning();
            }
            else if(!Choose.CheckRadio()){
                Choose.WarningRadio();
            }
            else if(Choose.CheckText(Choose.player1.getText()) || (Choose.multi.isSelected() && Choose.CheckText(Choose.player2.getText()))){
                Choose.WarningText();
            }
            else{
            Secondry.hide();
            third.setTitle("Choose PlayGround");
            third.setScene(playground.getScene());
            third.setResizable(false);
            third.show();
            }
        });
        copyright.back.setOnAction((ActionEvent e) -> {
            primaryStage.show();
            Secondry.close();
        });

        inst.back.setOnAction((ActionEvent e) -> {
            primaryStage.show();
            Secondry.close();
        });
        playground.back.setOnAction((ActionEvent e) -> {
            Secondry.show();
            third.close();
        });
        playground.Back.setOnMouseClicked((MouseEvent e) -> {
            String[] players = new String[2];
            if (Choose.player1.getText() == null && Choose.player2.getText() == null) {
                num = 0;
           } else if (Choose.player1.getText() != null && Choose.player2.getText() == null) {
                num = 1;
               players[0] = Choose.player1.getText();
            } else {
                num = 2;
                players[1] = Choose.player2.getText();
            }
            GameBoard gameboard;
                gameboard = new GameBoard(num,players, 2,Choose.getplayer1coin(),primaryStage,fourth);
                third.close();
                fourth.setTitle("Let's Play The Game");
                fourth.setScene(gameboard.getScene());
                fourth.setResizable(false);
                fourth.show();
                gameboard.Menu.setOnAction((ActionEvent e2) -> {
                        fourth.close();
                         primaryStage.show();
                });                                  
        });
        playground.Back1.setOnMouseClicked((MouseEvent e) -> {
           String[] players = new String[2]; 
            if (Choose.player1.getText() == null && Choose.player2.getText() == null) {
                num = 0;
            } else if (Choose.player1.getText() != null && Choose.player2.getText() == null) {
                num = 1;
                players[0] = Choose.player1.getText();
            } else {
                num = 2;
                players[1] = (Choose.player2.getText());
            }
            GameBoard gameboard;
           
            gameboard = new GameBoard(num, players, 1,Choose.getplayer1coin(),primaryStage,fourth);
            third.close();
            fourth.setTitle("Let's Play The Game");
            fourth.setScene(gameboard.getScene());
            fourth.setResizable(false);
            fourth.show();
            gameboard.Menu.setOnAction((ActionEvent e2) -> {
                        fourth.close();
                         primaryStage.show();
                });     
        });
        
    }
    public static void main(String[] args) {
        launch(args);
    }
    
}
