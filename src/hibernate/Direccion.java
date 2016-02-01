package hibernate;

public class Direccion {
	private String calle;
	private String poblacion;
	private int cp;
	private Empresa empresa;
	
	
	public Direccion(){
		
	}
	
	public Direccion(String calle, String poblacion, int cp) {
		super();
		this.calle = calle;
		this.poblacion = poblacion;
		this.cp = cp;
	}
	
	//getters y setters
	public String getCalle() {
		return calle;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}
	public String getPoblacion() {
		return poblacion;
	}
	public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
	}
	public int getCp() {
		return cp;
	}
	public void setCp(int cp) {
		this.cp = cp;
	}
	
	public Empresa getEmpresa() {
		return empresa;
	}
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	
}
