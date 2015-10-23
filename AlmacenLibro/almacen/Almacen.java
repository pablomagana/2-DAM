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
	
	public void guardarLibro(Libro libro,String stringfile){
		try {
			File file=new File(""+stringfile);
			if(file.exists()){
				System.out.println("Ya existe un fichero con el mismo nombre.");
			}
			out=new ObjectOutputStream(new FileOutputStream(file));
			out.writeObject(libro);
			System.out.println("El libro "+libro.getTitulo()+" se ha guardado correctamente en el archivo "+stringfile);
		} catch (IOException e) {
			System.out.println("Error al guardar el libro "+libro.getTitulo());
		}finally{
			try {
				out.close();
			}catch(IOException e){
					System.out.println("Advertencia, no se ha podido cerrar el arhivo");
			}
		}
	}
	public Libro recuperarLibro(String filein) throws FileNotFoundException, IOException, ClassNotFoundException{
			in=new ObjectInputStream(new FileInputStream(new File(filein)));
			Libro libro=(Libro) in.readObject();
			return libro;
	}
	
	public void guardarListaLibros(ArrayList<Libro> libros){
		String nombreArchivo="listalibros";
		int version=0;
		File listaLibros=new File(nombreArchivo);
		if(listaLibros.exists()){
			System.out.println("Ya existe un archivo con es nombre");
			while(listaLibros.exists()==true){
				version++;
				listaLibros=new File(nombreArchivo+"-"+version);
			}
			System.out.println("La lista se guardara en el archivo" +nombreArchivo+"-"+version);
		}else{
			System.out.println("La lista se guardara en el archivo" +nombreArchivo);
		}
		
		
		try {
			out=new ObjectOutputStream(new FileOutputStream(listaLibros));
		} catch (IOException e) {
			System.out.println("Error al abrir el archivo para guardar la lista de libros");
		}
		try {
		Iterator iteratorLibros=libros.iterator();
		while(iteratorLibros.hasNext()){
			Libro libro=(Libro) iteratorLibros.next();
			out.writeObject(libro);
		}
		} catch (IOException e) {
			System.out.println("Error al escribir la lista de nombres en el archivo");
		}finally{
			try {
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
		System.out.println("Titulo modificado  con exito");
	}
	public void modificarAutor(String fileLibro,String newAutor) throws FileNotFoundException, ClassNotFoundException, IOException{
		Libro libroAModificar=null;
		try{
			libroAModificar=recuperarLibro(fileLibro);
		}catch(Exception e){
			System.out.println("imposible recuparar el libro que quieres modificar");
		}
		
		new File(fileLibro).delete();
		String tituloOriginal=fileLibro;
		libroAModificar.setAutor(newAutor);
		guardarLibro(libroAModificar,tituloOriginal);
		System.out.println("Autor modificado con exito");
	}
	
}
