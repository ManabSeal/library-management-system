package com.library.management.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "checkoutRecords")
public class CheckoutRecord {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate checkoutDate;
    private LocalDate returnDate;
    private LocalDate actualReturnDate;
    private double fineAmount;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    @ManyToOne
    @JoinColumn(name = "bookId")
    private Book book;

	/**
	 * 
	 */
	public CheckoutRecord() {
		super();
	}

	/**
	 * @param id
	 * @param checkoutDate
	 * @param returnDate
	 * @param actualReturnDate
	 * @param fineAmount
	 * @param user
	 * @param book
	 */
	public CheckoutRecord(Long id, LocalDate checkoutDate, LocalDate returnDate, LocalDate actualReturnDate,
			double fineAmount, User user, Book book) {
		super();
		this.id = id;
		this.checkoutDate = checkoutDate;
		this.returnDate = returnDate;
		this.actualReturnDate = actualReturnDate;
		this.fineAmount = fineAmount;
		this.user = user;
		this.book = book;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the checkoutDate
	 */
	public LocalDate getCheckoutDate() {
		return checkoutDate;
	}

	/**
	 * @param checkoutDate the checkoutDate to set
	 */
	public void setCheckoutDate(LocalDate checkoutDate) {
		this.checkoutDate = checkoutDate;
	}

	/**
	 * @return the returnDate
	 */
	public LocalDate getReturnDate() {
		return returnDate;
	}

	/**
	 * @param returnDate the returnDate to set
	 */
	public void setReturnDate(LocalDate returnDate) {
		this.returnDate = returnDate;
	}

	/**
	 * @return the actualReturnDate
	 */
	public LocalDate getActualReturnDate() {
		return actualReturnDate;
	}

	/**
	 * @param actualReturnDate the actualReturnDate to set
	 */
	public void setActualReturnDate(LocalDate actualReturnDate) {
		this.actualReturnDate = actualReturnDate;
	}

	/**
	 * @return the fineAmount
	 */
	public double getFineAmount() {
		return fineAmount;
	}

	/**
	 * @param fineAmount the fineAmount to set
	 */
	public void setFineAmount(double fineAmount) {
		this.fineAmount = fineAmount;
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * @return the book
	 */
	public Book getBook() {
		return book;
	}

	/**
	 * @param book the book to set
	 */
	public void setBook(Book book) {
		this.book = book;
	}

	@Override
	public String toString() {
		return "CheckoutRecord [id=" + id + ", checkoutDate=" + checkoutDate + ", returnDate=" + returnDate
				+ ", actualReturnDate=" + actualReturnDate + ", fineAmount=" + fineAmount + ", user=" + user + ", book="
				+ book + "]";
	}
    
    
    
}
