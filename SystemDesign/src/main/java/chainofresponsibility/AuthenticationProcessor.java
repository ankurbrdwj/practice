package chainofresponsibility;
/*
/ each processor will process a provider
oauthprovider is responsibility of oauth provider
userprovider is responsibility of userprocessor and so on
isAuthorized is process method

 */
public abstract class AuthenticationProcessor {
    public AuthenticationProcessor nextProcessor;

    public AuthenticationProcessor(AuthenticationProcessor nextProcessor) {
        this.nextProcessor=nextProcessor;
    }

    // standard constructors

    public abstract boolean isAuthorized(AuthenticationProvider authProvider);
}
