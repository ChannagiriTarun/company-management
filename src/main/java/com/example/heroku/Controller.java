package com.example.heroku;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/employees")
public class Controller {

    Configuration con = new Configuration().configure().addAnnotatedClass(Employee.class);
    SessionFactory sf= con.buildSessionFactory();

    Session session = sf.openSession();


    @GetMapping

    public List<Employee> findAllStudentsWithJpql() {

        session.clear();
        return session.createQuery("SELECT a FROM Employee a", Employee.class).getResultList();
    }


    @GetMapping(path="/{eid}")
    public Employee add(@PathVariable int eid)
    {
        session.clear();
        return  (Employee)session.get(Employee.class , eid);
    }
    @PostMapping
    public String ad(@RequestBody Employee emp) {
        Transaction tx =  session.beginTransaction();
        session.clear();
        session.save(emp);
        tx.commit();

        return " successfully added " + emp.toString();

    }

    @PutMapping
    public String update(@RequestBody Employee emp) {

        Transaction tx =  session.beginTransaction();
        session.clear();
        session.saveOrUpdate(emp);
        tx.commit();
        return " successfully updated " + emp.toString();

    }
    @DeleteMapping(path = "/{eid}")
    public String ad(@PathVariable int eid) {

        Employee emp = (Employee)session.get(Employee.class , eid);
        String temp = " successfully deleted "+emp.toString();
        Transaction tx =  session.beginTransaction();
        session.clear();
        session.delete(emp);
        tx.commit();

        return temp;

    }
}

@RestController
@RequestMapping("/")
class Controller2 {
    @GetMapping
    public String h()
    {
        return "Welcome to employee management";
    }

}




