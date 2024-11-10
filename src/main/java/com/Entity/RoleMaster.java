/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author IT CARE
 */
@Entity
@Table(name = "role_master")
@NamedQueries({
    @NamedQuery(name = "RoleMaster.findAll", query = "SELECT r FROM RoleMaster r"),
    @NamedQuery(name = "RoleMaster.findByRoleId", query = "SELECT r FROM RoleMaster r WHERE r.roleId = :roleId"),
    @NamedQuery(name = "RoleMaster.findByRoleName", query = "SELECT r FROM RoleMaster r WHERE r.roleName = :roleName")})
public class RoleMaster implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "role_id")
    private Integer roleId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "role_name")
    private String roleName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "roleId")
    private Collection<UserTable> userTableCollection;

    public RoleMaster() {
    }

    public RoleMaster(Integer roleId) {
        this.roleId = roleId;
    }

    public RoleMaster(Integer roleId, String roleName) {
        this.roleId = roleId;
        this.roleName = roleName;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Collection<UserTable> getUserTableCollection() {
        return userTableCollection;
    }

    public void setUserTableCollection(Collection<UserTable> userTableCollection) {
        this.userTableCollection = userTableCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (roleId != null ? roleId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RoleMaster)) {
            return false;
        }
        RoleMaster other = (RoleMaster) object;
        if ((this.roleId == null && other.roleId != null) || (this.roleId != null && !this.roleId.equals(other.roleId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.Entity.RoleMaster[ roleId=" + roleId + " ]";
    }
    
}
