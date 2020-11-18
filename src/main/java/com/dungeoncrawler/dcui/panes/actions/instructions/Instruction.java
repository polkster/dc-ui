package com.dungeoncrawler.dcui.panes.actions.instructions;

import com.dungeoncrawler.dcui.entities.Entity2D;

public class Instruction {
	
	private Entity2D entity;
	private int delay;
	private long executeTime;
	
	public Instruction( Entity2D entity, int delay ) {
		this.entity = entity;
		this.delay = delay;
		
		this.executeTime = System.currentTimeMillis() + this.delay;
	}

	public Entity2D getEntity() {
		return entity;
	}

	public void setEntity(Entity2D entity) {
		this.entity = entity;
	}

	public int getDelay() {
		return delay;
	}

	public void setDelay(int delay) {
		this.delay = delay;
	}
	
	public long getExecuteTime() {
		return this.executeTime;
	}
	
	public void setExecuteTime( long ms ) {
		this.executeTime = ms;
	}
}
