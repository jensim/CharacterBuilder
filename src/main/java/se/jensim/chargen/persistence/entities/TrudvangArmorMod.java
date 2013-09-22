/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package se.jensim.chargen.persistence.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author jens
 */
@Entity
@Table(name = "trudvang_armor_mod", catalog = "rollspel", schema = "public")
@NamedQueries({
    @NamedQuery(name = "TrudvangArmorMod.findAll", query = "SELECT t FROM TrudvangArmorMod t")})
public class TrudvangArmorMod implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "top_rv", nullable = false)
    private int topRv;
    @Basic(optional = false)
    @NotNull
    @Column(name = "bm", nullable = false)
    private int bm;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fm", nullable = false)
    private int fm;
    @Basic(optional = false)
    @NotNull
    @Column(name = "im", nullable = false)
    private int im;
    @Basic(optional = false)
    @NotNull
    @Column(name = "rm", nullable = false)
    private int rm;

    public TrudvangArmorMod() {
    }

    public TrudvangArmorMod(Integer id) {
        this.id = id;
    }

    public TrudvangArmorMod(Integer id, int topRv, int bm, int fm, int im, int rm) {
        this.id = id;
        this.topRv = topRv;
        this.bm = bm;
        this.fm = fm;
        this.im = im;
        this.rm = rm;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getTopRv() {
        return topRv;
    }

    public void setTopRv(int topRv) {
        this.topRv = topRv;
    }

    public int getBm() {
        return bm;
    }

    public void setBm(int bm) {
        this.bm = bm;
    }

    public int getFm() {
        return fm;
    }

    public void setFm(int fm) {
        this.fm = fm;
    }

    public int getIm() {
        return im;
    }

    public void setIm(int im) {
        this.im = im;
    }

    public int getRm() {
        return rm;
    }

    public void setRm(int rm) {
        this.rm = rm;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TrudvangArmorMod)) {
            return false;
        }
        TrudvangArmorMod other = (TrudvangArmorMod) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "se.jensim.chargen.persistence.entities.TrudvangArmorMod[ id=" + id + " ]";
    }
    
}
