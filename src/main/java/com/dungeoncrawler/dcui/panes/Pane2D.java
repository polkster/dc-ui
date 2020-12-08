package com.dungeoncrawler.dcui.panes;

import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import com.dungeoncrawler.dcui.entities.Entity2D;

public abstract class Pane2D extends JPanel {

	private static final long serialVersionUID = 1L;

	public Pane2D() {

		setLayout( null );
		loadResources();
	}
	
	protected void addEntity( Entity2D entity, int x, int y ) {
		add( entity );
		
		entity.setLocation( new Point( x, y ) );
	}
	
	protected abstract void loadResources();
	
	public void hidePane () {
		this.setVisible(false);
	
	
	}
	
	public void hideCompletely() {
		this.setSize(0, -1);
	}

}
