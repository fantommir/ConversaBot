import React, { useState, useEffect } from "react";
import axios from "axios";

const CardDetails = ({ userData }) => {
  const [cardData, setCardData] = useState(null);

  useEffect(() => {
    const fetchCardDetails = async () => {
      console.log("userData:", userData); // Log userData for verification

      try {
        const response = await axios.get(
          `http://localhost:8080/accounts/${userData}/carddetails`
        );
        console.log("Card details response:", response.data);
        setCardData(response.data); // Set the card data
      } catch (error) {
        console.error("Error fetching card details:", error);
      }
    };

    fetchCardDetails();
  }, [userData]);

  return (
    <div>
      <h2>Card Details</h2>
      {cardData ? (
        <div>
          {cardData.map((card, index) => (
            <div key={index}>
              <p>Card Name: {card.cardName}</p>
              <p>Card Number: {card.cardNumber}</p>
              <p>Expiry Date: {card.expiryDate}</p>
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

export default CardDetails;
