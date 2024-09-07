package laba3.PlayableCharacter;

import java.util.Objects;

public class Mage extends PlayableCharacter{

	private Integer mana;
	
	public Mage() {
		super("Mage");
	}
	
	public Mage(Integer health, Integer attack_damage, MovemenButtons movemenButtons, String playableCharacterName, Integer mana) {
		super(health, attack_damage, "Mage", movemenButtons, playableCharacterName);
		this.mana = mana;
	}

	@Override
	public String attack() {
		return "Magical whoosh";
	}

	public Integer getMana() {
		return mana;
	}

	public void setMana(Integer mana) {
		this.mana = mana;
	}
	
	@Override
	public boolean isDead() {
		if (super.getHealth() <= 0)
		{
			if (this.mana == 0)
				return true;
			super.setHealth(mana * 10);
			mana = 0;
		}
		return false;
	}

	@Override
	String specialAttack() {
		return "Fire sphere";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(mana);
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
		Mage other = (Mage) obj;
		return Objects.equals(mana, other.mana);
	}

	@Override
	public String toString() {
		return super.toString() + ", mana=" + mana;
	}

}
