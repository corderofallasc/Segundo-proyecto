/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import domain.Circle;
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

public class XMLCircle {
    
    //variables
    private Document document;
    private Element root;
    private String path;

    public XMLCircle(String path) throws IOException, JDOMException {
        //ruta en la que se encuentra el archivo XML
        this.path = path;
        File fileCircle = new File(path);//esto es solo para hacer validacion
        if(fileCircle.exists()){
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
            this.root = new Element("Circles");
            
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
    public void insertvTriangle(Circle circle) throws IOException{
        //INSERTAMOS EN EL DOCUMENTO EN MEMORIA
        //para insertar en xml, primero se crean los elementos
        
        //crear el Circle
        Element eCircle = new Element("Circle");
        //agregamos atributo
        eCircle.setAttribute("identification", circle.getIdentification());
        
        //creamos el elemento de las posiciones
        Element eXAxis = new Element("xAxis");
        eXAxis.addContent(String.valueOf(circle.getxAxis()));
        
        Element eYAxis = new Element("yAxis");
        eYAxis.addContent(String.valueOf(circle.getyAxis()));
        
        //creamos el elemento tamaño
        Element eSize = new Element("size");
        eSize.addContent(String.valueOf(circle.getSize()));
        
        //agregar al elemento Triangle el contenido de tamaño2
        eCircle.addContent(eXAxis);
        eCircle.addContent(eYAxis);
        eCircle.addContent(eSize);
        
        //AGREGAMOS AL ROOT
        this.root.addContent(eCircle);
        
        //FINALMENTE: GUARDAR EN DD
        storeXML();
    }//end insert
    
    
    //delete
    public void deleteCircle() throws IOException{
        List elementList = this.root.getChildren();
        elementList.remove(1);
        
        //FINALMENTE: GUARDAR EN DD
        storeXML();
    }
    
    //metodo para obtener todos los estudiantes en un arreglo
    public ArrayList<Circle> getAllCircles(){
        //obtenemos la cantidad de cuadrados
        int circlesQuantity = this.root.getContentSize();
        //obtenemos una lista con todos los elementos de root
        List elementList = this.root.getChildren();
        
        //definimos el tamanno del arreglo
        ArrayList<Circle> ciclesArray = new ArrayList<>(circlesQuantity);
        
        //recorremos la lista para ir creando los objetos de tipo cuadrado
        int count = 0;
        for(Object currentObject: elementList){
            //transformo el object
            Element currentElement = (Element)currentObject;
            
            //crear el Circle
            Circle currentCircle = new Circle();
            
            //establezco el id
            currentCircle.setIdentification(
                    currentElement.getAttributeValue("identification"));
            
            //establezco la posición
            currentCircle.setxAxis(Integer.parseInt(currentElement.getChild("xAxis").getValue()));
            
            currentCircle.setyAxis(Integer.parseInt(currentElement.getChild("yAxis").getValue()));
            
            //establezco el tamaño
            currentCircle.setSize(Integer.parseInt(currentElement.getChild("size").getValue()));
            
            //guardar en el arreglo
            ciclesArray.add(currentCircle);
            count++;
        }//end for
        return ciclesArray;
    } 
}
