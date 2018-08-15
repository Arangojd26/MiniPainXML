/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

/**
 *
 * @author juand
 */
public class Punto {
    
    private String nombreFigura;
    private String X = "449, 358, 416, 534, 519, 384, 372, 491, 547, 449";
    private String Y = "400, 480, 582, 544, 428, 428, 542, 583, 480, 400";

    public Punto() {
    }
    
    

    public Punto(String nombreFigura, String X, String Y) {
        this.nombreFigura = "poligono";
        this.X = X;
        this.Y = Y;
    }

    public String getNombreFigura() {
        return nombreFigura;
    }

    public String getX() {
        return X;
    }

    public String getY() {
        return Y;
    }

    public void setNombreFigura(String nombreFigura) {
        this.nombreFigura = nombreFigura;
    }

    public void setX(String X) {
        this.X = X;
    }

    public void setY(String Y) {
        this.Y = Y;
    }
    
    public boolean crearArchivoXML() {
        
        boolean guardar = false;
        
            try {
                
                Element Figura = new Element("Figura");
                Document doc = new Document(Figura);

                    //Elemento raíz 
                    Element poligono = new Element("poligono");
                    //Elementos hijos
                    
                    poligono.addContent(new Element("X").setText(X));
                    poligono.addContent(new Element("Y").setText(Y));

                    //Guardamos el archivo XML al documento.
                    doc.getRootElement().addContent(poligono);
                
                //Objeto del tipo XMLOutputter
                XMLOutputter xmlOutput = new XMLOutputter();               
                xmlOutput.setFormat(Format.getPrettyFormat());
                xmlOutput.output(doc, new FileWriter("Figura.xml"));
                
                guardar = true;
                System.out.println("File saved");
                
        } catch (IOException e) {
            
                System.out.println(e.getMessage());
                guardar = false;
        }

        return  guardar;
        
        
    }
    
    
}
