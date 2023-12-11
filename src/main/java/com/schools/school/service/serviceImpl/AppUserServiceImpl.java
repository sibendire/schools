package com.schools.school.service.serviceImpl;

import com.schools.school.entity.AppUser;
import com.schools.school.repository.AppUserRepository;
import com.schools.school.service.AppUserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class AppUserServiceImpl implements AppUserService {

    private final AppUserRepository appUserRepository;
    @Override
    public AppUser saveAppUser(AppUser appUser) {
        return appUserRepository.save(appUser);
    }

    @Override
    public AppUser findAppUserById(Long id) {
        return appUserRepository.findById(id).get();
    }

    @Override
    public void deleteAppUserById(Long id) {
        appUserRepository.deleteById(id);

    }

    @Override
    public List<AppUser> findAllAppUser() {
        return appUserRepository.findAll();
    }


}
