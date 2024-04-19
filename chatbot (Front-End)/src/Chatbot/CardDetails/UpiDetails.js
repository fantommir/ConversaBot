import React, { useState, useEffect } from "react";
import axios from "axios";

const UpiDetails = ({ userData }) => {
  const [upiData, setupiData] = useState(null);

  useEffect(() => {
    const fetchUPIDetails = async () => {
      console.log("userData:", userData); // Log userData for verification

      try {
        const response = await axios.get(
          `http://localhost:8080/accounts/${userData}/upidetails`
        );
        console.log("UPI details response:", response.data);
        setupiData(response.data); // Set the card data
      } catch (error) {
        console.error("Error fetching card details:", error);
      }
    };

    fetchUPIDetails();
  }, [userData]);

  return (
    <div>
      <h2>UPI Details</h2>
      {upiData ? (
        <div>
          {upiData.map((card, index) => (
            <div key={index}>
              <p>UPI Name: {card.upiName}</p>
              <p>UPI ID: {card.upiIdentifier}</p>
              <p>UPI PIN: {card.upiPin}</p>
              <br /> {/* Line break */}
            </div>
          ))}
        </div>
      ) : (
        <p>Invalid ...</p>
      )}
    </div>
  );
};

export default UpiDetails;
