package lv.venta.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lv.venta.model.Grade;
import lv.venta.model.Student;
import lv.venta.repo.IGradeRepo;
import lv.venta.repo.IStudentRepo;
import lv.venta.service.IStudentCRUDService;

@Service
public class StudentCRUDServiceImpl implements IStudentCRUDService{

	@Autowired
	private IStudentRepo studRepo;

	@Autowired
	private IGradeRepo grRepo; 
	
	@Override
	public ArrayList<Student> retrieveAll() throws Exception {
		if(studRepo.count() == 0) {
			throw new Exception("Studentu tabula ir tuksa");
		}
		return (ArrayList<Student>)studRepo.findAll();
	}

	@Override
	public Student retrieveById(long id) throws Exception {
		if(id <= 0) {
			throw new Exception("Id nevar but negatvis vai 0");
		}
		if(!studRepo.existsById(id))
		{
			throw new Exception("Student ar id " + id + " neeksiste");
		}
		
		Student studentFromDB = studRepo.findById(id).get();
		
				
		return studentFromDB;
	}

	@Override
	public void deleteById(long id) throws Exception {
		Student studentForRemoving = retrieveById(id);
		
		ArrayList<Grade> gradesForThisStudent = grRepo.findByStudentSid(id);
		
		for(Grade tempG : gradesForThisStudent) {
			tempG.setStudent(null);
			grRepo.save(tempG);
		}
		
		studRepo.delete(studentForRemoving);
	}

	@Override
	public void create(String name, String surname) throws Exception {
		// TODO pabeigt pec lidziga piemera ka Produkta create servisa funkciju
		
	}

	@Override
	public void updateById(long id, String name, String surname) throws Exception {
		// TODO pabeigt pec lidziga piemera ka Produkta update servisa funkciju
		
	}

}
