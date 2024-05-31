package com.library.management.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="adminInfo")
public class Admin {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int adminId;
	private String adminName;
	private String password;
	private String phoneNumber;
	private String address;
	/**
	 * 
	 */
	public Admin() {
		super();
	}
	/**
	 * @param adminId
	 * @param adminName
	 * @param password
	 * @param phoneNumber
	 * @param address
	 */
	public Admin(int adminId, String adminName, String password, String phoneNumber, String address) {
		super();
		this.adminId = adminId;
		this.adminName = adminName;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.address = address;
	}
	
	public Admin(String adminName, String password, String phoneNumber, String address) {
		super();
		this.adminName = adminName;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.address = address;
	}
	/**
	 * @return the adminId
	 */
	public int getAdminId() {
		return adminId;
	}
	/**
	 * @param adminId the adminId to set
	 */
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	/**
	 * @return the adminName
	 */
	public String getAdminName() {
		return adminName;
	}
	/**
	 * @param adminName the adminName to set
	 */
	public void setAdminName(String adminName) {
		this.adminName = adminName;
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
		return "Admin [adminId=" + adminId + ", adminName=" + adminName + ", password=" + password + ", phoneNumber="
				+ phoneNumber + ", address=" + address + "]";
	}
	
	
}
