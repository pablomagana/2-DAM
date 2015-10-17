package almacen;

public class Main {
	private static int idLibro=0;
	public static void main(String[] args) {
		new Almacen();

	}
	public static String asignarId(){
		idLibro++;
		return String.valueOf(idLibro);
	}
}
