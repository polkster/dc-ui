package com.dungeoncrawler.dcui.panes.elements;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import com.dungeoncrawler.dcui.panes.Pane2D;
import com.dungeoncrawler.dcui.panes.actions.Actions;
import com.dungeoncrawler.dcui.panes.actions.instructions.Instruction;
import com.dungeoncrawler.dcui.panes.actions.instructions.MovementInstruction;
import com.dungeoncrawler.dcui.panes.elements.maps.DungeonMap;
import com.dungeoncrawler.dcui.panes.elements.maps.Map;
import com.dungeoncrawler.dcui.panes.elements.maps.Tile;
import com.dungeoncrawler.dcui.panes.entity.Entity;
import com.dungeoncrawler.dcui.util.Utility;

public class Viewport extends Pane2D implements KeyListener {

	private static final String RESOURCE_OGRE = "ogre.png";
	private static final String RESOURCE_OGRE2 = "ogre2.png";
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
	
	private Map mapTiles = null;
	
	private Font font = null;
	private Boolean _alive = true;
	
	private Actions actions;
	
	private List<Entity> entities = null;
	private Entity ogre;
	
	private BufferedImage currentMap = null;
	
	public Viewport() {
		
		super();
		setBackground(Color.BLACK);		
			
		this.actions = new Actions();
		this.heartIcon = Utility.loadImage( RESOURCE_HEART ).getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		this.attackIcon = Utility.loadImage( RESOURCE_ATTACK ).getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		this.shieldIcon = Utility.loadImage( RESOURCE_SHIELD ).getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		this.font = new Font(  "Courier", Font.BOLD, 20 );
		
		this.ogre = new Entity(50, 50, Utility.loadImage( RESOURCE_OGRE2 ) );		
		addEntityToScene( this.ogre, new Point( 64-25, 64-25 ) );
		
		setFocusable(true);
		addKeyListener(this);
		setupMap();
		addActions();
		startRendering();
	}
	
	

	@Override
	public void keyTyped(KeyEvent e) {
		
	}



	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void keyReleased(KeyEvent e) {
		

		Tile tile = this.mapTiles.getTile(this.ogre.getTileX(), this.ogre.getTileY());
		
		switch( e.getKeyCode() ) {
			case 65: // a
				moveWest(tile);
				break;
			case 83: // s
				moveSouth(tile);
				break;
			case 68: // d
				moveEast(tile);
				break;
			case 87: // w
				moveNorth(tile);
				break;
		}
		
		repaint();
	}

	private void moveNorth( Tile tile ) {
		
		if ( tile.allowsNorth() ) {
			int x = this.ogre.getTileX();
			int y = this.ogre.getTileY();
			
			this.ogre.setTileLocation(x, y-1);
			this.ogre.setLocation( new Point(this.ogre.getLocation().x, this.ogre.getLocation().y - 128 ) );
		}
	}

	private void moveEast( Tile tile ) {
		if ( tile.allowsEast() ) {
			int x = this.ogre.getTileX();
			int y = this.ogre.getTileY();
			
			this.ogre.setTileLocation(x+1, y);
			this.ogre.setLocation( new Point(this.ogre.getLocation().x+128, this.ogre.getLocation().y ) );
		}
	}
	
	private void moveSouth( Tile tile ) {
		if ( tile.allowsSouth() ) {
			int x = this.ogre.getTileX();
			int y = this.ogre.getTileY();
			
			this.ogre.setTileLocation(x, y+1);
			this.ogre.setLocation( new Point(this.ogre.getLocation().x, this.ogre.getLocation().y+128 ) );
		}
	}
	
	private void moveWest( Tile tile ) {
		if ( tile.allowsWest() ) {
			int x = this.ogre.getTileX();
			int y = this.ogre.getTileY();
			
			this.ogre.setTileLocation(x-1, y);
			this.ogre.setLocation( new Point(this.ogre.getLocation().x-128, this.ogre.getLocation().y ) );
		}
	}

	// HERE IS THE ASSIGNMENT!
	private void addActions() {
		

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
	
	private void addEntityToScene( Entity entity, Point location ) {
		
		if ( this.entities == null ) {
			this.entities = new ArrayList<>();
		}
		
		entity.setLocation(location);
		entity.setTileLocation( 0, 0 );
		this.entities.add( entity );
	}
	
	protected void loadResources() {
		
		doLayout();
	}
	
	private void setupMap() {
		
		this.mapTiles = new DungeonMap();
		this.currentMap = this.mapTiles.generateMap();
		
//		try {
//			ImageIO.write(this.currentMap, "png", new File("./output.png" ) );
//		}
//		catch ( Exception e ) {
//			e.printStackTrace();
//		}
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		
		g.setFont(this.font);
		
		if ( this.currentMap != null ) {
			g.drawImage( this.currentMap, 0, 0, this );
		}
		
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
		
		paintEntities(g);
	}
	
	private void paintEntities( Graphics g ) {
		
		if ( this.entities != null ) {
			for ( Entity entity : this.entities ) {
				
				g.drawImage(entity, entity.getLocation().x, entity.getLocation().y, this );
			}
		}
	}
	
	
}
