import React, { useState } from "react";
import ChatBot from "react-simple-chatbot";
import AccountDetails from "./Account/AccountDetails";
import OrderDetails from "./Order/OrderDetails";
import CashbackDetails from "./Cashback/CashbackDetails";
import PaymentDetails from "./Payment/PaymentDetails";
import CardDetails from "./CardDetails/CardDetails";
import axios from "axios";
import { useNavigate } from "react-router-dom";
import Validpay from "./CardDetails/Validpay";
import UpiDetails from "./CardDetails/UpiDetails";
import DefaultDetails from "./CardDetails/DefaultDetails";

const Chatbot = ({ userData, setIsLoggedIn, accountId }) => {
  const [isChatbotVisible, setIsChatbotVisible] = useState(false);
  const [orderId, setorderId] = useState(null);

  const toggleChatbot = () => {
    setIsChatbotVisible(!isChatbotVisible);
  };

  console.log("userData:", userData);
  console.log("orderId11:", orderId);

  localStorage.setItem("orderId", orderId);

  const steps = [
    {
      id: "1",
      message: "Welcome to our store! How can I assist you today?",
      trigger: "option",
    },
    {
      id: "option",
      options: [
        { value: "account", label: "Account", trigger: "accountDetails" },
        { value: "order", label: "Order", trigger: "orderDetails" },
        {
          value: "card payment",
          label: "Card Payment Info",
          trigger: "enterpin",
        }, //cardpaymentValid
        { value: "exit", label: "Exit", trigger: "end" },
      ],
    },

    {
      id: "enterpin",
      message: "Please enter PIN...",
      trigger: "validatepin",
    },
    {
      id: "validatepin",
      inputAttributes: {
        type: "password",
      },
      user: true,
      validator: (value) => {
        const regex = /^\d{4}$/; // Regular expression for 4 digits
        if (!regex.test(value)) return "Please enter a valid 4-digit PIN.";
        return true;
      },
      trigger: "middleware",
    },
    {
      id: "middleware",
      message: ({ previousValue }) => {
        axios
          .get(
            `http://localhost:8080/accounts/${accountId}/carddetails/cardpin`,
            {
              params: {
                cardPin: previousValue,
              },
            }
          )
          .then((response) => {
            console.log("response data is", response.data);
            if (response.data) {
              localStorage.setItem("valid", true);
            } else {
              localStorage.setItem("valid", false);
            }
            return "Fetching card details...";
          })
          .catch((error) => {
            console.error("Error updating user:", error);
          });
      },
      trigger: "ValidpayDetails",
    },

    {
      id: "ValidpayDetails",
      component: <Validpay userData={userData} />,
      asMessage: true,
      // trigger: 'Card_option',
      trigger: (valids) => {
        const valid = localStorage.getItem("valid");
        console.log("Selected 155.:", valid); // Print the selected order ID
        if (valid === "true") {
          console.log("158", valid);
          console.log(typeof valid);

          return "Card_option";
        } else {
          console.log("160 hi", valid);
          return "enterpin"; // Go back to options if no order selected
        }
      },
    },

    {
      id: "Card_option",
      options: [
        { value: "card", label: "Card Payment", trigger: "CardPayDetails" },
        { value: "upi", label: "UPI Payment", trigger: "UPIPayDetails" },
        {
          value: "DefaultPayment",
          label: "Default Payment Info",
          trigger: "DefaultPayDetails",
        }, //cardpaymentValid
        { value: "exit", label: "Exit", trigger: "end" },
      ],
    },

    {
      id: "CardPayDetails",
      component: <CardDetails userData={userData} />,
      asMessage: true,
      trigger: "Card_option",
    },

    {
      id: "UPIPayDetails",
      component: <UpiDetails userData={userData} />,
      asMessage: true,
      trigger: "Card_option",
    },

    {
      id: "DefaultPayDetails",
      component: <DefaultDetails userData={userData} />,
      asMessage: true,
      trigger: "Default_option",
    },

    {
      id: "Default_option",
      options: [
        {
          value: "UpateDefaultPayment",
          label: "Upate Default Payment",
          trigger: "UpdateDefaultPayDetails",
        },
        { value: "exit", label: "Exit", trigger: "end" },
      ],
    },

    {
      id: "UpdateDefaultPayDetails",
      message:
        "Please enter Default Payment: Card, UPI, Cash on Delivery (any one)",
      trigger: "updateDefaultPays",
    },

    {
      id: "updateDefaultPays",
      user: true,
      validator: (value) => {
        const validPaymentMethods = ["Card", "UPI", "Cash on Delivery"];
        if (!validPaymentMethods.includes(value)) {
          return "Please select a valid payment method (Card, UPI, Cash on Delivery).";
        }
        return true;
      },
      trigger: "printDefaultPays",
    },

    {
      id: "printDefaultPays",
      message: ({ previousValue }) => {
        console.log(previousValue);
        axios
          .put(`http://localhost:8080/accounts/defaultpayment/${userData}`, {
            defaultPayment: previousValue,
          })
          .then((response) => {
            console.log("Update Default payment response:", response.data);
          })
          .catch((error) => {
            console.error("Error updating Default payment:", error);
          });

        return "Updating Default payment...";
      },
      trigger: "updateSuccessPay",
    },
    // Update success message
    {
      id: "updateSuccessPay",
      message: "Your Default Payment details have been updated successfully!",
      trigger: "Card_option",
    },

    // ---------------------------------
    {
      id: "orderDetails",
      component: <OrderDetails userData={userData} />,
      waitAction: true, // Wait for user input (order selection)
      asMessage: true,
      trigger: (value) => {
        const orderId = value.value;
        console.log("Selected Order ID:", orderId); // Print the selected order ID
        setorderId(orderId);
        if (orderId) {
          return "showPaymentAndCashbackDetails";
        } else {
          return "option"; // Go back to options if no order selected
        }
      },
    },

    //-----------------------------------------------

    {
      id: "orderDetails",
      component: <OrderDetails userData={userData} />,
      waitAction: true, // Wait for user input (order selection)
      asMessage: true,
      trigger: (value) => {
        const orderId = value.value;
        console.log("Selected Order ID:", orderId); // Print the selected order ID
        setorderId(orderId);
        if (orderId) {
          return "showPaymentAndCashbackDetails";
        } else {
          return "option"; // Go back to options if no order selected
        }
      },
    },
    {
      id: "showPaymentAndCashbackDetails",
      message: "Fetching payment and cashback details...",
      trigger: "displayPaymentAndCashbackDetails",
    },
    {
      id: "displayPaymentAndCashbackDetails",
      options: [
        { value: "payment", label: "Payment", trigger: "payment" },
        { value: "cashback", label: "Cashback", trigger: "cashback" },
      ],
    },

    //svsh
    {
      id: "payment",
      options: [
        {
          value: "paymentDetails",
          label: "View Payment Details",
          trigger: "showPaymentDetails",
        },
        { value: "back", label: "Back", trigger: "option" },
      ],
    },
    {
      id: "showPaymentDetails",
      component: <PaymentDetails orderId={orderId} />,
      asMessage: true,
      trigger: "option",
    },

    {
      id: "accountDetails",
      component: <AccountDetails userData={userData} />,
      asMessage: true,
      trigger: "accountMessage",
    },
    {
      id: "accountMessage",
      message: "Here are your account details. What would you like to modify?",
      trigger: "modifyOptions",
    },
    // Options for modification
    {
      id: "modifyOptions",
      options: [
        { value: "Username", label: "Name", trigger: "askForName" },
        { value: "Email", label: "Email", trigger: "askForEmail" },
        { value: "Phone", label: "Phone", trigger: "askForPhone" },
        { value: "password", label: "Password", trigger: "askForPassword" },
        { value: "back", label: "Back", trigger: "option" },
        { value: "exit", label: "Exit", trigger: "end" },
      ],
    },
    // Update user name
    {
      id: "askForName",
      message: "Please enter your new name:",
      trigger: "updateName",
    },
    {
      id: "updateName",
      user: true,
      validator: (value) => {
        if (!value.trim()) return "Please enter a valid name.";
        return true;
      },
      trigger: "printName",
    },
    {
      id: "printName",
      message: ({ previousValue }) => {
        axios
          .put(`http://localhost:8080/accounts/userName/${userData}`, {
            userName: previousValue,
          })
          .then((response) => {
            console.log("Update user response:", response.data);
          })
          .catch((error) => {
            console.error("Error updating user:", error);
          });

        return "Updating username...";
      },
      trigger: "updateSuccess",
    },

    // Update email
    {
      id: "askForEmail",
      message: "Please enter your new email:",
      trigger: "updateEmail",
    },
    {
      id: "updateEmail",
      user: true,
      validator: (value) => {
        const re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
        if (!re.test(String(value).toLowerCase()))
          return "Please enter a valid email address.";
        return true;
      },
      trigger: "printMail",
    },
    {
      id: "printMail",
      message: ({ previousValue }) => {
        axios
          .put(`http://localhost:8080/accounts/mailID/${userData}`, {
            mailId: previousValue,
          })
          .then((response) => {
            console.log("Update mailid response:", response.data);
          })
          .catch((error) => {
            console.error("Error updating mailid:", error);
          });

        return "Updating mailid...";
      },
      trigger: "updateSuccess",
    },

    // Update phone
    {
      id: "askForPhone",
      message: "Please enter your new phone no:",
      trigger: "updatePhone",
    },
    {
      id: "updatePhone",
      user: true,
      validator: (value) => {
        const re = /^\d{10}$/; // Regular expression to validate a 10-digit phone number
        if (!re.test(value))
          return "Please enter a valid 10-digit phone number.";
        return true;
      },
      trigger: "printPhone",
    },
    {
      id: "printPhone",
      message: ({ previousValue }) => {
        axios
          .put(`http://localhost:8080/accounts/phone/${userData}`, {
            phone: previousValue,
          })
          .then((response) => {
            console.log("Update phone response:", response.data);
          })
          .catch((error) => {
            console.error("Error updating phone:", error);
          });

        return "Updating Phone No...";
      },
      trigger: "updateSuccess",
    },

    // update password
    {
      id: "askForPassword",
      message: "Please enter your new password:",
      trigger: "updatePassword",
    },
    {
      id: "updatePassword",
      user: true,
      validator: (value) => {
        if (value.length < 6) return "Password must be at least 6 characters.";
        return true;
      },
      trigger: "printPassword",
    },
    {
      id: "printPassword",
      message: ({ previousValue }) => {
        axios
          .put(`http://localhost:8080/accounts/password/${userData}`, {
            password: previousValue,
          })
          .then((response) => {
            console.log("Update password response:", response.data);
          })
          .catch((error) => {
            console.error("Error updating password:", error);
          });

        return "Updating password...";
      },
      trigger: "updateSuccess",
    },

    {
      id: "cashback",
      options: [
        {
          value: "cashbackDetails",
          label: "View Cashback Details",
          trigger: "showCashbackDetails",
        },
        { value: "back", label: "Back", trigger: "option" },
      ],
    },
    {
      id: "showCashbackDetails",
      component: <CashbackDetails orderId={orderId} />,
      asMessage: true,
      trigger: "option",
    },
    // Update success message
    {
      id: "updateSuccess",
      message: "Your account details have been updated successfully!",
      trigger: "option",
    },
    // End message
    {
      id: "end",
      message: "Thankyou for using ConversaBot chatbot!",
      end: true,
    },
  ];

  const navigate = useNavigate();

  return (
    <div>
      <nav
        style={{
          alignItems: "center",
          backgroundColor: "#333",
          color: "white",
          padding: "10px",
          display: "flex",
          justifyContent: "space-between",
          height: "50px",
        }}
      >
        <div
          style={{ marginLeft: "20px", cursor: "pointer" }}
          onClick={() => {
            navigate("/");
          }}
        >
          ConversaBot
        </div>
        <div style={{ marginRight: "20px" }}>
          <button
            onClick={() => {
              const confirmLogout = window.confirm(
                "Are you sure you want to logout?"
              );
              if (confirmLogout) {
                localStorage.removeItem("user");
                window.location.reload();
                navigate("/");
              }
            }}
            style={{
              backgroundColor: "#007bff",
              color: "white",
              border: "none",
              padding: "5px 10px",
              borderRadius: "5px",
              cursor: "pointer",
              height: "30px",
            }}
          >
            Logout
          </button>
        </div>
      </nav>

      <button
        onClick={toggleChatbot}
        style={{
          position: "fixed",
          right: "20px",
          bottom: "20px",
          zIndex: "1001",
          cursor: "pointer",
          padding: "10px", // Increase the padding to make the icon larger
          borderRadius: "30px",
          border: "none",
          backgroundColor: "#FBFADA", // Change the color to red
          color: "black",
          fontWeight: "bold",
          fontSize: "24px", // Increase the font size
          width: "100px",
          height: "50px",
        }}
      >
        {isChatbotVisible ? "X" : "Chat"}
      </button>
      {isChatbotVisible && (
        <div
          style={{
            position: "fixed",
            bottom: "70px", // Adjust based on your button size and desired position
            right: "20px",
            zIndex: "1000",
          }}
        >
          <ChatBot steps={steps} />
        </div>
      )}
    </div>
  );
};

export default Chatbot;
