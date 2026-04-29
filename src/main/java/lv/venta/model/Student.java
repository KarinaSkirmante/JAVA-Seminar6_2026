package lv.venta.model;

import java.util.ArrayList;
import java.util.Collection;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Table(name = "StudentTable")
@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Student extends Person{

	@Setter(value = AccessLevel.NONE)
	@Column(name = "Sid")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long sid;
	
		
	@OneToMany(mappedBy = "student")
	@ToString.Exclude
	private Collection<Grade> grades = new ArrayList<>();
	
	public Student(String name, String surname) {
		super(name, surname);
	}
	
}
