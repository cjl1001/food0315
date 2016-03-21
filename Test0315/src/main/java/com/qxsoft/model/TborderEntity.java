package com.sean.model;

import javax.persistence.*;
import java.sql.Time;
import java.util.Collection;

/**
 * Created by zc-09-023 on 2016/3/18.
 */
@Entity
@Table(name = "tborder", schema = "public", catalog = "test")
public class TborderEntity {
    private Integer oid;
    private String smerchant;
    private String susername;
    private Double mtotalcost;
    private Time tordertime;
    private Integer iorderstatus;
    private String sordernum;
    private String torderremark;
    private String sorderaddress;
    private Collection<TbsaleEntity> saleById;

    @Id
    @Column(name = "oid", nullable = false)
    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }

    @Basic
    @Column(name = "smerchant", nullable = true, length = 20)
    public String getSmerchant() {
        return smerchant;
    }

    public void setSmerchant(String smerchant) {
        this.smerchant = smerchant;
    }

    @Basic
    @Column(name = "susername", nullable = true, length = 20)
    public String getSusername() {
        return susername;
    }

    public void setSusername(String susername) {
        this.susername = susername;
    }

    @Basic
    @Column(name = "mtotalcost", nullable = true, precision = 0)
    public Double getMtotalcost() {
        return mtotalcost;
    }

    public void setMtotalcost(Double mtotalcost) {
        this.mtotalcost = mtotalcost;
    }

    @Basic
    @Column(name = "tordertime", nullable = true)
    public Time getTordertime() {
        return tordertime;
    }

    public void setTordertime(Time tordertime) {
        this.tordertime = tordertime;
    }

    @Basic
    @Column(name = "iorderstatus", nullable = true)
    public Integer getIorderstatus() {
        return iorderstatus;
    }

    public void setIorderstatus(Integer iorderstatus) {
        this.iorderstatus = iorderstatus;
    }

    @Basic
    @Column(name = "sordernum", nullable = true, length = 20)
    public String getSordernum() {
        return sordernum;
    }

    public void setSordernum(String sordernum) {
        this.sordernum = sordernum;
    }

    @Basic
    @Column(name = "torderremark", nullable = true, length = -1)
    public String getTorderremark() {
        return torderremark;
    }

    public void setTorderremark(String torderremark) {
        this.torderremark = torderremark;
    }

    @Basic
    @Column(name = "sorderaddress", nullable = true, length = 50)
    public String getSorderaddress() {
        return sorderaddress;
    }

    public void setSorderaddress(String sorderaddress) {
        this.sorderaddress = sorderaddress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TborderEntity that = (TborderEntity) o;

        if (oid != null ? !oid.equals(that.oid) : that.oid != null) return false;
        if (smerchant != null ? !smerchant.equals(that.smerchant) : that.smerchant != null) return false;
        if (susername != null ? !susername.equals(that.susername) : that.susername != null) return false;
        if (mtotalcost != null ? !mtotalcost.equals(that.mtotalcost) : that.mtotalcost != null) return false;
        if (tordertime != null ? !tordertime.equals(that.tordertime) : that.tordertime != null) return false;
        if (iorderstatus != null ? !iorderstatus.equals(that.iorderstatus) : that.iorderstatus != null) return false;
        if (sordernum != null ? !sordernum.equals(that.sordernum) : that.sordernum != null) return false;
        if (torderremark != null ? !torderremark.equals(that.torderremark) : that.torderremark != null) return false;
        if (sorderaddress != null ? !sorderaddress.equals(that.sorderaddress) : that.sorderaddress != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = oid != null ? oid.hashCode() : 0;
        result = 31 * result + (smerchant != null ? smerchant.hashCode() : 0);
        result = 31 * result + (susername != null ? susername.hashCode() : 0);
        result = 31 * result + (mtotalcost != null ? mtotalcost.hashCode() : 0);
        result = 31 * result + (tordertime != null ? tordertime.hashCode() : 0);
        result = 31 * result + (iorderstatus != null ? iorderstatus.hashCode() : 0);
        result = 31 * result + (sordernum != null ? sordernum.hashCode() : 0);
        result = 31 * result + (torderremark != null ? torderremark.hashCode() : 0);
        result = 31 * result + (sorderaddress != null ? sorderaddress.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "orderByOid")
    public Collection<TbsaleEntity> getSaleById() {
        return saleById;
    }

    public void setSaleById(Collection<TbsaleEntity> saleById) {
        this.saleById = saleById;
    }
}
