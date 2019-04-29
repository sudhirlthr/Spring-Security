/**
 * 
 */

package com.pramati.boostrap;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.pramati.model.Authority;
import com.pramati.model.Users;
import com.pramati.repository.RolesRepository;
import com.pramati.repository.UserRepository;

/**
 * @author sudhirk
 *
 */
@Component
public class Bootstrap implements ApplicationListener<ContextRefreshedEvent> {

	UserRepository userRepository;
	RolesRepository roleRepository;

	public Bootstrap(UserRepository userRepository, RolesRepository roleRepository) {
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		init();
	}

	public void init() {
		Authority roles = new Authority("sudhir", "ROLE_USER");
		Authority roles2 = new Authority("kumar", "ROLE_ADMIN");
		Set<Authority> rolesSet = new HashSet<>();
		rolesSet.add(roles);
		rolesSet.add(roles2);
		roleRepository.save(roles);
		roleRepository.save(roles2);

		// roleRepository.saveAll(rolesSet);

		Users users = new Users("sudhir", "{noop}123", true);
		Users users2 = new Users("kumar", "{noop}1234", true);

		userRepository.save(users);
		userRepository.save(users2);
	}

}
