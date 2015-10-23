package almacen;

import java.util.ArrayList;
import java.util.Iterator;

public class Main {
	static Almacen almacen;
	public static void main(String[] args) {
		Libro libro1=new Libro("titulo 1","autor 1",1995,"editor 1",200);
		Libro libro2=new Libro("titulo 2","autor 2",1545,"editor 2",194);
		Libro libro3=new Libro("titulo 3","autor 3",1585,"editor 3",758);
		Libro libro4=new Libro("titulo 4","autor 4",1495,"editor 4",1547);
		Libro libro5=new Libro("titulo 5","autor 5",1345,"editor 5",85);
		almacen=new Almacen();
		
//Guardar Libro individual
		//almacen.guardarLibro(libro1,libro1.getTitulo());
		
//Recuperar Libro individual
	/*
		try{
			Libro l=almacen.recuperarLibro(libro1.getTitulo());
				System.out.print("Titulo: "+l.getTitulo()+" / ");
				System.out.print("  Autor: "+l.getAutor()+" / ");
				System.out.print("  Año de publicación: "+l.getPublicacion()+" / ");
				System.out.print("  Editor: "+l.getEditor()+" / ");
				System.out.print("  N paginas: "+l.getNpaginas());
			
		}catch(Exception e){
			System.out.println("se ha producido un error al recuperar el libro.");
		}
	*/
//Guardar Libros
		/*
		ArrayList<Libro> listaLibros=new ArrayList<Libro>();
		listaLibros.add(libro1);
		listaLibros.add(libro2);
		listaLibros.add(libro3);
		listaLibros.add(libro4);
		listaLibros.add(libro5);
		almacen.guardarListaLibros(listaLibros);
		*/
//modificar Titulo
		almacen.guardarLibro(libro2,libro2.getTitulo());
		try{
			almacen.modificarTitulo(libro2.getTitulo(), "Titulo cambiado de nombre");
		}catch(Exception e){
			System.out.println("error al recuperar el libro a modificar, comprueba que esta guardado");
		}
		
//modificar Autor
		
		almacen.guardarLibro(libro3,libro3.getTitulo());
		try{
			almacen.modificarAutor(libro3.getTitulo(), "Autor cambiado de nombre");
		}catch(Exception e){
			System.out.println("error al recuperar el libro a modificar, comprueba que esta guardado");
		}
		
	}
	
}
