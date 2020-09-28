package gangoffour.classic.structural.adapter.security;

public interface AuthenticatedPrincipal {

    /**
     * Returns the name of the authenticated <code>Principal</code>. Never <code>null</code>.
     *
     * @return the name of the authenticated <code>Principal</code>
     */
    String getName();

}
