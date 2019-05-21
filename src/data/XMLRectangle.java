
package data;

import domain.Rectangle;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.jdom.output.XMLOutputter;

public class XMLRectangle {
    
    //variables
    private Document document;
    private Element root;
    private String path;

    public XMLRectangle(String path) throws IOException, JDOMException {
        //ruta en la que se encuentra el archivo XML
        this.path = path;
        File fileRectangle = new File(path);//esto es solo para hacer validacion
        if(fileRectangle.exists()){
            //1. EL ARCHIVO YA EXISTE, ENTONCES LO CARGO EN MEMORIA
            
            //toma la estructura de datos y las carga en memoria
            SAXBuilder saxBuilder = new SAXBuilder();
            saxBuilder.setIgnoringElementContentWhitespace(true);
            
            //carga la memoria
            this.document = saxBuilder.build(path);
            this.root = this.document.getRootElement();
        }
        else{
            //2. EL ARCHIVO NO EXISTE, ENTONCES LO CREO Y LUEGO LO CARGO EN MEMORIA
            
            //CREAMOS EL ELEMENTO RAIZ
            this.root = new Element("squares");
            
            //CREAMOS EL DOCUMENTO
            this.document = new Document(this.root);
            
            //GUARDAMOS EN DISCO DURO
            storeXML();
        }
    }//end constructor
    
    //almacena en disco duro nuestro documento xml en la ruta especificada
    private void storeXML() throws IOException{
        XMLOutputter xmlOutputter = new XMLOutputter();
        xmlOutputter.output(document, new PrintWriter(path));
    }
    
    //metodo para insertar un nuevo cuadrado en el documento xml
    public void insertRectangle(Rectangle rectangle) throws IOException{
        //INSERTAMOS EN EL DOCUMENTO EN MEMORIA
        //para insertar en xml, primero se crean los elementos
        
        //crear el Rectangle
        Element eRectangle = new Element("Triangle");
        //agregamos atributo
        eRectangle.setAttribute("identification", rectangle.getIdentification());
        
        //creamos el elemento de las posiciones
        Element eXAxis = new Element("xAxis");
        eXAxis.addContent(String.valueOf(rectangle.getxAxis()));
        
        Element eYAxis = new Element("yAxis");
        eYAxis.addContent(String.valueOf(rectangle.getyAxis()));
        
        //creamos el elemento tamaño
        Element eWidth = new Element("width");
        eWidth.addContent(String.valueOf(rectangle.getWidth()));
        
        Element eHeight = new Element("height");
        eHeight.addContent(String.valueOf(rectangle.getHeight()));
        
        //agregar al elemento Rectangle el contenido de tamaño2
        eRectangle.addContent(eXAxis);
        eRectangle.addContent(eYAxis);
        eRectangle.addContent(eWidth);
        eRectangle.addContent(eHeight);
        
        //AGREGAMOS AL ROOT
        this.root.addContent(eRectangle);
        
        //FINALMENTE: GUARDAR EN DD
        storeXML();
    }//end insert
    
    
    //delete
    public void deleteRectangle() throws IOException{
        List elementList = this.root.getChildren();
        elementList.remove(1);
        
        //FINALMENTE: GUARDAR EN DD
        storeXML();
    }
    
    //metodo para obtener todos los estudiantes en un arreglo
    public ArrayList<Rectangle> getAllRectangles(){
        //obtenemos la cantidad de rectangulos
        int rectanglesQuantity = this.root.getContentSize();
        //obtenemos una lista con todos los elementos de root
        List elementList = this.root.getChildren();
        
        //definimos el tamanno del arreglo
        ArrayList<Rectangle> rectanglesArray = new ArrayList<>(rectanglesQuantity);
        
        //recorremos la lista para ir creando los objetos de tipo Rectangle
        int count = 0;
        for(Object currentObject: elementList){
            //transformo el object
            Element currentElement = (Element)currentObject;
            
            //crear el cuadrado
            Rectangle currentRectangle = new Rectangle();
            
            //establezco el id
            currentRectangle.setIdentification(
                    currentElement.getAttributeValue("identification"));
            
            //establezco la posición
            currentRectangle.setxAxis(Integer.parseInt(currentElement.getChild("xAxis").getValue()));
            
            currentRectangle.setyAxis(Integer.parseInt(currentElement.getChild("yAxis").getValue()));
            
            //establezco el tamaño
            currentRectangle.setWidth(
                    Integer.parseInt(currentElement.getChild("width").getValue()));
            
            currentRectangle.setHeight(
                    Integer.parseInt(currentElement.getChild("height").getValue()));
            //guardar en el arreglo
            rectanglesArray.add(currentRectangle);
            count++;
        }//end for
        return rectanglesArray;
    } 
}
