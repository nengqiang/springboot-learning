package com.hnq.study;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hnq.study.dao.domain.Employee;
import com.hnq.study.dao.domain.EmployeeCriteria;
import com.hnq.study.dao.mapper.EmployeeMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author henengqiang
 * @date 2018/8/10
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class MyBatisTest {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Test
    public void pageHelperTest() {
        EmployeeCriteria example = new EmployeeCriteria();
        EmployeeCriteria.Criteria criteria = example.createCriteria();

        criteria.andEmailLike("%gmail%");

        PageHelper.startPage(1, 10);

        List<Employee> employees =  employeeMapper.selectByExample(example);

        PageInfo<Employee> pageInfo = new PageInfo<>(employees);
        pageInfo.getList().forEach(System.out::println);
    }

    @Test
    public void insertDeleteUpdateFindTest() {
        EmployeeCriteria example = new EmployeeCriteria();
        EmployeeCriteria.Criteria criteria = example.createCriteria();

        // insert
        Employee employee = new Employee();
        employee.setEmpId(48);
        employee.setEmpName("测试小姐");
        employee.setGender("f");
        employee.setEmail("testGirl@163.com");
        employee.setDeptId(2);
        try {
            int num = employeeMapper.insert(employee);
            System.out.println("Insert " + num + " employee(s)");
        } catch (Exception e) {
            System.out.println("Insert failed");
            e.printStackTrace();
        }

        // find
        findAndPrint(criteria, example);

        // update
        Employee anotherEmp = new Employee();
        anotherEmp.setEmpName("测试小哥");
        anotherEmp.setGender("m");
        anotherEmp.setEmail("testBoy@gmail.com");
        try {
            int num = employeeMapper.updateByExampleSelective(anotherEmp, example);
            System.out.println("Updated " + num + " employee(s)");
        } catch (Exception e) {
            System.out.println("Update failed");
            e.printStackTrace();
        }

        // find again
        findAndPrint(criteria, example);

        // waite for 3 seconds then delete the employee who we added just now
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // delete(If you want to reserve it, take the following code out)
        try {
            int num = employeeMapper.deleteByExample(example);
            System.out.println("Deleted " + num + " employee(s)");
        } catch (Exception e) {
            System.out.println("Delete failed");
            e.printStackTrace();
        }

        // find again
        findAndPrint(criteria, example);

    }

    private void findAndPrint(EmployeeCriteria.Criteria criteria ,EmployeeCriteria example) {
        criteria.andEmpIdEqualTo(48);
        try {
            List<Employee> employees = employeeMapper.selectByExample(example);
            if (employees != null && employees.size() > 0) {
                for (Employee emp : employees) {
                    System.out.println(emp);
                }
            } else {
                System.out.println("There hasn't a employee who you are looking for...");
            }
        } catch (Exception e) {
            System.out.println("Find employee failed");
            e.printStackTrace();
        }
    }

}
