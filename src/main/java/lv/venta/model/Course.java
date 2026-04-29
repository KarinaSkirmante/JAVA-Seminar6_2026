package lv.venta.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name = "CourseTable")
@Entity
public class Course {
	
	
	@Setter(value = AccessLevel.NONE)
	@Column(name = "Cid")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long cid;
	
	@NotNull
	@NotEmpty
	@Pattern(regexp = "[A-Z]{1}[A-Za-z0-9 ]{1,40}")
	@Column(name = "Title")
	private String title;
	
	@Min(1)
	@Max(30)
	@Column(name = "CreditPoints")
	private int creditPoints;
	
	@OneToOne
	//joincolumn ir ar id no otras klases
	@JoinColumn(name = "Pid")
	private Professor professor;
	
	//TODO sasaiste ar profesoru
	public Course(String title, int creditPoints, Professor professor) {
		setTitle(title);
		setCreditPoints(creditPoints);
		setProfessor(professor);
	}
	
	

}
