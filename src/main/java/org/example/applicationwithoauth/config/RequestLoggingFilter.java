package org.example.applicationwithoauth.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;


@Component
@Order(1)
@Slf4j
public class RequestLoggingFilter extends OncePerRequestFilter {

  @Override
  protected void doFilterInternal(@NonNull HttpServletRequest request,
                                  @NonNull HttpServletResponse response,
                                  @NonNull FilterChain filterChain)
          throws ServletException, IOException {
    final CacheHttpServletRequest cacheHttpServletRequest = new CacheHttpServletRequest(request);
    log.info("request: {}", cacheHttpServletRequest.getRequestBody());
    filterChain.doFilter(cacheHttpServletRequest, response);
    log.info("response status: " + response.getStatus());
  }

}
