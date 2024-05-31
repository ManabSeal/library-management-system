package com.library.management.services;

import java.util.List;

import com.library.management.model.Admin;

public interface AdminService {
	int createAdmin(Admin admin);
	boolean updateAdmin(Admin admin);
	Admin getAdminById(int adminId);
    boolean deleteAdmin(int adminId);
    List<Admin> getAllAdmins();
    boolean adminAuth(int adminId, String password);
}
