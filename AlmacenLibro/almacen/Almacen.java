package almacen;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Iterator;

public class Almacen {
	private ObjectOutputStream out=null;
	private ObjectInputStream in=null;
	
	public Almacen(){
		
	}
	/*Pablo Magaña*/
	
	public void guardarLibro(Libro libro,String stringfile){
		//intenta crear un archivo con el mismo nombre que el libro imprimiendo un error en caso contrario
		try {
			File file=new File(""+stringfile);
			if(file.exists()){
				System.out.println("Ya existe un fichero con el mismo nombre.");
			}
			//crear un flujo de datos y guarda en el archivo un objeto libro serializable
			out=new ObjectOutputStream(new FileOutputStream(file));
			out.writeObject(libro);
			System.out.println("El libro "+libro.getTitulo()+" se ha guardado correctamente en el archivo "+stringfile);
		} catch (IOException e) {
			System.out.println("Error al guardar el libro "+libro.getTitulo());
		}finally{
			//intenta cerrar el archivo con o sin errores en la escritura
			try {
				out.close();
			}catch(IOException e){
					System.out.println("Advertencia, no se ha podido cerrar el arhivo");
			}
		}
	}
	public Libro recuperarLibro(String filein) throws FileNotFoundException, IOException, ClassNotFoundException{
		// recuperar del archivo con nombre el libro deseado mediante un flujo de datos
			in=new ObjectInputStream(new FileInputStream(new File(filein)));
			Libro libro=(Libro) in.readObject();//guarda el libro en un objeto Libro
			return libro;
	}
	
	public void guardarListaLibros(ArrayList<Libro> libros){
		// recibe una lista de libros
		String nombreArchivo="listalibros";
		//comprueba que el archivo no exista y en caso contrario añade versiones al archivo hasta conseguir un archivo unico
		int version=0;
		File listaLibros=new File(nombreArchivo);
		if(listaLibros.exists()){
			System.out.println("Ya existe un archivo con es nombre");
			while(listaLibros.exists()==true){
				version++;
				listaLibros=new File(nombreArchivo+"-"+version);
			}
			System.out.println("La lista se guardara en el archivo : " +nombreArchivo+"-"+version);
		}else{
			System.out.println("La lista se guardara en el archivo : " +nombreArchivo);
		}
		
		
		try {//abre un flujo de datos para guardar los libros
			out=new ObjectOutputStream(new FileOutputStream(listaLibros));
		} catch (IOException e) {
			System.out.println("Error al abrir el archivo para guardar la lista de libros");
		}
		try {//recorre la lista de libros para guardarlos uno a uno en el archivo
		Iterator iteratorLibros=libros.iterator();
		while(iteratorLibros.hasNext()){
			Libro libro=(Libro) iteratorLibros.next();
			out.writeObject(libro);
		}
		} catch (IOException e) {
			System.out.println("Error al escribir la lista de nombres en el archivo");
		}finally{
			try {//cierra flujos de datos
				out.close();
			} catch (IOException e) {System.out.println("Advertencia, no se ha podido cerrar el archivo");}
		}
		System.out.println("La lista de libros se ha guardado con exito");
	}

	
	public void modificarTitulo(String fileLibro,String newTitulo) throws FileNotFoundException, ClassNotFoundException, IOException{
		Libro libroAModificar=null;
		try{
			libroAModificar=recuperarLibro(fileLibro);
		}catch(Exception e){
			System.out.println("imposible recuparar el libro que quieres modificar");
		}
		libroAModificar.setTitulo(newTitulo);
		out=new ObjectOutputStream(new FileOutputStream(fileLibro));
		out.writeObject(fileLibro);
		System.out.println("El libro '"+fileLibro+"' ha cambiado el titulo a '"+newTitulo+"'  con exito");
	}
	public void modificarAutor(String fileLibro,String newAutor) throws FileNotFoundException, ClassNotFoundException, IOException{
		Libro libroAModificar=null;
		try{
			libroAModificar=recuperarLibro(fileLibro);
		}catch(Exception e){
			System.out.println("imposible recuparar el libro que quieres modificar");
		}
		libroAModificar.setAutor(newAutor);
		out=new ObjectOutputStream(new FileOutputStream(fileLibro));
		out.writeObject(fileLibro);
		System.out.println("El libro '"+fileLibro+"' ha cambiado el autor por '"+newAutor+"' con exito");
	}
	
}
