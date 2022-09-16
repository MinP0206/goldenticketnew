import React from 'react';
import { NavLink } from 'react-router-dom';
import classes from './SignInPage.module.scss';

const SignInPage = () => {
  return (
    <div className={classes.signin}>
        <div>
            <h2 className={classes.signin__title}>
                Welcome to Golden Ticket Website Booking
            </h2>
        </div>
        <div>
            <h3 className={classes.signin__title__h3}>
                Sign In
            </h3>
        </div>
        <form className={classes.signin__form}>
            <div className={classes.signin__form_formgroup}>
                <div>
                    <input className={classes.signin__form__input}
                    placeholder='Enter Email'
                    type="text"/>
                </div>
                </div>

            <div className={classes.signin__form_formgroup}>
                <div>
                    <input  className={classes.signin__form__input}
                    placeholder='Enter Password'
                    type="password"/>
                </div>
            </div>
                <NavLink to={'/signup'}>
                    <span>
                        Haven't a account? Register now!
                    </span>
                </NavLink>
            <button className={classes.signin__form__button}>
                Sign In
            </button>

        </form>

    </div>
  )
}

export default SignInPage