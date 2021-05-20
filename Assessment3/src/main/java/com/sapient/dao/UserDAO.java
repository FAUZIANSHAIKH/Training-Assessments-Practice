package com.sapient.dao;
import java.util.List;

import com.sapient.model.Post;
import com.sapient.model.User;
public interface UserDAO {

	    public void saveUser(User user);
	    public List<User> listAll();
	    public User findById(int id);
	    public void deleteUser(int id);
	    public void updateUser(int id,User user);
	    public void savePost(Post post);
	    public List<Post> listAllPost() ;
	    public List<Post> findPostById(int id);
	    public void deletePostById(int id);
	    public void updatePost(int id, User post);
	    public void deletePost();


	
}
