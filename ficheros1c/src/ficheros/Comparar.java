package ficheros;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Comparar {

	public static void main(String[] args) {
		File file1=new File("t1.txt");
		File file2=new File("t2.txt");
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
		try{
			System.out.println("la palabra se encuentra en la linea "+buscarPalabra(file3, "casa", false));
		}catch(Exception e){
			System.out.println("no se ha podido buscar la palabra");
		}

	}
	
	public static boolean comparar(File file1,File file2) throws IOException{
		BufferedReader br1=new BufferedReader(new FileReader(file1));
		BufferedReader br2=new BufferedReader(new FileReader(file2));
		
		String s1=br1.readLine();
		String s2=br2.readLine();
		
		while(s1!=null && s2!=null){
			if(s1.equals(s2)){
				s1=br1.readLine();
				s2=br2.readLine();
			}else{
				return false;
			}
		}
		br1.close();
		br2.close();
		return true;
		
	}
	
	public static int buscarPalabra (File fichero1, String palabra, boolean primera) throws IOException{
		BufferedReader br1=new BufferedReader(new FileReader(fichero1));
		String s=br1.readLine();
		int linea=1;
		int lineaEncontrada=0;
		
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
		br1.close();
		return lineaEncontrada;
	}

}
