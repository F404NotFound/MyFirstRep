package com.yzu.GUI;
import java.awt.Frame;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Util {
	public static void close(Frame f){
		f.addWindowListener(			
			new WindowAdapter() {  		
			public void windowClosing(WindowEvent e) {  
				System.exit(0);
			}
		});
	}
	
	public static void closeWindow(Frame f){
		f.addWindowListener(			
			new	WindowAdapter(){	
				public void windowClosing(WindowEvent e) {  
					Frame f = (Frame)e.getSource();
					f.setVisible(false);
				}
			});
	}
	
	
	public static Image getImage(File path){
		BufferedImage img = null;
		try {
			img = ImageIO.read(path);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return img;
	}
}
