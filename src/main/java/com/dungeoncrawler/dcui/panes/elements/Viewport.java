package com.dungeoncrawler.dcui.panes.elements;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import com.dungeoncrawler.dcui.entities.Entity2D;
import com.dungeoncrawler.dcui.panes.Pane2D;

public class Viewport extends Pane2D {

	private static final String RESOURCE_OGRE = "ogre.png";
	private static final String RESOURCE_OGRE2 = "ogre.jpg";
	private static final String RESOURCE_GOBLIN = "goblin.png";	
	private static final String RESOURCE_JOKER = "joker.gif";
	private static final String RESOURCE_DARTH_VADER = "darth_vader.png";
			
	private static final long serialVersionUID = 1L;

	public Viewport() {
		
		super();
		setBackground(Color.BLACK);		
	}
	
	protected void loadResources() {
		
		Entity2D ogre = new Entity2D(50, 50, loadImage( RESOURCE_OGRE2 ) );
		Entity2D goblin = new Entity2D(50, 50, loadImage( RESOURCE_GOBLIN ) );
		Entity2D Joker = new Entity2D(50, 50, loadImage( RESOURCE_JOKER ) );
		Entity2D darth_vader = new Entity2D(50, 50, loadImage( RESOURCE_DARTH_VADER ) );
		addEntity( ogre, 100, 100 );
		addEntity( goblin, 100, 200);
		addEntity( Joker, 100, 300);
		addEntity( darth_vader, 100, 400);
		doLayout();
	}

	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		
		Font font = new Font( "Arial", Font.BOLD, 16 );
		
		g.setFont(font);
		g.setColor( Color.white );
		
		g.drawString("(c) SandburgEvents 2020", 20, 30);
	}
}
