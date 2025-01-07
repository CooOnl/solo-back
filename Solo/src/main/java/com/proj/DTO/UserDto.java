package com.proj.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

	private String username;
//	private String userpassword;
	private String name;
	private String email;
	private String userbirth;
	private String usernumber;
	private String role;
}
