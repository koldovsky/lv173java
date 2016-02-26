package com.softserveinc.ita.redplatform.business.service;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.
        AuthenticationSuccessHandler;
/**
 * Redirecting users to different pages according to they role.
 * @author Roman Ivaniv
 *
 */
public class AuthenticationManager implements AuthenticationSuccessHandler {
    /**
     * creating RedirectStrategy object.
     */
    private RedirectStrategy strategy = new DefaultRedirectStrategy();
 
    @Override
    public final void onAuthenticationSuccess(final HttpServletRequest request, 
     final HttpServletResponse response, final Authentication authentication)
	     throws IOException {
        handle(request, response, authentication);
        clearAuthenticationAttributes(request);
    }
    /**
     * 
     * @param request object
     * @param response object
     * @param authentication  object
     * @throws IOException type
     */
    protected final void handle(final HttpServletRequest request, 
      final HttpServletResponse response, final Authentication authentication) 
	      throws IOException {
        String targetUrl = determineTargetUrl(authentication);
 
        if (response.isCommitted()) {
            return;
        }
 
       strategy.sendRedirect(request, response, targetUrl);
    }
    /**
     * 
     * @param authentication object
     * @return redirecting url.
     */
    protected final String determineTargetUrl(
	    final Authentication authentication) {
        boolean isUser = false;
        boolean isREDAdmin = false;
        boolean isAdmin = false;
        Collection<GrantedAuthority> authorities = 
        	(Collection<GrantedAuthority>) authentication.getAuthorities();
        for (GrantedAuthority grantedAuthority : authorities) {
            if (grantedAuthority.getAuthority().equals("ROLE_USER")) {
                isUser = true;
                break;
            } else if (grantedAuthority.getAuthority().
        	    equals("ROLE_REDADMIN")) {
                isREDAdmin = true;
                break;
            } else if (grantedAuthority.getAuthority().equals("ROLE_ADMIN")) {
        	isAdmin = true;
        	break;
            }
        }
 
        if (isUser) {
            return "/index";
        } else if (isAdmin) {
            return "/adminregister";
        } else if (isREDAdmin) {
            return "/agency";
        } else {
            throw new IllegalStateException();
        }
    }
    /**
     * 
     * @param request object
     */
    protected final void clearAuthenticationAttributes(
	    final HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session == null) {
            return;
        }
        session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
    }
 
    public final void setStrategy(final RedirectStrategy redirectStrategy) {
        this.strategy = redirectStrategy;
    }

    public final RedirectStrategy getStrategy() {
        return strategy;
    }
}