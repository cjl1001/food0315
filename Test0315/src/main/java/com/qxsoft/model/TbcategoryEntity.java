package com.qxsoft.model;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by jz128 on 2016/3/16.
 */
@Entity
@Table(name = "tbcategory", schema = "public", catalog = "db_food")
public class TbcategoryEntity {
    private Integer cid;
    private String scatename;
    private Integer parentid;
    private Set<TbmenusummaryEntity> tbmenusummaryEntitySetByCid;

    @Id
    @Column(name = "cid", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    @Basic
    @Column(name = "scatename", nullable = true, length = 20)
    public String getScatename() {
        return scatename;
    }

    public void setScatename(String scatename) {
        this.scatename = scatename;
    }

    @Basic
    @Column(name = "parentid", nullable = true)
    public Integer getParentid() {
        return parentid;
    }

    public void setParentid(Integer parentid) {
        this.parentid = parentid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TbcategoryEntity that = (TbcategoryEntity) o;

        if (cid != null ? !cid.equals(that.cid) : that.cid != null) return false;
        if (scatename != null ? !scatename.equals(that.scatename) : that.scatename != null) return false;
        if (parentid != null ? !parentid.equals(that.parentid) : that.parentid != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = cid != null ? cid.hashCode() : 0;
        result = 31 * result + (scatename != null ? scatename.hashCode() : 0);
        result = 31 * result + (parentid != null ? parentid.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "tbcategoryEntityByCid")
    public Set<TbmenusummaryEntity> getTbmenusummaryEntitySetByCid() {
        return tbmenusummaryEntitySetByCid;
    }

    public void setTbmenusummaryEntitySetByCid(Set<TbmenusummaryEntity> tbmenusummaryEntitySetByCid) {
        this.tbmenusummaryEntitySetByCid = tbmenusummaryEntitySetByCid;
    }
}
