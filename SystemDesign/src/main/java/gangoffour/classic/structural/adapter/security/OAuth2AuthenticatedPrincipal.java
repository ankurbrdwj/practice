package gangoffour.classic.structural.adapter.security;
import gangoffour.classic.structural.adapter.security.AuthenticatedPrincipal;
import gangoffour.classic.structural.adapter.security.GrantedAuthority;
import jdk.internal.jline.internal.Nullable;

import java.util.Collection;
import java.util.Map;

/**
 * An {@link AuthenticatedPrincipal} that represents the principal
 * associated with an OAuth 2.0 token.
 *
 * @author Josh Cummings
 * @since 5.2
 */
public interface OAuth2AuthenticatedPrincipal extends AuthenticatedPrincipal {
    /**
     * Get the OAuth 2.0 token attribute by name
     *
     * @param name the name of the attribute
     * @param <A> the type of the attribute
     * @return the attribute or {@code null} otherwise
     */
    @Nullable
    default <A> A getAttribute(String name) {
        return (A) getAttributes().get(name);
    }

    /**
     * Get the OAuth 2.0 token attributes
     *
     * @return the OAuth 2.0 token attributes
     */
    Map<String, Object> getAttributes();

    /**
     * Get the {@link Collection} of {@link GrantedAuthority}s associated
     * with this OAuth 2.0 token
     *
     * @return the OAuth 2.0 token authorities
     */
    Collection<? extends GrantedAuthority> getAuthorities();

}
