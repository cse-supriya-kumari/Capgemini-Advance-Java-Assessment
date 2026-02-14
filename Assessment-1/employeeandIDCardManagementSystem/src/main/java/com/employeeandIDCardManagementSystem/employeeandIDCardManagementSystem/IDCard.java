package com.employeeandIDCardManagementSystem.employeeandIDCardManagementSystem;



import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "id_card")
public class IDCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String cardNumber;
    private LocalDate issueDate;

    @OneToOne
    @JoinColumn(name = "employee_id", unique = true)
    private Employee employee;


    public IDCard() {}

    public IDCard(String cardNumber, LocalDate issueDate) {
        this.cardNumber = cardNumber;
        this.issueDate = issueDate;
    }

 
    public int getId() {
        return id;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

	@Override
	public String toString() {
		return "IDCard [id=" + id + ", cardNumber=" + cardNumber + ", issueDate=" + issueDate + ", employee=" + employee
				+ "]";
	}
    
}
