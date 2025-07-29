package com.aluracursos.forohub.domains.user;

import com.aluracursos.forohub.infra.security.JWTTokenData;
import com.aluracursos.forohub.infra.security.JWTTokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
@RequestMapping("/login")
public class UserController {

    @Autowired
    private JWTTokenService service;

    @Autowired
    private AuthenticationManager manager;

    @PostMapping
    public ResponseEntity login(@RequestBody @Valid AuthUserData data) {
        try {
            var authToken = new UsernamePasswordAuthenticationToken(data.email(), data.password());
            var auth = manager.authenticate(authToken);
            var jwtToken = service.generateToken((User) auth.getPrincipal());
            return ResponseEntity.ok(new JWTTokenData(jwtToken));
        } catch (Exception e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
