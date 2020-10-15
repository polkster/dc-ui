package com.dungeoncrawler.dcui.panes.elements;

import java.awt.Color;

import com.dungeoncrawler.dcui.entities.Entity2D;
import com.dungeoncrawler.dcui.panes.Pane2D;

public class RightPane extends Pane2D {

	private static final long serialVersionUID = 1L;

	public RightPane() {
		
		super();
		
		setBackground(Color.BLUE);
	}

	@Override
	protected void loadResources() {
		
		Entity2D sword = new Entity2D(32, 32, loadImage( "sword.png" ) );
		
		addEntity( sword, 10, 10 );
				
		doLayout();
	}
}
