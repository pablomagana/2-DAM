package ordenar;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class OrdenarDatos {

	public static void main(String[] args) {
		System.out.println("para esta actividad se presupone que solo hay una palabra por linea");
		Scanner s=new Scanner(System.in);
		
		//String namefile1="t1.txt";
		//String namefile2="t2.txt";
		
		System.out.println("nombre del primer archivo : ");
		String namefile1=s.nextLine();
		File file1=new File(namefile1);
		
		System.out.println("nombre del segundo archivo : ");
		String namefile2=s.nextLine();
		File file2=new File(namefile2);
		
		System.out.println("0 para orden natural, 1 para orden inverso");
		int i=s.nextInt();
		
		try{
			ordenarFichero(file1,file2,i);
		}catch(IOException e){
			System.out.println("error al ordenar el archivo!");
		}
		
	}
	
	public static void ordenarFichero(File file1,File file2,int tipo_orden) throws IOException {
		//abrir flujo de datos
		BufferedReader br=new BufferedReader(new FileReader(file1));
		BufferedWriter br2=new BufferedWriter(new FileWriter(file2));
		
		//inicializar variables
		String[] palabrasEnOrdenArray=null;
		String[] palabrasEnDesOrdenArray;
		ArrayList<String> palabrasEnDesOrden=new ArrayList<String>();
		ArrayList<String> palabrasEnOrden=new ArrayList<String>();
		
		//recorrer archivo
		String linealeida=br.readLine();
		while(linealeida!=null){
			palabrasEnDesOrden.add(linealeida);
			linealeida=br.readLine();
		}
		palabrasEnOrdenArray=new String[palabrasEnDesOrden.size()];
		palabrasEnDesOrdenArray=new String[palabrasEnDesOrden.size()];
		
		//ordenar palabras segun el orden indicado
		if(tipo_orden==0){
			//ordenar naturalmente
			Collections.sort(palabrasEnDesOrden);
			palabrasEnOrden=palabrasEnDesOrden;
			palabrasEnOrdenArray=(String[]) palabrasEnOrden.toArray(palabrasEnOrdenArray);
		}else{
			//ordenar naturalmente
			Collections.sort(palabrasEnDesOrden);
			palabrasEnDesOrdenArray=(String[]) palabrasEnDesOrden.toArray(palabrasEnDesOrdenArray);
			String prov;
			//invertir orden
			int num;
			for(int i=0;i<=palabrasEnDesOrdenArray.length-1;i++){
				num=(palabrasEnDesOrdenArray.length-1)-i;
				prov=palabrasEnDesOrdenArray[num];
				palabrasEnOrdenArray[i]=prov;
			}
		}
		
		//escribir palabras ordenadas en archivo 2
		for(int i=0;i<=palabrasEnOrdenArray.length-1;i++){
			br2.write(palabrasEnOrdenArray[i]);
			if(i!=palabrasEnOrdenArray.length-1){
				br2.newLine();
			}
			
		}
		//cerrar flujo de datos
		br.close();
		br2.close();
	}

}


