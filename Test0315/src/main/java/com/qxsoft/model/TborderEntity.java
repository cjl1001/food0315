package com.qxsoft.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * Created by jz128 on 2016/3/16.
 */
@Entity
@Table(name = "tborder", schema = "public", catalog = "db_food")
public class TborderEntity {
    private Integer oid;
    //private Integer uid;
    //private Integer mcid;
    //private Integer aid;
    private Double mtotalcost;
    private Date ordertime;
    private Integer orderstatus;
    private String ordernum;
    private String orderremark;
    private Set<TborderdetailEntity> tborderdetailEntitySetByOid;
    private Set<TbsaleEntity> tbsaleEntitySetBySid;
    private TbusersEntity tbusersEntityByUid;
    private TbmerchantEntity tbmerchantEntityByMcid;
    private TbaddressEntity tbaddressEntityByAid;

    @Id
    @Column(name = "oid", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }

    /*@Basic
    @Column(name = "uid", nullable = true)
    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    @Basic
    @Column(name = "mcid", nullable = true)
    public Integer getMcid() {
        return mcid;
    }

    public void setMcid(Integer mcid) {
        this.mcid = mcid;
    }

    @Basic
    @Column(name = "aid", nullable = true)
    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }*/

    @Basic
    @Column(name = "mtotalcost", nullable = true)
    public Double getMtotalcost() {
        return mtotalcost;
    }

    public void setMtotalcost(Double mtotalcost) {
        this.mtotalcost = mtotalcost;
    }

    @Basic
    @Column(name = "ordertime", nullable = true)
    public Date getOrdertime() {
        return ordertime;
    }

    public void setOrdertime(Date ordertime) {
        this.ordertime = ordertime;
    }

    @Basic
    @Column(name = "orderstatus", nullable = true)
    public Integer getOrderstatus() {
        return orderstatus;
    }

    public void setOrderstatus(Integer orderstatus) {
        this.orderstatus = orderstatus;
    }

    @Basic
    @Column(name = "ordernum", nullable = true, length = 20)
    public String getOrdernum() {
        return ordernum;
    }

    public void setOrdernum(String ordernum) {
        this.ordernum = ordernum;
    }

    @Basic
    @Column(name = "orderremark", nullable = true, length = -1)
    public String getOrderremark() {
        return orderremark;
    }

    public void setOrderremark(String orderremark) {
        this.orderremark = orderremark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TborderEntity that = (TborderEntity) o;

        if (oid != null ? !oid.equals(that.oid) : that.oid != null) return false;
        /*if (uid != null ? !uid.equals(that.uid) : that.uid != null) return false;
        if (mcid != null ? !mcid.equals(that.mcid) : that.mcid != null) return false;
        if (aid != null ? !aid.equals(that.aid) : that.aid != null) return false;*/
        if (mtotalcost != null ? !mtotalcost.equals(that.mtotalcost) : that.mtotalcost != null) return false;
        if (ordertime != null ? !ordertime.equals(that.ordertime) : that.ordertime != null) return false;
        if (orderstatus != null ? !orderstatus.equals(that.orderstatus) : that.orderstatus != null) return false;
        if (ordernum != null ? !ordernum.equals(that.ordernum) : that.ordernum != null) return false;
        if (orderremark != null ? !orderremark.equals(that.orderremark) : that.orderremark != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = oid != null ? oid.hashCode() : 0;
        /*result = 31 * result + (uid != null ? uid.hashCode() : 0);
        result = 31 * result + (mcid != null ? mcid.hashCode() : 0);
        result = 31 * result + (aid != null ? aid.hashCode() : 0);*/
        result = 31 * result + (mtotalcost != null ? mtotalcost.hashCode() : 0);
        result = 31 * result + (ordertime != null ? ordertime.hashCode() : 0);
        result = 31 * result + (orderstatus != null ? orderstatus.hashCode() : 0);
        result = 31 * result + (ordernum != null ? ordernum.hashCode() : 0);
        result = 31 * result + (orderremark != null ? orderremark.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "tborderEntityByOid")
    public Set<TborderdetailEntity> getTborderdetailEntitySetByOid() {
        return tborderdetailEntitySetByOid;
    }

    public void setTborderdetailEntitySetByOid(Set<TborderdetailEntity> tborderdetailEntitySetByOid) {
        this.tborderdetailEntitySetByOid = tborderdetailEntitySetByOid;
    }

    @OneToMany(mappedBy = "tborderEntityByOid")
    public Set<TbsaleEntity> getTbsaleEntitySetBySid() {
        return tbsaleEntitySetBySid;
    }

    public void setTbsaleEntitySetBySid(Set<TbsaleEntity> tbsaleEntitySetBySid) {
        this.tbsaleEntitySetBySid = tbsaleEntitySetBySid;
    }

    @ManyToOne
    @JoinColumn(name = "uid",referencedColumnName = "uid")
    public TbusersEntity getTbusersEntityByUid() {
        return tbusersEntityByUid;
    }

    public void setTbusersEntityByUid(TbusersEntity tbusersEntityByUid) {
        this.tbusersEntityByUid = tbusersEntityByUid;
    }

    @ManyToOne
    @JoinColumn(name = "mcid",referencedColumnName = "mcid")
    public TbmerchantEntity getTbmerchantEntityByMcid() {
        return tbmerchantEntityByMcid;
    }

    public void setTbmerchantEntityByMcid(TbmerchantEntity tbmerchantEntityByMcid) {
        this.tbmerchantEntityByMcid = tbmerchantEntityByMcid;
    }

    @ManyToOne
    @JoinColumn(name = "aid",referencedColumnName = "aid")
    public TbaddressEntity getTbaddressEntityByAid() {
        return tbaddressEntityByAid;
    }

    public void setTbaddressEntityByAid(TbaddressEntity tbaddressEntityByAid) {
        this.tbaddressEntityByAid = tbaddressEntityByAid;
    }
}
