package com.hyperdata.proms.api.Config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.hyperdata.proms.api.Persintance.Repository.UserRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j 
@Component 
@Profile ("dev")
@RequiredArgsConstructor 
public class DevPasswordSeedeer implements CommandLineRunner {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) {
        // TODO Auto-generated method stub
        userRepository.findByEmail("admin@gmail.com").ifPresent(user -> {
            if (user.getPassword() == null || user.getPassword().isBlank()) {
                user.setPassword(passwordEncoder.encode("password"));
                userRepository.save(user);
                log.info("DEV: password admin@gmail.com di-set");
            }
        });
    }
    
}
