package com.dungeoncrawler.dcui.panes.elements;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import com.dungeoncrawler.dcui.entities.Entity2D;
import com.dungeoncrawler.dcui.panes.Pane2D;
import com.dungeoncrawler.dcui.panes.actions.Actions;
import com.dungeoncrawler.dcui.panes.actions.instructions.Instruction;
import com.dungeoncrawler.dcui.panes.actions.instructions.MovementInstruction;

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
	private Boolean _alive = true;
	
	private Actions actions;
	
	private Entity2D ogre;
	private Entity2D goblin;
	private Entity2D joker;
	private Entity2D darth_vader;
	
	public Viewport() {
		
		super();
		setBackground(Color.BLACK);		
		
		this.actions = new Actions();
		this.heartIcon = loadImage( RESOURCE_HEART ).getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		this.attackIcon = loadImage( RESOURCE_ATTACK ).getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		this.shieldIcon = loadImage( RESOURCE_SHIELD ).getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		this.font = new Font(  "Courier", Font.BOLD, 20 );
		
		addActions();
		startRendering();
	}
	
	// HERE IS THE ASSIGNMENT!
	private void addActions() {
		
		int x = 0;
		int y = this.ogre.getY();
		
		for ( int i = 0; i < 30; i++ ) {
			this.actions.addAction( new MovementInstruction( this.ogre, 500, x, 100));
			x+= 10;
		}
		for ( int i =0; i < 30; i++ ) {
			this.actions.addAction( new MovementInstruction( this.ogre, 500, x, y));
			y+= 10;
		}
	}
	
	private void startRendering() {
		Runnable runner = new Runnable() {
			
			@Override
			public void run() {

				while ( _alive ) {
					
					handleActions();
					render();
					
					try {
						Thread.sleep(20L);
					}
					catch ( Exception e ) {
						
					}
				}
			}
		};
		
		new Thread( runner ).start();
	}
	
	private void handleActions() {
		long now = System.currentTimeMillis();
		
		if ( this.actions.peekNextInstruction() != null &&  this.actions.peekNextInstruction().getExecuteTime() > now ) {
			Instruction instruction = this.actions.fetchNextInstruction();
			
			processInstruction( instruction );
		}
	}
	
	private void processInstruction( Instruction instruction ) {
		if ( instruction instanceof MovementInstruction ) {
			processMovement( (MovementInstruction)instruction );
		}
	}
	
	private void processMovement( MovementInstruction instruction ) {
		
		System.out.println( "Moving entity to: " + instruction.getX() + "," + instruction.getY() );
		instruction.getEntity().moveLocation(instruction.getX(), instruction.getY() );
	}
	
	private void addAction( Instruction instruction ) {
		this.actions.addAction(instruction);
	}
	
	private void render() {
		
		this.doLayout();
		this.repaint();
	}
	
	protected void loadResources() {
		
		this.ogre = new Entity2D(50, 50, loadImage( RESOURCE_OGRE2 ) );
		this.goblin = new Entity2D(50, 50, loadImage( RESOURCE_GOBLIN ) );
		this.joker = new Entity2D(50, 50, loadImage( RESOURCE_JOKER ) );
		this.darth_vader = new Entity2D(50, 50, loadImage( RESOURCE_DARTH_VADER ) );
		
		addEntity( this.ogre, 100, 100 );
		addEntity( this.goblin, 100, 200);
		addEntity( this.joker, 100, 300);
		addEntity( this.darth_vader, 100, 400);
		
		doLayout();
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		
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
