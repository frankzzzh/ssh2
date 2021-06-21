package service;

import dao.EmployeeDao;
import entities.Employee;

import java.util.List;

/**
 * @author Andong
 * @create 2021-06-11-21:02
 */
public class EmployeeService {
    private EmployeeDao employeeDao;

    public void setEmployeeDao(EmployeeDao employeeDao){
        this.employeeDao = employeeDao;
    }

    public List<Employee> getAll(){
        return employeeDao.getAll();
    }

    public void delete(int id){
        employeeDao.delete(id);
    }

    public void saveOrUpdate(Employee employee){
        employeeDao.saveOrUpdate(employee);
    }

    public boolean lastNameIsValid(String lastName){
        return employeeDao.getEmployeeByLastName(lastName) == null;
    }

    public Employee get(int id){
        return employeeDao.get(id);
    }

}
