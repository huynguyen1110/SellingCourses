package com.example.backend.models;


import com.example.backend.common.PhuongThucThanhToan;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
public class GiaoDich {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idGiaoDich;

    private LocalDateTime ngayGioGiaoDich;

    private Double tongSoTien;

    @Enumerated(EnumType.STRING)
    private PhuongThucThanhToan phuongThucThanhToan;

    @ManyToOne
    private UserInfo userInfo;

    @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinTable(
            name = "giao_dich_khoa_hoc",
            joinColumns = @JoinColumn(name = "giao_dich_id"),
            inverseJoinColumns = @JoinColumn(name = "khoa_hoc_id")
    )
    private Set<KhoaHoc> khoaHocSet = new HashSet<>();
}
