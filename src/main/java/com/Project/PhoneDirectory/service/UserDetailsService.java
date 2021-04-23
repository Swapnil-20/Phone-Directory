package com.Project.PhoneDirectory.service;

import com.Project.PhoneDirectory.model.UserDetails;
import com.Project.PhoneDirectory.repository.UserDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDetailsService {

    @Autowired
    UserDetailsRepository userDetailsRepository;

    public List<UserDetails> getAllUserDetails(Integer userId){

        return userDetailsRepository.getAllUserDetails(userId);
    }

    public void createDetails(UserDetails newEntry){
        userDetailsRepository.createDetails(newEntry);
    }

    public void deleteDetail(Integer userId){
        userDetailsRepository.deleteDetails(userId);
    }

    public UserDetails getPost(Integer userId) {
        return userDetailsRepository.getPost(userId);
    }


}
