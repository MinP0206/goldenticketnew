import React from 'react'
import Button from '../../../UI/Button/Button';
import ProfileIcon from './../../../UI/Logo Profile/LogoProfile';

import classes from './Nav.module.scss';

const Nav = ({isMenu, menuToggle}) => {
  return (
        <nav className={isMenu ? classes.menu__nav : classes.nav}>
            <ul>
                <li onClick={menuToggle}>
                    <a href='/'>
                        Movie
                    </a>
                </li>
                <li onClick={menuToggle}>
                    <a href='/'>
                        News and Event
                    </a>
                </li>
                <li onClick={menuToggle}>
                    <a href='/'>
                        Pricing
                    </a>
                </li>
            </ul>
            <Button outline className={classes.booknow} onClick={menuToggle}>
                Book Now
            </Button>
            <ProfileIcon />
        </nav>
  );
}

export default Nav