import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.w3c.dom.NodeList;

public class Main {

	public static void main(String[] args) {
		//http://www.pccomponentes.com/
		
		Document html=null;
		try{//conecto con el documento html en red y lodescargo
			html=Jsoup.connect("http://www.pccomponentes.com").get();
		}catch(Exception e){
			
		}
		//capturo el titulo del html
		System.out.println(html.title());
		System.out.println("");
		
		//obtener lista con todos los elementos de los productos y otra paa los precios
		ArrayList<Element> articulosPrecio=html.getElementsByClass("preciosProductos");
		ArrayList<Element> articulosNombre=html.getElementsByClass("nombre");
		//al extraerse los nombre y los precios de los productos con el mismo orden los puedo relacionar
		
		//iterador productos
				Iterator it2=articulosNombre.iterator();
		//iterador precios
				//se recorren a la par los dos iteradores y se imprime el producto junto con el precio
				Iterator it=articulosPrecio.iterator();
				while(it2.hasNext()){
					Element e2=(Element) it2.next();
					Element e=(Element) it.next();
					System.out.println("Contenido: "+e2.text()+" - "+" Precio: "+e.text());
				}
		
		
	}

}
