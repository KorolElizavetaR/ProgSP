package laba3.ObjectsInterf;

import java.util.Objects;

public abstract class CreaturesImpl implements Creatures{
	Integer health;
	Integer attack_damage;
	final String name;
	
	public CreaturesImpl(String name) {
		this.name = name;
	}

	public CreaturesImpl(Integer health, Integer attack_damage, String name) {
		this(name);
		this.health = health;
		this.attack_damage = attack_damage;
	}

	public Integer getHealth() {
		return health;
	}
	
	public void setHealth(Integer health) {
		this.health = health;
	}
	
	public Integer getAttack_damage() {
		return attack_damage;
	}
	
	public void setAttack_damage(Integer attack_damage) {
		this.attack_damage = attack_damage;
	}
	
	public String getName() {
		return name;
	}

	@Override
	public int hashCode() {
		return Objects.hash(attack_damage, health, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		CreaturesImpl other = (CreaturesImpl) obj;
		return Objects.equals(attack_damage, other.attack_damage) && Objects.equals(health, other.health)
				&& Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "health=" + health + ", attack_damage=" + attack_damage + ", name=" + name;
	}
	
	
	
}
