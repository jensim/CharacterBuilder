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
@Table(name = "mutant_character", catalog = "rollspel", schema = "public", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"user_id", "name"})})
@NamedQueries({
    @NamedQuery(name = "MutantCharacter.findAll", query = "SELECT m FROM MutantCharacter m")})
public class MutantCharacter implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "name", nullable = false, length = 50)
    private String name;
    @Column(name = "initiativbonus")
    private Integer initiativbonus;
    @Size(max = 50)
    @Column(name = "prior_occupation", length = 50)
    private String priorOccupation;
    @Size(max = 50)
    @Column(name = "home", length = 50)
    private String home;
    @Column(name = "age")
    private Integer age;
    @Size(max = 50)
    @Column(name = "sex", length = 50)
    private String sex;
    @Column(name = "length")
    private Integer length;
    @Column(name = "weight")
    private Integer weight;
    @Size(max = 2147483647)
    @Column(name = "looks", length = 2147483647)
    private String looks;
    @Column(name = "money")
    private Integer money;
    @Column(name = "rumor_points")
    private Integer rumorPoints;
    @Column(name = "ff_strid")
    private Integer ffStrid;
    @Column(name = "ff_springa")
    private Integer ffSpringa;
    @Column(name = "ff_sprint")
    private Integer ffSprint;
    @Column(name = "health_points")
    private Integer healthPoints;
    @Column(name = "trauma_points")
    private Integer traumaPoints;
    @Size(max = 2147483647)
    @Column(name = "other_text", length = 2147483647)
    private String otherText;
    @Basic(optional = false)
    @NotNull
    @Column(name = "creation_points", nullable = false)
    private int creationPoints;
    @Column(name = "status_points")
    private Integer statusPoints;
    @Size(max = 25)
    @Column(name = "damage_bonus", length = 25)
    private String damageBonus;
    @Column(name = "carry_cap")
    private Integer carryCap;
    @Column(name = "reaktion_value")
    private Integer reaktionValue;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "characterId")
    private List<MutantArmorCharacter> mutantArmorCharacterList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "characterId")
    private List<MutantWeaponCharacter> mutantWeaponCharacterList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "characterId")
    private List<MutantSkillCharacter> mutantSkillCharacterList;
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private RollspelUser userId;
    @JoinColumn(name = "class_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private MutantClass classId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "characterId")
    private List<MutantAbilityCharacter> mutantAbilityCharacterList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "characterId")
    private List<MutantBaseStatCharacter> mutantBaseStatCharacterList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "characterId")
    private List<MutantItemCharacter> mutantItemCharacterList;

    public MutantCharacter() {
    }

    public MutantCharacter(Integer id) {
        this.id = id;
    }

    public MutantCharacter(Integer id, String name, int creationPoints) {
        this.id = id;
        this.name = name;
        this.creationPoints = creationPoints;
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

    public Integer getInitiativbonus() {
        return initiativbonus;
    }

    public void setInitiativbonus(Integer initiativbonus) {
        this.initiativbonus = initiativbonus;
    }

    public String getPriorOccupation() {
        return priorOccupation;
    }

    public void setPriorOccupation(String priorOccupation) {
        this.priorOccupation = priorOccupation;
    }

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getLooks() {
        return looks;
    }

    public void setLooks(String looks) {
        this.looks = looks;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public Integer getRumorPoints() {
        return rumorPoints;
    }

    public void setRumorPoints(Integer rumorPoints) {
        this.rumorPoints = rumorPoints;
    }

    public Integer getFfStrid() {
        return ffStrid;
    }

    public void setFfStrid(Integer ffStrid) {
        this.ffStrid = ffStrid;
    }

    public Integer getFfSpringa() {
        return ffSpringa;
    }

    public void setFfSpringa(Integer ffSpringa) {
        this.ffSpringa = ffSpringa;
    }

    public Integer getFfSprint() {
        return ffSprint;
    }

    public void setFfSprint(Integer ffSprint) {
        this.ffSprint = ffSprint;
    }

    public Integer getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(Integer healthPoints) {
        this.healthPoints = healthPoints;
    }

    public Integer getTraumaPoints() {
        return traumaPoints;
    }

    public void setTraumaPoints(Integer traumaPoints) {
        this.traumaPoints = traumaPoints;
    }

    public String getOtherText() {
        return otherText;
    }

    public void setOtherText(String otherText) {
        this.otherText = otherText;
    }

    public int getCreationPoints() {
        return creationPoints;
    }

    public void setCreationPoints(int creationPoints) {
        this.creationPoints = creationPoints;
    }

    public Integer getStatusPoints() {
        return statusPoints;
    }

    public void setStatusPoints(Integer statusPoints) {
        this.statusPoints = statusPoints;
    }

    public String getDamageBonus() {
        return damageBonus;
    }

    public void setDamageBonus(String damageBonus) {
        this.damageBonus = damageBonus;
    }

    public Integer getCarryCap() {
        return carryCap;
    }

    public void setCarryCap(Integer carryCap) {
        this.carryCap = carryCap;
    }

    public Integer getReaktionValue() {
        return reaktionValue;
    }

    public void setReaktionValue(Integer reaktionValue) {
        this.reaktionValue = reaktionValue;
    }

    public List<MutantArmorCharacter> getMutantArmorCharacterList() {
        return mutantArmorCharacterList;
    }

    public void setMutantArmorCharacterList(List<MutantArmorCharacter> mutantArmorCharacterList) {
        this.mutantArmorCharacterList = mutantArmorCharacterList;
    }

    public List<MutantWeaponCharacter> getMutantWeaponCharacterList() {
        return mutantWeaponCharacterList;
    }

    public void setMutantWeaponCharacterList(List<MutantWeaponCharacter> mutantWeaponCharacterList) {
        this.mutantWeaponCharacterList = mutantWeaponCharacterList;
    }

    public List<MutantSkillCharacter> getMutantSkillCharacterList() {
        return mutantSkillCharacterList;
    }

    public void setMutantSkillCharacterList(List<MutantSkillCharacter> mutantSkillCharacterList) {
        this.mutantSkillCharacterList = mutantSkillCharacterList;
    }

    public RollspelUser getUserId() {
        return userId;
    }

    public void setUserId(RollspelUser userId) {
        this.userId = userId;
    }

    public MutantClass getClassId() {
        return classId;
    }

    public void setClassId(MutantClass classId) {
        this.classId = classId;
    }

    public List<MutantAbilityCharacter> getMutantAbilityCharacterList() {
        return mutantAbilityCharacterList;
    }

    public void setMutantAbilityCharacterList(List<MutantAbilityCharacter> mutantAbilityCharacterList) {
        this.mutantAbilityCharacterList = mutantAbilityCharacterList;
    }

    public List<MutantBaseStatCharacter> getMutantBaseStatCharacterList() {
        return mutantBaseStatCharacterList;
    }

    public void setMutantBaseStatCharacterList(List<MutantBaseStatCharacter> mutantBaseStatCharacterList) {
        this.mutantBaseStatCharacterList = mutantBaseStatCharacterList;
    }

    public List<MutantItemCharacter> getMutantItemCharacterList() {
        return mutantItemCharacterList;
    }

    public void setMutantItemCharacterList(List<MutantItemCharacter> mutantItemCharacterList) {
        this.mutantItemCharacterList = mutantItemCharacterList;
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
        if (!(object instanceof MutantCharacter)) {
            return false;
        }
        MutantCharacter other = (MutantCharacter) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "se.jensim.chargen.persistence.entities.MutantCharacter[ id=" + id + " ]";
    }
    
}
