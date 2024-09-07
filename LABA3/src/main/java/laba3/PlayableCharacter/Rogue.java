package laba3.PlayableCharacter;

import java.util.Objects;

public class Rogue extends PlayableCharacter {

	private Integer arrows;
	
	public Rogue() {
		super("Rogue");
	}
	
	public Rogue(Integer health, Integer attack_damage, MovemenButtons movemenButtons, String playableCharacterName, Integer mana) {
		super(health, attack_damage, "Rogue", movemenButtons, playableCharacterName);
		this.setArrows(arrows);
	}

	@Override
	public String attack() {
		return "Pull a bowstring and let it go";
	}

	@Override
	String specialAttack() {
		return "Backstab";
	}

	public Integer getArrows() {
		return arrows;
	}

	public void setArrows(Integer arrows) {
		this.arrows = arrows;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(arrows);
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
		Rogue other = (Rogue) obj;
		return Objects.equals(arrows, other.arrows);
	}

	@Override
	public String toString() {
		return super.toString() + ", arrows=" + arrows;
	}
	
	
	
}
