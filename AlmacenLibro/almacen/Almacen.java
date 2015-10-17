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

public class Almacen {
	private ObjectOutputStream out=null;
	private ObjectInputStream in=null;
	
	public Almacen(){
		Libro libro1=new Libro();
		Libro libro2=new Libro();
		Libro libro3=new Libro();
		Libro libro4=new Libro();
		Libro libro5=new Libro();
	}
	
	private void guardarLibro(Libro libro){
		try {
			out=new ObjectOutputStream(new FileOutputStream(libro.getId()));
			out.writeObject(libro);
		} catch (IOException e) {
			System.out.println("Error al guardar el libro "+libro.getTitulo());
		}finally{
			try {out.close();} catch (IOException e) {}
		}
	}
	private Libro recuperarLibro(String filein){
		try {
			in=new ObjectInputStream(new FileInputStream(filein));
			Libro libro=(Libro) in.readObject();
			return libro;
		} catch (IOException |ClassNotFoundException e) {
			System.out.println("Error al leer el libro");
		}
		return null;
		
	}
	private void guardarListaLibros() throws IOException{
		File listaLibros=new File("listalibros.txt");
		BufferedWriter bufferedfile=new BufferedWriter(new FileWriter(listaLibros));
		//por aqui iii
	}
	private void modificarTitulo(String fileLibro,String newTitulo){
		Libro libroAModificar=recuperarLibro(fileLibro);
		libroAModificar.setTitulo(newTitulo);
		guardarLibro(libroAModificar);
	}
	private void modificarAutor(String fileLibro,String newAutor){
		Libro libroAModificar=recuperarLibro(fileLibro);
		libroAModificar.setAutor(newAutor);
		guardarLibro(libroAModificar);
	}
	
}
