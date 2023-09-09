package com.example.backend.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.*;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
public class GiangVien {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idGiangVien;

    private String tenGiangVien;

    private String diaChi;

    private String sdt;

    private String email;

    @OneToOne
    private Account account;

    @OneToMany(mappedBy = "giangVien")
    private List<KhoaHoc> khoaHocList = new ArrayList<>();
}
