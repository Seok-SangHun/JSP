package com.app.jdbc.post.vo;

import java.util.Objects;

public class PostVO {
	private Long id;
	private String postTitle;
	private int postLiked;
	
	public PostVO() {;}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPostTitle() {
		return postTitle;
	}
	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}
	public int getPostLiked() {
		return postLiked;
	}
	public void setPostLiked(int postLiked) {
		this.postLiked = postLiked;
	}

	@Override
	public String toString() {
		return "PostVO [id=" + id + ", postTitle=" + postTitle + ", postLiked=" + postLiked + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PostVO other = (PostVO) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
}
