package com.example.__LeHuynhDuc.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "NhanSu")
public class NHANVIEN {
   @Id
   @Length(min=1,max=3)
   private String Ma_NV;

   @Length(min=2,max=100)
   private String Ten_NV;

    @Length(min=2,max=3)
   private String Phai;

    @Length(min=1,max=200)
    private String Noi_Sinh;

    @ManyToOne
    @JoinColumn(name="MaPhong")
    private PHONGBAN maphong;

    private int Luong;
}
