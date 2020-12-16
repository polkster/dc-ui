package com.dungeoncrawler.dcui.panes.elements.maps;

import java.awt.image.BufferedImage;

public class Tile {

	public static final int ROTATION_0  = 0;
	public static final int ROTATION_90 = 1;
	public static final int ROTATION_180 = 2;
	public static final int ROTATION_270 = 3;
	
	private boolean allowNorth = false;
	private boolean allowEast = false;
	private boolean allowWest = false;
	private boolean allowSouth = false;
	
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
	
	public void setDirections( boolean north, boolean south, boolean west, boolean east ) {
		this.allowEast = east;
		this.allowNorth = north;
		this.allowSouth = south;
		this.allowWest = west;
	}
	
	public boolean allowsNorth() {
		return this.allowNorth;
	}
	
	public boolean allowsSouth() {
		return this.allowSouth;
	}
	
	public boolean allowsEast() {
		return this.allowEast;
	}
	
	public boolean allowsWest() {
		return this.allowWest;
	}
}
