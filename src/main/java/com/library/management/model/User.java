package com.library.management.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="userinfo")
public class User {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	private String userName;
	private String password;
	private String phoneNumber;
	private String address;
	/**
	 * 
	 */
	public User() {
		super();
	}
	/**
	 * @param userId
	 * @param userName
	 * @param password
	 * @param phoneNumber
	 * @param address
	 */
	public User(int userId, String userName, String password, String phoneNumber, String address) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.address = address;
	}
	
	public User(String userName, String password, String phoneNumber, String address) {
		super();
		this.userName = userName;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.address = address;
	}
	/**
	 * @return the userId
	 */
	public int getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the phoneNumber
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}
	/**
	 * @param phoneNumber the phoneNumber to set
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", password=" + password + ", phoneNumber="
				+ phoneNumber + ", address=" + address + "]";
	}
	
	
	
}
