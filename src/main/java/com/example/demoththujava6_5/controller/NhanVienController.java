package com.example.demoththujava6_5.controller;


import com.example.demoththujava6_5.entity.NhanVien;
import com.example.demoththujava6_5.request.NhanVienRequest;
import com.example.demoththujava6_5.response.NhanVienResponse;
import com.example.demoththujava6_5.service.ChucVuService;
import com.example.demoththujava6_5.service.NhanVienService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/staffs")
public class NhanVienController {

    @Autowired
    private NhanVienService nhanVienService;

    @Autowired
    private ChucVuService chucVuService;

    @GetMapping()
    public List<NhanVienResponse> getNhanVienResponse() {
        return nhanVienService.getNhanVien();
    }

    @GetMapping("/paging")
    public List<NhanVienResponse> getNhanVienPaging(Pageable pageable) {
        return nhanVienService.getPageNhanVien(pageable);
    }

    @PostMapping()
    public ResponseEntity<?> add(@Validated @RequestBody NhanVienRequest nhanVienRequest, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            List<String> errors = bindingResult.getAllErrors().stream()
                    .map(DefaultMessageSourceResolvable::getDefaultMessage)
                    .collect(Collectors.toList());
            return ResponseEntity.badRequest().body(errors);
        }

        NhanVien nhanVien = new NhanVien();
        nhanVien.setMa(nhanVienRequest.getMa());
        nhanVien.setTen(nhanVienRequest.getTen());
        nhanVien.setTenDem(nhanVienRequest.getTenDem());
        nhanVien.setHo(nhanVienRequest.getHo());
        nhanVien.setGioiTinh(nhanVienRequest.getGioiTinh());
        nhanVien.setDiaChi(nhanVienRequest.getDiaChi());
        nhanVien.setSdt(nhanVienRequest.getSdt());
        nhanVien.setMatKhau(nhanVienRequest.getMatKhau());
        nhanVien.setIdCv(chucVuService.findById(nhanVienRequest.getIdCv()));
        nhanVien.setTrangThai(nhanVienRequest.getTrangThai());

        return ResponseEntity.ok(nhanVienService.save(nhanVien));
    }

    @GetMapping("/{id}")
    public ResponseEntity<NhanVien> getNhanVienById(@PathVariable Integer id) {
        NhanVien nhanVien = nhanVienService.findByID(id);
        if (nhanVien == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(nhanVien);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody NhanVienRequest nhanVienRequest) {
        NhanVien nhanVien = nhanVienService.findByID(id);
        if (nhanVien == null) {
            return ResponseEntity.notFound().build();
        }

        nhanVien.setMa(nhanVienRequest.getMa());
        nhanVien.setTen(nhanVienRequest.getTen());
        nhanVien.setTenDem(nhanVienRequest.getTenDem());
        nhanVien.setHo(nhanVienRequest.getHo());
        nhanVien.setGioiTinh(nhanVienRequest.getGioiTinh());
        nhanVien.setDiaChi(nhanVienRequest.getDiaChi());
        nhanVien.setSdt(nhanVienRequest.getSdt());
        nhanVien.setMatKhau(nhanVienRequest.getMatKhau());
        nhanVien.setIdCv(chucVuService.findById(nhanVienRequest.getIdCv()));
        nhanVien.setTrangThai(nhanVienRequest.getTrangThai());

        return ResponseEntity.ok(nhanVienService.save(nhanVien));

    }
}
