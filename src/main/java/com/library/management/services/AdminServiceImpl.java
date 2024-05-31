package com.library.management.services;

import java.util.List;

import com.library.management.exception.AdminNotFoundException;
import com.library.management.model.Admin;
import com.library.management.repository.AdminRepository;

public class AdminServiceImpl implements AdminService{
    private final AdminRepository adminRepository;

    public AdminServiceImpl() {
        this.adminRepository = new AdminRepository();
    }
    
	@Override
	public int createAdmin(Admin admin) {
		// TODO Auto-generated method stub
		return adminRepository.saveAdmin(admin);
	}

	@Override
	public Admin getAdminById(int adminId) {
		// TODO Auto-generated method stub
		try {			
			return adminRepository.findById(adminId);
		}catch(AdminNotFoundException e) {
			return null;
		}catch(Exception e) {
			return null;
		}
	}


	@Override
	public boolean deleteAdmin(int adminId) {
		// TODO Auto-generated method stub
		return adminRepository.deleteAdmin(adminId);
	}

	@Override
	public List<Admin> getAllAdmins() {
		// TODO Auto-generated method stub
		return adminRepository.findAllAdmin();
	}

	@Override
	public boolean updateAdmin(Admin admin) {
		// TODO Auto-generated method stub
		return adminRepository.saveOrUpdateAdmin(admin);
	}

	@Override
	public boolean adminAuth(int adminId, String password) {
		// TODO Auto-generated method stub
		return adminRepository.checkAuth(adminId, password);
	}
	
}
