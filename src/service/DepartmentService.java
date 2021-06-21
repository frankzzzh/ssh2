package service;

import dao.DepartmentDao;
import entities.Department;

import java.util.List;

/**
 * @author Andong
 * @create 2021-06-13-16:54
 */
public class DepartmentService {

    public DepartmentDao  departmentDao;

    public void setDepartmentDao(DepartmentDao departmentDao){
        this.departmentDao = departmentDao;
    }

    public List<Department> getAll(){
        return departmentDao.getAll();
    }



}
