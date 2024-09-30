package com.hiep.mart.config;

import com.hiep.mart.domain.constant.PredefinedRole;
import com.hiep.mart.domain.entity.Role;
import com.hiep.mart.domain.entity.Users;
import com.hiep.mart.repository.RoleRepository;
import com.hiep.mart.repository.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.HashSet;

@Component
@Configuration
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class Init implements CommandLineRunner {
    PasswordEncoder passwordEncoder;
    UserRepository userRepository;
    RoleRepository roleRepository;

    @Override
    public void run(String... args) throws Exception {
        if (userRepository.count() == 0) {
            Role adminRole = roleRepository.save(Role.builder()
                    .name(PredefinedRole.ADMIN_ROLE)
                    .description("Admin role")
                    .build());

            var roles = new HashSet<Role>();
            roles.add(adminRole);

            Users admin = Users.builder()
                    .username("admin")
                    .password(passwordEncoder.encode("admin"))
                    .build();

            userRepository.save(admin);
        }
    }
}
