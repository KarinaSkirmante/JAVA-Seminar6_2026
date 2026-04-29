package lv.venta.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name = "GradeTable")
@Entity
public class Grade {
	
	@Setter(value = AccessLevel.NONE)
	@Column(name = "Gid")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long gid;
	
	@Min(0)
	@Max(10)
	@Column(name = "grValue")
	private int grvalue;
	
	//TODO sasaitse uz studentu
	@ManyToOne
	@JoinColumn(name = "Sid")
	private Student student;
	
	//TODO sasaiste uz kursu
	
	//TODO argumenta konstruktors

}
