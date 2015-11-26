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
	 * Pablo Magaña
	 */
	static BufferedImage bufferedorigen=null;
	static BufferedImage buffereddestino=null;
	static File destino=null;
	static File origen=null;
	static String menu=null;
	
	public static void main(String[] args) {
		
		Scanner s=new Scanner(System.in);
		System.out.println("nombre archivo origen:");
		String nameOrigen=s.nextLine();
		System.out.println("nombre archivo destino:");
		String nameDestino=s.nextLine();
		origen=new File(nameOrigen);
		destino=new File(nameDestino);
		System.out.println("elige una opción apara aplicar a la imagen");
		System.out.println("1 - para rotar la imagen 90º");
		System.out.println("2 - para hacer su espejo");
		menu=s.nextLine();
		try {
			//abrir imagen para leer
			bufferedorigen=ImageIO.read(origen);
			//crear objeto de imagen en blanco identico a imagen ooriginal para dibujar
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
				System.out.println("opción no valida, vuelve a intentarlo");
			}
		}catch(IOException e){
			System.out.println("error al rotar la imagen");
		}
	}
	
	
	public static void rotar() throws IOException{
		//capturo valores de la imagen
		int ancho = bufferedorigen.getWidth();//512
		int alto = bufferedorigen.getHeight();//512
		
		int rgbo;//origen
		int rgbo2;
		//recorro la imagen cambiando el pixel de origen por el de destino
		//siguiendo el modelo de rotar la diagonal y hacer el espejo
		for(int i=0;i<ancho;i++){
			for(int j=0;j<alto;j++){
				rgbo=bufferedorigen.getRGB(i, j);
				rgbo2=bufferedorigen.getRGB(j, (ancho-1)-i);
			
				buffereddestino.setRGB((ancho-1)-j,i , rgbo);
				buffereddestino.setRGB(i,j,rgbo2);
			}
			
		}
		System.out.println("imagen rotada 90º a la derecha");
		ImageIO.write(buffereddestino, "jpg", destino);
	}
	
	public static void espill() throws IOException{
		//capturo medidas de la imagen
		int ancho = bufferedorigen.getWidth();
		int alto = bufferedorigen.getHeight();
		
		int rgbo;//origen
		//recorro la imagen de derecha a izquierda intercambiando los pixeles espejos
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