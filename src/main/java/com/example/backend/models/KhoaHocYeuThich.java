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
public class KhoaHocYeuThich {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idKhoaHocYeuThich;

    @OneToOne
    private UserInfo userInfo;

    @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinTable(
            name = "khoa_hoc_yeu_thich_khoa_hoc",
            joinColumns = @JoinColumn(name = "khoa_hoc_yeu_thich_id"),
            inverseJoinColumns = @JoinColumn(name = "khoa_hoc_id")
    )
    private Set<KhoaHoc> khoaHocSet = new HashSet<>();
}

