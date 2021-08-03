package com.msp.config.auth;


import com.msp.domain.user.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@RequiredArgsConstructor
@EnableWebSecurity //spring security 설정들을 활성화 시켜줌.
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomOAuth2UserService customOAuth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .headers().frameOptions().disable()
                .and()
                    .authorizeRequests()//URL별 권한관리를 설정하는 옵션의 진입점.
                    .antMatchers("/", "/css/**", "/images/**", "/js/**", "/h2-console/**", "/profile").permitAll()//모두에게 권한
                    .antMatchers("/api/v1/**").hasRole(Role.USER.name())//USER권한을 가진 자에게만 권한
                    .anyRequest().authenticated()// 설정된 값 이외 나머지 URL은 모두 인증된 사용자들에게만 허용. 즉, 로그인한 사람.
                .and()
                    .logout()//로그아웃 기능에 대한 여러 설정의 진입점.
                        .logoutSuccessUrl("/")//로그아웃 후 이동시킬 URL
                .and()
                    .oauth2Login()//oauth2 로그인 기능에 대한 여러 설정의 진입점
                        .userInfoEndpoint()//로그인 성공 이후 사용자 정보를 가져올 때의 설정을 담당.
                            .userService(customOAuth2UserService); // 사용자 정보를 가져온상태에서 추가로 진행하고자 하는 기능 명시
    }
}