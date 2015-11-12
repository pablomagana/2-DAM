package basedatos;

public class Datos {
	//Driver tipo 4
	//inicializar variables de la conexion
	Connection conexion=null;
	Statement statement=null;
	ResultSet resultados=null;
	//parametron para la conexion
	String url="jdbc:mysql://localhost/";
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
	}
}
