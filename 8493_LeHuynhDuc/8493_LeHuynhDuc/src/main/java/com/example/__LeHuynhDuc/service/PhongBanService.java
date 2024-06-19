package com.example.__LeHuynhDuc.service;

import com.example.__LeHuynhDuc.Repository.PhongBanRepository;
import com.example.__LeHuynhDuc.model.PHONGBAN;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class PhongBanService {
    private  final PhongBanRepository phongBanRepository;
    public List<PHONGBAN>getALl(){
        return phongBanRepository.findAll();
    }
}
