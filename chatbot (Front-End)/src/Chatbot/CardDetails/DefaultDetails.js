import React, { useState, useEffect } from "react";
import axios from "axios";

const DefaultDetails = ({ userData }) => {
  const [defaultData, setdefaultData] = useState(null);

  useEffect(() => {
    const fetchUPIDetails = async () => {
      console.log("userData:", userData); // Log userData for verification

      try {
        const response = await axios.get(
          `http://localhost:8080/accounts/${userData}/defaultpayment`
        );
        console.log("Default Payment Method response:", response.data);
        setdefaultData(response.data); // Set the card data
      } catch (error) {
        console.error("Error fetching card details:", error);
      }
    };

    fetchUPIDetails();
  }, [userData]);

  return (
    <div>
      {defaultData ? (
        <div>
          Default Payment Method:
          <h2>
            <b>{defaultData}</b>
          </h2>
        </div>
      ) : (
        <p>Invalid ...</p>
      )}
    </div>
  );
};

export default DefaultDetails;
