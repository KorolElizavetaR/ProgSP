package laba2.Objects;

import laba2.interf.implementation.ElectronicsImpl;

public class Kettle extends ElectronicsImpl{

	public Kettle() {
		super("Kettle");
	}
	
	public Kettle(Integer voltage) {
		this();
		setVoltage(voltage);
	}

}
