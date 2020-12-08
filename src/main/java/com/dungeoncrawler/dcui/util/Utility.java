package com.dungeoncrawler.dcui.util;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class Utility {

	public static BufferedImage loadImage( String resource ) {
		
		InputStream in = new Utility().getClass().getClassLoader().getResourceAsStream(resource);
		
		if ( in != null ) {
			
			try {
				BufferedImage image = ImageIO.read(in);
				
				return image;
			}
			catch ( Exception e ) {
				e.printStackTrace();
			}
		}
		
		return null;
	}
	
	public static BufferedImage getScaledImage( Image image, int newWidth, int newHeight ) {
		Image scaled = image.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH );
		BufferedImage ret = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_4BYTE_ABGR );
		ret.getGraphics().drawImage(scaled, 0, 0, null);
		
		return ret;
	}
	
    public static BufferedImage rotateImageByDegrees(BufferedImage img, double angle) {

        double rads = Math.toRadians(angle);
        double sin = Math.abs(Math.sin(rads)), cos = Math.abs(Math.cos(rads));
        int w = img.getWidth();
        int h = img.getHeight();
        int newWidth = (int) Math.floor(w * cos + h * sin);
        int newHeight = (int) Math.floor(h * cos + w * sin);

        BufferedImage rotated = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = rotated.createGraphics();
        AffineTransform at = new AffineTransform();
        at.translate((newWidth - w) / 2, (newHeight - h) / 2);

        int x = w / 2;
        int y = h / 2;

        at.rotate(rads, x, y);
        g2d.setTransform(at);
        g2d.drawImage(img, 0, 0, null);
        g2d.dispose();

        return rotated;
    }
}
