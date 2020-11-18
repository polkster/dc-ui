package com.dungeoncrawler.dcui.panes.actions;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

import com.dungeoncrawler.dcui.panes.actions.instructions.Instruction;

public class Actions {

	private Queue<Instruction> queue = new ArrayBlockingQueue<>(1000);
	private Instruction lastInstruction = null;
	
	public Actions() {
		
	}
	
	public void addAction( Instruction instruction ) {
		
		if ( this.lastInstruction != null ) {
			instruction.setExecuteTime( lastInstruction.getExecuteTime() + instruction.getDelay() );
		}
		
		this.queue.add( instruction );
		
		this.lastInstruction = instruction;
	}
	
	public Instruction peekNextInstruction() {
		return this.queue.peek();
	}
	
	public Instruction fetchNextInstruction() {
		return this.queue.poll();
	}
}
