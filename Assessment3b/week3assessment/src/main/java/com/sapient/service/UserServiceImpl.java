package com.sapient.service;
import com.sapient.dao.UserDAO;
import com.sapient.model.Post;
import com.sapient.model.User;
//import com.sapient.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;

	@Service(value = "employeeService")
	public class UserServiceImpl implements UserService {

	    @Autowired( required = true)
	    @Qualifier(value = "HybernateDAOImpl")
	    private UserDAO userDAO;
	    public UserServiceImpl(@Qualifier(value="HybernateDAOImpl") UserDAO userDAO)
	    {
	    	this.userDAO=userDAO;
	    }
	    @Transactional
		public void saveUser(User user) {
			
			userDAO.saveUser(user);
		}
	    @Transactional
		public List<User> fetchAllEmployees() {
			
			return userDAO.listAll() ;
		}
	    @Transactional
		public User findById(int id) {
			
			return userDAO.findById(id);
		}
	    @Transactional
		public void deleteUser(int id) {
			
			userDAO.deleteUser(id);
		}
	    @Transactional
		public void updateUser(int id, User user) {
			
			userDAO.updateUser(id, user);
		}
	    @Transactional
		public List<Post> listAllPost() {
			
	    	return userDAO.listAllPost() ;
		}
	    @Transactional
		public List<Post> findPostById(int id) {
			
	    	return userDAO.findPostById(id);
		}
	    @Transactional
		public void savePost(Post post) {
	    	userDAO.savePost(post);
		
			
		}
	    @Transactional
		public void deletePostById(int id) {
	    	userDAO.deletePostById(id);
			
		}
	    @Transactional
		public void deletePost() {
	    	userDAO.deletePost();
			
		}
		
}
