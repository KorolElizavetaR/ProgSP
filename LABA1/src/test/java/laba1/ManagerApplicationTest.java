package laba1;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Set;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;

public class ManagerApplicationTest {
	static Validator validator;
	
	@BeforeAll
	static void ValidationInit()
	{
		validator = Validation.buildDefaultValidatorFactory().getValidator();
	}
	
	@Test
	void CreateNormalManagerTest() {
		Manager manager = new Manager("Вахтеман Андрей Андреевич", 23);
		System.out.println(manager);
	}
	
	@Test
	void IsThisManagerCompetentTest() {
		Manager manager = new Manager("Борейко Александр Александрович", 50, false);
		System.out.println(manager.GetManager());
		Assertions.assertThat(manager.getIsCompetent()).as(manager.getFull_name() + " is incompetent!").isTrue();
	}
	
	@Test
	void CreateRandomFullnameManager() {
		Manager manager = new Manager("AWsdAWDAWDDASD", 45);
		Set<ConstraintViolation<Manager>> violations = validator.validate(manager);
		assertTrue(violations.isEmpty());
	}
	
}
