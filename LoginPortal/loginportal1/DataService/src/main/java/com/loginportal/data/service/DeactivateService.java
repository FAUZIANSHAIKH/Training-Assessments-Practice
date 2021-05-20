package com.loginportal.data.service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loginportal.data.model.AccountStatus;
import com.loginportal.data.model.Deactivate;
import com.loginportal.data.model.User;
import com.loginportal.data.repository.DeactivateRepository;
import com.loginportal.data.repository.UserRepository;

@Service
public class DeactivateService {
	@Autowired
	DeactivateRepository deactivateRepository;
	
	@Autowired
	UserRepository userRepository;

	@Transactional
	public Optional<Deactivate> getDeactivateByID(Deactivate deactivate) {
		return deactivateRepository.getDeactivateByID(deactivate.getDeactivateId());
	}
	
	@Transactional
	public Optional<Deactivate> getDeactivateByUserID(User user) {
		return deactivateRepository.getDeactivateByUserID(user.getUserID());
	}
	
	@Transactional
	public Deactivate create(Deactivate deactivate) {
		Timestamp timestamp = new Timestamp((new Date()).getTime());
		deactivate.setDeactivateTime(timestamp);
		return deactivateRepository.save(deactivate);
	}
	
	@Transactional
	public void deleteDeactivateByUserID(User user) {
		deactivateRepository.deleteDeactivate(user.getUserID());
	}
	
	@Transactional
	public List<Long> findDeactivatedUsers() {
		return deactivateRepository.findDeactivatedUsers();
	}
	
	@Transactional
	public void changeToPurge() {
		List<Long> list = findDeactivatedUsers();
		for (Long long1 : list) {
			userRepository.updateAccountStatus(AccountStatus.PURGE, long1);
		}
	}
	
	@Transactional
	public void deletePurgeUser() {
		userRepository.deleteUserByAccountStatus();
	}
}
