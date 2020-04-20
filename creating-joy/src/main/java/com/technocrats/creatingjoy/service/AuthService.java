package com.technocrats.creatingjoy.service;

public interface AuthService {
    // to send OTP/token to user
    public void sendToken(String to,String channel);

    // to verify OTP/token entered by user
    public Boolean verifyToken(String code,String to);
}
