package com.sean.model;

import javax.persistence.*;

/**
 * Created by zc-09-023 on 2016/3/18.
 */
@Entity
@Table(name = "tborderdetail", schema = "public", catalog = "test")
public class TborderdetailEntity {
    private Integer did;
    private Integer icount;
    private Double mprice;
    private Double mtotalmoney;
    private TbmenusummaryEntity menuByMsid;
    private TborderEntity orderByOid;

    @Id
    @Column(name = "did", nullable = false)
    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    @Basic
    @Column(name = "icount", nullable = true)
    public Integer getIcount() {
        return icount;
    }

    public void setIcount(Integer icount) {
        this.icount = icount;
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
    @Column(name = "mtotalmoney", nullable = true, precision = 0)
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
        if (icount != null ? !icount.equals(that.icount) : that.icount != null) return false;
        if (mprice != null ? !mprice.equals(that.mprice) : that.mprice != null) return false;
        if (mtotalmoney != null ? !mtotalmoney.equals(that.mtotalmoney) : that.mtotalmoney != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = did != null ? did.hashCode() : 0;
        result = 31 * result + (icount != null ? icount.hashCode() : 0);
        result = 31 * result + (mprice != null ? mprice.hashCode() : 0);
        result = 31 * result + (mtotalmoney != null ? mtotalmoney.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "msid", referencedColumnName = "msid")
    public TbmenusummaryEntity getMenuByMsid() {
        return menuByMsid;
    }

    public void setMenuByMsid(TbmenusummaryEntity menuByMsid) {
        this.menuByMsid = menuByMsid;
    }

    @ManyToOne
    @JoinColumn(name = "oid", referencedColumnName = "oid")
    public TborderEntity getOrderByOid() {
        return orderByOid;
    }

    public void setOrderByOid(TborderEntity orderByOid) {
        this.orderByOid = orderByOid;
    }
}
