import React from 'react';
import classes from './Footer.module.scss';
import { FaYoutube, FaInstagram, FaFacebook } from "react-icons/fa";

const socials = [
  <FaFacebook />,
  <FaInstagram />,
  <FaYoutube />
]
const Footer = () => {
  return (
    <div className={classes.container}>
      <div className={classes.footer}>
          <div className={classes.footer__col}>
            <h1>Golden Ticket</h1>
              <ul>
                <li>About us</li>
                <li>Mission</li>
              </ul>
          </div>
          <div className={classes.footer__col}>
            <h1>Movie World</h1>
              <ul>
                <li>About</li>
                <li>Mission</li>
              </ul>
          </div>
          <div className={classes.footer__col}>
            <h1>Help</h1>
              <ul>
                <li>Webmail</li>
                <li>WHOIS lookup</li>
              </ul>
          </div>
          <div className={classes.footer__col__socials}>
            <h1>Social</h1>
            <ul>
              {socials.map((icon, index)=>(
                <li key={index+1}>
                  <a href='/'>{icon}</a>
                </li>
              ))}
            </ul>
          </div>
        <div className={classes.footer__clearfix}></div>
      </div>
    </div>

  )
}

export default Footer