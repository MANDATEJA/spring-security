package com.springsec.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.springsec.model.Customer;
import com.springsec.repository.CustomerRepository;

@Service
public class SecurityUserDetails implements UserDetailsService {
  private CustomerRepository customerRepository;
  public SecurityUserDetails (CustomerRepository customerRepository) {
    this.customerRepository = customerRepository;
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    String userName = null;
    String password = null;
    List<GrantedAuthority> authorities = null;
    List<Customer> customer = customerRepository.findByEmail(username);

    if (customer.isEmpty()) {
      throw new UsernameNotFoundException("User details not found for the user: " + username);
    } else {
      userName = customer.get(0).getEmail();
      password = customer.get(0).getPwd();
      authorities = new ArrayList<>();

      authorities.add(new SimpleGrantedAuthority(customer.get(0).getRole()));
    }

    return new User(userName, password, authorities);
  }
}
