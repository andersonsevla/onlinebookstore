package com.brascode.service;

import javax.servlet.http.HttpSession;

import com.brascode.model.StoreException;
import com.brascode.model.User;
import com.brascode.model.UserRole;

public interface UserService {

    public User login(UserRole role, String email, String password, HttpSession session) throws StoreException;

    public String register(UserRole role, User user) throws StoreException;

    public boolean isLoggedIn(UserRole role, HttpSession session);

    public boolean logout(HttpSession session);

}
