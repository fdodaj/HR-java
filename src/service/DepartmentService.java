package service;

import entity.Department;

public interface DepartmentService {

    void listDepartments();

    Department addDepartment(Department department);

    Department getDepartmentById(Integer id);

    Department deleteDepartment(Integer id);



}
