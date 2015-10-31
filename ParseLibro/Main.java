public class Main {

	public static void main(String[] args) {
		Parseador p=new Parseador();
		p.parsearFicheroXml("biblioteca.xml");
		p.parsearBiblioteca();
		p.print();
	}

}
