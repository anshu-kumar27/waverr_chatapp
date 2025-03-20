package com.app.model;

import java.time.LocalDateTime;

import com.app.model.enums.MessageStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "messages",schema = "public")
public class Messages {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "message_id")
	private Long messageID;
	
	@Column(name = "message_content")
	private String messageContent;
	
	@Column(name = "image_message")
	private byte[] imageMessage;
	
	@ManyToOne
	@JoinColumn(name = "sender_id",referencedColumnName = "user_id")
	private User senderID;
	
	@ManyToOne
	@JoinColumn(name = "receiver_id",referencedColumnName = "user_id")
	private User receiverID;
	
	@Column(name = "message_time")
	private LocalDateTime messageTime;
	
	@Column(name = "read_at")
	private LocalDateTime readAtTime;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "message_status")
	private MessageStatus messageStatus;
}

