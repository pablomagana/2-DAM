package posgre;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Driver;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.postgresql.core.ConnectionFactory;

public class Posgre {
	
	//Driver tipo 4
	
		//instance
		static Posgre instance=null;
		//inicializar variables de la conexion
		java.sql.Connection conexion=null;
		Statement statement=null;
		ResultSet resultados=null;
		//parametron para la conexion
		static String url="jdbc:postgresql://localhost/datos";
		static String user="postgres";
		static String pw = "000000";
	private Posgre() {
		cargarControlador();
		try {
			conexion=DriverManager.getConnection(url,user,pw);
			System.out.println("conecion realizada con exito a la base de datos PostgreSQL");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			statement=(Statement) conexion.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static Posgre getInstance(){
		if(instance==null){
			instance=new Posgre();
		}
		return instance;
	}
	
	public void cargarControlador(){
		try{
			//cargar el driver de conexion con la base de datos durante la ejecución
			Class.forName("org.postgresql.Driver");
		}catch(ClassNotFoundException e){
			System.out.println("Error al cargar el controlador");
		}
	}
	
	public void erroresSQL(Exception e){
		System.out.println("se ha producido un error con la base de datos.");
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
			statement.execute("insert into actividades(asignatura,nombre,inicio,fin,entregada) values('"+arg[0]+"','"+arg[1]+"','"+arg[2]+"','"+arg[3]+"',"+arg[4]+");");
			System.out.println("inserción de dase de datos realizada con exito");
		}catch(SQLException e){
			
		}finally {
			//cerrar();
		}
	}
	
	public void leerPosgre(){
		ArrayList<String> arrayListResultados=new ArrayList<String>();
		//crear la conexion con la base de datos mediante el driveManager
		try{
			resultados=statement.executeQuery("select * from actividades");
			//iterar resultados
			System.out.println("asignatura"+"\t"+"nombre"+"\t"+"inicio"+"\t\t"+"fin"+"\t\t"+"entregada");
			while(resultados.next()){
				System.out.println(resultados.getObject("asignatura")+"\t\t"+resultados.getObject("nombre")+"\t"+resultados.getObject("inicio")+"\t"+resultados.getObject("fin")+"\t"+resultados.getObject("entregada"));
			}
		}catch(SQLException e){
			if(e.getSQLState().equals("28000"))
				System.out.println("Error de autentificación");
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
