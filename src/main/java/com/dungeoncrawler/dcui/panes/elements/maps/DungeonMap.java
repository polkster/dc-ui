package com.dungeoncrawler.dcui.panes.elements.maps;

import java.awt.image.BufferedImage;

import com.dungeoncrawler.dcui.util.Utility;

public class DungeonMap extends Map {

	private static int TILE_SIZE 			= 128;
	
	private BufferedImage mapTileBend = null;			// default orientation N and E
	private BufferedImage mapTileCrossroad = null;		// default orientation N/S/E/W
	private BufferedImage mapTileJunction = null;		// default orientation N/S/W
	private BufferedImage maptileStraight = null;		// default orientation N/S
	
	public DungeonMap() {
		
		super(5, 5, TILE_SIZE);
		
		loadResources();
		buildMap();
	}
	
	private void loadResources() {
		
		this.mapTileBend = Utility.getScaledImage(Utility.loadImage("map/CaveTunnels-Bend.png"), TILE_SIZE, TILE_SIZE );
		this.mapTileCrossroad = Utility.getScaledImage(Utility.loadImage("map/CaveTunnels-Crossroad.png"), TILE_SIZE, TILE_SIZE );
		this.mapTileJunction = Utility.getScaledImage(Utility.loadImage("map/CaveTunnels-Junction.png"), TILE_SIZE, TILE_SIZE );
		this.maptileStraight = Utility.getScaledImage(Utility.loadImage("map/CaveTunnels-Straight.png"), TILE_SIZE, TILE_SIZE );
	}
	
	private void buildMap() {
		
		
		this.setTile(0, 0, this.mapTileBend, Tile.ROTATION_90);
		this.setTileDirections( 0, 0, false, true, true, false );
		
		this.setTile(1, 0, this.mapTileJunction, Tile.ROTATION_270);
		this.setTileDirections(1, 0, false, true, true, true);
		
		this.setTile(2, 0, this.mapTileJunction, Tile.ROTATION_270);
		this.setTileDirections(2, 0, false, true, true, true);
		
		this.setTile(3, 0, this.maptileStraight, Tile.ROTATION_90);
		this.setTileDirections(3,  0,  false, true, true, true);
		
		this.setTile(4, 0, this.mapTileBend, Tile.ROTATION_180);
		this.setTileDirections(4,  0,  false, false, true, true);
		
		this.setTile(0, 1, this.mapTileJunction, Tile.ROTATION_180);
		this.setTile(1, 1, this.mapTileCrossroad, Tile.ROTATION_90);
		this.setTile(2, 1, this.mapTileCrossroad, Tile.ROTATION_0);
		this.setTile(3, 1, this.maptileStraight, Tile.ROTATION_90);
		this.setTile(4, 1, this.mapTileJunction, Tile.ROTATION_0);
		
		this.setTile(4, 2, this.maptileStraight, Tile.ROTATION_0);
		this.setTile(4, 3, this.mapTileBend, Tile.ROTATION_270);
		
		
		this.setTile(0, 2, this.mapTileBend, Tile.ROTATION_0);
		this.setTile(1, 2, this.mapTileCrossroad, Tile.ROTATION_0);
		this.setTile(2, 2, this.mapTileJunction, Tile.ROTATION_0);
		this.setTile(3, 3, this.maptileStraight, Tile.ROTATION_90);
		this.setTile(2, 3, this.mapTileBend, Tile.ROTATION_0);
		
		this.setTile(1, 3, this.maptileStraight, Tile.ROTATION_0);		
		this.setTile(1, 4, this.mapTileBend, Tile.ROTATION_0);
		this.setTile(2, 4, this.maptileStraight, Tile.ROTATION_90);
		this.setTile(3, 4, this.maptileStraight, Tile.ROTATION_90);
		this.setTile(3, 4, this.mapTileBend, Tile.ROTATION_180);
	}
}
