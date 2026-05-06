package lv.venta.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lv.venta.model.Course;
import lv.venta.model.Grade;
import lv.venta.model.Professor;
import lv.venta.model.Student;
import lv.venta.model.enums.Degree;
import lv.venta.repo.ICourseRepo;
import lv.venta.repo.IGradeRepo;
import lv.venta.repo.IProfessorRepo;
import lv.venta.repo.IStudentRepo;
import lv.venta.service.IFilterService;

@Service
public class FilterServiceImpl implements IFilterService{

	@Autowired
	private IProfessorRepo profRepo;
	
	@Autowired
	private ICourseRepo courseRepo;
	
	@Autowired
	private IStudentRepo studRepo;
	
	@Autowired
	private IGradeRepo grRepo;
	
	@Override
	public ArrayList<Professor> filterProfessorsByDegree(Degree degree) throws Exception {
		if(degree == null) {
			throw new Exception("Gradam jabut eksistejosam");
		}
		
		ArrayList<Professor> result  = profRepo.findByDegree(degree);
		
		if(result.isEmpty()) {
			throw new Exception("Nav profesori ar " + degree);
		}
		
		return result;
	}

	@Override
	public ArrayList<Course> filterCoursesByProfessorId(long id) throws Exception {
		if(id <= 0) {
			throw new Exception("Id jabut pozitivam");
		}
		
		if(!profRepo.existsById(id)) {
			throw new Exception("Nevar atgriezt kursus, jo profesors ar id " + id + " neeksiste");
		}
		
		ArrayList<Course> result = courseRepo.findByProfessorPid(id);
		
		if(result.isEmpty()) {
			throw new Exception("profesoram ar id " + id + " nav piesaistits neviens kurss");
		}
		
		return result;
	}

	@Override
	public ArrayList<Grade> filterGradesByStudentNameAndSurname(String name, String surname) throws Exception {
		if(name == null || surname == null) {//TODO var pielikt ari isEmpty un regex
			throw new Exception("Ievades dati nav pilnigi");
		}
		
		if(!studRepo.existsByNameAndSurname(name, surname)) {
			throw new Exception("Students " + name + " " + surname + " neeksiste");
		}
		
		ArrayList<Grade> result = grRepo.findByStudentNameAndStudentSurname(name, surname);
		
		if(result.isEmpty()) {
			throw new Exception("Studentam " + name + " " + surname + " nav piesaistas atzimes");
		}
		
		return result;
	}

	@Override
	public float calculateAvgGradeByCourseTitle(String title) throws Exception {
		if(title == null) {//TODO isempty un regex
			throw new Exception("Ievades dati nav pilnigi");
		}
		
		if(!courseRepo.existsByTitle(title)) {
			throw new Exception("Kurss ar nosaukumu " + title + " neeksite");
		}
		
		
		float result = grRepo.calculateAVGGradeForCourse(title);
		
		if(result == 0) {
			throw new Exception("Kursam " + title + " nav piesaistias atzimes un nevar aprekinat videjo");
		}
		
		return result;
	}

	@Override
	public ArrayList<Student> filterStudentsWithFailedGrades() throws Exception {
		
		if(studRepo.count() == 0) {
			throw new Exception("Studentu tabula ir tuksa");
		}
		
		if(grRepo.count() == 0) {
			throw new Exception("Atzimju tabula ir tuksa");
		}
		
		
		ArrayList<Student> result = studRepo.findByGradesGrvalueLessThan(4);
		
		if(result.isEmpty()) {
			throw new Exception("Sistema nav neviens students ar nesekmigu atzimi");
		}
		
		return result;
	}

}
