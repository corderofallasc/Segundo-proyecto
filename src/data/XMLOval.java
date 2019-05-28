/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import domain.Oval;
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

public class XMLOval {
    
    //variables
    private Document document;
    private Element root;
    private String path;

    public XMLOval(String path) throws IOException, JDOMException {
        //ruta en la que se encuentra el archivo XML
        this.path = path;
        File fileOval = new File(path);//esto es solo para hacer validacion
        if(fileOval.exists()){
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
            this.root = new Element("ovals");
            
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
    
    //metodo para insertar un nuevo circulo en el documento xml
    public void insertOval(Oval oval) throws IOException{
        //INSERTAMOS EN EL DOCUMENTO EN MEMORIA
        //para insertar en xml, primero se crean los elementos
        
        //crear el cuadrado
        Element eOval = new Element("oval");
        //agregamos atributo
        eOval.setAttribute("identification", oval.getIdentification());
        
        //creamos el elemento de las posiciones
        Element eXAxis = new Element("xAxis");
        eXAxis.addContent(String.valueOf(oval.getxAxis()));
        
        Element eYAxis = new Element("yAxis");
        eYAxis.addContent(String.valueOf(oval.getyAxis()));
        
        //creamos el elemento tamaño
        Element eSizeX = new Element("sizeX");
        eSizeX.addContent(String.valueOf(oval.getSizeX()));
        
        Element eSizeY = new Element("sizeY");
        eSizeY.addContent(String.valueOf(oval.getSizeY()));
        
        //agregar al elemento square el contenido de punto y tamaño2
        eOval.addContent(eXAxis);
        eOval.addContent(eYAxis);
        eOval.addContent(eSizeX);
        eOval.addContent(eSizeY);
        
        //AGREGAMOS AL ROOT
        this.root.addContent(eOval);
        
        //FINALMENTE: GUARDAR EN DD
        storeXML();
    }//end insert
    
    
    //delete
    public void deleteOval() throws IOException{
        List elementList = this.root.getChildren();
        elementList.remove(1);
        
        //FINALMENTE: GUARDAR EN DD
        storeXML();
    }
    
    //metodo para obtener todos los ovalos en un arreglo
    public ArrayList<Oval> getAllOvals(){
        //obtenemos la cantidad de cuadrados
        int ovalsQuantity = this.root.getContentSize();
        //obtenemos una lista con todos los elementos de root
        List elementList = this.root.getChildren();
        
        //definimos el tamanno del arreglo
        ArrayList<Oval> ovalsArray = new ArrayList<>(ovalsQuantity);
        
        //recorremos la lista para ir creando los objetos de tipo ovalo
        int count = 0;
        for(Object currentObject: elementList){
            //transformo el object
            Element currentElement = (Element)currentObject;
            
            //crear el cuadrado
            Oval currentOval = new Oval();
            
            //establezco el id
            currentOval.setIdentification(
                    currentElement.getAttributeValue("identification"));
            
            //establezco la posición
            currentOval.setxAxis(Integer.parseInt(currentElement.getChild("xAxis").getValue()));
            
            currentOval.setyAxis(Integer.parseInt(currentElement.getChild("yAxis").getValue()));
            
            //establezco el tamaño
            currentOval.setSizeX(Integer.parseInt(currentElement.getChild("sizeX").getValue()));
            currentOval.setSizeY(Integer.parseInt(currentElement.getChild("sizeY").getValue()));
            
            //guardar en el arreglo
            ovalsArray.add(currentOval);
            count++;
        }//end for
        return ovalsArray;
    }
    
}
