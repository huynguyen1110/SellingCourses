package com.example.backend.models;


import com.example.backend.common.GioiTinh;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.HashSet;
import java.util.*;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
public class UserInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idNguoiDung;

    private String tenNguoiDung;

    private String sdt;

    private Date thangNamSinh;

    private String diaChi;

    @Enumerated(EnumType.STRING)
    private GioiTinh gioiTinh;

    @OneToOne
    private Account account;

    @OneToMany(mappedBy = "userInfo")
    private List<GiaoDich> giaoDichSet = new ArrayList<>();

    @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinTable(
            name = "user_course",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    private Set<KhoaHoc> khoaHocList = new HashSet<>();

    @OneToOne
    private GioHang gioHang;

    @OneToOne
    private KhoaHocYeuThich khoaHocYeuThich;
}
