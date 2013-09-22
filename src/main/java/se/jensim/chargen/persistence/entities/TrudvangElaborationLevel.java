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
import javax.persistence.Id;
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
@Table(name = "trudvang_elaboration_level", catalog = "rollspel", schema = "public", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"name"})})
@NamedQueries({
    @NamedQuery(name = "TrudvangElaborationLevel.findAll", query = "SELECT t FROM TrudvangElaborationLevel t")})
public class TrudvangElaborationLevel implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "name", nullable = false, length = 50)
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "description", nullable = false, length = 2147483647)
    private String description;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cost", nullable = false)
    private int cost;
    @Basic(optional = false)
    @NotNull
    @Column(name = "required_skill_level", nullable = false)
    private int requiredSkillLevel;
    @Column(name = "vitner_mod")
    private Integer vitnerMod;
    @Column(name = "vitner_cost")
    private Integer vitnerCost;
    @Column(name = "vitner_fail_cost")
    private Integer vitnerFailCost;
    @Size(max = 2147483647)
    @Column(name = "vitner_learn_time", length = 2147483647)
    private String vitnerLearnTime;
    @Basic(optional = false)
    @NotNull
    @Column(name = "religion_segment", nullable = false)
    private int religionSegment;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "levelId")
    private List<TrudvangElaboration> trudvangElaborationList;

    public TrudvangElaborationLevel() {
    }

    public TrudvangElaborationLevel(Integer id) {
        this.id = id;
    }

    public TrudvangElaborationLevel(Integer id, String name, String description, int cost, int requiredSkillLevel, int religionSegment) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.cost = cost;
        this.requiredSkillLevel = requiredSkillLevel;
        this.religionSegment = religionSegment;
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

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getRequiredSkillLevel() {
        return requiredSkillLevel;
    }

    public void setRequiredSkillLevel(int requiredSkillLevel) {
        this.requiredSkillLevel = requiredSkillLevel;
    }

    public Integer getVitnerMod() {
        return vitnerMod;
    }

    public void setVitnerMod(Integer vitnerMod) {
        this.vitnerMod = vitnerMod;
    }

    public Integer getVitnerCost() {
        return vitnerCost;
    }

    public void setVitnerCost(Integer vitnerCost) {
        this.vitnerCost = vitnerCost;
    }

    public Integer getVitnerFailCost() {
        return vitnerFailCost;
    }

    public void setVitnerFailCost(Integer vitnerFailCost) {
        this.vitnerFailCost = vitnerFailCost;
    }

    public String getVitnerLearnTime() {
        return vitnerLearnTime;
    }

    public void setVitnerLearnTime(String vitnerLearnTime) {
        this.vitnerLearnTime = vitnerLearnTime;
    }

    public int getReligionSegment() {
        return religionSegment;
    }

    public void setReligionSegment(int religionSegment) {
        this.religionSegment = religionSegment;
    }

    public List<TrudvangElaboration> getTrudvangElaborationList() {
        return trudvangElaborationList;
    }

    public void setTrudvangElaborationList(List<TrudvangElaboration> trudvangElaborationList) {
        this.trudvangElaborationList = trudvangElaborationList;
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
        if (!(object instanceof TrudvangElaborationLevel)) {
            return false;
        }
        TrudvangElaborationLevel other = (TrudvangElaborationLevel) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "se.jensim.chargen.persistence.entities.TrudvangElaborationLevel[ id=" + id + " ]";
    }
    
}
