package com.example.cbbq.service;

public interface OrgSecurityService {
    String findLoggedInUsername();
    void autoLogin(String username, String password);
}