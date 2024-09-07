package laba3.NPC;

import laba3.ObjectsInterf.CreaturesImpl;
import laba3.ObjectsInterf.RigidBody;

public class Wolf extends CreaturesImpl implements RigidBody{

	public Wolf() {
		super("Wolf");
	}

	public Wolf(Integer health, Integer attack_damage) {
		super(health, attack_damage, "Wolf");
	}

	@Override
	public String attack() {
		return "claws attack";
	}

	@Override
	public void collision() {
		// такая же реализация как у человека
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		return true;
	}

	@Override
	public String toString() {
		return super.toString();
	}
	
}
