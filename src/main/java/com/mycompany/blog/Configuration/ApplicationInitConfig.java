package com.mycompany.blog.Configuration;

import com.mycompany.blog.Repository.UserRepository;
import com.mycompany.blog.entity.User;
import com.mycompany.blog.enums.Role;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;

@Configuration
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class ApplicationInitConfig {


     PasswordEncoder passwordEncoder;

    @Bean
    ApplicationRunner applicationRunner(UserRepository userRepository) {
        return args -> {
          if ( userRepository.findByEmail("admin@blog.com").isEmpty()){
                var role = new HashSet<String>();
                role.add(Role.ADMIN.name());

                User user = User.builder()
                        .email("admin@blog.com")
                        .password(passwordEncoder.encode("admin"))
                        .roles(role)
                        .build();

                userRepository.save(user);
                log.warn("admin đã được tạo dưới dạng mặc định password: admin, pls change it");
            }
        };
    };
}
