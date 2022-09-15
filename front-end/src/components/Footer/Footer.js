import React from 'react';
import classes from './Footer.module.scss';

const Footer = () => {
  return (
    <div>
      <div className={classes.footer}>
        {/* <div class={classes.footer}> */}
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
                <li><img src="https://svgshare.com/i/5eA.svg" width={20} style={{width: 20}} /></li>
                <li><img src="https://svgshare.com/i/5eA.svg" width={20} style={{width: 20}} /></li>
              </ul>
          </div>
        <div className={classes.footer__clearfix}></div>
      </div>
      {/* </div> */}
    </div>

  )
}

export default Footer