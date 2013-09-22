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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author jens
 */
@Entity
@Table(name = "trudvang_character", catalog = "rollspel", schema = "public")
@NamedQueries({
    @NamedQuery(name = "TrudvangCharacter.findAll", query = "SELECT t FROM TrudvangCharacter t")})
public class TrudvangCharacter implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "name", nullable = false, length = 250)
    private String name;
    @Size(max = 2147483647)
    @Column(name = "notes", length = 2147483647)
    private String notes;
    @Size(max = 50)
    @Column(name = "hometown", length = 50)
    private String hometown;
    @Size(max = 50)
    @Column(name = "homeland", length = 50)
    private String homeland;
    @Size(max = 50)
    @Column(name = "race", length = 50)
    private String race;
    @Size(max = 50)
    @Column(name = "people", length = 50)
    private String people;
    @Size(max = 50)
    @Column(name = "religion", length = 50)
    private String religion;
    @Size(max = 50)
    @Column(name = "upbringing", length = 50)
    private String upbringing;
    @Size(max = 50)
    @Column(name = "arketype", length = 50)
    private String arketype;
    @Size(max = 50)
    @Column(name = "weaponhand", length = 50)
    private String weaponhand;
    @Size(max = 50)
    @Column(name = "sex", length = 50)
    private String sex;
    @Basic(optional = false)
    @NotNull
    @Column(name = "age", nullable = false)
    private int age;
    @Basic(optional = false)
    @NotNull
    @Column(name = "weight", nullable = false)
    private int weight;
    @Basic(optional = false)
    @NotNull
    @Column(name = "length", nullable = false)
    private int length;
    @Basic(optional = false)
    @NotNull
    @Column(name = "movement", nullable = false)
    private int movement;
    @Basic(optional = false)
    @NotNull
    @Column(name = "experience", nullable = false)
    private int experience;
    @Size(max = 2147483647)
    @Column(name = "background_story", length = 2147483647)
    private String backgroundStory;
    @Basic(optional = false)
    @NotNull
    @Column(name = "health_total", nullable = false)
    private int healthTotal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "vitner_points_extra", nullable = false)
    private int vitnerPointsExtra;
    @Basic(optional = false)
    @NotNull
    @Column(name = "religion_points_extra", nullable = false)
    private int religionPointsExtra;
    @Basic(optional = false)
    @NotNull
    @Column(name = "health_atm", nullable = false)
    private int healthAtm;
    @Basic(optional = false)
    @NotNull
    @Column(name = "projectiles", nullable = false)
    private int projectiles;
    @Basic(optional = false)
    @NotNull
    @Column(name = "money_carried_hv", nullable = false)
    private int moneyCarriedHv;
    @Basic(optional = false)
    @NotNull
    @Column(name = "money_banked_hv", nullable = false)
    private int moneyBankedHv;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "characterId")
    private List<TrudvangSkillCharacter> trudvangSkillCharacterList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "characterId")
    private List<TrudvangExceptionalCharacter> trudvangExceptionalCharacterList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "characterId")
    private List<TrudvangWeaponProjectileCharacter> trudvangWeaponProjectileCharacterList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "characterId")
    private List<TrudvangWeaponMeleeCharacter> trudvangWeaponMeleeCharacterList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "characterId")
    private List<TrudvangItemCharacter> trudvangItemCharacterList;
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private RollspelUser userId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "characterId")
    private List<TrudvangElaborationCharacter> trudvangElaborationCharacterList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "characterId")
    private List<TrudvangArmorCharacter> trudvangArmorCharacterList;

    public TrudvangCharacter() {
    }

    public TrudvangCharacter(Integer id) {
        this.id = id;
    }

    public TrudvangCharacter(Integer id, String name, int age, int weight, int length, int movement, int experience, int healthTotal, int vitnerPointsExtra, int religionPointsExtra, int healthAtm, int projectiles, int moneyCarriedHv, int moneyBankedHv) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.length = length;
        this.movement = movement;
        this.experience = experience;
        this.healthTotal = healthTotal;
        this.vitnerPointsExtra = vitnerPointsExtra;
        this.religionPointsExtra = religionPointsExtra;
        this.healthAtm = healthAtm;
        this.projectiles = projectiles;
        this.moneyCarriedHv = moneyCarriedHv;
        this.moneyBankedHv = moneyBankedHv;
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

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getHometown() {
        return hometown;
    }

    public void setHometown(String hometown) {
        this.hometown = hometown;
    }

    public String getHomeland() {
        return homeland;
    }

    public void setHomeland(String homeland) {
        this.homeland = homeland;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getPeople() {
        return people;
    }

    public void setPeople(String people) {
        this.people = people;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public String getUpbringing() {
        return upbringing;
    }

    public void setUpbringing(String upbringing) {
        this.upbringing = upbringing;
    }

    public String getArketype() {
        return arketype;
    }

    public void setArketype(String arketype) {
        this.arketype = arketype;
    }

    public String getWeaponhand() {
        return weaponhand;
    }

    public void setWeaponhand(String weaponhand) {
        this.weaponhand = weaponhand;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getMovement() {
        return movement;
    }

    public void setMovement(int movement) {
        this.movement = movement;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public String getBackgroundStory() {
        return backgroundStory;
    }

    public void setBackgroundStory(String backgroundStory) {
        this.backgroundStory = backgroundStory;
    }

    public int getHealthTotal() {
        return healthTotal;
    }

    public void setHealthTotal(int healthTotal) {
        this.healthTotal = healthTotal;
    }

    public int getVitnerPointsExtra() {
        return vitnerPointsExtra;
    }

    public void setVitnerPointsExtra(int vitnerPointsExtra) {
        this.vitnerPointsExtra = vitnerPointsExtra;
    }

    public int getReligionPointsExtra() {
        return religionPointsExtra;
    }

    public void setReligionPointsExtra(int religionPointsExtra) {
        this.religionPointsExtra = religionPointsExtra;
    }

    public int getHealthAtm() {
        return healthAtm;
    }

    public void setHealthAtm(int healthAtm) {
        this.healthAtm = healthAtm;
    }

    public int getProjectiles() {
        return projectiles;
    }

    public void setProjectiles(int projectiles) {
        this.projectiles = projectiles;
    }

    public int getMoneyCarriedHv() {
        return moneyCarriedHv;
    }

    public void setMoneyCarriedHv(int moneyCarriedHv) {
        this.moneyCarriedHv = moneyCarriedHv;
    }

    public int getMoneyBankedHv() {
        return moneyBankedHv;
    }

    public void setMoneyBankedHv(int moneyBankedHv) {
        this.moneyBankedHv = moneyBankedHv;
    }

    public List<TrudvangSkillCharacter> getTrudvangSkillCharacterList() {
        return trudvangSkillCharacterList;
    }

    public void setTrudvangSkillCharacterList(List<TrudvangSkillCharacter> trudvangSkillCharacterList) {
        this.trudvangSkillCharacterList = trudvangSkillCharacterList;
    }

    public List<TrudvangExceptionalCharacter> getTrudvangExceptionalCharacterList() {
        return trudvangExceptionalCharacterList;
    }

    public void setTrudvangExceptionalCharacterList(List<TrudvangExceptionalCharacter> trudvangExceptionalCharacterList) {
        this.trudvangExceptionalCharacterList = trudvangExceptionalCharacterList;
    }

    public List<TrudvangWeaponProjectileCharacter> getTrudvangWeaponProjectileCharacterList() {
        return trudvangWeaponProjectileCharacterList;
    }

    public void setTrudvangWeaponProjectileCharacterList(List<TrudvangWeaponProjectileCharacter> trudvangWeaponProjectileCharacterList) {
        this.trudvangWeaponProjectileCharacterList = trudvangWeaponProjectileCharacterList;
    }

    public List<TrudvangWeaponMeleeCharacter> getTrudvangWeaponMeleeCharacterList() {
        return trudvangWeaponMeleeCharacterList;
    }

    public void setTrudvangWeaponMeleeCharacterList(List<TrudvangWeaponMeleeCharacter> trudvangWeaponMeleeCharacterList) {
        this.trudvangWeaponMeleeCharacterList = trudvangWeaponMeleeCharacterList;
    }

    public List<TrudvangItemCharacter> getTrudvangItemCharacterList() {
        return trudvangItemCharacterList;
    }

    public void setTrudvangItemCharacterList(List<TrudvangItemCharacter> trudvangItemCharacterList) {
        this.trudvangItemCharacterList = trudvangItemCharacterList;
    }

    public RollspelUser getUserId() {
        return userId;
    }

    public void setUserId(RollspelUser userId) {
        this.userId = userId;
    }

    public List<TrudvangElaborationCharacter> getTrudvangElaborationCharacterList() {
        return trudvangElaborationCharacterList;
    }

    public void setTrudvangElaborationCharacterList(List<TrudvangElaborationCharacter> trudvangElaborationCharacterList) {
        this.trudvangElaborationCharacterList = trudvangElaborationCharacterList;
    }

    public List<TrudvangArmorCharacter> getTrudvangArmorCharacterList() {
        return trudvangArmorCharacterList;
    }

    public void setTrudvangArmorCharacterList(List<TrudvangArmorCharacter> trudvangArmorCharacterList) {
        this.trudvangArmorCharacterList = trudvangArmorCharacterList;
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
        if (!(object instanceof TrudvangCharacter)) {
            return false;
        }
        TrudvangCharacter other = (TrudvangCharacter) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "se.jensim.chargen.persistence.entities.TrudvangCharacter[ id=" + id + " ]";
    }
    
}
