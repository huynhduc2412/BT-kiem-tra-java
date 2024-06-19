package com.example.__LeHuynhDuc.Repository;

import com.example.__LeHuynhDuc.model.PHONGBAN;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhongBanRepository  extends JpaRepository<PHONGBAN,String> {
}
