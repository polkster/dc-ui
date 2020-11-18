package com.dungeoncrawler.dcui.panes.actions.instructions;

import com.dungeoncrawler.dcui.entities.Entity2D;

public class MovementInstruction extends Instruction {

	private int x;
	private int y;
	
	public MovementInstruction( Entity2D e, int delay, int x, int y ) {
		
		super( e, delay );
		
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
}
