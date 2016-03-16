package com.qxsoft.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by jz128 on 2016/3/16.
 */
@Entity
@Table(name = "tbsale", schema = "public", catalog = "db_food")
public class TbsaleEntity {
    private Integer sid;
    //private Integer uid;
    //private Integer mcid;
    //private Integer oid;
    private Double msalemoney;
    private Date dsaledate;
    private TbusersEntity tbusersEntityByUid;
    private TbmerchantEntity tbmerchantEntityByMcid;
    private TborderEntity tborderEntityByOid;

    @Id
    @Column(name = "sid", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
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
    @Column(name = "oid", nullable = true)
    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }*/

    @Basic
    @Column(name = "msalemoney", nullable = true)
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
        /*if (uid != null ? !uid.equals(that.uid) : that.uid != null) return false;
        if (mcid != null ? !mcid.equals(that.mcid) : that.mcid != null) return false;
        if (oid != null ? !oid.equals(that.oid) : that.oid != null) return false;*/
        if (msalemoney != null ? !msalemoney.equals(that.msalemoney) : that.msalemoney != null) return false;
        if (dsaledate != null ? !dsaledate.equals(that.dsaledate) : that.dsaledate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = sid != null ? sid.hashCode() : 0;
        /*result = 31 * result + (uid != null ? uid.hashCode() : 0);
        result = 31 * result + (mcid != null ? mcid.hashCode() : 0);
        result = 31 * result + (oid != null ? oid.hashCode() : 0);*/
        result = 31 * result + (msalemoney != null ? msalemoney.hashCode() : 0);
        result = 31 * result + (dsaledate != null ? dsaledate.hashCode() : 0);
        return result;
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
    @JoinColumn(name = "oid",referencedColumnName = "oid")
    public TborderEntity getTborderEntityByOid() {
        return tborderEntityByOid;
    }

    public void setTborderEntityByOid(TborderEntity tborderEntityByOid) {
        this.tborderEntityByOid = tborderEntityByOid;
    }
}
