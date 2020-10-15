package com.dungeoncrawler.dcui.panes;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.util.logging.Logger;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import com.dungeoncrawler.dcui.panes.elements.BottomPane;
import com.dungeoncrawler.dcui.panes.elements.LeftPane;
import com.dungeoncrawler.dcui.panes.elements.RightPane;
import com.dungeoncrawler.dcui.panes.elements.Viewport;

public class MainViewport extends JPanel implements ComponentListener {

	private static final long serialVersionUID = 1L;
	
	private static final int MIN_WIDTH = 800;
	private static final int MIN_HEIGHT = 600;
	
	private JPanel leftPanel;
	private JPanel rightPanel;
	private JPanel viewport;
	private JTextArea bottomPane;
	
	private JScrollPane left;
	private JScrollPane right;
	private JScrollPane bottom;
	
	private int preferredWidthLeftPane;
	private int preferredWidthRightPane;
	private int preferredHeightBottomPane;
	
	public MainViewport( int leftPaneWidth, int rightPaneWidth, int bottomPaneHeight ) {
		
		this.preferredWidthLeftPane = leftPaneWidth;
		this.preferredWidthRightPane = rightPaneWidth;
		this.preferredHeightBottomPane = bottomPaneHeight;
		
		setupPane();
	}
	
	private void setupPane() {
		
		setLayout( null );
		
		this.leftPanel = new LeftPane();
		this.rightPanel = new RightPane();
		this.bottomPane = new BottomPane();
		this.viewport = new Viewport();
		
		this.left = new JScrollPane(this.leftPanel);
		this.right = new JScrollPane(this.rightPanel);
		this.bottom = new JScrollPane(this.bottomPane);
	
		add( this.left );
		add( this.right );
		add( this.bottom );
		add( this.viewport );
	}
	
	public void reRender() {
		
		setViewportSize();
		Container container = getRootContainer();
		
		if ( container != null ) {
			int width = container.getWidth();
			int height = container.getHeight();
			
			if ( width < MIN_WIDTH || height < MIN_HEIGHT ) {
				Logger.getAnonymousLogger().warning("The screen size is too small to render.  Aborting render sequence");
				return;
			}
			
			positionElements(container);
			sizeElements(container);
			
			this.repaint();
		}
	}
	
	private void setViewportSize() {
		Container root = getRootContainer();
		
		if ( root != null ) {
			Logger.getAnonymousLogger().info("Setting viewport size to: " + root.getWidth() + " x " + root.getHeight() );
		}
	}
	
	private void positionElements( Container root ) {
		this.left.setLocation( new Point(0,0));
		this.right.setLocation( new Point( root.getWidth() - this.preferredWidthRightPane, 0 ));
		this.bottom.setLocation( new Point( 0, root.getHeight() - this.preferredHeightBottomPane ));
		this.viewport.setLocation( new Point( this.preferredWidthLeftPane, 0 ));
	}
	
	private void sizeElements( Container root ) {
		this.left.setSize( new Dimension( this.preferredWidthLeftPane, root.getHeight() - this.preferredHeightBottomPane ));
		this.right.setSize( new Dimension( this.preferredWidthRightPane, root.getHeight() - this.preferredHeightBottomPane ));
		this.bottom.setSize( new Dimension( root.getWidth(), this.preferredHeightBottomPane ));
		this.bottom.getViewport().setSize( new Dimension( root.getWidth(), this.preferredHeightBottomPane-30 ));
		this.bottom.setBorder(BorderFactory.createEmptyBorder( 0, 0, 30, 0 ));
		this.viewport.setSize( new Dimension( root.getWidth() - this.preferredWidthLeftPane - this.preferredWidthRightPane, root.getHeight() - this.preferredHeightBottomPane ));
	}
	
	private Container getRootContainer() {
		
		Container obj = getParent();
		
		while ( obj.getParent() != null ) {
			obj = obj.getParent();
		}
		
		return obj;
	}

	@Override
	public void componentResized(ComponentEvent e) {
		
		this.reRender();
	}

	@Override
	public void componentMoved(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void componentShown(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void componentHidden(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
}
