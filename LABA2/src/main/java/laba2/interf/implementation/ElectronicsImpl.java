package laba2.interf.implementation;

import java.util.Objects;

import laba2.interf.Electronics;

public abstract class ElectronicsImpl implements Electronics{
	private Integer voltage;
	private final String electronicsType;

	protected ElectronicsImpl(String electronicsType)
	{
		this.electronicsType = electronicsType;
		voltage = 0;
	}
	
	protected ElectronicsImpl(String electronicsType, Integer voltage)
	{
		this(electronicsType);
		this.voltage = voltage;
	}
	
	public Integer getVoltage() {
		return voltage;
	}

	public void setVoltage(Integer voltage) {
		this.voltage = voltage;
	}
	
	@Override
	public Boolean CheckVoltage() {
		if (voltage != 0) return true;
		else return false;
	}
	
	@Override
	public String isWorking() {
		if (CheckVoltage()) return electronicsType + " is working";
		else return electronicsType + " does not meet criteria \"voltage\" to start.";
	}

	public String getElectronicsType() {
		return electronicsType;
	}

	@Override
	public String toString() {
		return "voltage = " + voltage + ", electronicsType = " + electronicsType;
	}

	@Override
	public int hashCode() {
		return Objects.hash(electronicsType, voltage);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ElectronicsImpl other = (ElectronicsImpl) obj;
		return Objects.equals(electronicsType, other.electronicsType) && Objects.equals(voltage, other.voltage);
	}
		
}
