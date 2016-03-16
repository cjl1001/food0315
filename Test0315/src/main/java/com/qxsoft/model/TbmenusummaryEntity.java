package com.qxsoft.model;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by jz128 on 2016/3/16.
 */
@Entity
@Table(name = "tbmenusummary", schema = "public", catalog = "db_food")
public class TbmenusummaryEntity {
    private Integer msid;
    //private String mcnum;
    private String smenuname;
    private Double mprice;
    private Integer favorstatus;
    //private Integer cid;
    private String smenunum;
    private String smenupicture;
    private TbmerchantEntity tbmerchantEntityByMcnum;
    private TbcategoryEntity tbcategoryEntityByCid;
    private Set<TborderdetailEntity> tborderdetailEntitySetByMsid;

    @Id
    @Column(name = "msid", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getMsid() {
        return msid;
    }

    public void setMsid(Integer msid) {
        this.msid = msid;
    }

    /*@Basic
    @Column(name = "mcnum", nullable = true, length = 20)
    public String getMcnum() {
        return mcnum;
    }

    public void setMcnum(String mcnum) {
        this.mcnum = mcnum;
    }*/

    @Basic
    @Column(name = "smenuname", nullable = true, length = 20)
    public String getSmenuname() {
        return smenuname;
    }

    public void setSmenuname(String smenuname) {
        this.smenuname = smenuname;
    }

    @Basic
    @Column(name = "mprice", nullable = true)
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

    /*@Basic
    @Column(name = "cid", nullable = true)
    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }*/

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
        //if (mcnum != null ? !mcnum.equals(that.mcnum) : that.mcnum != null) return false;
        if (smenuname != null ? !smenuname.equals(that.smenuname) : that.smenuname != null) return false;
        if (mprice != null ? !mprice.equals(that.mprice) : that.mprice != null) return false;
        if (favorstatus != null ? !favorstatus.equals(that.favorstatus) : that.favorstatus != null) return false;
        //if (cid != null ? !cid.equals(that.cid) : that.cid != null) return false;
        if (smenunum != null ? !smenunum.equals(that.smenunum) : that.smenunum != null) return false;
        if (smenupicture != null ? !smenupicture.equals(that.smenupicture) : that.smenupicture != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = msid != null ? msid.hashCode() : 0;
        //result = 31 * result + (mcnum != null ? mcnum.hashCode() : 0);
        result = 31 * result + (smenuname != null ? smenuname.hashCode() : 0);
        result = 31 * result + (mprice != null ? mprice.hashCode() : 0);
        result = 31 * result + (favorstatus != null ? favorstatus.hashCode() : 0);
        //result = 31 * result + (cid != null ? cid.hashCode() : 0);
        result = 31 * result + (smenunum != null ? smenunum.hashCode() : 0);
        result = 31 * result + (smenupicture != null ? smenupicture.hashCode() : 0);
        return result;
    }


    @ManyToOne
    @JoinColumn(name = "cid", referencedColumnName = "cid")
    public TbcategoryEntity getTbcategoryEntityByCid() {
        return tbcategoryEntityByCid;
    }

    public void setTbcategoryEntityByCid(TbcategoryEntity tbcategoryEntityByCid) {
        this.tbcategoryEntityByCid = tbcategoryEntityByCid;
    }

    @ManyToOne
    @JoinColumn(name = "mcnum", referencedColumnName = "mcnum")
    public TbmerchantEntity getTbmerchantEntityByMcnum() {
        return tbmerchantEntityByMcnum;
    }

    public void setTbmerchantEntityByMcnum(TbmerchantEntity tbmerchantEntityByMcnum) {
        this.tbmerchantEntityByMcnum = tbmerchantEntityByMcnum;
    }

    @OneToMany(mappedBy = "tbmenusummaryEntityByMsid")
    public Set<TborderdetailEntity> getTborderdetailEntitySetByMsid() {
        return tborderdetailEntitySetByMsid;
    }

    public void setTborderdetailEntitySetByMsid(Set<TborderdetailEntity> tborderdetailEntitySetByMsid) {
        this.tborderdetailEntitySetByMsid = tborderdetailEntitySetByMsid;
    }
}
