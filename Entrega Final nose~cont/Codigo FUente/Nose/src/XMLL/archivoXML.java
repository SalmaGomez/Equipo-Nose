package XMLL;

/** Esta clase es un TDA que permite manipular archivo XML
 * Version 3.0
 * Se agrego los espacios de nombre para la inclusión de prefijos
 * Se agregaron las opciones:
 * -Crear nodo
 * -Agregar un nodo
 * -Remover un nodo
 * -Asignar un atributo
 */


import com.sun.org.apache.xerces.internal.parsers.DOMParser;
import com.sun.org.apache.xml.internal.serialize.*;
import com.sun.org.apache.xml.internal.serialize.XMLSerializer;
import java.io.*;
import java.util.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.*;
import org.w3c.dom.*;

/**
 *
 * 
 * Basado en http://www.drdobbs.com/jvm/easy-dom-parsing-in-java/231002580
 * http://www.drdobbs.com/jvm/creating-and-modifying-xml-in-java/240150782
 * http://www.mkyong.com/java/how-to-create-xml-file-in-java-dom/
 * http://crunchify.com/java-simple-way-to-write-xml-dom-file-in-java/
 */
public class archivoXML {
    DocumentBuilderFactory docFactory ;
    DocumentBuilder docBuilder;
    Document documentDOM;
    DOMParser analyzerDOM;
    String pathFile;
    
    /** Constructor por defecto */
    public archivoXML(String ruta){
        this.pathFile=ruta;
    }
    
    //Manipulación XML ---------------------------------------------------
    /** Abrimos un archivo XML para manipularlo */
    public boolean open(){
        try{
            boolean exist=new File(this.pathFile).exists();
            if(!exist){
               this.create("root");
            }
            analyzerDOM = new DOMParser();
            analyzerDOM.parse(this.pathFile);
            documentDOM = analyzerDOM.getDocument();
            return true;
        }catch(Exception error){
           System.out.println(error.toString());
           return false; 
        }    
    }
    
    /** Cierra el archivo XML y guarda los cambios */
    public void close() throws IOException{
        documentDOM = analyzerDOM.getDocument();
        OutputFormat format = new OutputFormat(documentDOM);
        format.setIndenting(true);
        XMLSerializer serializer = new XMLSerializer(
        new FileOutputStream(new File(this.pathFile)), format);
        serializer.serialize(documentDOM);
    }
    
    //Creacion de XML-------------------------------------
    /** Crea un nuevo archivo XML con un nodo raiz "labelRoot" */
    public boolean create(String labelRoot){
        try{
            docFactory = DocumentBuilderFactory.newInstance();
            docBuilder = docFactory.newDocumentBuilder();
            documentDOM = docBuilder.newDocument();
            Element rootElement = documentDOM.createElement(labelRoot);
            documentDOM.appendChild(rootElement);
            // write the content into xml file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(documentDOM);
            StreamResult result = new StreamResult(new File(this.pathFile));
            transformer.transform(source, result);
            return true;
        }catch(Exception error){
            System.out.println(error.toString());
            return false;
        }
    }
	/** Crea un nuevo archivo XML con un nodo raiz "labelRoot" y un prefijo*/
    public boolean create(String labelRoot, String URI, String prefijo){
        try{
            docFactory = DocumentBuilderFactory.newInstance();
            docBuilder = docFactory.newDocumentBuilder();
            documentDOM = docBuilder.newDocument();
            Element rootElement = documentDOM.createElementNS(URI,prefijo+":"+labelRoot);
            documentDOM.appendChild(rootElement);
            // write the content into xml file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(documentDOM);
            StreamResult result = new StreamResult(new File(this.pathFile));
            transformer.transform(source, result);
            return true;
        }catch(Exception error){
            System.out.println(error.toString());
            return false;
        }
    }
    //Obtencion y asignaccion de nodos ---------------------------------
    /** Obtiene el nodo raiz */
    public NodeList getRoot(){
            NodeList root = documentDOM.getChildNodes();
            return root;
    }
    
    /** Obtiene el nodo identificado por "tagName" de una lista de nodos*/
    public Node getNode(String tagName, NodeList nodes) {
        for ( int x = 0; x < nodes.getLength(); x++ ) {
            Node node = nodes.item(x);
            if (node.getNodeName().equalsIgnoreCase(tagName)) {
                return node;
            }
        }

        return null;
    }
    
    /** Obtiene la lista de nodos identificados por "tagName" de una lista de nodos*/
    public List<Node> getListNode(String tagName, NodeList nodes) {
        List<Node> lista=new ArrayList<>();
        for ( int x = 0; x < nodes.getLength(); x++ ) {
            Node node = nodes.item(x);
            if (node.getNodeName().equalsIgnoreCase(tagName)) {
                lista.add(node);
            }
        }
        return lista;
    }

    
    /** Obtiene el valor o contenido de un nodo*/
    public String getNodeValue( Node node ) {
        NodeList childNodes = node.getChildNodes();
        for (int x = 0; x < childNodes.getLength(); x++ ) {
            Node data = childNodes.item(x);
            if ( data.getNodeType() == Node.TEXT_NODE )
                return data.getNodeValue().trim();
        }
        return "";
    }
    
    /** Obtiene el valor o contenido de un nodo*/
    public String getNodeValue(String tagName, NodeList nodes ) {
        for ( int x = 0; x < nodes.getLength(); x++ ) {
            Node node = nodes.item(x);
            if (node.getNodeName().equalsIgnoreCase(tagName)) {
                NodeList childNodes = node.getChildNodes();
                for (int y = 0; y < childNodes.getLength(); y++ ) {
                    Node data = childNodes.item(y);
                    if ( data.getNodeType() == Node.TEXT_NODE )
                        return data.getNodeValue().trim();
                }
            }
        }
        return "";
    }
    
    /** Obtiene el valor del ATRIBUTO de un nodo*/
    public String getNodeAttr(String attrName, Node node ) {
        NamedNodeMap attrs = node.getAttributes();
        for (int y = 0; y < attrs.getLength(); y++ ) {
            Node attr = attrs.item(y);
            if (attr.getNodeName().equalsIgnoreCase(attrName)) {
                return attr.getNodeValue();
            }
        }
        return "";
    }
    
    /** Obtiene el valor del ATRIBUTO de una lista de nodos*/
    public String getNodeAttr(String tagName, String attrName, NodeList nodes ) {
        for ( int x = 0; x < nodes.getLength(); x++ ) {
            Node node = nodes.item(x);
            if (node.getNodeName().equalsIgnoreCase(tagName)) {
                NodeList childNodes = node.getChildNodes();
                for (int y = 0; y < childNodes.getLength(); y++ ) {
                    Node data = childNodes.item(y);
                    if ( data.getNodeType() == Node.ATTRIBUTE_NODE ) {
                        if ( data.getNodeName().equalsIgnoreCase(attrName) )
                            return data.getNodeValue();
                    }
                }
            }
        }
        return "";
    }
    
    /** Agrega un nuevo nodo a un nodo existente(parent)*/
    public void addNode(String tagName, String value, Node parent) {
        Document dom = parent.getOwnerDocument();
        // Create a new Node with the given tag name
        Node node = dom.createElement(tagName);
        // Add the node value as a child text node
        Text nodeVal = dom.createTextNode(value);
        node.appendChild(nodeVal);
        // Add the new node structure to the parent node
        parent.appendChild(node);
    }
    
    /** Asigna el valor o contenido de una lista de nodos*/   
    public void setListValue(String tagName, String value, NodeList nodes) {
        List<Node> nodos = getListNode(tagName, nodes);
        if ( nodos.size()>0 ){
            for(Node nodo:nodos){
                // Locate the child text node and change its value
                NodeList childNodes = nodo.getChildNodes();
                for (int y = 0; y < childNodes.getLength(); y++ ) {
                    Node data = childNodes.item(y);
                    if ( data.getNodeType() == Node.TEXT_NODE ) {
                        data.setNodeValue(value);
                    }
                }
            }
        }
    }
    
    /** Asigna el valor o contenido de una lista de nodos*/   
    public void setNodeValue(String value, Node node) {
                // Locate the child text node and change its value
                NodeList childNodes = node.getChildNodes();
                for (int y = 0; y < childNodes.getLength(); y++ ) {
                    Node data = childNodes.item(y);
                    if ( data.getNodeType() == Node.TEXT_NODE ) {
                        data.setNodeValue(value);
                        break;
                    }
                }
    }
    
    //Consultas de Xpath
    /** Ejecuta una consulta con Xpath sobre el archivo XML y obtiene la lista de nodos correspondientes*/ 
    public List<Node> queryXpath(String consultaXpath){
        try{
            XPath consulta=XPathFactory.newInstance().newXPath();
            //Asignar la consulta Xpath
            XPathExpression expresion=consulta.compile(consultaXpath);
            //Ejecutar la consulta Xpath
            Object resultado=
                    expresion.evaluate(documentDOM,XPathConstants.NODESET);
           //Empaquetamos el resultado en el vector
            NodeList nodos=(NodeList) resultado;
            List<Node> resultados=new ArrayList<>();
            for(int i=0; i<nodos.getLength(); i++)
                resultados.add(nodos.item(i));
            return resultados;
        }catch(Exception error){
            System.out.println(error.toString());
            return null;
        }
    }
    
    /**Asigna un atributo al nodo**/
    public void setAtribute(Node nodo, String atributo, String valor){
        //Convertimos el nodo a Element para manipularlo
        if (nodo.getNodeType() == Node.ELEMENT_NODE) {
                    Element elem = (Element) nodo;
                    elem.setAttribute(atributo, valor);
                }
    }
    
    /**Remueve un nodo de los hijo de un nodo principal**/
    public void removeNode(Node padre, Node hijo){
        padre.removeChild(hijo);
    }
    
    /**Agregar un nodo existente a un padre**/
    public void addNode(Node padre, Node hijo){
        padre.appendChild(hijo);
    }
    
    /**Crea un nuevo nodo**/
    public Node createNode(String etiqueta,String valor){
        // Create a new Node with the given tag name
        Node node = documentDOM.createElement(etiqueta);
        // Add the node value as a child text node
        Text nodeVal = documentDOM.createTextNode(valor);
        node.appendChild(nodeVal);
        return node;
    }
}
