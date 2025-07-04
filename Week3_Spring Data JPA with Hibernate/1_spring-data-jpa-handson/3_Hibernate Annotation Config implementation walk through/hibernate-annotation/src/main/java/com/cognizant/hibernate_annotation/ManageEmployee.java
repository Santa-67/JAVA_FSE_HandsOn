package com.cognizant.hibernate_annotation;

import com.cognizant.model.Employee;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class ManageEmployee {
   private static SessionFactory factory;

   public static void main(String[] args) {
      try {
         factory = new Configuration()
               .configure()  // loads hibernate.cfg.xml
               .addAnnotatedClass(Employee.class)
               .buildSessionFactory();
      } catch (Throwable ex) {
         System.err.println("Failed to create sessionFactory object." + ex);
         throw new ExceptionInInitializerError(ex);
      }

      ManageEmployee ME = new ManageEmployee();
      Integer empID1 = ME.addEmployee("Zara", "Ali", 1000);
      Integer empID2 = ME.addEmployee("Daisy", "Das", 5000);
      Integer empID3 = ME.addEmployee("John", "Paul", 10000);
      ME.listEmployees();
      ME.updateEmployee(empID1, 7000);
      ME.deleteEmployee(empID2);
      ME.listEmployees();
   }

   public Integer addEmployee(String fname, String lname, int salary) {
      Session session = factory.openSession();
      Transaction tx = null;
      Integer employeeID = null;

      try {
         tx = session.beginTransaction();
         Employee employee = new Employee(fname, lname, salary);
         employeeID = (Integer) session.save(employee);
         tx.commit();
      } catch (HibernateException e) {
         if (tx != null) tx.rollback();
         e.printStackTrace();
      } finally {
         session.close();
      }
      return employeeID;
   }

   public void listEmployees() {
      Session session = factory.openSession();
      Transaction tx = null;

      try {
         tx = session.beginTransaction();
         List<Employee> employees = session.createQuery("FROM Employee", Employee.class).list();
         for (Employee emp : employees) {
            System.out.println("First Name: " + emp.getFirstName()
                  + ", Last Name: " + emp.getLastName()
                  + ", Salary: " + emp.getSalary());
         }
         tx.commit();
      } catch (HibernateException e) {
         if (tx != null) tx.rollback();
         e.printStackTrace();
      } finally {
         session.close();
      }
   }

   public void updateEmployee(Integer EmployeeID, int salary) {
      Session session = factory.openSession();
      Transaction tx = null;

      try {
         tx = session.beginTransaction();
         Employee employee = session.get(Employee.class, EmployeeID);
         employee.setSalary(salary);
         session.update(employee);
         tx.commit();
      } catch (HibernateException e) {
         if (tx != null) tx.rollback();
         e.printStackTrace();
      } finally {
         session.close();
      }
   }

   public void deleteEmployee(Integer EmployeeID) {
      Session session = factory.openSession();
      Transaction tx = null;

      try {
         tx = session.beginTransaction();
         Employee employee = session.get(Employee.class, EmployeeID);
         session.delete(employee);
         tx.commit();
      } catch (HibernateException e) {
         if (tx != null) tx.rollback();
         e.printStackTrace();
      } finally {
         session.close();
      }
   }
}
