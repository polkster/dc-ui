package com.dungeoncrawler.dcui.panes.elements;

import java.awt.Color;

import com.dungeoncrawler.dcui.entities.Entity2D;
import com.dungeoncrawler.dcui.panes.Pane2D;

public class Viewport extends Pane2D {

	private static final String RESOURCE_OGRE = "ogre.png";
	
	private static final long serialVersionUID = 1L;

	public Viewport() {
		
		super();
		setBackground(Color.BLACK);		
	}
	
	protected void loadResources() {
		
		Entity2D ogre = new Entity2D(32, 32, loadImage( RESOURCE_OGRE ) );
	
		addEntity( ogre, 100, 100 );
		
		
		doLayout();
	}
}
