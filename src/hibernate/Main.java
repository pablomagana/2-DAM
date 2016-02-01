package hibernate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;

public class Main {

	public static void main(String[] args) {
		//crear la sesion con la base de datos utilizando la clase de Hibernate
		Session session =HibernateUtilities.getSessionFactory().openSession();
		
		//inicial el proceso de transaccion
		session.beginTransaction();
		
		//crear y guardar pedidos en la empresa
		
/////////////primera empresa
		
		long tiempo;
		Date d;
		
		Pedido pedido=null;
		
		Empresa empresa=new Empresa();//crear nueva empresa
		empresa.setCif("cif google");
		empresa.setNombre("Google");
		empresa.setEmpleados(500);
		empresa.setDireccion(new Direccion("calle inventada 789","shelvivill",45852));//crear direccion y aplicar a la empresa creada
		List<Pedido> pedidos=new ArrayList<Pedido>();
		
		for(int i=0;i<5;i++){//crear varios pedidos para la empresa creada anteriormente
			tiempo=System.currentTimeMillis();
			d=new Date(tiempo);
			pedido=new Pedido();
			pedido.setFecha(d);
			
			empresa.addPedido(pedido);
		}
		
		session.save(empresa);/////////////////////guargar empresa
		
///////////segunda empresa
		
		pedido=null;
		
		empresa=new Empresa();
		empresa.setCif("cif yahoo");
		empresa.setNombre("yahoo");
		empresa.setEmpleados(500);
		empresa.setDireccion(new Direccion("calle falsa 123","sprinfield",46456));
		pedidos=new ArrayList<Pedido>();
		
		for(int i=0;i<5;i++){
			tiempo=System.currentTimeMillis();
			d=new Date(tiempo);
			pedido=new Pedido();
			pedido.setFecha(d);
			
			empresa.addPedido(pedido);
		}
		
		session.save(empresa);/////////////////////
		
		//aplicar cambios en la base de datos
		session.getTransaction().commit();
		
		
		System.out.println("----------insercion reaizada----------");
		
		//recuperar objetos
		session.beginTransaction();
		
		//recuperar objetor y guardar
		Empresa e=session.get(Empresa.class, "cif google");//obtener la empresa 
		
		Empresa e2=session.get(Empresa.class, "cif yahoo");//obtener el empresa 2
		
		//imprimir resultados
		System.out.println();
		System.out.println("---resultados de la base de datos---");
		e.printEmpresa();
		System.out.println("---------------------------------------------------");
		e2.printEmpresa();
		
		//aplicar cambios en base de datos
		session.getTransaction().commit();
		
		//la conexion esta configurada para autocerrarse
		session.close();
		
		//cerrar conexion con la clase que gestiona Hibernate
		HibernateUtilities.getSessionFactory().close();
	}

}
