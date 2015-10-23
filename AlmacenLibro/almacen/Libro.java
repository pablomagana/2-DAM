package almacen;

import java.io.Serializable;

public class Libro implements Serializable {
	String titulo;
	String autor;
	int publicacion;
	String editor;
	int npaginas;
	
	public Libro(String titulo, String autor, int publicacion, String editor,int npaginas) {
		this.titulo = titulo;
		this.autor = autor;
		this.publicacion = publicacion;
		this.editor = editor;
		this.npaginas = npaginas;
	}

	public Libro(){
		
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
	public int getPublicacion() {
		return publicacion;
	}
	public void setPublicacion(int publicacion) {
		this.publicacion = publicacion;
	}
	public String getEditor() {
		return editor;
	}
	public void setEditor(String editor) {
		this.editor = editor;
	}
	public int getNpaginas() {
		return npaginas;
	}
	public void setNpaginas(int npaginas) {
		this.npaginas = npaginas;
	}
	
}
