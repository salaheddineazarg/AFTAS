package com.spring.aftas.entities;


import com.spring.aftas.enumuration.IdentityDocType;
import com.spring.aftas.enumuration.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "app_user")
@Entity
public class User  implements UserDetails {


    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID num;

    @NotBlank(message = "Name must not be blank")
    @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters")
    @Column(nullable = false)
    private String name;

    @NotBlank(message = "Family name must not be blank")
    @Size(min = 2, max = 50, message = "Family name must be between 2 and 50 characters")
    @Column(nullable = false)
    private String familyName;

    @Column(unique = true)
    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email address")
    private String email;


    @NotBlank(message = "Password is required")
    @Size(min = 6, message = "Password must be at least 6 characters long")
    private String password;

    @NotNull(message = "User role is required")
    @Enumerated(EnumType.STRING)
    private Role role;

    @NotNull(message = "Accession date must be provided")
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private LocalDate accessionDate;

    @NotBlank(message = "Nationality must not be blank")
    @Size(min = 2, max = 50, message = "Nationality must be between 2 and 50 characters")
    @Column(nullable = false)
    private String nationality;

    @Enumerated(EnumType.STRING)
    private IdentityDocType identityDocumentType;

    @NotBlank(message = "Identity number must not be blank")
    @Pattern(regexp = "[A-Za-z0-9]+", message = "Identity number must contain only letters and numbers")
    @Column(nullable = false,unique = true)
    private String identityNumber;

    private Boolean status;

    @OneToMany(mappedBy = "user",fetch = FetchType.LAZY,cascade =CascadeType.ALL,orphanRemoval = true)
    private List<Hunting> huntings;

    @OneToMany(mappedBy = "user",fetch = FetchType.LAZY,cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Rank> ranks;



    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(this.role.name()));
    }

    @Override
    public String getPassword(){

        return this.password;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
