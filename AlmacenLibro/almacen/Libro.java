package almacen;

import java.io.Serializable;

public class Libro implements Serializable {
	String id;
	String titulo;
	String autor;
	String publicacion;
	String editor;
	String npaginas;
	
	public Libro(String id,String titulo,String autor,String publicacion,String editor,String npaginas){
		
	}
	public Libro(){
		
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getPublicacion() {
		return publicacion;
	}
	public void setPublicacion(String publicacion) {
		this.publicacion = publicacion;
	}
	public String getEditor() {
		return editor;
	}
	public void setEditor(String editor) {
		this.editor = editor;
	}
	public String getNpaginas() {
		return npaginas;
	}
	public void setNpaginas(String npaginas) {
		this.npaginas = npaginas;
	}
	
}
