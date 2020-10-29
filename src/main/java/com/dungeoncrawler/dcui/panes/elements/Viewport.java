package com.dungeoncrawler.dcui.panes.elements;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

import com.dungeoncrawler.dcui.entities.Entity2D;
import com.dungeoncrawler.dcui.panes.Pane2D;

public class Viewport extends Pane2D {

	private static final String RESOURCE_OGRE = "ogre.png";
	private static final String RESOURCE_OGRE2 = "ogre.jpg";
	private static final String RESOURCE_GOBLIN = "goblin.png";	
	private static final String RESOURCE_JOKER = "joker.gif";
	private static final String RESOURCE_DARTH_VADER = "darth_vader.png";
	
	private static final String RESOURCE_ATTACK = "attack.png";
	private static final String RESOURCE_SHIELD = "shield.png";
	private static final String RESOURCE_HEART = "heart.png";
			
	private static final long serialVersionUID = 1L;

	private Image heartIcon = null;
	private Image attackIcon = null;
	private Image shieldIcon = null;
	
	private Font font = null;
	
	public Viewport() {
		
		super();
		setBackground(Color.BLACK);		
		
		this.heartIcon = loadImage( RESOURCE_HEART ).getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		this.attackIcon = loadImage( RESOURCE_ATTACK ).getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		this.shieldIcon = loadImage( RESOURCE_SHIELD ).getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		this.font = new Font(  "Courier", Font.BOLD, 20 );
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
		super.paint(g);
		
		System.out.println( "Painting" );
		
		g.setFont(this.font);
		
		g.drawImage( this.heartIcon, 10, 0, this );
		g.drawImage( this.attackIcon, 160, 0, this );
		g.drawImage( this.shieldIcon, 310, 0, this );
		
		g.setColor(Color.white);
		
		g.drawRect(10,  0, 80, 42);
		g.drawString( "21", 60, 30 );
		
		g.drawRect( 160,  0, 80, 42 );
		g.drawString( "16", 210, 30 );
		
		g.drawRect( 310,  0, 80, 42 );
		g.drawString( "4", 365, 30 );
	}
	
	
}
