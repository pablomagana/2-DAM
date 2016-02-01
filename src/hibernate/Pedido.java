package hibernate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Pedido {
	private int id;
	private Date fecha;
	private Empresa empresa;
	
	public Pedido(){
		
	}
	
//getters y setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
////
	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
///		
	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
/////imprimir el objeto pedido
	public void printPedido(){
		System.out.println();
		System.out.println("id : "+id);
		System.out.println("fecha : "+fecha);
		System.out.println();
		
	}

}
