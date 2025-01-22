package com.motel.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "room_availability")
public class RoomAvailabilityEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer availabilityId;
	private Integer roomId;
	private String date;
	private Boolean isAvailable;
	private String createdAt;
	public Integer getAvailabilityId() {
		return availabilityId;
	}
	public void setAvailabilityId(Integer availabilityId) {
		this.availabilityId = availabilityId;
	}
	public Integer getRoomId() {
		return roomId;
	}
	public void setRoomId(Integer roomId) {
		this.roomId = roomId;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Boolean getIsAvailable() {
		return isAvailable;
	}
	public void setIsAvailable(Boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	public String getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}
	
	
}
