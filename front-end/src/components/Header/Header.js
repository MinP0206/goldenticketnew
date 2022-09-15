import React, { useState } from 'react';
import { CgMenuRight, CgClose } from 'react-icons/cg';
import Logo from '../../UI/Logo/Logo';
import classes from './Header.module.scss';
import Nav from './Nav/Nav';

const Header = () => {
    const [menuOpen, setMenuOpen] = useState(false);

    const handleMenuToggle = () =>{
        setMenuOpen((p) => !p)
    };

    const menuToggle = !menuOpen ? (
        <CgMenuRight onClick={handleMenuToggle} />
    ):  (
        <CgClose onClick={handleMenuToggle}/>
    )
    
  return (
    <header className={classes.header}>
        <Logo />
        <Nav />
        <div className={classes.header__menu}>
            <div className={classes.header__menu__toggle}>
                {menuToggle}
            </div>
            <aside className={`${classes.menu} ${menuOpen && classes.show}`}>
                <Nav isMenu menuToggle={handleMenuToggle} />
            </aside>
        </div>
    </header>
  )
}

export default Header