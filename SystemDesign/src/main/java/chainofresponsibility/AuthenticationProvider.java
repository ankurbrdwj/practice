package chainofresponsibility;

import javax.naming.AuthenticationException;

public interface AuthenticationProvider {
    Authentication authenticate(Authentication var1) throws AuthenticationException;

    boolean supports(Class<?> var1);
}
