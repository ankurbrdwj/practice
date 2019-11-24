package gangoffour.classic.behavioral.chainofresponsibility;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ChainOfResponsibilityTest {
    private static AuthenticationProcessor getChainOfAuthProcessor() {
        AuthenticationProcessor samlProcessor = new SamlTokenProcessor(null);
        AuthenticationProcessor oAuthProcessor = new OAuthProcessor(samlProcessor);
        return new UsernamePasswordProcessor(oAuthProcessor);
    }

    @Test
    public void givenOAuthProvider_whenCheckingAuthorized_thenSuccess() {
        AuthenticationProcessor authProcessorChain = getChainOfAuthProcessor();
        assertTrue(authProcessorChain.isAuthorized(new OAuthTokenProvider()));
    }

    @Test
    public void givenSamlProvider_whenCheckingAuthorized_thenSuccess() {
        AuthenticationProcessor authProcessorChain = getChainOfAuthProcessor();
        assertTrue(authProcessorChain.isAuthorized(new SamlTokenProvider()));
    }
    @Test
    public void givenUserPassword_whenCheckingAuthorized_thenSuccess() {
        AuthenticationProcessor authProcessorChain = getChainOfAuthProcessor();
        assertTrue(authProcessorChain.isAuthorized(new UsernamePasswordProvider()));
    }
}
