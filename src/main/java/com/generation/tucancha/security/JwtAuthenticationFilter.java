package com.generation.tucancha.security;

import com.generation.tucancha.model.entity.Usuario;
import com.generation.tucancha.repository.UsuarioRepository;
import com.generation.tucancha.security.JwtService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtService jwtService;
    private final UsuarioRepository usuarioRepository;

    public JwtAuthenticationFilter(
            JwtService jwtService,
            UsuarioRepository usuarioRepository) {
        this.jwtService = jwtService;
        this.usuarioRepository = usuarioRepository;
    }
    @Override
    protected boolean shouldNotFilter(
            HttpServletRequest request
    ) {

        return HttpMethod.OPTIONS
                .matches(request.getMethod());
    }

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain)
            throws ServletException, IOException {

        String header = request.getHeader("Authorization");

        if (header == null || !header.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }

        try {
            String token = header.substring(7);

            String correo = jwtService.extraerUsername(token);

            Usuario usuario = usuarioRepository
                    .findByCorreo(correo)
                    .orElseThrow();

            var autoridad = new SimpleGrantedAuthority(
                    "ROLE_" + usuario.getRol().name()
            );

            var autenticacion =
                    new UsernamePasswordAuthenticationToken(
                            usuario.getCorreo(),
                            null,
                            List.of(autoridad)
                    );

            SecurityContextHolder
                    .getContext()
                    .setAuthentication(autenticacion);

        } catch (Exception e) {
            SecurityContextHolder.clearContext();
        }

        filterChain.doFilter(request, response);
    }
}