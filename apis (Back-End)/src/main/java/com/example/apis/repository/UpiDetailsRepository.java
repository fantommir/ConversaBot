package com.example.apis.repository;

import com.example.apis.model.Account;
import com.example.apis.model.UpiDetails;

public interface UpiDetailsRepository {

    UpiDetails getUpiIdById(int upiId);

    String getUpiNameById(int upiId);

    String getUpiIdentifierById(int upiId);

    String getRegisteredMobileById(int upiId);

    int getUpiPinById(int upiId);


    Account getUpiDetailsAccount(int upiId);

}
