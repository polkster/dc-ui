package com.dungeoncrawler.dcui.panes.elements;

import java.awt.Color;

import com.dungeoncrawler.dcui.entities.Entity2D;
import com.dungeoncrawler.dcui.panes.Pane2D;

public class RightPane extends Pane2D {

	private static final long serialVersionUID = 1L;
	private static final String RESOURCE_SWORD = "sword.png";
	private static final String RESOURCE_MACE = "mace.jpg";
	private static final String RESOURCE_SLINGSHOT = "slingshot.png";
	private static final String RESOURCE_BOW = "bow.jpg";
	public RightPane() {
		
		super();
		
		setBackground(Color.BLUE);
	}

	@Override
	protected void loadResources() {
		
		// this is where we declare a new entity
		Entity2D slingshot = new Entity2D(32, 32, loadImage( RESOURCE_SLINGSHOT) );
		Entity2D sword = new Entity2D(32, 32, loadImage( RESOURCE_SWORD ) );
		Entity2D mace = new Entity2D(32, 32, loadImage( RESOURCE_MACE ) );
		Entity2D bow = new Entity2D(32, 32, loadImage( RESOURCE_BOW) );
		// this is us adding the entity to the scene
		addEntity( sword, 10, 10 );
		addEntity( mace, 60, 10 );
		addEntity( slingshot, 10, 60 );
		addEntity( bow, 60, 60 );
		// this redraws everything
		doLayout();
	}
}
