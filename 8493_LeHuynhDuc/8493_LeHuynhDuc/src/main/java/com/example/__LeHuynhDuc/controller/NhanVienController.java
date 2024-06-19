package com.example.__LeHuynhDuc.controller;


import com.example.__LeHuynhDuc.model.NHANVIEN;
import com.example.__LeHuynhDuc.service.NhanVienService;
import com.example.__LeHuynhDuc.service.PhongBanService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.naming.Binding;

@Controller
@RequestMapping("/nhanvien")
@RequiredArgsConstructor
public class NhanVienController {
    @Autowired
    private final NhanVienService nhanVienService;
    @Autowired
    private final PhongBanService phongBanService;

    @GetMapping
    public String listNhanVien(@RequestParam(defaultValue = "0") int page, Model model){
        Page<NHANVIEN> nhanVienPage = nhanVienService.findPaginated(page, 5);
        model.addAttribute("nhanViens", nhanVienPage);
        model.addAttribute("currentPage", page);
        return "nhanviens/nhanvien-list";
    }

    @GetMapping("/add")
    public String add(Model model){
        model.addAttribute("nhanvien",new NHANVIEN());
        model.addAttribute("phongBans",phongBanService.getALl());
        return "nhanviens/add-nhanvien";
    }

    @PostMapping("/add")
    public String addNV(@Valid NHANVIEN nhanvien, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "nhanviens/add-nhanvien";
        }
        nhanVienService.AddNhanVien(nhanvien);
        return "redirect:/nhanvien";
    }

    @GetMapping("/edit/{id}")
    public String show(@PathVariable String id, Model model){
        NHANVIEN n = nhanVienService.getNhanVienById(id).orElseThrow();
        model.addAttribute("n",n);
        model.addAttribute("PhongBan",phongBanService.getALl());
        return "nhanviens/update-nhanvien";
    }

    @PostMapping("/update/{id}")
    public String upadateNV(@PathVariable String id,@Valid NHANVIEN n,BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "nhanviens/update-nhanvien";
        }
        n.setMa_NV(id);
        nhanVienService.UpdateNV(n);
        return "redirect:/nhanvien";
    }
    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable String id) {
        nhanVienService.deleteById(id);
        return "redirect:/nhanvien";
    }


}
