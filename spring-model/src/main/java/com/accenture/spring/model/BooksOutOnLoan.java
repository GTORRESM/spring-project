package com.accenture.spring.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the books_out_on_loan database table.
 * 
 */
@Entity
@Table(name="books_out_on_loan")
@NamedQuery(name="BooksOutOnLoan.findAll", query="SELECT b FROM BooksOutOnLoan b")
public class BooksOutOnLoan implements Serializable {
	private static final long serialVersionUID = 1L;
	private int idBookBorrowing;
	private BigDecimal amountOfFine;
	private Date dataDueForReturn;
	private Date dataIssued;
	private Date dataReturned;
	private Book book;
	private Student student;

	public BooksOutOnLoan() {
	}


	@Id
	public int getIdBookBorrowing() {
		return this.idBookBorrowing;
	}

	public void setIdBookBorrowing(int idBookBorrowing) {
		this.idBookBorrowing = idBookBorrowing;
	}


	@Column(name="amount_of_fine")
	public BigDecimal getAmountOfFine() {
		return this.amountOfFine;
	}

	public void setAmountOfFine(BigDecimal amountOfFine) {
		this.amountOfFine = amountOfFine;
	}


	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="data_due_for_return")
	public Date getDataDueForReturn() {
		return this.dataDueForReturn;
	}

	public void setDataDueForReturn(Date dataDueForReturn) {
		this.dataDueForReturn = dataDueForReturn;
	}


	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="data_issued")
	public Date getDataIssued() {
		return this.dataIssued;
	}

	public void setDataIssued(Date dataIssued) {
		this.dataIssued = dataIssued;
	}


	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="data_returned")
	public Date getDataReturned() {
		return this.dataReturned;
	}

	public void setDataReturned(Date dataReturned) {
		this.dataReturned = dataReturned;
	}


	//bi-directional many-to-one association to Book
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="isbn")
	public Book getBook() {
		return this.book;
	}

	public void setBook(Book book) {
		this.book = book;
	}


	//bi-directional many-to-one association to Student
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="borrowerStudent_id")
	public Student getStudent() {
		return this.student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

}