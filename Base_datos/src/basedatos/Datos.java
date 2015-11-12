package basedatos;

public class Datos {
	//Driver tipo 4
	//inicializar variables de la conexion
	Connection conexion=null;
	Statement statement=null;
	ResultSet resultados=null;
	//parametron para la conexion
	String url="jdbc:mysql://localhost/DAM";
	String user="root";
	String pw = "root";
	try{
		//cargar el driver de conexion con la base de datos durante la ejecución
		Class.forName("com.mysql.jdbc.Driver");
	}catch(ClassNotFoundException e){
		System.out.println("Error al cargar el controlador");
	}
	
	//crear la conexion con la base de datos mediante el driveManager
	try{
		conexion=DriverManager.getConnection(url,user,pw);
		System.out.println("conecion realizada con exito");
		statement=(Sttement) conexion.createStatement();
		resultados=statement.executeQuery("select * from tal")
	}catch(SQLException e){
		if(e.getSQLState().equals("28000"))
			System.out.println("Error de autentificación");
		else 
			throw e;
		e.printStackTrace();
	}finally {
		try{
			if(conjuntoResultados!=null && !conjuntoResultados.isClosed())
				conjuntoResultados.close();
		}catch(SQLException e){
			Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, e);
		}
		try{
			if(instruccion!=null && !instruccion.isClosed())
				instruccion.close();
		}catch(SQLException e){
			
		}
		try{
			if(conexion!=null && !conexion.isClosed())
				conexion.close();
		}catch(SQLException e){
			
		}
	}
}
