package com.example.backend.models;

import com.example.backend.common.RoleName;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTaiKhoan;

    private String username;

    private String password;

    private LocalDateTime createdAt;

    private boolean deletedAt;

    @Enumerated(EnumType.STRING)
    private RoleName role;

    @OneToOne
    private UserInfo userInfo;

    @OneToOne
    private GiangVien giangVien;
}

