// import React, { useState, useEffect } from 'react';
// import axios from 'axios';

// const PaymentDetails = ({orderId}) => {
//   const [paymentData, setPaymentData] = useState(null);

//   useEffect(() => {
//     const order = localStorage.getItem('orderId');
//     console.log('orderId:', order);
//     const fetchPaymentDetails = async () => {
//       try {
//         // const response = await axios.get(`http://localhost:8080/accounts/${userData}/transactions`);
//         const response = await axios.get(`http://localhost:8080/accounts/transactions/${order}`);
//         // ${orderId}
//         console.log('Payment details response:', response.data);
//         setPaymentData(response.data);
//       } catch (error) {
//         console.error('Error fetching payment details:', error);
//       }
//     };

//     fetchPaymentDetails();

//   }, [orderId]);

//   return (
//     <div>
//       {paymentData ? (
//         <div>
//           <p>Payment Details:</p>
//           <p>Transaction ID: {paymentData.transactionId}</p>
//           <p>Pincode: {paymentData.pincode}</p>
//           <p>Payment ID: {paymentData.paymentId}</p>
//           <p>Account Number: {paymentData.accountNumber}</p>
//           <p>Payment Date: {paymentData.paymentDate}</p>
//           <p>Payment Method: {paymentData.paymentMethod}</p>
//           <p>Payment Status: {paymentData.paymentStatus}</p>
//           <p>Payment Amount: {paymentData.paymentAmount}</p>
//         </div>
//       ) : (
//         <p>Loading payment details...</p>
//       )}
//     </div>
//   );
// }

// export {PaymentDetails}

import React, { useState, useEffect } from "react";
import axios from "axios";

const PaymentDetails = ({ orderId }) => {
  const [paymentData, setPaymentData] = useState(null);

  useEffect(() => {
    const order = localStorage.getItem("orderId");
    console.log("orderId:", order);
    const fetchPaymentDetails = async () => {
      try {
        // const response = await axios.get(http://localhost:8080/accounts/${userData}/transactions);
        const response = await axios.get(
          `http://localhost:8080/accounts/transactions/${order}`
        );
        // ${orderId}
        console.log("Payment details response:", response.data);
        setPaymentData(response.data);
      } catch (error) {
        console.error("Error fetching payment details:", error);
      }
    };

    fetchPaymentDetails();
  }, [orderId]);

  return (
    <div>
      {paymentData ? (
        <div>
          <p>Payment Details:</p>
          <p>Transaction ID: {paymentData.transactionId}</p>
          <p>Pincode: {paymentData.pincode}</p>
          <p>Payment ID: {paymentData.paymentId}</p>
          <p>Account Number: {paymentData.accountNumber}</p>
          <p>Payment Date: {paymentData.paymentDate}</p>
          <p>Payment Method: {paymentData.paymentMethod}</p>
          <p>Payment Status: {paymentData.paymentStatus}</p>
          <p>Payment Amount: {paymentData.paymentAmount}</p>
        </div>
      ) : (
        <p>Loading payment details...</p>
      )}
    </div>
  );
};

export default PaymentDetails;
