package com.sean.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

/**
 * Created by zc-09-023 on 2016/3/18.
 */
@Entity
@Table(name = "tbusers", schema = "public", catalog = "test")
public class TbusersEntity {
    private Integer uid;
    private String susername;
    private String spassword;
    private String stel;
    private Date dcreatdate;
    private Date dlastdate;
    private Double mcostmoney;
    private Integer iuserpoint;
    private Integer irolelevel;
    private Collection<TbaddressEntity> addressById;
    private Collection<TbsaleEntity> saleById;

    @Id
    @Column(name = "uid", nullable = false)
    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
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
    @Column(name = "spassword", nullable = true, length = 20)
    public String getSpassword() {
        return spassword;
    }

    public void setSpassword(String spassword) {
        this.spassword = spassword;
    }

    @Basic
    @Column(name = "stel", nullable = true, length = 11)
    public String getStel() {
        return stel;
    }

    public void setStel(String stel) {
        this.stel = stel;
    }

    @Basic
    @Column(name = "dcreatdate", nullable = true)
    public Date getDcreatdate() {
        return dcreatdate;
    }

    public void setDcreatdate(Date dcreatdate) {
        this.dcreatdate = dcreatdate;
    }

    @Basic
    @Column(name = "dlastdate", nullable = true)
    public Date getDlastdate() {
        return dlastdate;
    }

    public void setDlastdate(Date dlastdate) {
        this.dlastdate = dlastdate;
    }

    @Basic
    @Column(name = "mcostmoney", nullable = true, precision = 0)
    public Double getMcostmoney() {
        return mcostmoney;
    }

    public void setMcostmoney(Double mcostmoney) {
        this.mcostmoney = mcostmoney;
    }

    @Basic
    @Column(name = "iuserpoint", nullable = true)
    public Integer getIuserpoint() {
        return iuserpoint;
    }

    public void setIuserpoint(Integer iuserpoint) {
        this.iuserpoint = iuserpoint;
    }

    @Basic
    @Column(name = "irolelevel", nullable = true)
    public Integer getIrolelevel() {
        return irolelevel;
    }

    public void setIrolelevel(Integer irolelevel) {
        this.irolelevel = irolelevel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TbusersEntity that = (TbusersEntity) o;

        if (uid != null ? !uid.equals(that.uid) : that.uid != null) return false;
        if (susername != null ? !susername.equals(that.susername) : that.susername != null) return false;
        if (spassword != null ? !spassword.equals(that.spassword) : that.spassword != null) return false;
        if (stel != null ? !stel.equals(that.stel) : that.stel != null) return false;
        if (dcreatdate != null ? !dcreatdate.equals(that.dcreatdate) : that.dcreatdate != null) return false;
        if (dlastdate != null ? !dlastdate.equals(that.dlastdate) : that.dlastdate != null) return false;
        if (mcostmoney != null ? !mcostmoney.equals(that.mcostmoney) : that.mcostmoney != null) return false;
        if (iuserpoint != null ? !iuserpoint.equals(that.iuserpoint) : that.iuserpoint != null) return false;
        if (irolelevel != null ? !irolelevel.equals(that.irolelevel) : that.irolelevel != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = uid != null ? uid.hashCode() : 0;
        result = 31 * result + (susername != null ? susername.hashCode() : 0);
        result = 31 * result + (spassword != null ? spassword.hashCode() : 0);
        result = 31 * result + (stel != null ? stel.hashCode() : 0);
        result = 31 * result + (dcreatdate != null ? dcreatdate.hashCode() : 0);
        result = 31 * result + (dlastdate != null ? dlastdate.hashCode() : 0);
        result = 31 * result + (mcostmoney != null ? mcostmoney.hashCode() : 0);
        result = 31 * result + (iuserpoint != null ? iuserpoint.hashCode() : 0);
        result = 31 * result + (irolelevel != null ? irolelevel.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "userByUid")
    public Collection<TbaddressEntity> getAddressById() {
        return addressById;
    }

    public void setAddressById(Collection<TbaddressEntity> addressById) {
        this.addressById = addressById;
    }

    @OneToMany(mappedBy = "usersByUid")
    public Collection<TbsaleEntity> getSaleById() {
        return saleById;
    }

    public void setSaleById(Collection<TbsaleEntity> saleById) {this.saleById = saleById;}
}
