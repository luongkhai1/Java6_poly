package com.example.demoththujava6_5.repo;

import com.example.demoththujava6_5.response.NhanVienResponse;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NhanVienResponseRepository extends JpaRepository<NhanVienResponse, Integer> {


    @Query(value = "SELECT \n" +
            "\tnv.id ,\n" +
            "\tCONCAT(nv.ho, ' ', nv.ten_dem, ' ' , nv.ten) AS 'ho_ten',\n" +
            "\tnv.ma,\n" +
            "\tnv.gioi_tinh ,\n" +
            "\tnv.dia_chi,\n" +
            "\tcv.ten AS 'chuc_vu'\n" +
            "FROM dbo.nhan_vien nv JOIN dbo.chuc_vu cv ON cv.id = nv.id_cv",
            nativeQuery = true
    )
    List<NhanVienResponse> getNhanVienResponse();

    @Query(value = "SELECT \n" +
            "\tnv.id ,\n" +
            "\tCONCAT(nv.ho, ' ', nv.ten_dem, ' ' , nv.ten) AS 'ho_ten',\n" +
            "\tnv.ma,\n" +
            "\tnv.gioi_tinh ,\n" +
            "\tnv.dia_chi,\n" +/////
            "\tcv.ten AS 'chuc_vu'\n" +
            "FROM dbo.nhan_vien nv JOIN dbo.chuc_vu cv ON cv.id = nv.id_cv",
            nativeQuery = true
    )
    List<NhanVienResponse> getPageNhanVienResponse(Pageable pageable);

}