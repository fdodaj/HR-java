package service;

import entity.Department;
import repository.DepartmentRepository;
import service.services.DepartmentService;

import java.util.List;


public class DepartmentServiceImpl implements DepartmentService {
    DepartmentRepository departmentRepository = new DepartmentRepository();
    @Override
    public List<Department> listDepartments() {
        return departmentRepository.listDepartments();
    }
    @Override
    public Department addDepartment(Department department) {
        return departmentRepository.addDepartment(department);
    }

    @Override
    public Department getDepartmentById(Integer id) {
        return departmentRepository.getDepartmentById(id);
    }

    @Override
    public Department deleteDepartment(Integer id) {
        return departmentRepository.delete(id);
    }
}
