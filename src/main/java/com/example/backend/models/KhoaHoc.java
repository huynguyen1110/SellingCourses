package com.example.backend.models;

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
public class KhoaHoc {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idKhoaHoc;

    private String tenKhoaHoc;

    private String image;

    private Double giaGocKhoaHoc;

    private Double giaUuDaiKhoaHoc;

    private String moTa;

    private String linkKhoaHoc;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    @ManyToMany(mappedBy = "khoaHocList")
    private Set<UserInfo> userInfos = new HashSet<>();

    @ManyToMany(mappedBy = "khoaHocSet")
    private Set<GioHang> gioHangSet = new HashSet<>();

    @ManyToMany(mappedBy = "khoaHocSet")
    private Set<KhoaHocYeuThich> khoaHocYeuThichSet = new HashSet<>();

    @ManyToMany(mappedBy = "khoaHocSet")
    private Set<GiaoDich> giaoDichSet = new HashSet<>();

    @ManyToOne
    private TheLoai theLoai;

    @ManyToOne
    private GiangVien giangVien;
}
