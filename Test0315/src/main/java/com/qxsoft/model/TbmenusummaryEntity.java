package com.sean.model;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by zc-09-023 on 2016/3/18.
 */
@Entity
@Table(name = "tbmenusummary", schema = "public", catalog = "test")
public class TbmenusummaryEntity {
    private Integer msid;
    private String smenuname;
    private Double mprice;
    private Integer favorstatus;
    private String smenunum;
    private String smenupicture;
    private Collection<TborderdetailEntity> borderderdetailById;
    private TbcategoryEntity categoryByCid;
    private TbmerchantEntity merchantByMcnum;

    @Id
    @Column(name = "msid", nullable = false)
    public Integer getMsid() {
        return msid;
    }

    public void setMsid(Integer msid) {
        this.msid = msid;
    }

    @Basic
    @Column(name = "smenuname", nullable = true, length = 20)
    public String getSmenuname() {
        return smenuname;
    }

    public void setSmenuname(String smenuname) {
        this.smenuname = smenuname;
    }

    @Basic
    @Column(name = "mprice", nullable = true, precision = 0)
    public Double getMprice() {
        return mprice;
    }

    public void setMprice(Double mprice) {
        this.mprice = mprice;
    }

    @Basic
    @Column(name = "favorstatus", nullable = true)
    public Integer getFavorstatus() {
        return favorstatus;
    }

    public void setFavorstatus(Integer favorstatus) {
        this.favorstatus = favorstatus;
    }

    @Basic
    @Column(name = "smenunum", nullable = true, length = 20)
    public String getSmenunum() {
        return smenunum;
    }

    public void setSmenunum(String smenunum) {
        this.smenunum = smenunum;
    }

    @Basic
    @Column(name = "smenupicture", nullable = true, length = 100)
    public String getSmenupicture() {
        return smenupicture;
    }

    public void setSmenupicture(String smenupicture) {
        this.smenupicture = smenupicture;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TbmenusummaryEntity that = (TbmenusummaryEntity) o;

        if (msid != null ? !msid.equals(that.msid) : that.msid != null) return false;
        if (smenuname != null ? !smenuname.equals(that.smenuname) : that.smenuname != null) return false;
        if (mprice != null ? !mprice.equals(that.mprice) : that.mprice != null) return false;
        if (favorstatus != null ? !favorstatus.equals(that.favorstatus) : that.favorstatus != null) return false;
        if (smenunum != null ? !smenunum.equals(that.smenunum) : that.smenunum != null) return false;
        if (smenupicture != null ? !smenupicture.equals(that.smenupicture) : that.smenupicture != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = msid != null ? msid.hashCode() : 0;
        result = 31 * result + (smenuname != null ? smenuname.hashCode() : 0);
        result = 31 * result + (mprice != null ? mprice.hashCode() : 0);
        result = 31 * result + (favorstatus != null ? favorstatus.hashCode() : 0);
        result = 31 * result + (smenunum != null ? smenunum.hashCode() : 0);
        result = 31 * result + (smenupicture != null ? smenupicture.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "menuByMsid")
    public Collection<TborderdetailEntity> getBorderderdetailById() {
        return borderderdetailById;
    }

    public void setBorderderdetailById(Collection<TborderdetailEntity> borderderdetailById) {
        this.borderderdetailById = borderderdetailById;
    }

    @ManyToOne
    @JoinColumn(name = "cid", referencedColumnName = "cid")
    public TbcategoryEntity getCategoryByCid() {
        return categoryByCid;
    }

    public void setCategoryByCid(TbcategoryEntity categoryByCid) {
        this.categoryByCid = categoryByCid;
    }

    @OneToOne
    @JoinColumn(name = "mcnum", referencedColumnName = "mcnum", nullable = false)
    public TbmerchantEntity getMerchantByMcnum() {
        return merchantByMcnum;
    }

    public void setMerchantByMcnum(TbmerchantEntity merchantByMcnum) {
        this.merchantByMcnum = merchantByMcnum;
    }
}
