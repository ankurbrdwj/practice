package gangoffour.classic.behavioral.chainofresponsibility;

public class SamlTokenProcessor extends AuthenticationProcessor {

    public SamlTokenProcessor(AuthenticationProcessor nextProcessor) {
        super(nextProcessor);
    }

    @Override
    public boolean isAuthorized(AuthenticationProvider authProvider) {
        if (authProvider instanceof SamlTokenProvider) {
            return true;
        } else if (nextProcessor != null) {
            return nextProcessor.isAuthorized(authProvider);
        }
        return false;
    }
}
