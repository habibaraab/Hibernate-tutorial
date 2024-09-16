package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Student;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.Session;


import java.util.List;

public class MainApp {
    public static void main(String[] args) {


        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

       // Student ob=new Student("Radwa",22,"roro@gmail.com");
        


        try{
            session.beginTransaction();
          // session.save(ob);
         //   List<Student>students = session.createQuery("from Student").list();
           // display(students);

            session.createQuery("update Student set fullName ='ayat' where id =3").executeUpdate();


            session.getTransaction().commit();



        } catch (Exception e) {

            System.out.println(e.getMessage());
        } finally {
            session.close();
        }

    }

    private static void display(List<Student> students) {
        for (Student student: students) {

            System.out.println(student);
        }
    }


}

