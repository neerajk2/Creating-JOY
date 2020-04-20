package com.technocrats.creatingjoy.service;
import com.twilio.Twilio;
import com.twilio.rest.verify.v2.service.Verification;
import com.twilio.rest.verify.v2.service.VerificationCheck;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    public static final String ACCOUNT_SID = "ACd55ef59b0e5b3c6d47bae367ae4e9923";
    public static final String AUTH_TOKEN = "acfe0d2bc4153425fb268535274c1d02";

    public static final String PATH_SERVICE_SID = "VA48b375aa42aff1ff32676a33acba5a5a";


    @Override
    public void sendToken(String to,String channel){
    Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
    Verification verification = Verification.creator(PATH_SERVICE_SID,to,channel) .create();
        //System.out.println (verification.getStatus());

}

@Override
public Boolean verifyToken(String code,String to){
    Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
    VerificationCheck verificationCheck = VerificationCheck.creator(PATH_SERVICE_SID,code).setTo(to).create();
    //System.out.println(verificationCheck.getStatus());
    if(verificationCheck.getStatus().equals("approved"))
        return(true);
    else if(verificationCheck.getStatus().equals("pending"))
        return(false);
    return false;
}
}
