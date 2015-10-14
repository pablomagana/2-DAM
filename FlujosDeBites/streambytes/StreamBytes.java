package streambytes;

import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class StreamBytes {
	static FileInputStream is;
	static FileOutputStream os;
	
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		System.out.println("nombre del fichero origen :");
		String origen=s.nextLine();
		System.out.println("nombre del fichero destino :");
		String destino=s.nextLine();
		
		try {
			// 0 para abrir origen
			// 1 para abrir destino
			is=(FileInputStream) abrirFichero(origen,0);
			os= (FileOutputStream) abrirFichero(destino,1);
		} catch (FileNotFoundException | SecurityException e1) {
			System.out.println("error al abrir los ficheros");
		}
		
		try{
			copiaBytes(is,os);
			System.out.println("listo!!");
		}catch(Exception e){
			System.out.println("Error al copiar el archivo");
		}
	}
	
	/*Definir el perfil que se desee para esta función*/
	public static void copiaBytes(FileInputStream is,FileOutputStream os) throws IOException {
		int byteLlegit = is.read();
		while(byteLlegit!=-1){
			os.write(byteLlegit);
			byteLlegit = is.read();
		}
	}
	
	/*Definir el perfil que se desee para esta función*/
	public static  Closeable abrirFichero(String name,int type) throws FileNotFoundException, SecurityException {
		if(type==0){
			FileInputStream fileStream=new FileInputStream(new File(name));
			return 	fileStream;
		}else{
			FileOutputStream FileStream=new FileOutputStream(new File(name));
			return 	FileStream;
		}	
		
	}
	
}