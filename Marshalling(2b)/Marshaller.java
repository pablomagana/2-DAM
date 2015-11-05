import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;


public class Marshaller {
	private Document dom=null;
	private ArrayList<Libro> libros=null;
	
	public Marshaller(ArrayList<Libro> l){
		libros=l;
	}
	public void crearDocumento(){
		//instancia de DocumentBuilderFactory
		DocumentBuilderFactory docbuifac=DocumentBuilderFactory.newInstance();
		try{
			//Objeto DocumentBuilder
			DocumentBuilder docbuild=docbuifac.newDocumentBuilder();
			
			//Instancia de dom
			dom=docbuild.newDocument();
		}catch(ParserConfigurationException e) {
			System.out.println("error al crear el documento de DOM");
		}
	}
	
	public void estructuraDom(){
		//elemento raiz
		Element docElement=dom.createElement("libros");
		dom.appendChild(docElement);
		
		//recorrer ArrayList
		Iterator i=libros.iterator();
		while(i.hasNext()){
			//extraer objeto
			Libro libro=(Libro) i.next();
			
			//crear elementos para ese objeto
			Element ELibro= newElibro(libro);
			docElement.appendChild(ELibro);
		}
		
	}
	
	public Element newElibro(Libro l){
		
		//Elemento Libro
		Element ElementLibro=dom.createElement("libro");
		
		//crear sub elementos de libro y respectivos nodos de texto y añadir al elemento libro
		Element nombre=dom.createElement("nombre");
		Text textoNombre=dom.createTextNode(l.getTitulo());
		nombre.appendChild(textoNombre);
		ElementLibro.appendChild(nombre);
		
		Element autor=dom.createElement("autor");
		Text textoAutor=dom.createTextNode(l.getAutor());
		autor.appendChild(textoAutor);
		ElementLibro.appendChild(autor);
		
		Element publicacion=dom.createElement("publicacion");
		Text textoPublicacion=dom.createTextNode(l.getPublicacion()+"");
		publicacion.appendChild(textoPublicacion);
		ElementLibro.appendChild(publicacion);
		
		Element editor=dom.createElement("editor");
		Text textoEditor=dom.createTextNode(l.getEditor());
		editor.appendChild(textoEditor);
		ElementLibro.appendChild(editor);
		
		Element paginas=dom.createElement("paginas");
		Text textoPaginas=dom.createTextNode(l.getNpaginas()+"");
		paginas.appendChild(textoPaginas);
		ElementLibro.appendChild(paginas);
		
		return ElementLibro;
	}
	
	public void escribirDocumentoXml(File f){
		//instancia transformer para escribir escribir el dom
		Transformer transformer=null;
		try {
			transformer= TransformerFactory.newInstance().newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");//propiedad que permite que se contemplen los saltos de linea
		} catch (TransformerConfigurationException | TransformerFactoryConfigurationError e) {
			System.out.println("error al escribir el dom en el archivo");
		}
		
		//especificat donde y tipo de datos
		
		StreamResult resultado=new StreamResult(f);
		DOMSource origen=new DOMSource(dom);
		try {
			transformer.transform(origen,resultado);
		} catch (TransformerException e) {
			System.out.println("error al escribir el dom en el archivo");
		}
	}
}
