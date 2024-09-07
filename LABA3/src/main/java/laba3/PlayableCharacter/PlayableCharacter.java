package laba3.PlayableCharacter;

import java.util.Objects;

import laba3.ObjectsInterf.CreaturesImpl;
import laba3.ObjectsInterf.RigidBody;

public abstract class PlayableCharacter extends CreaturesImpl implements RigidBody{
	MovemenButtons movemenButtons;
	String PlayableCharacterName;

	public PlayableCharacter()
	{
		super(null);
	}
	
	public PlayableCharacter(String name)
	{
		super(name);
	}
	
	public String getPlayableCharacterName() {
		return PlayableCharacterName;
	}

	public void setPlayableCharacterName(String playableCharacterName) {
		PlayableCharacterName = playableCharacterName;
	}

	public void setMovemenButtons(MovemenButtons movemenButtons) {
		this.movemenButtons = movemenButtons;
	}

	public MovemenButtons getMovemenButtons() {
		return movemenButtons;
	}

	public PlayableCharacter(Integer health, Integer attack_damage, String name, MovemenButtons movemenButtons, String playableCharacterName) {
		super(health, attack_damage, name);
		this.movemenButtons = movemenButtons;
		PlayableCharacterName = playableCharacterName;
	}
	
	public boolean isDead()
	{
		if (super.getHealth() <= 0) return true;
		return false;
	}
	
	abstract String specialAttack();
	
	@Override
	public void collision() {
		// какая-то реализация
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(PlayableCharacterName, movemenButtons);
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
		PlayableCharacter other = (PlayableCharacter) obj;
		return Objects.equals(PlayableCharacterName, other.PlayableCharacterName)
				&& movemenButtons == other.movemenButtons;
	}

	@Override
	public String toString() {
		return super.toString() + ", movemenButtons=" + movemenButtons + ", PlayableCharacterName="
				+ PlayableCharacterName;
	}
	
	
}
