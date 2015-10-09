package ficheros;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Comparar {

	public static void main(String[] args) {
		
		//Pablo Magaña
		
		File file1=new File("t1.txt");
		File file2=new File("t2.txt");
		//comprobar si los archivos son o no iguales y mostrar error si se produce cualquier error
		try{
			if(comparar(file1,file2)==true){
				System.out.println("los archivos SON iguales");
			}else{
				System.out.println("los archivos NO SON iguales");
			}
			
		}catch(Exception e){
			System.out.println("error al comparar los archivos");
		}
		
		File file3=new File("t3.txt");
		//buscar una referencia a la palabra a buscar en el archivo guardando la linea de la primera o ultima referencia
		// mostrando mensaje de error si se produce cualquier error
		try{
			System.out.println("la palabra se encuentra en la linea "+buscarPalabra(file3, "casa", false));
		}catch(Exception e){
			System.out.println("no se ha podido buscar la palabra");
		}

	}
	
	public static boolean comparar(File file1,File file2) throws IOException{
		//crear flujo de datos
		BufferedReader br1=new BufferedReader(new FileReader(file1));
		BufferedReader br2=new BufferedReader(new FileReader(file2));
		//leer linea inicial
		String s1=br1.readLine();
		String s2=br2.readLine();
		//recorro linea a linea comprobando si son iguales
		//si no lo son se corta el bucle y devuelve false
		while(s1!=null && s2!=null){
			if(s1.equals(s2)){
				s1=br1.readLine();
				s2=br2.readLine();
			}else{
				//cierro archivos
				br1.close();
				br2.close();
				return false;
			}
		}
		//cierro archivos
		br1.close();
		br2.close();
		return true;
		
	}
	
	public static int buscarPalabra (File fichero1, String palabra, boolean primera) throws IOException{
		//creo flujo de datos
		BufferedReader br1=new BufferedReader(new FileReader(fichero1));
		//leer linea inicial
		String s=br1.readLine();
		//inicializa variables
		int linea=1;
		int lineaEncontrada=0;
		//recorro linea a linea y dependiendo si busco primera linea o no comparo la palabra leida con la buscada y la guardo en variable
		while(s!=null){
			if(primera==true && s.equals(palabra)){
				lineaEncontrada=linea;
				break;
			}else{
				if(s.equals(palabra)){
					lineaEncontrada=linea;
				}
			}
			linea++;
			s=br1.readLine();
		}
		//cerrar archivo
		br1.close();
		return lineaEncontrada;
	}

}
