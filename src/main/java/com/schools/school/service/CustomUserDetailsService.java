//package com.schools.school.service;
//
//import com.schools.school.entity.AppUser;
//import com.schools.school.entity.CustomUserDetails;
//import com.schools.school.repository.AppUserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//
//public class CustomUserDetailsService implements UserDetailsService {
//    @Autowired
//    private  AppUserRepository appUserRepository;
//
//    public CustomUserDetailsService() {
//        this.appUserRepository = appUserRepository;
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//        AppUser appUser = appUserRepository.findByEmail(email);
//        if (appUser == null){
//            throw new UsernameNotFoundException("user not found");
//        }
//        return new CustomUserDetails(appUser);
//    }
//}
