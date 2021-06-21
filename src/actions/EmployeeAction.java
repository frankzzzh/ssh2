package actions;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import entities.Employee;
import org.apache.struts2.interceptor.RequestAware;
import org.junit.runner.Request;
import org.springframework.ui.Model;
import service.DepartmentService;
import service.EmployeeService;

import javax.swing.*;
import javax.swing.plaf.basic.BasicSliderUI;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.Map;

/**
 * @author Andong
 * @create 2021-06-11-16:37
 */
public class EmployeeAction extends ActionSupport implements RequestAware, ModelDriven<Employee>, Preparable {
    private static final long serialVersionUID = 1l;

    private EmployeeService employeeService;

    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    private InputStream inputStream;

    public InputStream getInputStream() {
        return inputStream;
    }

    public String list() {
        request.put("employees", employeeService.getAll());
        return "list";
    }

    private Integer id;

    public void setId(int id) {
        this.id = id;
    }

    public String delete() {

        try {
            employeeService.delete(id);
            inputStream = new ByteArrayInputStream("1".getBytes(StandardCharsets.UTF_8));
        } catch (Exception e) {
            e.printStackTrace();
            try {
                inputStream = new ByteArrayInputStream("0".getBytes(StandardCharsets.UTF_8));
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }

        return "ajax-success";
    }

    public String input() {
        request.put("departments", departmentService.getAll());
        return INPUT;
    }

    public void prepareInput() {
        if (id != null) {
            model = employeeService.get(id);

        }
    }


    private String lastName;

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String validateLastName() throws Exception {
        if (employeeService.lastNameIsValid(lastName)) {
            inputStream = new ByteArrayInputStream("1".getBytes(StandardCharsets.UTF_8));
        } else {
            inputStream = new ByteArrayInputStream("0".getBytes(StandardCharsets.UTF_8));
        }

        return "ajax-success";
    }

    private Map<String, Object> request;

    @Override
    public void setRequest(Map<String, Object> arg0) {
        this.request = arg0;
    }

    private DepartmentService departmentService;

    public void setDepartmentService(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    public String save() {
        if (id == null) {
            model.setCreateTime(new Date());
        }
        System.out.println(model);
        employeeService.saveOrUpdate(model);
        return SUCCESS;
    }

    public void prepareSave() {

        if (id == null) {
            model = new Employee();
        } else {
            model = employeeService.get(id);
        }
    }

    private Employee model;

    @Override
    public Employee getModel() {
        return model;
    }

    @Override
    public void prepare() throws Exception {

    }
}
