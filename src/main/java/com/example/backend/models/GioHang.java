package com.example.backend.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
public class GioHang {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idGioHang;

    @OneToOne
    private UserInfo userInfo;

    @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinTable(
            name = "gio_hang_khoa_hoc",
            joinColumns = @JoinColumn(name = "gio_hang_id"),
            inverseJoinColumns = @JoinColumn(name = "khoa_hoc_id")
    )
    private Set<KhoaHoc> khoaHocSet = new HashSet<>();
}
