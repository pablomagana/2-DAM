package basedatos;

public class Main {

	public static void main(String[] args) {
		System.out.println("pablo magaña");
		Datos d=Datos.getInstance();
		//String[] actividad=new String[]{"acceso base de datos","4a","2015-09-12","2015-09-21","0"};
		d.introducirDatos(new String[]{"AAD","4a","2015-09-12","2015-09-21","true"});
		d.introducirDatos(new String[]{"AAD","4a","2015-09-12","2015-09-21","false"});
		d.introducirDatos(new String[]{"DDI","4a","2015-09-12","2015-09-21","false"});
		d.introducirDatos(new String[]{"PMM","4a","2015-09-12","2015-09-21","true"});
		//leer los datos 
		d.leerDatos();
		//cerrar conexion con la base de datos
		d.cerrar();
	}

}