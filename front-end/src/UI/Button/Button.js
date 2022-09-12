import React from 'react';
import classes from './Button.module.scss';

const Button = ({ outline, children, onClick }) => {
  return (
    <button onClick={onClick} className={`${classes.button} ${outline ? classes.outline: ""}`}>
        {children}
    </button>
  )
}

export default Button