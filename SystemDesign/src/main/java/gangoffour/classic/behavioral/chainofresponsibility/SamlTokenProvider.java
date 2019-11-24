package gangoffour.classic.behavioral.chainofresponsibility;

import javax.naming.AuthenticationException;

public class SamlTokenProvider implements AuthenticationProvider {
    @Override
    public Authentication authenticate(Authentication var1) throws AuthenticationException {
        return null;
    }

    @Override
    public boolean supports(Class<?> var1) {
        return false;
    }
}
