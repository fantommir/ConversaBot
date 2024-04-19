
import React from 'react';
import './Home.css';
import { Link } from 'react-router-dom';
import { Slide } from 'react-slideshow-image';
import 'react-slideshow-image/dist/styles.css';

function Home() {
  return (
    <body>
      <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" integrity="sha384-xxxxxx" crossOrigin="anonymous" />

      <nav className="navbar" >
        <div className="navbar-brand">
          <div className="chatbot-icon">
            {/* chatbot icon */}
          </div>
          <span className="navbar-name">ConversaBot</span>
        </div>
        <div className="navbar-links">
          <a href="#home" className="navbar-link">Home</a>
          <a href="#about" className="navbar-link">About Us</a>
          <a href="#contact" className="navbar-link">Contact</a>
          <Link to="/login" className="navbar-link">Login</Link>
          <Link to="/register" className="navbar-link">Register</Link>
        </div>
      </nav>

      <div id="home" className="content-one">
        <div className="slideshow-card">
          <Slide>
            <div className="each-slide">
              <div className="card-two">
                <img src={require('./Image/slide_three.jpg')} alt="Slide 1" />
              </div>
            </div>
            <div className="each-slide">
              <div className="card-two">
                <img src={require('./Image/slide.jpg')} alt="Slide 2" />
              </div>
            </div>
            <div className="each-slide">
              <div className="card-two">
                <img src={require('./Image/slide_two.png')} alt="Slide 3" />
              </div>
            </div>
            <div className="each-slide">
              <div className="card-two">
                <img src={require('./Image/slide_one.png')} alt="Slide 4" />
              </div>
            </div>
          </Slide>
        </div>
      </div>


      <div id="about" className="content-two">
        <div className="two">
          <p>Welcome to our company! At ConversaBot, we're proud to introduce our innovative chatbot service designed to revolutionize the way you interact with our platform. </p>
          <p>With our chatbot, you can:</p>
          <ul>
            <li>Look out at detailed order information.</li>
            <li>Access account details such as transaction history.</li>
            <li>Modify your profile information, including updating contact details.</li>
            <li>Use buttons which enables seamless interaction without the need to type messages.</li>
          </ul>
          <p>Our mission is to enhance your user experience by providing a seamless and efficient way to interact with our services. Our chatbot is here to assist you every step of the way.</p>
        </div>
      </div>

      <footer className="footer">
        <div className="footer-inner">
          <ul className="footer-menu">
            <li><a href="#">Terms of Service</a></li>
            <li><a href="#">Privacy Policy</a></li>
            <li><a href="#">Cookie Policy</a></li>
            <li><a href="#">FAQ</a></li>
          </ul>
          <p>&copy; 2024 ConversaBot. All rights reserved.</p>
          <div id="contact" className="content-three">
            <div className="card">
              <div className="social-media-icons">
                <a href="#"><img src="https://cdn.jsdelivr.net/gh/simple-icons/simple-icons/icons/facebook.svg" alt="Facebook" /></a>
                <a href="#"><img src="https://cdn.jsdelivr.net/gh/simple-icons/simple-icons/icons/github.svg" alt="Github" /></a>
                <a href="#"><img src="https://cdn.jsdelivr.net/gh/simple-icons/simple-icons/icons/instagram.svg" alt="Instagram" /></a>
                <a href="#"><img src="https://cdn.jsdelivr.net/gh/simple-icons/simple-icons/icons/linkedin.svg" alt="Instagram" /></a>
              </div>
            </div>
          </div>
        </div>
      </footer>
    </body>
  );
}

export default Home;