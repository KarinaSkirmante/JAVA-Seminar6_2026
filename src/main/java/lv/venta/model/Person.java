package lv.venta.model;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//1. no sis klases neveidosies tabula DB (parasti, ja netaisa objektu no sis klases vai abstractam modelu kalse)
@MappedSuperclass //nevajag lietot @Table un @Entity, bet tikai @Column pie mainigajiem
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Person {
	
	@NotNull
	@NotEmpty
	@Pattern(regexp = "[A-Z]{1}[a-z]{2,15}([ ]{1}[A-Z]{1}[a-z]{2,15})?")
	@Column(name = "Name")
	private String name;
	
	@NotNull
	@NotEmpty
	@Pattern(regexp = "[A-Z]{1}[a-z]{2,15}([-]{1}[A-Z]{1}[a-z]{2,15})?")
	@Column(name = "Surname")
	private String surname;
	
	
	public Person(String name, String surname) {
		setName(name);
		setSurname(surname);
	}

}
