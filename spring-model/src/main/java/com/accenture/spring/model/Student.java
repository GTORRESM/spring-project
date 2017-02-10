package com.accenture.spring.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the students database table.
 * 
 */
@Entity
@Table(name="students")
@NamedQuery(name="Student.findAll", query="SELECT s FROM Student s")
public class Student implements Serializable {
	private static final long serialVersionUID = 1L;
	private int idStudent;
	private String emailAdress;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String studentAdress;
	private List<BooksOutOnLoan> booksOutOnLoans;

	public Student() {
	}


	@Id
	public int getIdStudent() {
		return this.idStudent;
	}

	public void setIdStudent(int idStudent) {
		this.idStudent = idStudent;
	}


	@Column(name="email_adress")
	public String getEmailAdress() {
		return this.emailAdress;
	}

	public void setEmailAdress(String emailAdress) {
		this.emailAdress = emailAdress;
	}


	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	@Column(name="phone_number")
	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	@Column(name="student_adress")
	public String getStudentAdress() {
		return this.studentAdress;
	}

	public void setStudentAdress(String studentAdress) {
		this.studentAdress = studentAdress;
	}


	//bi-directional many-to-one association to BooksOutOnLoan
	@OneToMany(mappedBy="student")
	public List<BooksOutOnLoan> getBooksOutOnLoans() {
		return this.booksOutOnLoans;
	}

	public void setBooksOutOnLoans(List<BooksOutOnLoan> booksOutOnLoans) {
		this.booksOutOnLoans = booksOutOnLoans;
	}

	public BooksOutOnLoan addBooksOutOnLoan(BooksOutOnLoan booksOutOnLoan) {
		getBooksOutOnLoans().add(booksOutOnLoan);
		booksOutOnLoan.setStudent(this);

		return booksOutOnLoan;
	}

	public BooksOutOnLoan removeBooksOutOnLoan(BooksOutOnLoan booksOutOnLoan) {
		getBooksOutOnLoans().remove(booksOutOnLoan);
		booksOutOnLoan.setStudent(null);

		return booksOutOnLoan;
	}

}