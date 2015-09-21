package com.hibernate.onetomany;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class HibernateOneToManyTester {

    public static void main(String[] args) {
        Session session = HibernateUtil.createSessionFactory().openSession();
        Transaction txn = null;
        try{
            txn = session.beginTransaction();
            Company company = new Company();
            company.setCity("Hyderabad");
            company.setCountry("India");
            company.setState("Telangana");
            company.setStreet("R Nagar");
            
            Employee emp1 = new Employee();
            emp1.setEmployeeName("Krishnam G");
            emp1.setEmployeeContact("9885040187");
            emp1.setEmployeeEmail("krishnamrajgoud@gmail.com");
            emp1.setEmployeeId("10876");
            emp1.setEmployeeRole("SDE");
            emp1.setIsAdmin("1");
            emp1.setPassword("Lean1234");
            
            Employee emp2 = new Employee();
            emp2.setEmployeeName("Krishnam G2");
            emp2.setEmployeeContact("9866035579");
            emp2.setEmployeeEmail("findkrishnam@gmail.com");
            emp2.setEmployeeId("12345");
            emp2.setEmployeeRole("PE");
            emp2.setIsAdmin("0");
            emp2.setPassword("Lean123");
            
            Set<Employee> employees = new HashSet<Employee>();
            employees.add(emp1);
            employees.add(emp2);

            company.setEmployees(employees);
            session.save(company);
            
        }catch(HibernateException hx){
            txn.rollback();
        }finally{
            txn.commit();
        }
    }

}
