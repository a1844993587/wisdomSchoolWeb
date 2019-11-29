package com.wxiaoy.pojo;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Alex Yu
 * @date 2019/11/29 15:18
 */
@Data
@Entity
@ToString
@Table(name = "city")
public class City {

    @Id
    private String id;
    @Column(name = "cityEn")
    private String cityEn;
    @Column(name = "cityZh")
    private String cityZh;
    @Column(name = "provinceEn")
    private String provinceEn;
    @Column(name = "provinceZh")
    private String provinceZh;
    @Column(name = "countryEn")
    private String countryEn;
    @Column(name = "countryZh")
    private String countryZh;
    @Column(name = "leaderEn")
    private String leaderEn;
    @Column(name = "leaderZh")
    private String leaderZh;
    private String lat;
    private String lon;


}
