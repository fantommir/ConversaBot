import React, { useState } from 'react';
import './Register.css'; // Import the CSS file
import './Home.css'
import { Link, useNavigate } from 'react-router-dom';
function Register() {
  const [fullName, setFullName] = useState('');
  const [email, setEmail] = useState('');
  const [phone, setPhone] = useState('');
  const [password, setPassword] = useState('');
  const [confirmPassword, setConfirmPassword] = useState('');


  const handleSubmit = async (e) => {
    e.preventDefault();
    // Check if passwords match
    if (password !== confirmPassword) {
      alert('Passwords do not match');
      return;
    }

    try {
      const response = await fetch(`http://localhost:8080/accounts/CheckEmail?email=${email}`);
      if (!response.ok) {
        throw new Error('Failed to check email existence');
      }
      const isEmailExists = await response.json();

      if (isEmailExists) {
        alert('Email already exists. Please use a different email.');
        return;
      }
    } catch (error) {
      console.error('Error checking email existence:', error.message);
      alert('Error checking email existence. Please try again.');
      return;
    }

    // Create a user object with the form data
    const user = {
      userName: fullName,
      mailId: email,
      phone: phone,
      password: password
    };

    try {
      const response = await fetch('http://localhost:8080/signup', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json'
        },
        body: JSON.stringify(user)
      });

      // Check if the request was successful
      if (!response.ok) {
        throw new Error('Registration failed');
      }

      // Registration successful
      alert('Registration successful');
      navigate('/login')
      // Reset the form fields
      setFullName('');
      setEmail('');
      setPhone('');
      setPassword('');
      setConfirmPassword('');
    } catch (error) {
      console.error('Registration error:', error.message);
      alert('Registration failed');
    }
  };



  const navigate = useNavigate();

  return (
    <>
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

      <div className="register-container">
        <form onSubmit={handleSubmit} className="register-form">
          <h2>Register Here</h2>
          <div className="form-group">
            <label htmlFor="fullName">Full Name:</label>
            <input
              type="text"
              id="fullName"
              value={fullName}
              onChange={(e) => setFullName(e.target.value)}
              required
            />
          </div>
          <div className="form-group">
            <label htmlFor="email">Email-ID:</label>
            <input
              type="email"
              id="email"
              value={email}
              onChange={(e) => setEmail(e.target.value)}
              required
            />
          </div>
          <div className="form-group">
            <label htmlFor="phone">Phone-On:</label>
            <input
              type="tel"
              id="phone"
              value={phone}
              onChange={(e) => {
                const enteredValue = e.target.value;
                const numericValue = enteredValue.replace(/\D/g, '');
                const limitedValue = numericValue.slice(0, 10);
                setPhone(limitedValue);
              }}
              maxLength={10}
              required
            />
          </div>
          <div className="form-group">
            <label htmlFor="password">Password:</label>
            <input
              type="password"
              id="password"
              value={password}
              onChange={(e) => setPassword(e.target.value)}
              required
            />
          </div>
          <div className="form-group">
            <label htmlFor="confirmPassword">Confirm Password:</label>
            <input
              type="password"
              id="confirmPassword"
              value={confirmPassword}
              onChange={(e) => setConfirmPassword(e.target.value)}
              required
            />
          </div>
          <div className='button_submit'>
            <button type="submit">Register</button>
          </div>
          <p className="login-link">
            Already have an account? <span className="login-spacer"></span><Link to="/login" className="login-link">Login</Link>
          </p>
        </form>

      </div>
    </>
  );
}

export default Register;
