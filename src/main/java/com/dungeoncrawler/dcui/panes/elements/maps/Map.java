package com.dungeoncrawler.dcui.panes.elements.maps;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

import com.dungeoncrawler.dcui.util.Utility;

public class Map {

	private Tile[][] mapTiles = null;
	
	private int tileSize;
	
	public Map( int width, int height, int tileSize ) {
		this.mapTiles = new Tile[width][height];
		this.tileSize = tileSize;
	}
	
	public void setTile( int x, int y, BufferedImage tile, int rotation ) {
		this.mapTiles[x][y] = new Tile( tile, rotation );
	}
	
	public void setTileDirections( int x, int y, boolean north, boolean south, boolean east, boolean west ) {
		this.mapTiles[x][y].setDirections(north, south, west, east);
	}
	
	public Tile getTile( int x, int y ) {
		return this.mapTiles[x][y];
	}

	public BufferedImage generateMap() {
		
		int width = this.mapTiles.length*this.tileSize;
		int height = this.mapTiles[0].length*this.tileSize;
		
		BufferedImage ret = new BufferedImage( width, height, BufferedImage.TYPE_4BYTE_ABGR);
		Graphics g = ret.getGraphics();
		
		g.setColor(Color.black);
		g.fillRect(0, 0, width, height);
		
		for ( int w = 0; w < this.mapTiles.length; w++ ) {
			for ( int h = 0; h < this.mapTiles[0].length; h++ ) {
				
				if ( this.mapTiles[w][h] != null ) {
					
					double rotation = 0;
					
					rotation = this.mapTiles[w][h].getRotation() * 90;
					
					Image image = Utility.rotateImageByDegrees(this.mapTiles[w][h].getTile(), rotation);
					
					g.drawImage( image, w*this.tileSize, h*this.tileSize, null );	
				}
			}
		}
		
		return ret;
	}
}
