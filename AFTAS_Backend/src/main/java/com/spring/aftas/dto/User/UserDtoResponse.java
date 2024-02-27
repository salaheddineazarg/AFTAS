package com.spring.aftas.dto.User;



import com.spring.aftas.enumuration.IdentityDocType;
import com.spring.aftas.enumuration.Role;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDtoResponse {

    private UUID num;

    private String name;

    private String familyName;

    private String email;

    private String password;

    private Role role;

    private LocalDate accessionDate;

    private String nationality;

    private IdentityDocType identityDocumentType;
    
    private String identityNumber;

    private Boolean status;



}
