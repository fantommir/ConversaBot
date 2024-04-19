import React, { useState, useEffect } from "react";
import axios from "axios";

const OrderDetails = ({ userData, triggerNextStep }) => {
  const [orderData, setOrderData] = useState(null);

  useEffect(() => {
    const fetchOrderDetails = async () => {
      try {
        const response = await axios.get(
          `http://localhost:8080/accounts/${userData}/orders`
        );
        console.log("Order details response:", response.data);
        setOrderData(response.data);
      } catch (error) {
        console.error("Error fetching order details:", error);
      }
    };

    fetchOrderDetails();
  }, [userData]);

  const handleOrderSelection = (orderId) => {
    // Pass the selected orderId to the next step
    triggerNextStep({ value: orderId });
  };

  return (
    <div>
      {orderData ? (
        <div>
          <p>Please select an order:</p>
          {orderData.map((order, index) => (
            // <div key={index}>
            <button
              key={order.orderId}
              onClick={() => handleOrderSelection(order.orderId)}
              style={{
                backgroundColor: "#704cac",
                border: "1px solid black",
                margin: "5px",
              }}
            >
              <p>Order {index + 1}</p>
              <p>Product Name: {order.productname}</p>
              <p>Order ID: {order.orderId}</p>
              <p>Order Date: {order.orderDate}</p>
              <p>Order Address: {order.orderAddress}</p>
              <p>Order Price: {order.orderPrice}</p>
              <p>Quantity: {order.quantity}</p>
              <p>Total Price: {order.totalPrice}</p>
              <p>Status: {order.status}</p>
              <p>Delivery Date: {order.deliveryDate}</p>
              <br /> {/* Line break */}
            </button>
            // </div>
          ))}
        </div>
      ) : (
        <p>Loading order details...</p>
      )}
    </div>
  );
};

export default OrderDetails;
