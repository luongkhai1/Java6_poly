package com.example.demoththujava6_5.service;

import com.example.demoththujava6_5.entity.ChucVu;
import com.example.demoththujava6_5.repo.ChucVuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChucVuService {

    @Autowired
    private ChucVuRepository chucVuRepository;

    public ChucVu findById(Integer id) {
        return chucVuRepository.findById(id).orElse(null);
    }


}
