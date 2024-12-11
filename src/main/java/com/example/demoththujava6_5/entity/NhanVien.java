package com.example.demoththujava6_5.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Getter
@Setter
@Entity
@Table(name = "nhan_vien")
public class NhanVien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotBlank(message = "ma not null")
    @Column(name = "ma", length = 20)
    private String ma;

    @NotBlank(message = "ten not null")
    @Nationalized
    @Column(name = "ten", length = 30)
    private String ten;

    @NotBlank(message = "ten dem not null")
    @Nationalized
    @Column(name = "ten_dem", length = 30)
    private String tenDem;

    @NotBlank(message = "ho not null")
    @Nationalized
    @Column(name = "ho", length = 30)
    private String ho;

    @NotBlank(message = "gioi tinh not null")
    @Nationalized
    @Column(name = "gioi_tinh", length = 10)
    private String gioiTinh;

    @NotBlank(message = "dia chi not null")
    @Nationalized
    @Column(name = "dia_chi", length = 100)
    private String diaChi;

    @NotBlank(message = "sdt not null")
    @Column(name = "sdt", length = 30)
    private String sdt;

    @NotBlank(message = "mat khau not null")
    @Column(name = "mat_khau", length = 50)
    private String matKhau;

    @NotNull(message = "Chuc vu not null")
    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "id_cv")
    private ChucVu idCv;

    @NotNull(message = "trang thai not null")
    @Column(name = "trang_thai")
    private Integer trangThai;

}