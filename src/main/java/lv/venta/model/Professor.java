package lv.venta.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lv.venta.model.enums.Degree;


@Getter
@Setter
@NoArgsConstructor
@ToString
//@Table(name = "ProfessorTable"), tas jaaizkkomenta, ja ir SINGLE_TABLE startegija pie mantosanas
@Entity
public class Professor extends Person{
	
	
	@NotNull
	@Column(name = "Degree")
	@Enumerated(EnumType.STRING)
	private Degree degree;

	//mapedBy ir ar otras klases mainigo jasaasaita
	@OneToOne(mappedBy = "professor")
	@ToString.Exclude
	//@JsonIgnore, tad ja izmantojam citu priekgalsistemu, piemeram, React, Vue, Angular utt
	private Course course;
	
	
	public Professor(String name, String surname, Degree degree) {
		super(name, surname);
		setDegree(degree);
	}
}
