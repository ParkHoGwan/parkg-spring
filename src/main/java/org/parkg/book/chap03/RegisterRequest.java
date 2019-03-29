package org.parkg.book.chap03;

public class RegisterRequest {
	String email; // 이메일
	String password; // 비밀번호
	String name; // 이름

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "RegisterRequest [email=" + email + ", name=" + name + "]";
	}
}