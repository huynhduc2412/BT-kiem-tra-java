package com.example.__LeHuynhDuc.Repository;

import com.example.__LeHuynhDuc.model.NHANVIEN;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NhanVienRepository extends JpaRepository<NHANVIEN,String> {
}
