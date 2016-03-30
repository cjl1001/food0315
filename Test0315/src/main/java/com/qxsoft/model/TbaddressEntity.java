package com.qxsoft.model;

import javax.persistence.*;

/**
 * Created by zc-09-023 on 2016/3/18.
 */
@Entity
@Table(name = "tbaddress", schema = "public", catalog = "db_food")
public class TbaddressEntity {
    private Integer aid;
    private String address;
    private TbusersEntity userByUid;

    @Id
    @Column(name = "aid", nullable = false)
    @SequenceGenerator(name = "tbaddress_aid_seq",sequenceName ="tbaddress_aid_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tbaddress_aid_seq")
    /*@GeneratedValue(strategy = GenerationType.AUTO)*/
    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    @Basic
    @Column(name = "address", nullable = true, length = 50)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TbaddressEntity that = (TbaddressEntity) o;

        if (aid != null ? !aid.equals(that.aid) : that.aid != null) return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = aid != null ? aid.hashCode() : 0;
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
}
