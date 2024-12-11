package com.example.demoththujava6_5.request;

import com.example.demoththujava6_5.entity.ChucVu;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NhanVienRequest {

    @NotEmpty(message = "ma not null")
    private String ma;
    @NotEmpty(message = "ten not null")
    private String ten;
    @NotEmpty(message = "ten dem not null")
    private String tenDem;
    @NotEmpty(message = "ho not null")
    private String ho;
    @NotEmpty(message = "gioi tinh not null")
    private String gioiTinh;
    @NotEmpty(message = "dia chi not null")
    private String diaChi;
    @NotEmpty(message = "sdt not null")
    private String sdt;
    @NotEmpty(message = "mat khau not null")
    private String matKhau;
    @NotNull(message = "Chuc vu not null")
    private Integer idCv;
    @NotNull(message = "trang thai not null")
    private Integer trangThai;
}
