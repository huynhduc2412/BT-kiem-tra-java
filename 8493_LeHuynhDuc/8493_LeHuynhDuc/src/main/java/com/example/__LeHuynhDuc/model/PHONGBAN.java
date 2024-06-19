package com.example.__LeHuynhDuc.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
@Table(name = "PhongBan")
public class PHONGBAN {
    @Id
    private String MaPhong;

    @Length(min=1,max=30)
    private String Ten_Phong;
}
