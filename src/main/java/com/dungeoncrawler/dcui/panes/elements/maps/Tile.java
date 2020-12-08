package com.dungeoncrawler.dcui.panes.elements.maps;

import java.awt.image.BufferedImage;

public class Tile {

	public static final int ROTATION_0  = 0;
	public static final int ROTATION_90 = 1;
	public static final int ROTATION_180 = 2;
	public static final int ROTATION_270 = 3;
	
	private BufferedImage tile;
	private int rotation;
	
	public Tile( BufferedImage image, int rotation ) {
		this.tile = image;
		this.rotation = rotation;
	}
	
	public BufferedImage getTile() {
		return this.tile;
	}
	
	public int getRotation() {
		return this.rotation;
	}
}
