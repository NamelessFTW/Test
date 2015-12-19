//Ivan Ribeiro
//8 Dec 2015

package game;

import java.nio.file.Path;
import java.nio.file.Paths;

import game.entity.EntityEnemy;
import game.entity.EntityItem;
import game.entity.EntityPlayer;
import game.entity.MONSTERTYPE;
import game.item.Item;
import game.item.ItemChestplate;
import game.item.ItemHat;
import game.item.ItemWearable;
import game.map.Map;
import game.reference.Reference;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Game extends Application
{
	static Stage stage;
	private static int spacing = 0;
	private static Map map;
	
	// handles the setup event
	EventHandler<ActionEvent> setupHandler = new EventHandler<ActionEvent>()
			{
				@Override
				public void handle(ActionEvent event)
				{
					setup();
				}
			};

			
	// called whenever the mouse is moved on the screen
	static EventHandler<MouseEvent> mouseMove = new EventHandler<MouseEvent>()
	{
		@Override
		public void handle(MouseEvent event)
		{
			Scene scene = (Scene)event.getSource();
			Stage window = (Stage)scene.getWindow();
			window.setTitle("Hello X: " + event.getSceneX() + " " + "Y: " +event.getSceneY());
		}
	};

	
	// handles moving the player based on the movement buttons on screen
	static EventHandler<ActionEvent> movementButtonEventHandler = new EventHandler<ActionEvent>()
	{

		@Override
		public void handle(ActionEvent event)
		{
			if (event != null)
			{
				Button source = (Button) event.getSource();

				if (source.getText().equals("<"))
				{
					map.getPlayer().moveLeft();
					System.out.println("Left " + map.getPlayer().getX() + " " + map.getPlayer().getY());
				}
				else if (source.getText().equals("^"))
				{
					map.getPlayer().moveUp();
					System.out.println("Up " + map.getPlayer().getX() + " " + map.getPlayer().getY());
				}
				else if (source.getText().equals(">"))
				{
					map.getPlayer().moveRight();
					System.out.println("Right " + map.getPlayer().getX() + " " + map.getPlayer().getY());
				}
				else if (source.getText().equals("\\/"))
				{
					map.getPlayer().moveDown();
					System.out.println("Down " + map.getPlayer().getX() + " " + map.getPlayer().getY());
				}
				updateCanvas();
			}
		}
	};
	
	// handles player movement based on arrow keys or WASD being pressed
	static EventHandler<KeyEvent> keyboardEventHandler = new EventHandler<KeyEvent>()
	{
		@Override
		public void handle(KeyEvent event)
		{
			event.consume();
			//for (KeyCode i : Reference.assignedKeys)
			{
				//if (event.getCode() == i)
				{
					if (event.getCode() == KeyCode.W || event.getCode() == KeyCode.UP)
					{
						map.getPlayer().moveUp();
						System.out.println("Up " + map.getPlayer().getX() + " " + map.getPlayer().getY());
					}
					else if (event.getCode() == KeyCode.S || event.getCode() == KeyCode.DOWN)
					{
						map.getPlayer().moveDown();
						System.out.println("Down " + map.getPlayer().getX() + " " + map.getPlayer().getY());
					}
					else if (event.getCode() == KeyCode.A || event.getCode() == KeyCode.LEFT)
					{
						map.getPlayer().moveLeft();
						System.out.println("Left " + map.getPlayer().getX() + " " + map.getPlayer().getY());
					}
					else if (event.getCode() == KeyCode.D || event.getCode() == KeyCode.RIGHT)
					{
						map.getPlayer().moveRight();
						System.out.println("Right " + map.getPlayer().getX() + " " + map.getPlayer().getY());
					}
					updateCanvas();
				}
			}
		}
	};
	
	// prints the player stats to the console
	private static EventHandler<ActionEvent> showStats = new EventHandler<ActionEvent>()
			{
				@Override
				public void handle(ActionEvent event)
				{
					map.getPlayer().printStats();
				}
			};
			
	public static void main(String[] args)
	{
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage)
	{
		this.stage = primaryStage;
		Button btn = new Button();
		BorderPane root = new BorderPane();
		StackPane leftStack = new StackPane();
		
		primaryStage.setTitle("Hello");
		leftStack.getChildren().add(btn);
		root.setLeft(leftStack);
		
		btn.setText("setup");
		btn.setOnAction(setupHandler);
		stage.setScene(new Scene(root, 300, 200));;
		stage.show();
		primaryStage.getScene().setOnMouseMoved(mouseMove);
		primaryStage.getScene().setOnKeyPressed(keyboardEventHandler);
	}
	
	public static void setup()
	{
		Path path = Paths.get("").toAbsolutePath();
		System.out.println(path.toString());
		map = new Map();
		Rectangle[][] rectArray = map.getMapAsRectArray();
		BorderPane rootPane = (BorderPane) stage.getScene().getRoot();
		Canvas canvas = new Canvas(rectArray[0][0].getWidth() * (rectArray.length + spacing + 10), rectArray[0][0].getHeight() * (rectArray[0].length + spacing + 10));
		VBox leftPane = new VBox();
		VBox rightPane = new VBox();
		Button stats = new Button();
		rightPane.getChildren().add(stats);
		stats.setText("Stats");
		stats.setOnAction(showStats);

		
		rootPane.setLeft(leftPane);
		rootPane.setRight(rightPane);
		Button[] btns = new Button[4];
		for (int i = 0, iCond = btns.length; i < iCond; i++)
		{
			btns[i] = new Button();
			btns[i].setOnAction(movementButtonEventHandler);
			leftPane.getChildren().add(btns[i]);
		}
		
		btns[0].setText("^");
		btns[1].setText(">");
		btns[2].setText("\\/");
		btns[3].setText("<");
		
		rootPane.setCenter(canvas);
		stage.setHeight(480);
		stage.setWidth(854);
		
		for (int i = 0, iCond = rectArray.length; i < iCond; i++)
		{
			for (int j = 0, jCond = rectArray[i].length; j < jCond; j++)
			{
				canvas.getGraphicsContext2D().setFill(rectArray[i][j].getFill());
				canvas.getGraphicsContext2D().fillRect((rectArray[i][j].getWidth() + spacing) * i, (rectArray[i][j].getHeight() + spacing) * j, rectArray[i][j].getWidth(), rectArray[i][j].getHeight());
			}
		}
		
		EntityPlayer player = new EntityPlayer(map, 3, 3);
		EntityEnemy enemy1 = new EntityEnemy(MONSTERTYPE.OGRE, map, 2, 5);
		EntityEnemy enemy2 = new EntityEnemy(MONSTERTYPE.TROLL, map, 4, 8);
		ItemHat item = new ItemHat("Hat", "hat1", 0);
		ItemChestplate item2 = new ItemChestplate("chestplate", "chestplate1", 3);
		EntityItem entity = new EntityItem(item, map, 6, 6);
		EntityItem entity2 = new EntityItem(item2, map, 8, 8);
		updateCanvas();
	}
	
	private static void updateCanvas()
	{
		Rectangle[][] rectArray = map.getMapAsRectArray();
		BorderPane pane = (BorderPane) stage.getScene().getRoot();
		Canvas canvas = (Canvas) pane.getCenter();
		for (int i = 0, iCond = rectArray.length; i < iCond; i++)
		{
			for (int j = 0, jCond = rectArray[i].length; j < jCond; j++)
			{
				canvas.getGraphicsContext2D().setFill(rectArray[i][j].getFill());
				canvas.getGraphicsContext2D().fillRect((rectArray[i][j].getWidth() + spacing) * i, (rectArray[i][j].getHeight() + spacing) * j, rectArray[i][j].getWidth(), rectArray[i][j].getHeight());
			}
		}
	}
}
