package hibernate;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtilities {
	//clase encargada de crear y conectar la sesion con la base de datos
	
	private static SessionFactory sessionFactory = buildSessionFactory();
		
	private static SessionFactory buildSessionFactory(){//crear session con la base de datos segun la configuracion cfg
		try{
			StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
			Metadata metadata = new MetadataSources(standardRegistry).getMetadataBuilder().build();
			return metadata.getSessionFactoryBuilder().build();
		}catch(HibernateException e){
			System.out.println("Problema creando SessionFactory "+e);
		}
		return sessionFactory;
	}
	
	public static SessionFactory getSessionFactory(){
		return sessionFactory;
	}
}