package com.revature.dao;

import com.revature.entity.Post;

public interface PostDAO {
	
	public void addPost(Post post);
	public Post fetchPostbyId(int PostId);
	public void deletePostById(int PostId);
//	void updateBookById(int BookId, Float price);

}
