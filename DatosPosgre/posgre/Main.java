package posgre;

public class Main {

	public static void main(String[] args) {
		System.out.println("pablo magaña");
		Posgre p=Posgre.getInstance();
		p.introducirDatos(new String[]{"AAD","4a","2015-09-12","2015-09-21","true"});
		p.introducirDatos(new String[]{"AAD","4a","2015-09-12","2015-09-21","false"});
		p.introducirDatos(new String[]{"DDI","4a","2015-09-12","2015-09-21","false"});
		p.introducirDatos(new String[]{"PMM","4a","2015-09-12","2015-09-21","true"});
		//leer los datos 
		p.leerPosgre();
		//cerrar conexion con la base de datos
		p.cerrar();

	}

}
