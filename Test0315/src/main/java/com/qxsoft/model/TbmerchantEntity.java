package com.qxsoft.model;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by jz128 on 2016/3/16.
 */
@Entity
@Table(name = "tbmerchant", schema = "public", catalog = "db_food")
public class TbmerchantEntity {
    private Integer mcid;
    private String mcname;
    private String mcaddres;
    private String mcnum;
    private Set<TbmenusummaryEntity> tbmenusummaryEntitySetByMcnum;
    private Set<TbsaleEntity> tbsaleEntitySetByMcid;
    private Set<TborderEntity> tborderEntitySetByMcid;

    @Id
    @Column(name = "mcid", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getMcid() {
        return mcid;
    }

    public void setMcid(Integer mcid) {
        this.mcid = mcid;
    }

    @Basic
    @Column(name = "mcname", nullable = true, length = 20)
    public String getMcname() {
        return mcname;
    }

    public void setMcname(String mcname) {
        this.mcname = mcname;
    }

    @Basic
    @Column(name = "mcaddres", nullable = true, length = 50)
    public String getMcaddres() {
        return mcaddres;
    }

    public void setMcaddres(String mcaddres) {
        this.mcaddres = mcaddres;
    }

    @Basic
    @Column(name = "mcnum", nullable = true, length = 20)
    public String getMcnum() {
        return mcnum;
    }

    public void setMcnum(String mcnum) {
        this.mcnum = mcnum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TbmerchantEntity that = (TbmerchantEntity) o;

        if (mcid != null ? !mcid.equals(that.mcid) : that.mcid != null) return false;
        if (mcname != null ? !mcname.equals(that.mcname) : that.mcname != null) return false;
        if (mcaddres != null ? !mcaddres.equals(that.mcaddres) : that.mcaddres != null) return false;
        if (mcnum != null ? !mcnum.equals(that.mcnum) : that.mcnum != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = mcid != null ? mcid.hashCode() : 0;
        result = 31 * result + (mcname != null ? mcname.hashCode() : 0);
        result = 31 * result + (mcaddres != null ? mcaddres.hashCode() : 0);
        result = 31 * result + (mcnum != null ? mcnum.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "tbmerchantEntityByMcnum")
    public Set<TbmenusummaryEntity> getTbmenusummaryEntitySetByMcnum() {
        return tbmenusummaryEntitySetByMcnum;
    }

    public void setTbmenusummaryEntitySetByMcnum(Set<TbmenusummaryEntity> tbmenusummaryEntitySetByMcnum) {
        this.tbmenusummaryEntitySetByMcnum = tbmenusummaryEntitySetByMcnum;
    }

    @OneToMany(mappedBy = "tbmerchantEntityByMcid")
    public Set<TbsaleEntity> getTbsaleEntitySetByMcid() {
        return tbsaleEntitySetByMcid;
    }

    public void setTbsaleEntitySetByMcid(Set<TbsaleEntity> tbsaleEntitySetByMcid) {
        this.tbsaleEntitySetByMcid = tbsaleEntitySetByMcid;
    }

    @OneToMany(mappedBy = "tbmerchantEntityByMcid")
    public Set<TborderEntity> getTborderEntitySetByMcid() {
        return tborderEntitySetByMcid;
    }

    public void setTborderEntitySetByMcid(Set<TborderEntity> tborderEntitySetByMcid) {
        this.tborderEntitySetByMcid = tborderEntitySetByMcid;
    }
}
