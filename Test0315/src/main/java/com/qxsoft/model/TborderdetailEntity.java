package com.qxsoft.model;

import javax.persistence.*;

/**
 * Created by jz128 on 2016/3/16.
 */
@Entity
@Table(name = "tborderdetail", schema = "public", catalog = "db_food")
public class TborderdetailEntity {
    private Integer did;
    //private Integer msid;
    //private Integer oid;
    private Integer icount;
    private Double mprice;
    private Double mtotalmoney;
    private TbmenusummaryEntity tbmenusummaryEntityByMsid;
    private TborderEntity tborderEntityByOid;

    @Id
    @Column(name = "did", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    /*@Basic
    @Column(name = "msid", nullable = true)
    public Integer getMsid() {
        return msid;
    }

    public void setMsid(Integer msid) {
        this.msid = msid;
    }*/

    /*@Basic
    @Column(name = "oid", nullable = true)
    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }*/

    @Basic
    @Column(name = "icount", nullable = true)
    public Integer getIcount() {
        return icount;
    }

    public void setIcount(Integer icount) {
        this.icount = icount;
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
    @Column(name = "mtotalmoney", nullable = true)
    public Double getMtotalmoney() {
        return mtotalmoney;
    }

    public void setMtotalmoney(Double mtotalmoney) {
        this.mtotalmoney = mtotalmoney;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TborderdetailEntity that = (TborderdetailEntity) o;

        if (did != null ? !did.equals(that.did) : that.did != null) return false;
        //if (msid != null ? !msid.equals(that.msid) : that.msid != null) return false;
        //if (oid != null ? !oid.equals(that.oid) : that.oid != null) return false;
        if (icount != null ? !icount.equals(that.icount) : that.icount != null) return false;
        if (mprice != null ? !mprice.equals(that.mprice) : that.mprice != null) return false;
        if (mtotalmoney != null ? !mtotalmoney.equals(that.mtotalmoney) : that.mtotalmoney != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = did != null ? did.hashCode() : 0;
        //result = 31 * result + (msid != null ? msid.hashCode() : 0);
        //result = 31 * result + (oid != null ? oid.hashCode() : 0);
        result = 31 * result + (icount != null ? icount.hashCode() : 0);
        result = 31 * result + (mprice != null ? mprice.hashCode() : 0);
        result = 31 * result + (mtotalmoney != null ? mtotalmoney.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "msid",referencedColumnName = "msid")
    public TbmenusummaryEntity getTbmenusummaryEntityByMsid() {
        return tbmenusummaryEntityByMsid;
    }

    public void setTbmenusummaryEntityByMsid(TbmenusummaryEntity tbmenusummaryEntityByMsid) {
        this.tbmenusummaryEntityByMsid = tbmenusummaryEntityByMsid;
    }

    @ManyToOne
    @JoinColumn(name = "oid",referencedColumnName = "oid")
    public TborderEntity getTborderEntityByOid() {
        return tborderEntityByOid;
    }

    public void setTborderEntityByOid(TborderEntity tborderEntityByOid) {
        this.tborderEntityByOid = tborderEntityByOid;
    }
}
