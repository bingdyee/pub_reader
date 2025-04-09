package cn.scifi.novelogic.infrastructure.common.security;

import cn.scifi.novelogic.infrastructure.common.constants.enums.UserStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serial;
import java.util.*;

/**
 * @author bingdyee
 * @since 2024/9/27
 */
@Getter
public class UserPrincipal implements UserDetails {

    @Serial
    private static final long serialVersionUID = -5005705524613649632L;

    @JsonSerialize(using = ToStringSerializer.class)
    private final Long id;
    private final String name;
    private final String image;
    @JsonIgnore
    private final String password;
    @JsonIgnore
    private final Integer status;
    private final List<? extends GrantedAuthority> authorities;

    public UserPrincipal(Long id, String username, String image, String password, Integer status, List<String> roles) {
        this.id = id;
        this.name = username;
        this.password = password;
        this.status = status;
        this.image = image;
        roles = roles == null ? new ArrayList<>() : roles;
        this.authorities = roles.stream().map(SimpleGrantedAuthority::new).toList();
    }

    public UserPrincipal(Long id, String username, String role) {
        this(id, username, null, null, UserStatus.NORMAL.getCode(), Collections.singletonList(role));
    }

    public String getRole() {
        return authorities.get(0).getAuthority();
    }

    @JsonIgnore
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @JsonIgnore
    @Override
    public String getUsername() {
        return name;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return !status.equals(UserStatus.BANNED.getCode());
    }

    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isEnabled() {
        return status.equals(UserStatus.NORMAL.getCode());
    }

    public Map<String, Object> toClaimsMap() {
        Map<String, Object> claims = new HashMap<>();
        claims.put("sub", id);
        claims.put("name", name);
        claims.put("role", this.getRole());
        return claims;
    }

    public static class Builder {

        private Long id;
        private String name;
        private String image;
        private String password;
        private Integer status;
        private List<String> roles;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder image(String image) {
            this.image = image;
            return this;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public Builder status(Integer status) {
            this.status = status;
            return this;
        }

        public Builder role(String roles) {
            this.roles = this.roles == null ? new ArrayList<>() : this.roles;
            this.roles.add(roles);
            return this;
        }

        public Builder authorities(List<String> authorities) {
            this.roles = this.roles == null ? new ArrayList<>() : this.roles;
            this.roles.addAll(authorities);
            return this;
        }

        public UserPrincipal build() {
            this.roles = this.roles == null ? new ArrayList<>() : this.roles;
            return new UserPrincipal(id, name, image, password, status,  this.roles);
        }

    }

}
