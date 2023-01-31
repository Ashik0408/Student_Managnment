package SchoolManagnment;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.servlet.annotation.WebServlet;
//@WebServlet("/registration")
@Entity
public class principal {
private String name;
@Id
private int id;
private String email;
private String pass;

public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPass() {
	return pass;
}
public void setPass(String pass) {
	this.pass = pass;
}

}
