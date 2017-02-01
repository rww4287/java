package com.ktds.kjj.address.book.dao;

import java.util.ArrayList;
import java.util.List;

import com.ktds.kjj.address.book.vo.AddressVO;

public class AddressDaoImpl implements AddressDao{
	
	private List<AddressVO> addressList;
	
	public AddressDaoImpl(){
		addressList = new ArrayList<AddressVO>();
	}

	@Override
	public List<AddressVO> queryAllList() {
		return addressList;
	}

	@Override
	public AddressVO findOneAddress(int index) {
		return addressList.get(index);
	}

	@Override
	public void removerAddress(int index) {
		addressList.remove(index);
	}

	@Override
	public void updateAddress(int index, AddressVO newAddress) {
		addressList.set(index, newAddress);
	}

	@Override
	public void addAddress(AddressVO newAddress) {
		addressList.add(newAddress);
	}

}
