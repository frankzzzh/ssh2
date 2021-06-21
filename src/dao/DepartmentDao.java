package dao;

import entities.Department;

import java.util.List;

/**
 * @author Andong
 * @create 2021-06-13-16:51
 */
public class DepartmentDao extends BaseDao{


    public List<Department> getAll(){
        String hql = "FROM Department";
        return getSession().createQuery(hql).list();
    }

    public void delete(int id){
        String hql = "DELETE FROM Employee e WHERE e.id = ?";
        getSession().createQuery(hql).setInteger(0,id).executeUpdate();
    }

}
