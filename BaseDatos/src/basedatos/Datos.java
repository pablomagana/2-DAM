package basedatos;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Datos {
	//Driver tipo 4
	
	//instance
	static Datos instance=null;
	//inicializar variables de la conexion
	java.sql.Connection conexion=null;
	Statement statement=null;
	ResultSet resultados=null;
	//parametron para la conexion
	static String url="jdbc:mysql://localhost/datos";
	static String user="root";
	static String pw = "";
	
	private Datos() {
		cargarControlador();
		try {
			conexion=DriverManager.getConnection(url,user,pw);
			//System.out.println("conecion realizada con exito");
		} catch (SQLException e) {
			System.out.println("error al realizar la conexion");
			e.printStackTrace();
		}
		
		try {
			statement=(Statement) conexion.createStatement();
		} catch (SQLException e) {
			System.out.println("error al crear el statement");
			e.printStackTrace();
		}
	}
	public static Datos getInstance(){
		if(instance==null){
			instance=new Datos();
		}
		return instance;
	}
	
	public void cargarControlador(){
		try{
			//cargar el driver de conexion con la base de datos durante la ejecución
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException e){
			System.out.println("Error al cargar el controlador");
		}
	}
	public void erroresSQL(SQLException e){
		switch (e.getSQLState()) {
		case "28000":
			System.out.println("error de autentificaciÃ³n");
			break;
		case "42000":
			System.out.println("error con la base de datos");
			break;
		case "08S01":
			System.out.println("Servidor de base de datos apagado");
			break;
		default:
			e.printStackTrace();
			break;
		}
	}
	public void cerrar(){
		try{
			if(resultados!=null && !resultados.isClosed())
				resultados.close();
		}catch(SQLException e){
			Logger.getLogger(Collection.class.getName()).log(Level.SEVERE, "error al cerrar los resultados", e);
		}
		try{
			if(statement!=null && !statement.isClosed())
				statement.close();
		}catch(SQLException e){}
		try{
			if(conexion!=null && !conexion.isClosed())
				conexion.close();
		}catch(SQLException e){}
	}
	
	public void introducirDatos(String[] arg){
		//crear la conexion con la base de datos mediante el driveManager
		try{
			
			//statement.execute("insert into atc (asignatura,nombre,inicio,fin,entregada) values('asignatura','nombre','1111-11-01','1555-09-02',false);");
			statement.execute("insert into atc(asignatura,nombre,inicio,fin,entregada) values('"+arg[0]+"','"+arg[1]+"','"+arg[2]+"','"+arg[3]+"',"+arg[4]+");");
			System.out.println("inserción de dase de datos realizada con exito");
		}catch(SQLException e){
			
		}finally {
			//cerrar();
		}
	}
	
	public void leerDatos(){
		ArrayList<String> arrayListResultados=new ArrayList<String>();
		//crear la conexion con la base de datos mediante el driveManager
		try{
			resultados=statement.executeQuery("select * from atc");
			//iterar resultados
			System.out.println("asignatura"+"\t"+"nombre"+"\t"+"inicio"+"\t\t"+"fin"+"\t\t"+"entregada");
			while(resultados.next()){
				System.out.println(resultados.getObject("asignatura")+"\t\t"+resultados.getObject("nombre")+"\t"+resultados.getObject("inicio")+"\t"+resultados.getObject("fin")+"\t"+resultados.getObject("entregada"));
			}
		}catch(SQLException e){
			if(e.getSQLState().equals("28000"))
				System.out.println("Error de autentificaciÃ³n");
			else {
				try {
					throw e;
				} catch (SQLException e1) {
				}
			}
				
			e.printStackTrace();
		}finally {
			//cerrar();
		}
	}
	
}
