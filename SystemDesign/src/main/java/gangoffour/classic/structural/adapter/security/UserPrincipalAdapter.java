package gangoffour.classic.structural.adapter.security;

import net.minidev.json.JSONArray;

import java.util.Collection;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class UserPrincipalAdapter {
    private UserPrincipal userPrincipal;
    private static final JSONArray DEFAULT_ROLE_CLAIM = new JSONArray().appendElement("USER");
    private static final String ROLE_PREFIX = "ROLE_";

    public DefaultOAuth2User makeDefaultOAuth2User(UserPrincipal userPrincipal) {
        Collection<? extends GrantedAuthority> authorities = null;
        Map<String, Object> attributes = userPrincipal.getClaims();
        String nameAttributeKey = userPrincipal.getKid();
        final JSONArray roles = Optional.ofNullable((JSONArray) userPrincipal.getClaims().get("roles"))
                .filter(r -> !r.isEmpty())
                .orElse(DEFAULT_ROLE_CLAIM);

        DefaultOAuth2User defaultOAuth2User = new DefaultOAuth2User(authorities, attributes, nameAttributeKey);

        return defaultOAuth2User;
    }
}
