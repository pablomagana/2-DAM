package basedatos;

public class Datos {
	//Driver tipo 4
	//inicializar variables de la conexion
	Connection conexion=null;
	Statement statement=null;
	ResultSet resultados=null;
	//parametron para la conexion
	static String url="jdbc:mysql://localhost/DAM";
	static String user="root";
	static String pw = "root";
	
	public Datos(){
		
	}
	
	public void cargarControlador(){
		try{
			//cargar el driver de conexion con la base de datos durante la ejecución
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException e){
			System.out.println("Error al cargar el controlador");
		}
	}
	
	public void introducirDatos(String[] arg){
		//crear la conexion con la base de datos mediante el driveManager
		try{
			conexion=DriverManager.getConnection(url,user,pw);
			System.out.println("conecion realizada con exito");
			statement=(Statement) conexion.createStatement();
			statement.executeQuery("insert into dam(asignatura,nombre,inicio,fin,entregada) values('"+arg[0]+"','"+arg[1]+"',"+arg[2]+","+arg[3]+","+arg[4]+")");
		}catch(SQLException e){
			if(e.getSQLState().equals("28000"))
				System.out.println("Error de autentificación");
			else 
				throw e;
			e.printStackTrace();
		}finally {
			try{
				if(instruccion!=null && !instruccion.isClosed())
					instruccion.close();
			}catch(SQLException e){}
			try{
				if(conexion!=null && !conexion.isClosed())
					conexion.close();
			}catch(SQLException e){}
		}
	}
	
	public ArrayList<String> leerDatos(){
		ArrayList<String> arrayListResultados=new ArrayList<String>();
		//crear la conexion con la base de datos mediante el driveManager
		try{
			conexion=DriverManager.getConnection(url,user,pw);
			System.out.println("conecion realizada con exito");
			statement=(Statement) conexion.createStatement();
			resultados=statement.executeQuery("insert into dam(asignatura,nombre,inicio,fin,entregada) values('"+arg[0]+"','"+arg[1]+"',"+arg[2]+","+arg[3]+","+arg[4]+")");
			//iterar resultados
			Iterator i=(String) resultados.iterator();
			while(i.hasNext()){
				//
			}
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
				Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, "error al cerrar los resultados", e);
			}
			try{
				if(instruccion!=null && !instruccion.isClosed())
					instruccion.close();
			}catch(SQLException e){}
			try{
				if(conexion!=null && !conexion.isClosed())
					conexion.close();
			}catch(SQLException e){}
		}
	}
	
}
