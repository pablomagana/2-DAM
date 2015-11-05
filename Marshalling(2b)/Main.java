import java.io.File;
import java.util.ArrayList;


public class Main {
	
	public static void main(String[] args) {
		
		ArrayList<Libro> libros;
		libros=new ArrayList<Libro>();
		
		libros.add(new Libro("Introduction to Linux","Machtelt",2008,"O'Reilly",256));
		libros.add(new Libro("El lenguaje de programación C","Kernighan",1991,"Prentice Hall",294));
		
		Marshaller m=new Marshaller(libros);
		m.crearDocumento();
		m.estructuraDom();
		m.escribirDocumentoXml(new File("bibliteca.xml"));
	}

}
