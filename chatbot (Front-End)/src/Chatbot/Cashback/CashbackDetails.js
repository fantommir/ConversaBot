import React, { useState, useEffect } from "react";
import axios from "axios";

const CashbackDetails = ({ orderId }) => {
  const [cashbackData, setCashbackData] = useState(null);

  useEffect(() => {
    const order = localStorage.getItem("orderId");
    console.log("orderId:", order);
    const fetchCashbackDetails = async () => {
      try {
        const response = await axios.get(
          `http://localhost:8080/accounts/cashbacks/${order}`
        );
        console.log("Cashback details response:", response.data);
        setCashbackData(response.data);
      } catch (error) {
        console.error("Error fetching cashback details:", error);
      }
    };

    fetchCashbackDetails();
  }, [orderId]);

  return (
    <div>
      {cashbackData ? (
        <div>
          <p>Cashback Details:</p>
          <p>Cashback ID: {cashbackData.cashbackId}</p>
          <p>Cashback Amount: {cashbackData.cashbackAmount}</p>
          <p>Cashback Date: {cashbackData.cashbackDate}</p>
          <p>Cashback Status: {cashbackData.cashbackStatus}</p>
          <br /> {/* Line break */}
        </div>
      ) : (
        <p>Loading cashback details...</p>
      )}
    </div>
  );
};

export default CashbackDetails;
