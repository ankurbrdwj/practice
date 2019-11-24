package gangoffour.functional.behavioral.chainofresponsibility;

import gangoffour.classic.behavioral.chainofresponsibility.*;

import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

public class Chain {
    public static Optional<Boolean> authSaml(AuthenticationProcessor processor) {
        return Optional.of(processor instanceof SamlTokenProcessor);
    }

    public static Optional<Boolean> authOAuth(AuthenticationProcessor processor) {
        return Optional.of(processor instanceof OAuthProcessor);
    }

    public static Optional<Boolean> authUser(AuthenticationProcessor processor) {
        return Optional.of(processor instanceof UsernamePasswordProcessor);
    }

    public static void main(String[] args) {
        AuthenticationProcessor samlProcessor= new SamlTokenProcessor(null);
        System.out.println(Stream.<Function<AuthenticationProcessor, Optional<Boolean>>>
                of(Chain::authSaml,
                Chain::authOAuth,
                Chain::authUser)
                .map(f->f.apply(samlProcessor))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("UnAutherized Provider: ")));
    }
}
