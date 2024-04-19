import React from "react";
import Chatbot from "./Chatbot";
import "./Bot.css";

function Bot({ userData, accountId }) {
  return (
    <div className="main">
      <div className="background-image">
        <Chatbot userData={userData} accountId={accountId} />

        <div className="columns-container">
          <div className="left-column">
            {/* Add images or content for left column */}
          </div>

          <div className="right-column">
            {/* Add images or content for right column */}
          </div>
        </div>
      </div>
    </div>
  );
}

export default Bot;
