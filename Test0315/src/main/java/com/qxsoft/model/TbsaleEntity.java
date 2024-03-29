package com.qxsoft.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by zc-09-023 on 2016/3/18.
 */
@Entity
@Table(name = "tbsale", schema = "public", catalog = "db_food")
public class TbsaleEntity {
    private Integer sid;
    private Double msalemoney;
    private Date dsaledate;
    private com.qxsoft.model.TbmerchantEntity merchantByMcid;
    private com.qxsoft.model.TborderEntity orderByOid;
    private TbusersEntity usersByUid;

    @Id
    @Column(name = "sid", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    @Basic
    @Column(name = "msalemoney", nullable = true, precision = 0)
    public Double getMsalemoney() {
        return msalemoney;
    }

    public void setMsalemoney(Double msalemoney) {
        this.msalemoney = msalemoney;
    }

    @Basic
    @Column(name = "dsaledate", nullable = true)
    public Date getDsaledate() {
        return dsaledate;
    }

    public void setDsaledate(Date dsaledate) {
        this.dsaledate = dsaledate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TbsaleEntity that = (TbsaleEntity) o;

        if (sid != null ? !sid.equals(that.sid) : that.sid != null) return false;
        if (msalemoney != null ? !msalemoney.equals(that.msalemoney) : that.msalemoney != null) return false;
        if (dsaledate != null ? !dsaledate.equals(that.dsaledate) : that.dsaledate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = sid != null ? sid.hashCode() : 0;
        result = 31 * result + (msalemoney != null ? msalemoney.hashCode() : 0);
        result = 31 * result + (dsaledate != null ? dsaledate.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "mcid", referencedColumnName = "mcid")
    public com.qxsoft.model.TbmerchantEntity getMerchantByMcid() {
        return merchantByMcid;
    }

    public void setMerchantByMcid(com.qxsoft.model.TbmerchantEntity merchantByMcid) {
        this.merchantByMcid = merchantByMcid;
    }

    @ManyToOne
    @JoinColumn(name = "oid", referencedColumnName = "oid")
    public com.qxsoft.model.TborderEntity getOrderByOid() {
        return orderByOid;
    }

    public void setOrderByOid(com.qxsoft.model.TborderEntity orderByOid) {
        this.orderByOid = orderByOid;
    }

    @ManyToOne
    @JoinColumn(name = "uid", referencedColumnName = "uid")
    public TbusersEntity getUsersByUid() {
        return usersByUid;
    }

    public void setUsersByUid(TbusersEntity usersByUid) {
        this.usersByUid = usersByUid;
    }
}
