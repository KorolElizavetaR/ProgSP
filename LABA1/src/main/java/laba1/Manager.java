package laba1;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class Manager {
	@Pattern(regexp =  "[А-ЯЁ][-А-яЁё]+ [А-ЯЁ][-А-яЁё]+ [А-ЯЁ][-А-яЁё]+", message = "awdawd")
	@NotNull
	private String full_name;
	
	@Min (value = 0)
	@Max (value = 150)
	@NotNull
	private Integer age;
	
	@NotNull
	private Boolean isCompetent;

	public Manager()
	{
		full_name = "";
		age = 0;
		isCompetent = true;
	}
	
	public Manager( String full_name, @Min (value = 0) @Max (value = 150) Integer age)
	{
		this();
		this.full_name = full_name;
		this.age = age;
	}
	
	@Valid
	public Manager(String full_name, Integer age, Boolean isCompetent) {
		this(full_name, age);
		this.isCompetent = isCompetent;
	}

	public String getFull_name() {
		return full_name;
	}

	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Boolean getIsCompetent() {
		return isCompetent;
	}

	public void setIsCompetent(Boolean isCompetent) {
		this.isCompetent = isCompetent;
	}
	
	public String IsCompetent() {
		if (isCompetent) return "competent";
		else return "incompetent";
	}

	@Override
	public String toString() {
		return "Manager [full_name=" + full_name + ", age=" + age + ", isCompetent=" + isCompetent + "]";
	}
	
	public String GetManager()
	{
		return "Manager " + full_name + " (" + age + " y.o.) is " + IsCompetent();
	}

}
