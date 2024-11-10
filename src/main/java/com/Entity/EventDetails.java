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

/**
 *
 * @author IT CARE
 */
@Entity
@Table(name = "event_details")
@NamedQueries({
    @NamedQuery(name = "EventDetails.findAll", query = "SELECT e FROM EventDetails e"),
    @NamedQuery(name = "EventDetails.findByEventId", query = "SELECT e FROM EventDetails e WHERE e.eventId = :eventId"),
    @NamedQuery(name = "EventDetails.findByEventName", query = "SELECT e FROM EventDetails e WHERE e.eventName = :eventName"),
    @NamedQuery(name = "EventDetails.findByVenueId", query = "SELECT e FROM EventDetails e WHERE e.venueId = :venueId")})
public class EventDetails implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "event_id")
    private Integer eventId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "event_name")
    private int eventName;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Column(name = "photo")
    private byte[] photo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "venue_id")
    private int venueId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "eventId")
    private Collection<ConfirmEventTable> confirmEventTableCollection;
    @JoinColumn(name = "cat_id", referencedColumnName = "cat_id")
    @ManyToOne(optional = false)
    private EventCategory catId;

    public EventDetails() {
    }

    public EventDetails(Integer eventId) {
        this.eventId = eventId;
    }

    public EventDetails(Integer eventId, int eventName, byte[] photo, int venueId) {
        this.eventId = eventId;
        this.eventName = eventName;
        this.photo = photo;
        this.venueId = venueId;
    }

    public Integer getEventId() {
        return eventId;
    }

    public void setEventId(Integer eventId) {
        this.eventId = eventId;
    }

    public int getEventName() {
        return eventName;
    }

    public void setEventName(int eventName) {
        this.eventName = eventName;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public int getVenueId() {
        return venueId;
    }

    public void setVenueId(int venueId) {
        this.venueId = venueId;
    }

    public Collection<ConfirmEventTable> getConfirmEventTableCollection() {
        return confirmEventTableCollection;
    }

    public void setConfirmEventTableCollection(Collection<ConfirmEventTable> confirmEventTableCollection) {
        this.confirmEventTableCollection = confirmEventTableCollection;
    }

    public EventCategory getCatId() {
        return catId;
    }

    public void setCatId(EventCategory catId) {
        this.catId = catId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (eventId != null ? eventId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EventDetails)) {
            return false;
        }
        EventDetails other = (EventDetails) object;
        if ((this.eventId == null && other.eventId != null) || (this.eventId != null && !this.eventId.equals(other.eventId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.Entity.EventDetails[ eventId=" + eventId + " ]";
    }
    
}
