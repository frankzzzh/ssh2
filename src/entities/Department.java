package entities;

/**
 * @author Andong
 * @create 2021-06-10-19:59
 */
public class Department {
    private int id;
    private String department_name;

    public Department(String department_name) {
        this.department_name = department_name;
    }

    public Department() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDepartment_name() {
        return department_name;
    }

    public void setDepartment_name(String department_name) {
        this.department_name = department_name;
    }

}
