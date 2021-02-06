package com.mentrend.daos;

import java.util.List;

import com.mentrend.models.Address;

public interface AddressDao {

	public boolean addAddress(Address obj);
	public boolean deleteAddress(int addressId);
	public boolean updateAddress(Address obj);
	public List<Address> getAddress(String email);
	public Address getAddressById(int addressId);
	
	
}
