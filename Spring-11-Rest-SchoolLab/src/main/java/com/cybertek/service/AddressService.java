package com.cybertek.service;

import com.cybertek.model.Address;

import java.util.List;

public interface AddressService {

    List<Address> getAddresses();
    Address getAddress(long id);
}
