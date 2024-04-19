import React, { useState, useEffect } from "react";
import axios from "axios";

const AccountDetails = ({ userData }) => {
  const [accountData, setAccountData] = useState(null);

  useEffect(() => {
    const fetchAccountDetails = async () => {
      console.log("userData:", userData); // Log userData for verification

      try {
        const response = await axios.get(
          `http://localhost:8080/accounts/${userData}`
        );
        console.log("Account details response:", response.data);
        setAccountData([response.data]); // Wrap the response data in an array
      } catch (error) {
        console.error("Error fetching account details:", error);
      }
    };

    fetchAccountDetails();
  }, [userData]);

  return (
    <div>
      <h2>Account Details</h2>
      {accountData ? (
        <div>
          {accountData.map((account, index) => (
            <div key={index}>
              <p>Username: {account.userName}</p>
              <p>Email: {account.mailId}</p>
              <p>Phone: {account.phone}</p>
              <p>Password: {account.password}</p>
              <br /> {/* Line break */}
            </div>
          ))}
        </div>
      ) : (
        <p>Loading account details...</p>
      )}
    </div>
  );
};

export default AccountDetails;
