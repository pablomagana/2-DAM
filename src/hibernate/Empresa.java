package hibernate;

import java.util.ArrayList;
import java.util.List;

public class Empresa {
	private String cif;
	private String nombre;
	private int empleados;
	private Direccion direccion;
	private List<Pedido> pedidos=new ArrayList<Pedido>();
	
	public Empresa() {
		
	}
	//getters y setters
	public String getCif() {
		return cif;
	}
	public void setCif(String cif) {
		this.cif = cif;
	}
///	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
///
	public int getEmpleados() {
		return empleados;
	}
	public void setEmpleados(int empleados) {
		this.empleados = empleados;
	}
///
	public Direccion getDireccion() {
		return direccion;
	}
	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
		direccion.setEmpresa(this);
	}
///	
	public List<Pedido> getPedidos() {
		return pedidos;
	}
	
	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}
///
	public void addPedido(Pedido p){
		p.setEmpresa(this);
		this.pedidos.add(p);
	}
//imprimir el objeto empresa
	public void printEmpresa(){
			System.out.println();
			System.out.println("cif : "+cif);
			System.out.println("nombre : "+nombre);
			System.out.println("direccion : "+direccion.getCalle());
			System.out.println();
			System.out.println("pedidos de a empresa:");
			for(Pedido p:pedidos){
				System.out.println("--------Pedido: "+p.getId()+" - "+p.getFecha());
				System.out.println();
			}
	}

}
