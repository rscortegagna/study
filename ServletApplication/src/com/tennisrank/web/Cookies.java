package com.tennisrank.web;

import javax.servlet.http.Cookie;
import java.util.Arrays;

@Deprecated
public class Cookies {

    private final Cookie[] cookies;

    public Cookies(Cookie[] cookies) {
        this.cookies = cookies;
    }

    @Deprecated
    public Cookie getLoggedUser() {
        if (cookies == null) {
            return null;
        }
        return Arrays.stream(cookies).filter(cookie -> "logged.user".equals(cookie.getName())).findFirst().orElse(null);
    }
}
