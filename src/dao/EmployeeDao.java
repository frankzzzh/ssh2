package dao;

import entities.Employee;
import org.hibernate.Query;

import java.util.List;

/**
 * @author Andong
 * @create 2021-06-11-20:14
 */
public class EmployeeDao extends BaseDao{


    public List<Employee> getAll(){
        String hql = "From Employee e left outer join fetch e.department";
        return getSession().createQuery(hql).list();
    }

    public void delete(int id){
        String hql = "DELETE FROM Employee e WHERE e.id = ?";
        getSession().createQuery(hql).setInteger(0,id).executeUpdate();
    }

    public void saveOrUpdate(Employee employee){
        getSession().saveOrUpdate(employee);
    }

    public Employee getEmployeeByLastName(String lastName){
        String hql = "FROM Employee e where e.lastName=?";
        Query query = getSession().createQuery(hql).setString(0, lastName);
        return (Employee) query.uniqueResult();
    }

    public Employee get(int id){
        return (Employee) getSession().get(Employee.class, id);
    }

}
