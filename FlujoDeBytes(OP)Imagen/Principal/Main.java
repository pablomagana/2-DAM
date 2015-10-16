package Principal;

import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.imageio.ImageWriter;

import org.omg.PortableInterceptor.IORInfo;

public class Main {
	/*
	 * Pablo Maga�a
	 */
	static BufferedImage bufferedorigen=null;
	static BufferedImage buffereddestino=null;
	static File destino;
	static File origen;
	static String menu;
	
	public static void main(String[] args) {
		
		Scanner s=new Scanner(System.in);
		System.out.println("nombre archivo origen:");
		String nameOrigen=s.nextLine();
		System.out.println("nombre archivo destino:");
		String nameDestino=s.nextLine();
		origen=new File(nameOrigen);
		destino=new File(nameDestino);
		System.out.println("elige una opci�n apara aplicar a la imagen");
		System.out.println("1 - para rotar la imagen 90�");
		System.out.println("2 - para hacer su espejo");
		menu=s.nextLine();
		try {
			bufferedorigen=ImageIO.read(origen);
			buffereddestino=new BufferedImage(bufferedorigen.getWidth(), bufferedorigen.getHeight(), bufferedorigen.getType());
			
		} catch (IOException e) {
			System.out.println("error al abrir fichero origen");
		}
		try{
			if(menu.equals("1")){
				rotar();
			}else if(menu.equals("2")){
				espill();
			}else{
				System.out.println("opci�n no valida, vuelve a intentarlo");
			}
		}catch(IOException e){
			System.out.println("error al rotar la imagen");
		}
	}
	
	
	public static void rotar() throws IOException{
		
		
		int ancho = bufferedorigen.getWidth();//512
		int alto = bufferedorigen.getHeight();//512
		
		int rgbo;//origen
		int rgbo2;
		for(int i=0;i<ancho;i++){
			for(int j=0;j<alto;j++){
				rgbo=bufferedorigen.getRGB(i, j);
				
				rgbo2=bufferedorigen.getRGB(j, (ancho-1)-i);
			
				buffereddestino.setRGB((ancho-1)-j,i , rgbo);
				buffereddestino.setRGB(i,j,rgbo2);
			}
			
		}
		System.out.println("imagen rotada 90� a la derecha");
		ImageIO.write(buffereddestino, "png", destino);
	}
	
	public static void espill() throws IOException{
		int ancho = bufferedorigen.getWidth();
		int alto = bufferedorigen.getHeight();
		
		int rgbo;//origen
		for(int i=0;i<ancho;i++){
			for(int j=0;j<alto;j++){
				rgbo=bufferedorigen.getRGB(i, j);
				buffereddestino.setRGB((ancho-1)-i,j, rgbo);
			}
		}
		
		System.out.println("imagen espejo");
		ImageIO.write(buffereddestino, "jpg", destino);
	}
}