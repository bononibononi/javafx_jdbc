package model.services;

import java.util.ArrayList;
import java.util.List;

import model.entidades.Departments;

public class DepartmentService {

	public List<Departments> findAll(){
		List<Departments> list = new ArrayList<>();
		list.add(new Departments (1, "Livros"));
		list.add(new Departments (2, "computadores"));
		list.add(new Departments (3, "eletrônicos"));
		return list;	
	}
}
