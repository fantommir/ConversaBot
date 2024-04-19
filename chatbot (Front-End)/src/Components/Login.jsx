import React, { useState } from 'react';
import './Login.css';
import { Link } from 'react-router-dom';
import './Home.css'
function Login({ onLogin, setIsLoggedIn, setaccountId }) {
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const [error, setError] = useState('');


  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      const url = `http://localhost:8080/login?mailId=${email}&password=${password}`;

      const response = await fetch(url, {
        method: 'GET',
        headers: {
          'Content-Type': 'application/json'
        }
      });


      if (!response.ok) {
        throw new Error('Login failed');
      }

      const data = await response.json();
      console.log(data);

      console.log("its here  1");
      onLogin(data);

      setaccountId(data);
      console.log("its here");

      alert('Login successful');

    } catch (error) {
      console.log(error);
      setError('Invalid email or password');
      alert('Login unsuccessful');
    }
  };


  return (
    <body>


      <nav className="navbar" >
        <div className="navbar-brand">
          <div className="chatbot-icon">
            {/* chatbot icon */}
          </div>
          <span className="navbar-name">ConversaBot</span>
        </div>
        <div className="navbar-links">
          <Link to="/login" className="navbar-link">Login</Link>
          <Link to="/register" className="navbar-link">Register</Link>
        </div>
      </nav>


      <div className="login-container">
        <form onSubmit={handleSubmit} className="login-form">
          <h2>Login Here</h2>
          <div className="form-group">
            <label htmlFor="email">Email:</label>
            <input
              type="email"
              id="email"
              value={email}
              //   onChange={handleEmailChange}
              onChange={(e) => setEmail(e.target.value)}
              required
            />
          </div>
          <div className="form-group">
            <label htmlFor="password">Password:</label>
            <input
              type="password"
              id="password"
              value={password}
              //   onChange={handlePasswordChange}
              onChange={(e) => setPassword(e.target.value)}
              required
            />
          </div>
          <div className="Login_btn">
            <button type="submit">Login</button>
          </div>

          <p className="login-link">
            Don't have a account? <span className="login-spacer"></span><Link to="/Register" className="login-link">Register</Link>
          </p>

        </form>

      </div>

    </body>
  );
}

export default Login;
