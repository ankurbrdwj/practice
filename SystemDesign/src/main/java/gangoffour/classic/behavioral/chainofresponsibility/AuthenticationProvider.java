package gangoffour.classic.behavioral.chainofresponsibility;

import gangoffour.classic.behavioral.chainofresponsibility.Authentication;

import javax.naming.AuthenticationException;

public interface AuthenticationProvider {
    Authentication authenticate(Authentication var1) throws AuthenticationException;

    boolean supports(Class<?> var1);
}
