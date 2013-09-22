/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package se.jensim.chargen.persistence.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "oauth_provider", catalog = "rollspel", schema = "public", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"name"})})
@NamedQueries({
    @NamedQuery(name = "OauthProvider.findAll", query = "SELECT o FROM OauthProvider o")})
public class OauthProvider implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "name", nullable = false, length = 255)
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "client_id", nullable = false, length = 255)
    private String clientId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "client_secret", nullable = false, length = 255)
    private String clientSecret;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "authorize_url", nullable = false, length = 255)
    private String authorizeUrl;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "access_token_url", nullable = false, length = 255)
    private String accessTokenUrl;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "user_url", nullable = false, length = 255)
    private String userUrl;
    @Size(max = 255)
    @Column(name = "logout_url", length = 255)
    private String logoutUrl;
    @Size(max = 255)
    @Column(name = "login_icon_url", length = 255)
    private String loginIconUrl;
    @Basic(optional = false)
    @NotNull
    @Column(name = "active", nullable = false)
    private boolean active;
    @OneToMany(mappedBy = "oauthProviderId")
	private List<RollspelUser> rollspelUserList;
	public static final String ID = "id",
			NAME = "name",
			CLIENT_ID = "clientId",
			CLIENT_SECRET = "clientSecret",
			AUTHORIZE_URl = "authorizeUrl",
			ACCESS_TOKEN_URL = "accessTokenUrl",
			USER_URL = "userUrl",
			LOGOUT_URL = "logoutUrl",
			ACTIVE = "active",
			USERS = "rollspelUserList";

    public OauthProvider() {
    }

    public OauthProvider(Integer id) {
        this.id = id;
    }

    public OauthProvider(Integer id, String name, String clientId, String clientSecret, String authorizeUrl, String accessTokenUrl, String userUrl, boolean active) {
        this.id = id;
        this.name = name;
        this.clientId = clientId;
        this.clientSecret = clientSecret;
        this.authorizeUrl = authorizeUrl;
        this.accessTokenUrl = accessTokenUrl;
        this.userUrl = userUrl;
        this.active = active;
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

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    public String getAuthorizeUrl() {
        return authorizeUrl;
    }

    public void setAuthorizeUrl(String authorizeUrl) {
        this.authorizeUrl = authorizeUrl;
    }

    public String getAccessTokenUrl() {
        return accessTokenUrl;
    }

    public void setAccessTokenUrl(String accessTokenUrl) {
        this.accessTokenUrl = accessTokenUrl;
    }

    public String getUserUrl() {
        return userUrl;
    }

    public void setUserUrl(String userUrl) {
        this.userUrl = userUrl;
    }

    public String getLogoutUrl() {
        return logoutUrl;
    }

    public void setLogoutUrl(String logoutUrl) {
        this.logoutUrl = logoutUrl;
    }

    public String getLoginIconUrl() {
        return loginIconUrl;
    }

    public void setLoginIconUrl(String loginIconUrl) {
        this.loginIconUrl = loginIconUrl;
    }

    public boolean getActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public List<RollspelUser> getRollspelUserList() {
        return rollspelUserList;
    }

    public void setRollspelUserList(List<RollspelUser> rollspelUserList) {
        this.rollspelUserList = rollspelUserList;
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
        if (!(object instanceof OauthProvider)) {
            return false;
        }
        OauthProvider other = (OauthProvider) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "se.jensim.chargen.persistence.entities.OauthProvider[ id=" + id + " ]";
    }
    
}
