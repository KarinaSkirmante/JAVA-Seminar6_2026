package lv.venta.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;



//2. ja no bazes klases bus ari repo
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name = "PersonTable")
@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Person {
	
	@Setter(value = AccessLevel.NONE)
	@Column(name = "Pid")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long pid;
	
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
