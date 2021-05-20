package com.sapient.service;
import com.sapient.model.Post;
import com.sapient.model.User;

	
	import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

	public interface UserService {

	    public void saveUser(User user);
	    public List<User> fetchAllEmployees();
	    public User findById(int id);
	    public void deleteUser(int id);
	    public void updateUser(int id,User user);
	    public List<Post> listAllPost();
	    public List<Post> findPostById(int id);
	    public void savePost(Post post);
	    public void deletePostById(int id);
	    public void deletePost();

	}

