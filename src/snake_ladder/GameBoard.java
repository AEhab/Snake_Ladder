package snake_ladder;

import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.PathTransition;
import javafx.animation.PauseTransition;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author Ahmed Ehab - Loay Akram - Osama Hesham
 */
public class GameBoard {

    PauseTransition delay = new PauseTransition();
    double x, y;
    boolean WinnerMulti, WinnerSingel;
    Pair[] p;
    Random rand;
    int last_pos[], new_pos[];
    Pane root;
    int n;
    File[] F;
    Map Ladders = new HashMap();
    Map Snakes = new HashMap();
    int num_player;
    int count = -1, player2coin;
    ImageView Background, Board, Blue, SnakeAndLadderImg, Dice, Coin[], CoinTurn[];
    Image[] img;
    ImageView[] Num_Dice;
    Button Menu, Roll;
    Rectangle rect;
    Scene Gameboard;
    Text Player;
    Media sound1;
    Media sound2;
    MediaPlayer Clap;
    MediaPlayer Boo;
    ExitAndcongrats Statues;
    Stage miss, me, primary;
    int timeforplay = 2;

    public GameBoard(int numplayer, String[] players, int boardnum, int player1coin, Stage primarystage, Stage me) {
        primary = primarystage;
        this.me = me;
        if (player1coin == 0) {
            player2coin = 1;
        } else {
            player2coin = 0;
        }
        num_player = numplayer;
   
        sound1 = new Media(getClass().getResource("ladder-and-snakes/Clap.mp3").toExternalForm());
        sound2 = new Media(getClass().getResource("ladder-and-snakes/Boo.mp3").toExternalForm());
        Clap = new MediaPlayer(sound1);
        Boo = new MediaPlayer(sound2);
        p = new Pair[101];
        rand = new Random();
        p[1] = new Pair(35, 575);
        x = 5.0;
        y = 5.0;
        Num_Dice = new ImageView[7];
        last_pos = new int[2];
        new_pos = new int[2];
        last_pos[0] = 1;
        last_pos[1] = 1;
        new_pos[0] = 1;
        new_pos[1] = 1;
      
        SetPos(boardnum);
        root = new Pane();
           
        Image img1 = new Image(getClass().getResource("ladder-and-snakes/Background.jpg").toExternalForm());
        Image img3 = new Image(getClass().getResource("ladder-and-snakes/Blue.jpg").toExternalForm());
        Image img4 = new Image(getClass().getResource("ladder-and-snakes/snakeladder.png").toExternalForm());
        Image img5 = new Image(getClass().getResource("ladder-and-snakes/dice.gif").toExternalForm());
        Image img6 = new Image(getClass().getResource("ladder-and-snakes/redcoin.png").toExternalForm());
        Image[] Dice_img = new Image[6];
        Dice_img[0] = new Image(getClass().getResource("ladder-and-snakes/1.png").toExternalForm());
        Dice_img[1] = new Image(getClass().getResource("ladder-and-snakes/2.png").toExternalForm());
        Dice_img[2] = new Image(getClass().getResource("ladder-and-snakes/3.png").toExternalForm());
        Dice_img[3] = new Image(getClass().getResource("ladder-and-snakes/4.png").toExternalForm());
        Dice_img[4] = new Image(getClass().getResource("ladder-and-snakes/5.png").toExternalForm());
        Dice_img[5] = new Image(getClass().getResource("ladder-and-snakes/6.png").toExternalForm());
        Image img7 = new Image(getClass().getResource("ladder-and-snakes/bluecoin.png").toExternalForm());

        Background = new ImageView(img1);

        Blue = new ImageView(img3);
        SnakeAndLadderImg = new ImageView(img4);
        Dice = new ImageView(img5);
        Coin = new ImageView[2];
        CoinTurn = new ImageView[2];
        if (player1coin == 0) {
            Coin[player1coin] = new ImageView(img6);
            CoinTurn[player1coin] = new ImageView(img6);
            Coin[player2coin] = new ImageView(img7);
            CoinTurn[player2coin] = new ImageView(img7);
        } else {
            Coin[player2coin] = new ImageView(img6);
            CoinTurn[player2coin] = new ImageView(img6);
            Coin[player1coin] = new ImageView(img7);
            CoinTurn[player1coin] = new ImageView(img7);
        }

        Num_Dice = new ImageView[7];
        for (int i = 1; i <= 6; i++) {
            Num_Dice[i] = new ImageView(Dice_img[i - 1]);
        }
        Menu = new Button("Menu");
        Roll = new Button("Roll");

        Player = new Text("Player :-");
        Player.setLayoutX(1070);
        Player.setLayoutY(300);
        Player.setFont(Font.font("Cooper Black", FontWeight.BOLD, 40));

        rect = new Rectangle(1050, 50, 210, 550);
        Blue.setLayoutX(1050);
        Blue.setLayoutY(50);
        Blue.setFitHeight(550);
        Blue.setFitWidth(210);

        rect.setArcHeight(15);
        rect.setArcWidth(10);
        rect.setFill(Color.BEIGE);

        SnakeAndLadderImg.setLayoutX(1055);
        SnakeAndLadderImg.setLayoutY(110);
        SnakeAndLadderImg.setFitHeight(150);
        SnakeAndLadderImg.setFitWidth(200);

        for (int i = 1; i <= 6; i++) {
            Num_Dice[i].setLayoutX(1100);
            Num_Dice[i].setLayoutY(500);
            Num_Dice[i].setFitHeight(1);
            Num_Dice[i].setFitWidth(1);
        }
        //Menu Button
        Menu.setLayoutX(1065);
        Menu.setLayoutY(55);
        Menu.setMinSize(180, 40);
        Menu.setStyle("-fx-font: 24 Blazed;");

        Dice.setLayoutX(1100);
        Dice.setLayoutY(500);
        Dice.setFitHeight(100);
        Dice.setFitWidth(100);

        Roll.setLayoutX(1065);
        Roll.setLayoutY(450);
        Roll.setMinSize(180, 40);
        Roll.setStyle("-fx-font: 24 Blazed;");

        for (int i = 0; i < 2; i++) {
            Coin[i].setFitHeight(50);
            Coin[i].setFitWidth(50);
            Coin[i].setLayoutX(p[1].getX());
            Coin[i].setLayoutY(p[1].getY());
        }

        FadeTransition ft = new FadeTransition(Duration.millis(3000), SnakeAndLadderImg);
        ft.setFromValue(1.0);
        ft.setToValue(0.3);
        ft.setCycleCount(Timeline.INDEFINITE);
        ft.setAutoReverse(true);
        ft.play();
        for (int i = 0; i < 2; i++) {
            CoinTurn[i].setLayoutX(1100);
            CoinTurn[i].setLayoutY(330);
            CoinTurn[i].setFitHeight(100);
            CoinTurn[i].setFitWidth(100);
        }

        CoinTurn[player1coin].setOpacity(0.0);
        Roll.setOnAction((ActionEvent e) -> {
            count++;
            Clap.stop();
            Boo.stop();
            if (count % 2 == 1) {
                CoinTurn[player2coin].setOpacity(1.0);
                CoinTurn[player1coin].setOpacity(0.0);
            } else {
                CoinTurn[player2coin].setOpacity(0.0);
                CoinTurn[player1coin].setOpacity(1.0);
            }
            n = rand.nextInt(6) + 1;
            Dice.setFitHeight(1);
            Dice.setFitWidth(1);
            Num_Dice[n].setLayoutX(1100);
            Num_Dice[n].setLayoutY(500);
            Num_Dice[n].setFitHeight(100);
            Num_Dice[n].setFitWidth(100);
            for (int i = 1; i <= 6; i++) {
                Num_Dice[i].setOpacity(0.0);
                if (i == n) {
                    Num_Dice[i].setOpacity(1.0);
                }
            }
            if (numplayer == 2) {
                if (count % 2 == 0) {
                    PlayerTurn(player2coin, n);
                } else {
                    PlayerTurn(player1coin, n);
                }

            } else {
                PlayerTurn(player2coin, n);
                if (new_pos[player2coin] == 100) {
                    WinnerSingel = true;
                    Statues = new ExitAndcongrats(false, false, true, players[0]);
                    stagenow(Statues);
                }
                count++;

                delay = new PauseTransition(Duration.seconds(timeforplay));

                delay.setOnFinished(event -> {
                    Clap.stop();
                    Boo.stop();
                    if (count % 2 == 1) {
                        CoinTurn[player2coin].setOpacity(1.0);
                        CoinTurn[player1coin].setOpacity(0.0);
                    } else {
                        CoinTurn[player2coin].setOpacity(0.0);
                        CoinTurn[player1coin].setOpacity(1.0);
                    }
                    n = rand.nextInt(6) + 1;
                    Dice.setFitHeight(1);
                    Dice.setFitWidth(1);
                    Num_Dice[n].setLayoutX(1100);
                    Num_Dice[n].setLayoutY(500);
                    Num_Dice[n].setFitHeight(100);
                    Num_Dice[n].setFitWidth(100);

                    ComputerTurn(player1coin, n);
                    if (new_pos[player1coin] == 100) {
                        WinnerSingel = false;
                        Statues = new ExitAndcongrats(false, false, true);
                        stagenow(Statues);
                    }
                    Roll.setOpacity(1.0);
                    Roll.setDisable(false);
                });
                delay.play();

            }
            if (numplayer == 2) {
                if (count % 2 == 0 && new_pos[1] == 100) {
                    WinnerMulti = false;
                    System.out.print("Player 1 Won");
                    Statues = new ExitAndcongrats(false, true, false, players[0]);
                    stagenow(Statues);
                } else if (count % 2 == 1 && new_pos[0] == 100) {
                    WinnerMulti = true;
                    Statues = new ExitAndcongrats(false, true, false, players[1]);
                    stagenow(Statues);
                    System.out.print("Player 2 Won");
                }
            }
            timeforplay = 2;
        });

        //Board Image
        Board.setFitHeight(630);
        Board.setFitWidth(1000);
        Board.setLayoutX(10);
        Board.setLayoutY(10);

        root.getChildren().addAll(Background, Board, rect, Menu, SnakeAndLadderImg, Dice, Roll, Player, Coin[0], Coin[1], Num_Dice[1],
                Num_Dice[2], Num_Dice[3], Num_Dice[4], Num_Dice[5], Num_Dice[6], CoinTurn[0], CoinTurn[1]);
        Gameboard = new Scene(root, 1300, 650);
    }

    public void ComputerTurn(int num, int dicenum) {
        new_pos[num] = last_pos[num] + dicenum;
        if (new_pos[num] > 100) {
            new_pos[num] = last_pos[num];
        }

        if (new_pos[num] != last_pos[num] && new_pos[num] <= 100 && last_pos[num] <= 100) {
            Coin[num].setLayoutX(p[last_pos[num]].getX());
            Coin[num].setLayoutY(p[last_pos[num]].getY());
            PathTransition transition = new PathTransition();
            transition.setNode(Coin[num]);
            transition.setDuration(Duration.seconds(0.5));
            transition.stop();

            Path path = new Path();
            path.getElements().add(new MoveToAbs(Coin[num]));
            path.getElements().add(new LineToAbs(Coin[num], p[new_pos[num]].getX(), p[new_pos[num]].getY()));
            if (Ladders.get(new_pos[num]) != null) {
                new_pos[num] = (int) Ladders.get(new_pos[num]);
                path.getElements().add(new LineToAbs(Coin[num], p[new_pos[num]].getX(), p[new_pos[num]].getY()));
                transition.setDuration(Duration.seconds(0.5));
            }
            if (Snakes.get(new_pos[num]) != null) {
                new_pos[num] = (int) Snakes.get(new_pos[num]);
                path.getElements().add(new LineToAbs(Coin[num], p[new_pos[num]].getX(), p[new_pos[num]].getY()));
                transition.setDuration(Duration.seconds(0.5));
            }
            transition.setPath(path);
            transition.play();
        }
        last_pos[num] = new_pos[num];
    }

    public void PlayerTurn(int num, int dicenum) {
        if (this.num_player < 2) {
            Roll.setOpacity(0.0);
            Roll.setDisable(true);
        }
        new_pos[num] = last_pos[num] + dicenum;
        if (new_pos[num] > 100) {
            new_pos[num] = last_pos[num];
        }

        if (new_pos[num] != last_pos[num] && new_pos[num] <= 100 && last_pos[num] <= 100) {
            Coin[num].setLayoutX(p[last_pos[num]].getX());
            Coin[num].setLayoutY(p[last_pos[num]].getY());
            PathTransition transition = new PathTransition();
            transition.setNode(Coin[num]);
            transition.setDuration(Duration.seconds(1));
            transition.stop();

            Path path = new Path();
            path.getElements().add(new MoveToAbs(Coin[num]));
            path.getElements().add(new LineToAbs(Coin[num], p[new_pos[num]].getX(), p[new_pos[num]].getY()));
            if (Ladders.get(new_pos[num]) != null) {
                timeforplay = 3;
                Clap.play();
                new_pos[num] = (int) Ladders.get(new_pos[num]);
                path.getElements().add(new LineToAbs(Coin[num], p[new_pos[num]].getX(), p[new_pos[num]].getY()));
                transition.setDuration(Duration.seconds(1));
            }
            if (Snakes.get(new_pos[num]) != null) {
                timeforplay = 3;
                Boo.play();
                new_pos[num] = (int) Snakes.get(new_pos[num]);
                path.getElements().add(new LineToAbs(Coin[num], p[new_pos[num]].getX(), p[new_pos[num]].getY()));
                transition.setDuration(Duration.seconds(1));
            }
            transition.setPath(path);
            transition.play();
        }
        last_pos[num] = new_pos[num];
    }

    public final void SetPos(int num) {
        if (num == 1) {
            for (int i = 2; i <= 100; i++) {
                if (i % 10 == 1 && i <= 50) {
                    x = (p[i - 1].getX());
                    y = (p[i - 1].getY()) - 60;
                    p[i] = new Pair(x, y);
                } else if (i % 10 == 1 && i > 50) {
                    x = (p[i - 1].getX());
                    y = (p[i - 1].getY()) - 64;
                    p[i] = new Pair(x, y);
                } else {
                    if ((i % 10 == 0) && (p[i - 1].getX() - p[i - 2].getX()) > 0) {
                        x = (p[i - 1].getX()) + 100.0;
                        y = (p[i - 1].getY());
                        p[i] = new Pair(x, y);
                    } else if ((i % 10 == 0) && (p[i - 1].getX() - p[i - 2].getX()) < 0) {
                        x = (p[i - 1].getX()) - 100.0;
                        y = (p[i - 1].getY());
                        p[i] = new Pair(x, y);
                    } else if ((i / 10) % 2 == 1) {
                        x = (p[i - 1].getX()) - 100.0;
                        y = (p[i - 1].getY());
                        p[i] = new Pair(x, y);
                    } else if ((i / 10) % 2 == 0) {
                        x = (p[i - 1].getX()) + 100.0;
                        y = (p[i - 1].getY());
                        p[i] = new Pair(x, y);
                    }
                }
            }
          File laddfile = new File("./ladder-and-snakes/ladders1.txt");
            File Snakefile = new File("./ladder-and-snakes/snakes1.txt");
            Image img2 = new Image(getClass().getResource("ladder-and-snakes/board1.jpg").toExternalForm());
            Board = new ImageView(img2);
            
            Scanner input;
            try {
                input = new Scanner(laddfile);
                while (input.hasNext()) {
                int laddx = input.nextInt();
                int laddy = input.nextInt();
                Ladders.put(laddx, laddy);
            }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(GameBoard.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            try {
                input = new Scanner(Snakefile);
                 while (input.hasNext()) {
                int laddx = input.nextInt();
                int laddy = input.nextInt();
                Snakes.put(laddx, laddy);
            }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(GameBoard.class.getName()).log(Level.SEVERE, null, ex);
            }
           
        } else {
            for (int i = 2; i <= 100; i++) {
                if (i % 10 == 1 && i <= 50) {
                    x = (p[1].getX());
                    y = (p[i - 1].getY()) - 60;
                    p[i] = new Pair(x, y);
                } else if (i % 10 == 1 && i > 50) {
                    x = (p[1].getX());
                    y = (p[i - 1].getY()) - 64;
                    p[i] = new Pair(x, y);
                } else {
                    if ((i % 10 == 0) && (p[i - 1].getX() - p[i - 2].getX()) > 0) {
                        x = (p[i - 1].getX()) + 100.0;
                        y = (p[i - 1].getY());
                        p[i] = new Pair(x, y);
                    } else if ((i % 10 == 0) && (p[i - 1].getX() - p[i - 2].getX()) < 0) {
                        x = (p[i - 1].getX()) - 100.0;
                        y = (p[i - 1].getY());
                        p[i] = new Pair(x, y);
                    } else if ((i / 10) % 2 == 1) {
                        x = (p[i - 1].getX()) + 100.0;
                        y = (p[i - 1].getY());
                        p[i] = new Pair(x, y);
                    } else if ((i / 10) % 2 == 0) {
                        x = (p[i - 1].getX()) + 100.0;
                        y = (p[i - 1].getY());
                        p[i] = new Pair(x, y);
                    }
                }
            }
            File laddfile = new File("./ladder-and-snakes/ladders2.txt");
            File Snakefile = new File("./ladder-and-snakes/snakes2.txt");
            Image img2 = new Image(getClass().getResource("ladder-and-snakes/board2.jpg").toExternalForm());
            Board = new ImageView(img2);
            Scanner input;
            try {
                input = new Scanner(laddfile);
                while (input.hasNext()) {
                int laddx = input.nextInt();
                int laddy = input.nextInt();
                Ladders.put(laddx, laddy);
            }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(GameBoard.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            try {
                input = new Scanner(Snakefile);
                 while (input.hasNext()) {
                int laddx = input.nextInt();
                int laddy = input.nextInt();
                Snakes.put(laddx, laddy);
            }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(GameBoard.class.getName()).log(Level.SEVERE, null, ex);
            }
           
        }
    }

    public Scene getScene() {
        return Gameboard;
    }

    public class MoveToAbs extends MoveTo {

        public MoveToAbs(Node node) {
            super(node.getLayoutBounds().getWidth() / 2, node.getLayoutBounds().getHeight() / 2);
        }

        public MoveToAbs(Node node, double x, double y) {
            super(x - node.getLayoutX() + node.getLayoutBounds().getWidth() / 2, y - node.getLayoutY() + node.getLayoutBounds().getHeight() / 2);
        }

    }

    public class LineToAbs extends LineTo {

        public LineToAbs(Node node, double x, double y) {
            super(x - node.getLayoutX() + node.getLayoutBounds().getWidth() / 2, y - node.getLayoutY() + node.getLayoutBounds().getHeight() / 2);
        }

    }

    void stagenow(ExitAndcongrats Statues) {
        if (miss == null) {
            miss = new Stage();
            miss.setAlwaysOnTop(true);
            miss.setScene(Statues.getScene());
            miss.setResizable(false);
            miss.show();
            this.Roll.setDisable(true);
            this.Roll.setOpacity(0.0);
            PauseTransition wait3 = new PauseTransition(Duration.seconds(2));
            wait3.setOnFinished(event -> {
                this.me.close();
            });
            wait3.play();
            Statues.exit.setOnAction((ActionEvent event) -> {
                this.primary.close();
                this.me.close();
                miss.close();

            });
            Statues.back.setOnAction((ActionEvent event) -> {
                this.primary.show();
                this.me.close();
                miss.close();

            });
        }
    }
}
