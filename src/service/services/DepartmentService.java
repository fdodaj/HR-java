package service.services;

import entity.Department;

import java.util.List;

public interface DepartmentService {

    List<Department> listDepartments();

    Department addDepartment(Department department);

    Department getDepartmentById(Integer id);

    Department deleteDepartment(Integer id);



}
