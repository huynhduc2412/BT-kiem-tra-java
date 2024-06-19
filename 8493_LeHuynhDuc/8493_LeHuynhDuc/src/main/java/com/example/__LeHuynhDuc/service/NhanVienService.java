package com.example.__LeHuynhDuc.service;

import com.example.__LeHuynhDuc.Repository.NhanVienRepository;
import com.example.__LeHuynhDuc.model.NHANVIEN;
import jakarta.transaction.Transactional;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class NhanVienService {
    private final NhanVienRepository nhanVienRepository;
    public List<NHANVIEN> getAll(){
        return  nhanVienRepository.findAll();
    }
    public Optional<NHANVIEN> getNhanVienById(String id){
        return nhanVienRepository.findById(id);
    }
    public Page<NHANVIEN> findPaginated(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return nhanVienRepository.findAll(pageable);
    }
    public void AddNhanVien(NHANVIEN n){
        nhanVienRepository.save(n);
    }

    public void UpdateNV(@NotNull NHANVIEN n){
        NHANVIEN exist = nhanVienRepository.findById(n.getMa_NV()).orElseThrow();
        exist.setPhai(n.getPhai());
        exist.setLuong(n.getLuong());
        exist.setMaphong(n.getMaphong());
        exist.setTen_NV(n.getTen_NV());
        exist.setNoi_Sinh(n.getTen_NV());
        nhanVienRepository.save(exist);
    }
    public void deleteById(String id){
        if(!nhanVienRepository.existsById(id)){
            throw new IllegalStateException("Ma Nhan Vien " + id + " does not exist.");
        }
        nhanVienRepository.deleteById(id);
    }
}
