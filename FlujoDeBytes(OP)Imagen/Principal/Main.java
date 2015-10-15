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
	static BufferedImage imagenorigen=null;

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		String nameOrigen=s.nextLine();
		File origen=new File(nameOrigen);
		try {
			imagenorigen=ImageIO.read(origen);
		} catch (IOException e) {
			System.out.println("error al abrir fichero origen");
		}
	}
	
	
	public void rotar(){
		for(int i=0;i<imagenorigen.getMinX();i++){
			for(int j=0;j<imagenorigen.getMinY();j++){
				imagenorigen.getRGB(i, j);
			}
				
		}
		System.out.println("imagen leida");
	}
}