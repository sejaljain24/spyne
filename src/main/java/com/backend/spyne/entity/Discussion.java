package com.backend.spyne.entity;


import jakarta.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
@Entity
//@Getter
//@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "discussions")
public class Discussion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @NotEmpty(message = "Text is required")
    private String text;

    private String imageUrl;

    @ElementCollection
    private List<String> hashtags = new ArrayList<>();

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdOn = new Date();

    @OneToMany(mappedBy = "discussion", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comment> comments = new ArrayList<>();

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "discussion_likes",
            joinColumns = @JoinColumn(name = "discussion_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private Set<User> likes = new HashSet<>();

    private int viewCount = 0;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public List<String> getHashtags() {
		return hashtags;
	}

	public void setHashtags(List<String> hashtags) {
		this.hashtags = hashtags;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public Set<User> getLikes() {
		return likes;
	}

	public void setLikes(Set<User> likes) {
		this.likes = likes;
	}

	public int getViewCount() {
		return viewCount;
	}

	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}

	@Override
	public String toString() {
		return "Discussion [id=" + id + ", user=" + user + ", text=" + text + ", imageUrl=" + imageUrl + ", hashtags="
				+ hashtags + ", createdOn=" + createdOn + ", comments=" + comments + ", likes=" + likes + ", viewCount="
				+ viewCount + ", getId()=" + getId() + ", getUser()=" + getUser() + ", getText()=" + getText()
				+ ", getImageUrl()=" + getImageUrl() + ", getHashtags()=" + getHashtags() + ", getCreatedOn()="
				+ getCreatedOn() + ", getComments()=" + getComments() + ", getLikes()=" + getLikes()
				+ ", getViewCount()=" + getViewCount() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}

    // Getters and Setters
    
}
