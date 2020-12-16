package com.dungeoncrawler.dcui.panes.entity;

import java.awt.Image;
import java.awt.Point;
import java.awt.image.BufferedImage;

public class Entity extends BufferedImage {

	private Point location = new Point(0,0);
	private int tileX = 0;
	private int tileY = 0;
	
	public Entity( int width, int height, Image resource ) {
		super( width, height, BufferedImage.TYPE_4BYTE_ABGR );
		
		getGraphics().drawImage(resource.getScaledInstance(width, height, Image.SCALE_SMOOTH),0,0,null);
	}
	
	public void setLocation( Point point ) {
		this.location = point;
	}
	
	public Point getLocation() {
		return this.location;
	}
	
	public void setTileLocation( int x, int y ) {
		this.tileX = x;
		this.tileY = y;
	}
	
	public int getTileX() {
		return this.tileX;
	}
	
	public int getTileY() {
		return this.tileY;
	}
}
