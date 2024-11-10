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
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
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
@Table(name = "user_table")
@NamedQueries({
    @NamedQuery(name = "UserTable.findAll", query = "SELECT u FROM UserTable u"),
    @NamedQuery(name = "UserTable.findByUserId", query = "SELECT u FROM UserTable u WHERE u.userId = :userId"),
    @NamedQuery(name = "UserTable.findByName", query = "SELECT u FROM UserTable u WHERE u.name = :name"),
    @NamedQuery(name = "UserTable.findByEmail", query = "SELECT u FROM UserTable u WHERE u.email = :email"),
    @NamedQuery(name = "UserTable.findByContactNo", query = "SELECT u FROM UserTable u WHERE u.contactNo = :contactNo"),
    @NamedQuery(name = "UserTable.findByPassword", query = "SELECT u FROM UserTable u WHERE u.password = :password")})
public class UserTable implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "user_id")
    private Integer userId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "name")
    private String name;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "contact_no")
    private String contactNo;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "address")
    private String address;
    @Basic(optional = false)
    @NotNull
    @Column(name = "password")
    private int password;
    @JoinColumn(name = "role_id", referencedColumnName = "role_id")
    @ManyToOne(optional = false)
    private RoleMaster roleId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private Collection<ConfirmEventTable> confirmEventTableCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private Collection<ReviewDetails> reviewDetailsCollection;

    public UserTable() {
    }

    public UserTable(Integer userId) {
        this.userId = userId;
    }

    public UserTable(Integer userId, String name, String email, String contactNo, String address, int password) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.contactNo = contactNo;
        this.address = address;
        this.password = password;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public RoleMaster getRoleId() {
        return roleId;
    }

    public void setRoleId(RoleMaster roleId) {
        this.roleId = roleId;
    }

    public Collection<ConfirmEventTable> getConfirmEventTableCollection() {
        return confirmEventTableCollection;
    }

    public void setConfirmEventTableCollection(Collection<ConfirmEventTable> confirmEventTableCollection) {
        this.confirmEventTableCollection = confirmEventTableCollection;
    }

    public Collection<ReviewDetails> getReviewDetailsCollection() {
        return reviewDetailsCollection;
    }

    public void setReviewDetailsCollection(Collection<ReviewDetails> reviewDetailsCollection) {
        this.reviewDetailsCollection = reviewDetailsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userId != null ? userId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserTable)) {
            return false;
        }
        UserTable other = (UserTable) object;
        if ((this.userId == null && other.userId != null) || (this.userId != null && !this.userId.equals(other.userId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.Entity.UserTable[ userId=" + userId + " ]";
    }
    
}
