package se.jensim.chargen.persistence.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
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
import javax.persistence.QueryHint;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author jens
 */
@Entity
@Table(name = "rollspel_user", catalog = "rollspel", schema = "public")
@NamedQueries({
	@NamedQuery(name = "getId", hints = {
		@QueryHint(name = "uid", value = "user oauthID"),
		@QueryHint(name = "pid", value = "oauth provider name")},
			query = "SELECT u." + RollspelUser.ID
			+ " FROM RollspelUser u JOIN u." + RollspelUser.OAUTH_PROVIDER + " p WHERE u."
			+ RollspelUser.OAUTH_USER_ID + " = :uid AND p." + OauthProvider.NAME + " = :pid")})
public class RollspelUser implements Serializable {

	@Id
	@SequenceGenerator(name = "ID_GEN", allocationSize = 1, sequenceName = "rollspel_user_id_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_GEN")
	@Column(name = "id")
	private Integer id;
	@NotNull
	@Column(name = "last_active", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastActive = new Date();
	@Size(max = 255)
	@Column(name = "oauth_provider_user_id", length = 255)
	private String oauthProviderUserId;
	// @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
	@NotNull
	@Size(min = 1, max = 250)
	@Column(name = "email", nullable = false, length = 250, unique = true)
	private String email;
	@Size(max = 250)
	@Column(name = "password", length = 250)
	private String password;
	@Size(max = 250)
	@Column(name = "password_sso", length = 250)
	private String passwordSso;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "usrId")
	private List<RollspelGruppApplication> rollspelGruppApplicationList;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
	private List<SvavelvinterCharacter> svavelvinterCharacterList;
	@JoinColumn(name = "user_role_id", referencedColumnName = "id", nullable = false)
	@ManyToOne(optional = false)
	private RollspelUserRole userRoleId;
	@JoinColumn(name = "status_id", referencedColumnName = "id", nullable = false)
	@ManyToOne(optional = false)
	private RollspelStatus statusId;
	@JoinColumn(name = "oauth_provider_id", referencedColumnName = "id")
	@ManyToOne
	private OauthProvider oauthProviderId;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
	private List<RollspelUserRoleApplication> rollspelUserRoleApplicationList;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
	private List<TrudvangCharacter> trudvangCharacterList;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
	private List<MutantCharacter> mutantCharacterList;
	@OneToMany(mappedBy = "userId")
	private List<RollspelLog> rollspelLogList;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
	private List<RollspelGruppMember> rollspelGruppMemberList;
	public static final String ID = "id",
			LAST_ACTIVE = "lastActive",
			OAUTH_USER_ID = "oauthProviderUserId",
			EMAIL = "email",
			PASSWORD = "password",
			PASSWORD_SSO = "passwordSso",
			GROUP_APPPLICATIONS = "rollspelGruppApplicationList",
			USER_ROLE = "userRoleId",
			STATUS = "statusId",
			OAUTH_PROVIDER = "oauthProviderId",
			USER_ROLE_APPLICATIONS = "rollspelUserRoleApplicationList",
			TRUDVANG_CHARACTERS = "trudvangCharacterList",
			SVAVELVINTER_CHARACTERS = "svavelvinterCharacterList",
			MUTANT_CHARACTERS = "mutantCharacterList",
			LOG_RECORDS = "rollspelLogList",
			GROUP_MEMBERS = "rollspelGruppMemberList";

	public RollspelUser() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getLastActive() {
		return lastActive;
	}

	public void setLastActive(Date lastActive) {
		this.lastActive = lastActive;
	}

	public String getOauthProviderUserId() {
		return oauthProviderUserId;
	}

	public void setOauthProviderUserId(String oauthProviderUserId) {
		this.oauthProviderUserId = oauthProviderUserId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordSso() {
		return passwordSso;
	}

	public void setPasswordSso(String passwordSso) {
		this.passwordSso = passwordSso;
	}

	public List<RollspelGruppApplication> getRollspelGruppApplicationList() {
		return rollspelGruppApplicationList;
	}

	public void setRollspelGruppApplicationList(List<RollspelGruppApplication> rollspelGruppApplicationList) {
		this.rollspelGruppApplicationList = rollspelGruppApplicationList;
	}

	public List<SvavelvinterCharacter> getSvavelvinterCharacterList() {
		return svavelvinterCharacterList;
	}

	public void setSvavelvinterCharacterList(List<SvavelvinterCharacter> svavelvinterCharacterList) {
		this.svavelvinterCharacterList = svavelvinterCharacterList;
	}

	public RollspelUserRole getUserRoleId() {
		return userRoleId;
	}

	public void setUserRoleId(RollspelUserRole userRoleId) {
		this.userRoleId = userRoleId;
	}

	public RollspelStatus getStatusId() {
		return statusId;
	}

	public void setStatusId(RollspelStatus statusId) {
		this.statusId = statusId;
	}

	public OauthProvider getOauthProviderId() {
		return oauthProviderId;
	}

	public void setOauthProviderId(OauthProvider oauthProviderId) {
		this.oauthProviderId = oauthProviderId;
	}

	public List<RollspelUserRoleApplication> getRollspelUserRoleApplicationList() {
		return rollspelUserRoleApplicationList;
	}

	public void setRollspelUserRoleApplicationList(List<RollspelUserRoleApplication> rollspelUserRoleApplicationList) {
		this.rollspelUserRoleApplicationList = rollspelUserRoleApplicationList;
	}

	public List<TrudvangCharacter> getTrudvangCharacterList() {
		return trudvangCharacterList;
	}

	public void setTrudvangCharacterList(List<TrudvangCharacter> trudvangCharacterList) {
		this.trudvangCharacterList = trudvangCharacterList;
	}

	public List<MutantCharacter> getMutantCharacterList() {
		return mutantCharacterList;
	}

	public void setMutantCharacterList(List<MutantCharacter> mutantCharacterList) {
		this.mutantCharacterList = mutantCharacterList;
	}

	public List<RollspelLog> getRollspelLogList() {
		return rollspelLogList;
	}

	public void setRollspelLogList(List<RollspelLog> rollspelLogList) {
		this.rollspelLogList = rollspelLogList;
	}

	public List<RollspelGruppMember> getRollspelGruppMemberList() {
		return rollspelGruppMemberList;
	}

	public void setRollspelGruppMemberList(List<RollspelGruppMember> rollspelGruppMemberList) {
		this.rollspelGruppMemberList = rollspelGruppMemberList;
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
		if (!(object instanceof RollspelUser)) {
			return false;
		}
		RollspelUser other = (RollspelUser) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "se.jensim.chargen.persistence.entities.RollspelUser[ id=" + id + " ]";
	}
}
