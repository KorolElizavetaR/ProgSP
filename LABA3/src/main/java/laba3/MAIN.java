package laba3;

import java.util.ArrayList;
import java.util.List;

import laba3.NPC.Wolf;
import laba3.NPC.Zombie;
import laba3.ObjectsInterf.CreaturesImpl;
import laba3.PlayableCharacter.Mage;
import laba3.PlayableCharacter.MovemenButtons;
import laba3.PlayableCharacter.Rogue;

public class MAIN {

	public static void main(String[] args) {
		List <CreaturesImpl> characters = new ArrayList<>();
		characters.add(new Mage(40, 6, MovemenButtons.Arrows, "Adolf", 5));
		characters.add(new Rogue(60, 3, MovemenButtons.Buttons, "Shapka ", 40));
		characters.add(new Wolf(35, 10));
		characters.add(new Zombie (70, 3, 2));

		for (CreaturesImpl charact : characters)
		{
			System.out.println(charact);
			System.out.println("\t" + charact.attack());
		}
		
		// characters.get(3).getRotLevel();
		Zombie zombie = (Zombie) characters.get(3);
		System.out.println("Rot level" + zombie.getRotLevel()); // норм
		
		Mage mage = (Mage) characters.get(0);
		System.out.println(mage + " | Is Dead: " + mage.isDead());
		mage.setHealth(0);
		System.out.println(mage + " | Is Dead: " + mage.isDead());
		
		Rogue rogue = (Rogue) characters.get(1);
		System.out.println(rogue + " | Is Dead: " + rogue.isDead());
		rogue.setHealth(0);
		System.out.println(rogue + " | Is Dead: " + rogue.isDead());
		
	}

}
