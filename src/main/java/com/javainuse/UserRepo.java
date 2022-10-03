package com.javainuse;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javainuse.model.User;

public interface UserRepo extends JpaRepository<User,Integer>{

}
