package dk.signfluent.service.bpm.configuration;

import org.keycloak.adapters.KeycloakDeployment;
import org.keycloak.adapters.KeycloakDeploymentBuilder;
import org.keycloak.adapters.springsecurity.KeycloakConfiguration;
import org.keycloak.adapters.springsecurity.KeycloakSecurityComponents;
import org.keycloak.adapters.springsecurity.config.KeycloakWebSecurityConfigurerAdapter;
import org.keycloak.representations.adapters.config.AdapterConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.web.authentication.session.RegisterSessionAuthenticationStrategy;
import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, jsr250Enabled = true)
@KeycloakConfiguration
@ComponentScan(basePackageClasses = KeycloakSecurityComponents.class)
public class SecurityConfig extends KeycloakWebSecurityConfigurerAdapter {
    private final KeycloakAuthServerURLProvider keycloakAuthServerURLProvider;

    public SecurityConfig(KeycloakAuthServerURLProvider keycloakAuthServerURLProvider) {
        this.keycloakAuthServerURLProvider = keycloakAuthServerURLProvider;
    }


    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) {
        auth.authenticationProvider(keycloakAuthenticationProvider());
    }

    @Bean
    @Override
    protected SessionAuthenticationStrategy sessionAuthenticationStrategy() {
        return new RegisterSessionAuthenticationStrategy(new SessionRegistryImpl());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        super.configure(http);
        http.authorizeRequests().antMatchers("/api/**").permitAll();
        http.csrf().disable();
    }

    @Bean
    public KeycloakDeployment keycloakDeployment(AdapterConfig adapterConfig) {
        adapterConfig.setAuthServerUrl(keycloakAuthServerURLProvider.getKeycloakAuthServerURL());
        return KeycloakDeploymentBuilder.build(adapterConfig);
    }

    @Bean
    public org.keycloak.adapters.KeycloakConfigResolver keycloakConfigResolver(KeycloakDeployment keycloakDeployment) {
        return request -> keycloakDeployment;
    }
}
