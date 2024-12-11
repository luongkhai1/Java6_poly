package com.example.demoththujava6_5.service;

import com.example.demoththujava6_5.entity.NhanVien;
import com.example.demoththujava6_5.repo.NhanVienRepository;
import com.example.demoththujava6_5.repo.NhanVienResponseRepository;
import com.example.demoththujava6_5.response.NhanVienResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NhanVienService {

    @Autowired
    private NhanVienRepository nhanVienRepository;

    @Autowired
    private NhanVienResponseRepository nhanVienResponseRepository;

    public List<NhanVienResponse> getNhanVien() {
        return nhanVienResponseRepository.getNhanVienResponse();
    }

    public List<NhanVienResponse> getPageNhanVien(Pageable pageable) {
        return nhanVienResponseRepository.getPageNhanVienResponse(pageable);
    }

    public NhanVien save(NhanVien nhanVien) {
        return nhanVienRepository.save(nhanVien);
    }

    public NhanVien findByID(Integer id) {
        return nhanVienRepository.findById(id).orElse(null);
    }


}
