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
@Table(name = "event_category")
@NamedQueries({
    @NamedQuery(name = "EventCategory.findAll", query = "SELECT e FROM EventCategory e"),
    @NamedQuery(name = "EventCategory.findByCatId", query = "SELECT e FROM EventCategory e WHERE e.catId = :catId"),
    @NamedQuery(name = "EventCategory.findByCatName", query = "SELECT e FROM EventCategory e WHERE e.catName = :catName")})
public class EventCategory implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cat_id")
    private Integer catId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "cat_name")
    private String catName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "catId")
    private Collection<ConfirmEventTable> confirmEventTableCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "catId")
    private Collection<EventDetails> eventDetailsCollection;

    public EventCategory() {
    }

    public EventCategory(Integer catId) {
        this.catId = catId;
    }

    public EventCategory(Integer catId, String catName) {
        this.catId = catId;
        this.catName = catName;
    }

    public Integer getCatId() {
        return catId;
    }

    public void setCatId(Integer catId) {
        this.catId = catId;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    public Collection<ConfirmEventTable> getConfirmEventTableCollection() {
        return confirmEventTableCollection;
    }

    public void setConfirmEventTableCollection(Collection<ConfirmEventTable> confirmEventTableCollection) {
        this.confirmEventTableCollection = confirmEventTableCollection;
    }

    public Collection<EventDetails> getEventDetailsCollection() {
        return eventDetailsCollection;
    }

    public void setEventDetailsCollection(Collection<EventDetails> eventDetailsCollection) {
        this.eventDetailsCollection = eventDetailsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (catId != null ? catId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EventCategory)) {
            return false;
        }
        EventCategory other = (EventCategory) object;
        if ((this.catId == null && other.catId != null) || (this.catId != null && !this.catId.equals(other.catId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.Entity.EventCategory[ catId=" + catId + " ]";
    }
    
}
