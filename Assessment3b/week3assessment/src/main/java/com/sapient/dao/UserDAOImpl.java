package com.sapient.dao;
import com.sapient.model.Post;
import com.sapient.model.User;
	import org.springframework.stereotype.Repository;

	import java.util.ArrayList;
	import java.util.List;

	@Repository(value="employeeDAO")
	public class UserDAOImpl implements UserDAO {

	    private static List<User> users = new ArrayList<User>();

	   

	    public List<User> listAll() {
	        System.out.println("Inside the list all method of EmployeeDAO");

	        return null;
	    }

	    public User findById(int id) {
	        System.out.println("Inside the findBYId method of EmployeeDAO");
	        return null;
	    }

	    public void deleteUser(int id) {
	        System.out.println("inside the delete method of EmployeeDAO");
	    }

		
		public void updateUser(int id, User user) {
			System.out.println("inside the update method of EmployeeDAO");
			
		}

		public void savePost(Post post) {
			System.out.println("inside the save method of EmployeeDAO");
			
		}

		public List<Post> listAllPost() {
			System.out.println("inside the lisallpost method of EmployeeDAO");
			return null;
		}

		public List<Post> findPostById(int id) {
			System.out.println("inside the findpostbyid method of EmployeeDAO");
			return null;
		}

		public void deletePostById(int id) {
			System.out.println("inside the deletepostby method of EmployeeDAO");
			
		}

		public void updatePost(int id, User post) {
			System.out.println("inside the update method of EmployeeDAO");
			
		}

		public void saveUser(User user) {
			users.add(user);
	        
			
		}

		public void deletePost() {
			
		}
	}

