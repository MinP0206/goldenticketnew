import React from 'react'
import Button from '../../../UI/Button/Button';
import Search from '../../Search/Search';

import classes from './Nav.module.scss';

const Nav = ({isMenu, menuToggle}) => {
  return (
        <nav className={isMenu ? classes.menu__nav : classes.nav}>
            <ul>
                <li>
                    <Search />
                </li>
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
                        Book now
                    </a>
                </li>
            </ul>
            <Button outline className={classes.booknow} onClick={menuToggle}>
                Sign-in
            </Button>
        </nav>
  );
}

export default Nav