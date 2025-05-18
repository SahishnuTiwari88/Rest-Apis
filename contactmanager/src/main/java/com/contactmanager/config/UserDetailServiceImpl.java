package com.contactmanager.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.contactmanager.dao.UserRepository;
import com.contactmanager.entities.User;

public class UserDetailServiceImpl implements UserDetailsService{
	@Autowired
	private UserRepository userrep;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		//here we have to get users from the database and do authentication and then return the user detail
		//in order to get user from database we have to Autowire the UserRepository here
		
		User user = userrep.getUserByUserName(username); //username is our email from the CustomUserDetail class
		
		if(user==null) {
			//if user not available then
			throw new UsernameNotFoundException("User not found");
		}
		//if user is not null then return Userdatails i.e.customUserDetails
		CustomUserDetail customUserDetails = new CustomUserDetail(user);
		
		
		return customUserDetails;
	}

}

//last step create configuration file of the security where we have to inform that we use Dao Authentication Provider
//which will get data from database using repository to authenticate the user
//here we also protect our url's or what url autorization given to whom like to admin or to user,
//for that we use userdatailservice
