package com.dungeoncrawler.dcui.entities;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.JPanel;

public class Entity2D extends JPanel {

	private static final long serialVersionUID = 1L;

	private int width;
	private int height;
	private Image resource2D;
	
	public Entity2D( int width, int height, Image resource ) {
		this.width = width;
		this.height = height;
		
		this.resource2D = resource.getScaledInstance(this.width, this.height, Image.SCALE_SMOOTH);
		
		setSize( new Dimension( width, height ) );
		setPreferredSize( new Dimension( this.width, this.height ) );
	}
	
	public void moveLocation( int x, int y ) {
		this.setLocation(x, y);
	}

	@Override
	public void paint(Graphics g) {
	
		super.paint(g);
		
		Graphics2D g2 = (Graphics2D)g;
		
		g2.drawImage( this.resource2D, 0, 0, this );
	}
}
