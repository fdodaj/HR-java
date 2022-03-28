package service.services;

import entity.Department;
import entity.Permission;

import java.util.List;

public interface DepartmentService {

    List<Department> listDepartments();

    Department addDepartment(Department department);

    Department getDepartmentById(Integer id);

    Department deleteDepartment(Integer id);

    boolean deletePermanentDepartment(Integer id);

    Department getDepartmentName(Integer id);
}
