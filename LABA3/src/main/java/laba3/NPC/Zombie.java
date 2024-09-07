package laba3.NPC;

import java.util.Objects;

import laba3.ObjectsInterf.CreaturesImpl;
import laba3.ObjectsInterf.RigidBody;

public class Zombie extends CreaturesImpl implements RigidBody{
	private Integer rotLevel;
	
	public Zombie(Integer rotLevel) {
		super("Zombie");
		this.rotLevel = rotLevel;
	}
	
	public Zombie(Integer health, Integer attack_damage, Integer rotLevel) {
		super(health, attack_damage, "Zombie");
		this.rotLevel = rotLevel;
	}

	@Override
	public String attack() {
		return "Rotten bite";
	}

	public Integer getRotLevel() {
		return rotLevel;
	}

	public void setRotLevel(Integer rotLevel) {
		this.rotLevel = rotLevel;
	}
	
	@Override
	public void collision() {
		// какая-то реализация тоже, отличная от коллизии Волков и ИгрПерс. Например, воспринимают предмет коллизии
		// как преграду и пытаются ее сломать
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(rotLevel);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Zombie other = (Zombie) obj;
		return Objects.equals(rotLevel, other.rotLevel);
	}

	@Override
	public String toString() {
		return super.toString() + ", rotLevel=" + rotLevel;
	}
	
	

}
