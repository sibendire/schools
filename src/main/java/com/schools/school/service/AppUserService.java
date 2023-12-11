package com.schools.school.service;

import com.schools.school.entity.AppUser;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppUserService {
    AppUser saveAppUser(AppUser appUser);
    AppUser findAppUserById(Long id);
    void deleteAppUserById(Long id);
   List <AppUser> findAllAppUser();
}
