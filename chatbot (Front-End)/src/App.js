// App.js
import React, { useState } from 'react';
import { BrowserRouter as Router, Route, Routes, Navigate  } from 'react-router-dom';
import Home from './Components/Home';
import Bot from './Chatbot/Bot';
import Register from './Components/Register';
import Login from './Components/Login';

function App() {
  const [isLoggedIn, setIsLoggedIn] = useState(false); // Initially, the user is not logged in
  const [userData, setUserData] = useState(null);
  const [accountId, setaccountId] = useState(null);
  
  // Function to handle successful login
  const handleLogin = (data) => {
    setIsLoggedIn(true); // Set isLoggedIn to true when user logs in successfully
    setUserData(data);
  };

  return (
    <div className="App">
      <Router>
        <Routes>
          <Route path='/' element={<Home />}>
        </Route>
          <Route exact path="/Login" element={isLoggedIn ? <Navigate to="/Bot" /> : <Login onLogin={handleLogin} setaccountId={setaccountId}/>}/>
          <Route path="/Bot" element={isLoggedIn ? <Bot userData={userData} accountId={accountId}/> : <Navigate to="/" />} />
        </Routes>

        <Routes>
          <Route path='/register' element={<Register />}></Route>
          {/* <Route exact path='/login' element={<Login/>}></Route> */}
        </Routes>

        <Routes>
          <Route path='/home' element={<Home />}></Route>
        </Routes>

      </Router>
    </div>
  );
}

export default App;
