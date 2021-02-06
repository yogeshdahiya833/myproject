package com.mentrend.daos;
import java.util.List;

import com.mentrend.models.Contact;

public interface ContactDao {
	public boolean addContact(Contact contObj);
	public Contact getUser(String email);
	public List<Contact> getAllContacts();
	public Contact getContactById(String email);
	public boolean deleteContact(String email);
}
