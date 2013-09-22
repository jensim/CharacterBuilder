/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package se.jensim.chargen.persistence.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author jens
 */
@Entity
@Table(name = "trudvang_elaboration", catalog = "rollspel", schema = "public", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"name", "skill_id", "level_id"})})
@NamedQueries({
    @NamedQuery(name = "TrudvangElaboration.findAll", query = "SELECT t FROM TrudvangElaboration t")})
public class TrudvangElaboration implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "name", nullable = false, length = 100)
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "description", nullable = false, length = 2147483647)
    private String description;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "elaborationId")
    private List<TrudvangPower> trudvangPowerList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "requiredId")
    private List<TrudvangElaborationRequire> trudvangElaborationRequireList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "elaborationId")
    private List<TrudvangElaborationRequire> trudvangElaborationRequireList1;
    @OneToMany(mappedBy = "elaborationId")
    private List<TrudvangMod> trudvangModList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "elaborationId")
    private List<TrudvangElaborationFree> trudvangElaborationFreeList;
    @JoinColumn(name = "skill_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private TrudvangSkill skillId;
    @JoinColumn(name = "religion_id", referencedColumnName = "id")
    @ManyToOne
    private TrudvangReligion religionId;
    @JoinColumn(name = "level_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private TrudvangElaborationLevel levelId;
    @JoinColumn(name = "book_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private TrudvangBook bookId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "elaborationId")
    private List<TrudvangVitner> trudvangVitnerList;

    public TrudvangElaboration() {
    }

    public TrudvangElaboration(Integer id) {
        this.id = id;
    }

    public TrudvangElaboration(Integer id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<TrudvangPower> getTrudvangPowerList() {
        return trudvangPowerList;
    }

    public void setTrudvangPowerList(List<TrudvangPower> trudvangPowerList) {
        this.trudvangPowerList = trudvangPowerList;
    }

    public List<TrudvangElaborationRequire> getTrudvangElaborationRequireList() {
        return trudvangElaborationRequireList;
    }

    public void setTrudvangElaborationRequireList(List<TrudvangElaborationRequire> trudvangElaborationRequireList) {
        this.trudvangElaborationRequireList = trudvangElaborationRequireList;
    }

    public List<TrudvangElaborationRequire> getTrudvangElaborationRequireList1() {
        return trudvangElaborationRequireList1;
    }

    public void setTrudvangElaborationRequireList1(List<TrudvangElaborationRequire> trudvangElaborationRequireList1) {
        this.trudvangElaborationRequireList1 = trudvangElaborationRequireList1;
    }

    public List<TrudvangMod> getTrudvangModList() {
        return trudvangModList;
    }

    public void setTrudvangModList(List<TrudvangMod> trudvangModList) {
        this.trudvangModList = trudvangModList;
    }

    public List<TrudvangElaborationFree> getTrudvangElaborationFreeList() {
        return trudvangElaborationFreeList;
    }

    public void setTrudvangElaborationFreeList(List<TrudvangElaborationFree> trudvangElaborationFreeList) {
        this.trudvangElaborationFreeList = trudvangElaborationFreeList;
    }

    public TrudvangSkill getSkillId() {
        return skillId;
    }

    public void setSkillId(TrudvangSkill skillId) {
        this.skillId = skillId;
    }

    public TrudvangReligion getReligionId() {
        return religionId;
    }

    public void setReligionId(TrudvangReligion religionId) {
        this.religionId = religionId;
    }

    public TrudvangElaborationLevel getLevelId() {
        return levelId;
    }

    public void setLevelId(TrudvangElaborationLevel levelId) {
        this.levelId = levelId;
    }

    public TrudvangBook getBookId() {
        return bookId;
    }

    public void setBookId(TrudvangBook bookId) {
        this.bookId = bookId;
    }

    public List<TrudvangVitner> getTrudvangVitnerList() {
        return trudvangVitnerList;
    }

    public void setTrudvangVitnerList(List<TrudvangVitner> trudvangVitnerList) {
        this.trudvangVitnerList = trudvangVitnerList;
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
        if (!(object instanceof TrudvangElaboration)) {
            return false;
        }
        TrudvangElaboration other = (TrudvangElaboration) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "se.jensim.chargen.persistence.entities.TrudvangElaboration[ id=" + id + " ]";
    }
    
}
