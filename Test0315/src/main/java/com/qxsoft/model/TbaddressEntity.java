package com.qxsoft.model;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by jz128 on 2016/3/16.
 */
@Entity
@Table(name = "tbaddress", schema = "public", catalog = "db_food")
public class TbaddressEntity {
    private Integer aid;
    //private Integer uid;
    private String address;
    private Integer defaultStatus;
    private TbusersEntity userByUid;
    private Set<TborderEntity> tborderEntitySetByAid;

    @Id
    @Column(name = "aid", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    /*@Basic
    @Column(name = "uid", nullable = true)
    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }*/

    @Basic
    @Column(name = "address", nullable = true, length = 50)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "defaultStatus", nullable = true, length = 50)
    public Integer getDefaultStatus() {
        return defaultStatus;
    }

    public void setDefaultStatus(Integer defaultStatus) {
        this.defaultStatus = defaultStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TbaddressEntity that = (TbaddressEntity) o;

        if (aid != null ? !aid.equals(that.aid) : that.aid != null) return false;
        //if (uid != null ? !uid.equals(that.uid) : that.uid != null) return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = aid != null ? aid.hashCode() : 0;
        //result = 31 * result + (uid != null ? uid.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "uid", referencedColumnName = "uid")
    public TbusersEntity getUserByUid() {
        return userByUid;
    }

    public void setUserByUid(TbusersEntity userByUid) {
        this.userByUid = userByUid;
    }

    @OneToMany(mappedBy = "tbaddressEntityByAid")
    public Set<TborderEntity> getTborderEntitySetByAid() {
        return tborderEntitySetByAid;
    }

    public void setTborderEntitySetByAid(Set<TborderEntity> tborderEntitySetByAid) {
        this.tborderEntitySetByAid = tborderEntitySetByAid;
    }
}
