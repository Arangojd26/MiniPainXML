/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minipain;

import com.sun.javafx.scene.paint.GradientUtils;
import java.awt.geom.Point2D;
import javafx.scene.paint.Color;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import java.lang.Object;
import java.util.EventObject;
import java.util.LinkedList;
import javafx.animation.Animation;
import javafx.animation.PathTransition;
import javafx.animation.StrokeTransition;
import javafx.animation.TranslateTransition;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ToggleButton;
import javafx.scene.input.InputEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeLineCap;
import javafx.util.Duration;
import modelo.Punto;

/**
 *
 * @author juan_david.arango
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Canvas lienzo;
    @FXML
    private Canvas microLienzo;
    @FXML
    private MenuBar menubar;
    @FXML
    private Label LX;
    @FXML
    private Label LY;
    @FXML
    private Circle C;
    @FXML
    private Circle C1;
    @FXML
    private Circle C2;
    @FXML
    private GraphicsContext g;
    @FXML
    private GraphicsContext l;
    @FXML
    private ColorPicker colorPicker;
    @FXML
    private Polygon polygon;
    @FXML
    private Button stop;
    @FXML
    private Button play;
    @FXML
    private ToggleButton changeColor;
    
    LinkedList<Punto> listaP;
    
    @FXML
    private void posicionMouse(MouseEvent e){
        
        LX.setText("" + e.getX());
        LY.setText("" + e.getY());

    }
    @FXML
    private void limpiar(ActionEvent event){

        double X = lienzo.getWidth();
        double Y = lienzo.getHeight();
        double W = microLienzo.getWidth();
        double H = microLienzo.getHeight();
        
        g.clearRect(0, 0, X, Y);
        l.clearRect(0, 0, W, H);
        
        
        
        
        
        
    }
    @FXML
    private void cambiarColor(){
                
        C.setFill(colorPicker.getValue());


    }

    @FXML
    private void crearEstrella1(ActionEvent event) {
        System.out.println("You clicked me!");
        //label.setText("Hello World!");
        
        g = lienzo.getGraphicsContext2D();
        double x [] = {449, 358, 416, 534, 519, 384, 372, 491, 547, 449};
        double y [] = {400, 480, 582, 544, 428, 428, 542, 583, 480, 400};
         
         g.setLineWidth(6);
          // Le otorfa color al contorno de la figura
        g.setStroke(Color.BLACK);
        g.strokePolygon(x, y, 10);
        
        
        g.setFill(colorPicker.getValue());
        g.fillPolygon(x, y, 10);

        
    }
    @FXML
    private void crearEstrella2(ActionEvent event){

        
        g = lienzo.getGraphicsContext2D();
         // Corre 260, baja 250 y así sucesivamente.
         double x [] = {127, 47, 207};
         double y [] = {401, 546, 546};
         double x2 [] = {64, 93, 222};
         double y2 [] = {425, 584, 490}; 
         double x3 [] = {188, 32, 157};
         double y3 [] = {425, 490, 584};
         g.setLineWidth(6);
          // Le otorfa color al contorno de la figura
         
         // Primer triangulo
         g.setStroke(colorPicker.getValue());
         g.strokePolygon(x, y, 3);
         //Segundo triangulo
         g.setStroke(colorPicker.getValue());
         g.strokePolygon(x2, y2, 3);
         //Tercer triangulo
         g.setStroke(colorPicker.getValue());
         g.strokePolygon(x3, y3, 3);
         
    
    }
    @FXML
    private void crearEstrella3(ActionEvent event) {
        
    l = microLienzo.getGraphicsContext2D();    
     double x [] = {747, 711, 815, 659, 841, 659, 810, 709, 747, 784, 677, 836, 653, 830, 682, 780, 747};
     double y [] = {401, 582, 431, 530, 500, 460, 563, 410, 589, 410, 561, 465, 492, 537, 420, 584, 401};
     
    l.setLineWidth(6.0);
    l.setStroke(Color.BLACK);
    l.strokePolygon(x, y, 17);
    l.setFill(colorPicker.getValue());
    l.fillPolygon(x, y, 17);
    
    Polygon CL = new Polygon();
        CL.getPoints().addAll(new Double[]{ 440.0, 359.0, 47.0, -26.0, 107.0, 246.0});
        PathTransition transition3 = new PathTransition();
        
        transition3.setNode(l.getCanvas());
        transition3.setDuration(Duration.seconds(6));
        transition3.setPath(CL);
        transition3.setCycleCount(PathTransition.INDEFINITE);
        transition3.playFromStart();

}

    @FXML
    private void crearCuadrados(MouseEvent e) {
        // Crea el lienzo 
        g = lienzo.getGraphicsContext2D();
        // Crea las coordenadas donde se encuentra el puntero del mouse dentro del canvas.
        double X = e.getX();
        double Y = e.getY();
//      Forma del cuadrado.
        g.setStroke(colorPicker.getValue());
//      grosor del las lineas.        
        g.setLineWidth(3);
//      dimensiones y coordenadas de la froma        
        g.strokeRect(X, Y, 40, 40);

    }

    @FXML
    private void moverCirculo(ActionEvent event) {

        //
        
        
//      Poligono en el que se mueven los circulos.
        Polygon CR = new Polygon();
        
//      Dimensiones del poligono en el que se mueven las figuras  
        CR.getPoints().addAll(new Double[]{0.0, 0.0, -400.0, 188.0, 50.0, 500.0, 400.0, 188.0, 100.0, -120.0 });

        
//      Path que generan el movimiento (animación) del circulo.        
        PathTransition transition = new PathTransition();
        PathTransition transition1 = new PathTransition();
        PathTransition transition2 = new PathTransition();
        
        
//      transiciones, duraciones y ciclo indefinido del movimiento.
        //1
        transition.setNode(C);      
        transition.setDuration(Duration.seconds(5));
        transition.setPath(CR);        
        transition.setCycleCount(PathTransition.INDEFINITE);
        transition.playFromStart();

        //2
        transition1.setNode(C1);
        transition1.setDuration(Duration.seconds(5.01));
        transition1.setPath(CR);
        transition1.setCycleCount(PathTransition.INDEFINITE);
        transition1.playFromStart();
        
        
        
        //3
        transition2.setNode(C2);
        transition2.setDuration(Duration.seconds(5.01));
        transition2.setPath(CR);
        transition2.setCycleCount(PathTransition.INDEFINITE);
        transition2.playFromStart();
        
        
        
        //
        play.setOnAction(new EventHandler<ActionEvent>(){
        
            @Override
            public void handle(ActionEvent e){
            
                transition.play();
                transition1.play();
                transition2.play();
                
            }
        });
        stop.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                   transition.pause();
                   transition1.pause();
                   transition2.pause();
                   
            }
        });

    }
    
    @FXML
    private void guardarXML(ActionEvent event) {
   
        
        Punto objG = new Punto();
        
        boolean guardar = objG.crearArchivoXML();
        
        
        
    }
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        listaP = new LinkedList();

    }

}
