package laba3.PlayableCharacter;

public enum MovemenButtons {
	
	Arrows("← → ↑ ↓"), Buttons("WASD");
	private String movementButtons;
	
	MovemenButtons (String movementButtons)
	{
		this.setMovementButtons(movementButtons);
	}

	public String getMovementButtons() {
		return movementButtons;
	}

	public void setMovementButtons(String movementButtons) {
		this.movementButtons = movementButtons;
	}
	
}
