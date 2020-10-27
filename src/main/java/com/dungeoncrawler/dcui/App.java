package com.dungeoncrawler.dcui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.dungeoncrawler.dcui.panes.MainViewport;

public class App extends JFrame
{
	private static final long serialVersionUID = 1L;

	private MainViewport viewport;
	
	public static void main( String[] args ) throws IOException
    {
        new App(1024, 768 ).setupUI();
    }
    
    public App( int width, int height ) {
    		
    		setSize( width, height );
    		setMinimumSize( new Dimension( 800, 600 ));
    		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    		setCentered();
    		doLayout();
    		
    		setupUI();
    		
    		setVisible(true);
    }
    
    private void setCentered() {
    		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
    		
    		setLocation( (screen.width / 2 ) - ( getWidth() / 2 ), (screen.height / 2) - (getHeight() / 2) );
    }
    
    private void setupUI() {
    		
    		// we need three areas
    		// 1. Main Viewable window
    		// 2. Console on bottom.
    		// 3. Equipment to the right
    		JPanel root = new JPanel();
    		
    		root.setBackground(Color.cyan);
    		getContentPane().setLayout( new BorderLayout() );
    		getContentPane().add(root);
    		
    		this.viewport = new MainViewport(150, 150, 150);
    		
    		this.viewport.addComponentListener(this.viewport);
    		
    		root.setLayout( new BorderLayout() );
    		root.add( this.viewport, BorderLayout.CENTER );
    }
}
