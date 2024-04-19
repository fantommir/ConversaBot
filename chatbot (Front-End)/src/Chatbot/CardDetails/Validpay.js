import React, { useState, useEffect } from "react";
import axios from "axios";

const Validpay = ({ userData }) => {
  const [validData, setvalidData] = useState(null);
  const [showValid, setshowValid] = useState(false);

  useEffect(() => {
    const fetchValidpayDetails = async () => {
      console.log("userData:", userData); // Log userData for verification

      try {
        let permission = localStorage.getItem("valid");
        if (permission === "true") {
          setshowValid(true);
          const response = await axios.get(
            `http://localhost:8080/accounts/${userData}/carddetails`
          );
          console.log("Valid details response:", response.data);
          setvalidData(response.data); // Set the card data
        }
      } catch (error) {
        console.error("Error fetching card details:", error);
      }
    };

    fetchValidpayDetails();
  }, [userData]);

  return (
    <div>
      {validData && showValid ? <h2>Valid PIN</h2> : <h2>Invalid PIN...</h2>}
    </div>
  );
};

export default Validpay;
