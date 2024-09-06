package laba2.Objects;

import laba2.interf.implementation.ElectronicsImpl;

public class Computer extends ElectronicsImpl{

	public Computer() {
		super("Computer");
	}
	
	public Computer(Integer voltage) {
		this();
		setVoltage(voltage);
	}
}
