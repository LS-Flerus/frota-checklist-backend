package com.frota.checklist.model;

import com.frota.checklist.dto.UserDto;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Data
@Table(name = "usuarios")
@EqualsAndHashCode
public class UserModel {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "nome", nullable = false, length = 50)
    private String name;

    @Column(name = "senha", length = 255)
    private String password;

    public UserDto toDto() {
        UserDto dto = new UserDto();
        dto.setId(this.id);
        dto.setName(this.name);
        dto.setPassword(this.password);
        return dto;
    }
}
