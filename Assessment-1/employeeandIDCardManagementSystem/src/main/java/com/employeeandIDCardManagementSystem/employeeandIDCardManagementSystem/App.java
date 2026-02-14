package com.employeeandIDCardManagementSystem.employeeandIDCardManagementSystem;


import jakarta.persistence.*;
import java.time.LocalDate;

public class App {

    public static void main(String[] args) {

        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("myPersistenceUnit");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();

          
            Employee emp = new Employee("Supriya", "sup@gmail.com");

          
            IDCard card = new IDCard("CAP22101", LocalDate.of(2026, 2, 14));

           
            emp.setIdCard(card);
            card.setEmployee(emp);

            
            em.persist(emp);

            tx.commit();
            System.out.println("Employee Created Successfully");

            
            Employee e = em.find(Employee.class, emp.getId());

            System.out.println("Employee Details:");
            System.out.println("ID: " + e.getId());
            System.out.println("Name: " + e.getName());
            System.out.println("Email: " + e.getEmail());
            
            System.out.println();
            System.out.println("ID Card Details:");
            System.out.println("Card Number: " + e.getIdCard().getCardNumber());
            System.out.println("Issue Date: " + e.getIdCard().getIssueDate());

           
            IDCard retrievedCard = em.find(IDCard.class, card.getId());

            System.out.println("Retrieved via ID Card:");
            System.out.println("Employee Name: " +
                    retrievedCard.getEmployee().getName());

        } finally {
            em.close();
            emf.close();
        }
    }
}
