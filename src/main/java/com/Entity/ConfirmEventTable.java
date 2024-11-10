/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author IT CARE
 */
@Entity
@Table(name = "confirm_event_table")
@NamedQueries({
    @NamedQuery(name = "ConfirmEventTable.findAll", query = "SELECT c FROM ConfirmEventTable c"),
    @NamedQuery(name = "ConfirmEventTable.findByOrderId", query = "SELECT c FROM ConfirmEventTable c WHERE c.orderId = :orderId"),
    @NamedQuery(name = "ConfirmEventTable.findByCost", query = "SELECT c FROM ConfirmEventTable c WHERE c.cost = :cost"),
    @NamedQuery(name = "ConfirmEventTable.findByPaymentStatus", query = "SELECT c FROM ConfirmEventTable c WHERE c.paymentStatus = :paymentStatus")})
public class ConfirmEventTable implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "order_id")
    private Integer orderId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "cost")
    private String cost;
    @Basic(optional = false)
    @NotNull
    @Column(name = "payment_status")
    private boolean paymentStatus;
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    @ManyToOne(optional = false)
    private UserTable userId;
    @JoinColumn(name = "venue_id", referencedColumnName = "venue_id")
    @ManyToOne(optional = false)
    private VenueDetails venueId;
    @JoinColumn(name = "event_id", referencedColumnName = "event_id")
    @ManyToOne(optional = false)
    private EventDetails eventId;
    @JoinColumn(name = "cat_id", referencedColumnName = "cat_id")
    @ManyToOne(optional = false)
    private EventCategory catId;

    public ConfirmEventTable() {
    }

    public ConfirmEventTable(Integer orderId) {
        this.orderId = orderId;
    }

    public ConfirmEventTable(Integer orderId, String cost, boolean paymentStatus) {
        this.orderId = orderId;
        this.cost = cost;
        this.paymentStatus = paymentStatus;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public boolean getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(boolean paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public UserTable getUserId() {
        return userId;
    }

    public void setUserId(UserTable userId) {
        this.userId = userId;
    }

    public VenueDetails getVenueId() {
        return venueId;
    }

    public void setVenueId(VenueDetails venueId) {
        this.venueId = venueId;
    }

    public EventDetails getEventId() {
        return eventId;
    }

    public void setEventId(EventDetails eventId) {
        this.eventId = eventId;
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
        hash += (orderId != null ? orderId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ConfirmEventTable)) {
            return false;
        }
        ConfirmEventTable other = (ConfirmEventTable) object;
        if ((this.orderId == null && other.orderId != null) || (this.orderId != null && !this.orderId.equals(other.orderId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.Entity.ConfirmEventTable[ orderId=" + orderId + " ]";
    }
    
}
