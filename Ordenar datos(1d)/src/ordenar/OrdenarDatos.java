package src.ordenar;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class OrdenarDatos {

	public static void main(String[] args) {
		
		Scanner s=new Scanner(System.in);
		System.out.print("nombre del primer archivo : ");
		String namefile1=s.nextLine();
		File file1=new File(namefile1);
		System.out.print("nombre del segundo archivo : ");
		String namefile2=s.nextLine();
		File file2=new File(namefile2);
		try{
			ordenar(file1,file2,0);
		}catch(IOException e){
			System.out.println("error al ordenar el archivo!");
		}
		
	}
	
	public static void ordenar(File file1,File file2,int tipo_orden) throws IOException {
		
		BufferedReader br=new BufferedReader(new FileReader(file1));
		String palabraleida=br.readLine();
		while(palabraleida!=null){
		
		}
	}

}
