package com.example.apis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

import com.example.apis.model.*;
import com.example.apis.repository.*;

@Service
public class AccountService implements AccountRepository {

    @Autowired
    private AccountJpaRepository accountJpaRepository;

    @Autowired
    private ProductJpaRepository productJpaRepository;

    @Autowired
    private OrderJpaRepository orderJpaRepository;

    @Autowired
    private CashbackJpaRepository cashbackJpaRepository;

    @Autowired
    private PaymentJpaRepository paymentJpaRepository;

    @Autowired
    private CardDetailsJpaRepository cardDetailsJpaRepository;

    @Autowired
    private UpiDetailsJpaRepository upiDetailsJpaRepository;


    // SignUp & Login
    @Override
    public void signUp(Account account) {
        accountJpaRepository.save(account);
    }

    @Override
    public int loginAuth(String mailId, String password) {

        List<Account> users = accountJpaRepository.findAll();
        for (Account user : users) {
            if (user.getMailId().equals(mailId) && user.getPassword().equals(password)) {
//                return user.getAccountId();
                int accountId = user.getAccountId();
                System.out.println("Logged in with accountId: " + accountId);
                return accountId;

            }
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Login Failed");
    }


    // ************   Get   *************

    @Override
    public boolean isEmailPresent(String email) {
        try {
            // Check if any account has the provided email
            Optional<Account> account = accountJpaRepository.findByMailId(email);
            return account.isPresent(); // If an account with the email exists, return true
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error checking email existence");
        }
    }

    @Override
    public Account getAccountById(int accountId) {
        try {
            return accountJpaRepository.findById(accountId).get();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Account details not found");
        }

    }

    public String getUsernameById(int accountId) {
        Account account = getAccountById(accountId);
        return account.getUserName();
    }

    public String getMailIdById(int accountId) {
        Account account = getAccountById(accountId);
        return account.getMailId();
    }

    public long getPhoneById(int accountId) {
        Account account = getAccountById(accountId);
        return account.getPhone();
    }

    public String getPasswordById(int accountId) {
        Account account = getAccountById(accountId);
        return account.getPassword();
    }

    public String getdefaultpaymentById(int accountId) {
        Account account = getAccountById(accountId);
        return account.getDefaultPayment();
    }


    // ************   Update   *************

    @Override
    public Account updateAccount(int accountId, Account account) {
        try {
            Account newAccount = accountJpaRepository.findById(accountId).get();
            if (account.getUserName() != null) {
                newAccount.setUserName(account.getUserName());
            }
            if (account.getMailId() != null) {
                newAccount.setMailId(account.getMailId());
            }
            if (account.getPhone() != 0) {
                newAccount.setPhone(account.getPhone());
            }
            if (account.getPassword() != null) {
                newAccount.setPassword(account.getPassword());
            }
            if (account.getDefaultPayment() != null) {
                newAccount.setDefaultPayment(account.getDefaultPayment());
            }
            accountJpaRepository.save(newAccount);

            return newAccount;

        } catch (Exception e) {

            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

    }


    public Account updateuserName(int accountId, Account account) {
        try {
            Account newAccount = accountJpaRepository.findById(accountId).get();
            if (account.getUserName() != null) {
                newAccount.setUserName(account.getUserName());
            }
            accountJpaRepository.save(newAccount);
            return newAccount;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    public Account updatemailID(int accountId, Account account) {
        try {
            Account newAccount = accountJpaRepository.findById(accountId).get();
            if (account.getMailId() != null) {
                newAccount.setMailId(account.getMailId());
            }
            accountJpaRepository.save(newAccount);
            return newAccount;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    public Account updatphone(int accountId, Account account) {
        try {
            Account newAccount = accountJpaRepository.findById(accountId).get();
            if (account.getPhone() != 0) {
                newAccount.setPhone(account.getPhone());
            }
            accountJpaRepository.save(newAccount);
            return newAccount;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    public Account updatpassword(int accountId, Account account) {
        try {
            Account newAccount = accountJpaRepository.findById(accountId).get();
            if (account.getPassword() != null) {
                newAccount.setPassword(account.getPassword());
            }
            accountJpaRepository.save(newAccount);
            return newAccount;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }


    public Account updatedefaultpayment(int accountId, Account account) {
        try {
            Account newAccount = accountJpaRepository.findById(accountId).get();
            if (account.getDefaultPayment() != null) {
                newAccount.setDefaultPayment(account.getDefaultPayment());
            }
            accountJpaRepository.save(newAccount);
            return newAccount;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }


    // *************  get the all product details  ***************

    @Override
    public ArrayList<Product> getProductAccount(int accountId) {
        ArrayList<Product> newProductList = new ArrayList<>();
        List<Product> productList = productJpaRepository.findAll();
        for (Product product : productList) {
            Account account = product.getAccount();
            if (account.getAccountId() == accountId) {
                newProductList.add(product);
            }
        }

        return newProductList;
    }

    @Override
    public ArrayList<Order> getOrderAccount(int accountId) {
        ArrayList<Order> newOrderList = new ArrayList<>();
        List<Order> orderList = orderJpaRepository.findAll();

        for (Order order : orderList) {
            Account account = order.getAccount();
            if (account.getAccountId() == accountId) {
                System.out.println("Order");
                System.out.println(order.toString());
                newOrderList.add(order);
            }
        }
        return newOrderList;
    }

    @Override
    public ArrayList<Cashback> getCashbackAccount(int accountId) {
        ArrayList<Cashback> newCashbackList = new ArrayList<>();
        List<Cashback> cashbackList = cashbackJpaRepository.findAll();
        for (Cashback cashback : cashbackList) {
            Account account = cashback.getAccount();
            if (account.getAccountId() == accountId) {
                newCashbackList.add(cashback);
            }
        }

        return newCashbackList;
    }

    @Override
    public ArrayList<Payment> getPaymentAccount(int accountId) {
        ArrayList<Payment> newPaymentList = new ArrayList<>();
        List<Payment> paymentList = paymentJpaRepository.findAll();
        for (Payment payment : paymentList) {
            Account account = payment.getAccount();
            if (account.getAccountId() == accountId) {
                newPaymentList.add(payment);
            }
        }

        return newPaymentList;
    }

    @Override
    public ArrayList<CardDetails> getCardDetailsAccount(int accountId) {
        ArrayList<CardDetails> newPaymentList = new ArrayList<>();
        List<CardDetails> paymentList = cardDetailsJpaRepository.findAll();
        for (CardDetails payment : paymentList) {
            Account account = payment.getAccount();
            if (account.getAccountId() == accountId) {
                newPaymentList.add(payment);
            }
        }

        return newPaymentList;
    }

    @Override
    public ArrayList<UpiDetails> getUpiDetailsAccount(int accountId) {
        ArrayList<UpiDetails> newupiList = new ArrayList<>();
        List<UpiDetails> upiList = upiDetailsJpaRepository.findAll();
        for (UpiDetails upi : upiList) {
            Account account = upi.getAccount();
            if (account.getAccountId() == accountId) {
                newupiList.add(upi);
            }
        }

        return newupiList;
    }

    // Method to validate card PIN using account ID
    public boolean validateCardPin(int accountId, int cardPin) {
        try {
            List<CardDetails> cardDetailsList = cardDetailsJpaRepository.findByAccount_AccountId(accountId);

            for (CardDetails cardDetails : cardDetailsList) {
                if (cardDetails.getCardPin() == cardPin) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error validating card PIN");
        }
    }

    public Object validatePin(int accountId, int pin) {
        try {
            List<Payment> paymentList = paymentJpaRepository.findByAccount_AccountId(accountId);

            for (Payment payments : paymentList) {
                if (payments.getPin() == pin) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error validating PIN");
        }
    }

    public boolean validateUpiPin(int accountId, int upiPin) {
        try {
            List<UpiDetails> upiDetailsList = upiDetailsJpaRepository.findByAccount_AccountId(accountId);

            for (UpiDetails upiDetails : upiDetailsList) {
                if (upiDetails.getUpiPin() == upiPin) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error validating upi PIN");
        }
    }

}
