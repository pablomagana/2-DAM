import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public class Parseador {
	/*Pablo Magaña*/
	private Document dom;
	private ArrayList<Libro> libros;
	public Parseador(){
		libros=new ArrayList<Libro>();
	}
	
	public void parsearFicheroXml(String fichero){
		DocumentBuilderFactory dbf= DocumentBuilderFactory.newInstance();
		DocumentBuilder db;	
		try {
				db=dbf.newDocumentBuilder();
				//obtener dom del fichero
				dom=db.parse("bliblioteca.xml");
			} catch (SAXException | IOException |ParserConfigurationException e) {
				e.printStackTrace();
			}
		
	}
	
	
	public void parsearBiblioteca(){
		// elemento raiz
		Element elementoraiz=dom.getDocumentElement();
		
		//lista de elementos dentro del elemento raiz(todos los libros que tiene)
		NodeList listaelementoslibro=elementoraiz.getElementsByTagName("libro");
		//recorrer cada libro
		for(int i=0;i<listaelementoslibro.getLength();i++){
			//obtener elemento i libro
			Element elemento=(Element) listaelementoslibro.item(i);
			
			//transformo elemento libro en objeto libro
			Libro l=getLibro(elemento);
			//añado a array de libros
			libros.add(l);
		}
		System.out.println("bliblioteca.xml parseada con exito");
	}
	public Libro getLibro(Element elementoLibro){
		//extraer todos los valores del libro
		String stringTitlo=getValor(elementoLibro,"titulo");
		
		int intPublicacion=Integer.parseInt(getAtrivute(elementoLibro,"titulo"));
		
		String stringEditor=getValor(elementoLibro,"editor");
		int intpaginas= Integer.parseInt(getValor(elementoLibro,"paginas"));
				
		String stringAutor=getMultiValor(elementoLibro,"autor","nombre");
		Libro libro=new Libro(stringTitlo,stringAutor,intPublicacion,stringEditor,intpaginas);
		return libro;
	}
	
	public String getValor(Element e,String name){
		NodeList nl=e.getElementsByTagName(name);
		Element e1=(Element) nl.item(0);
		String stringValor=e1.getFirstChild().getNodeValue();
		
		return stringValor;
	}
	
	//libro element
	public String getMultiValor(Element e,String name,String subName){
		String nombreCompleto="";
		NodeList listaelements = e.getElementsByTagName(name);
		//obtengo unico nodo de la lista
		Element elemento=(Element) listaelements.item(0);
			
			NodeList listaelements2 = elemento.getElementsByTagName(subName);		
								
			for(int j=0;j<listaelements2.getLength();j++){
				Element elemento2=(Element) listaelements2.item(j);
				String s = elemento2.getTextContent();
				if (j==0) {
					nombreCompleto=nombreCompleto+s;
				}else{
					nombreCompleto=nombreCompleto+" , "+s;
				}
			}

		
		
		
		return nombreCompleto;
	}
	
	
	public String getAtrivute(Element elemento, String name){
		NodeList nle=elemento.getElementsByTagName(name);
		NamedNodeMap lae = nle.item(0).getAttributes();
		String publicacion=lae.item(0).getTextContent();
		return publicacion;
	}
	
	public void print(){

		Iterator iterador = libros.iterator();
		while(iterador.hasNext()) {
			Libro l=(Libro) iterador.next();
			l.print(l);
		}
	}
}
