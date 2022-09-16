import React from 'react';
import { NavLink } from 'react-router-dom';
import classes from './../../components/Sign In Page/SignInPage.module.scss';
import quantum from './../../assets/theater.jpg';

const SignUpPage = () => {
  return (
    <div className={classes.signin}>
        <img
            className={classes.img}
            src={quantum}
        ></img>
        <div>
            <h2 className={classes.signin__title}>
                Welcome to Golden Ticket Website Booking
            </h2>
        </div>
        <div>
            <h3 className={classes.signin__title__h3}>
                Sign Up
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

            <div className={classes.signin__form_formgroup}>
                <div>
                    <input  className={classes.signin__form__input}
                    placeholder='Re-enter Password'
                    type="password"/>
                </div>
            </div>
                <NavLink to={'/signin'}>
                    <span>
                        If you had an account? Sign In!
                    </span>
                </NavLink>
            <button className={classes.signin__form__button}>
                Sign Up
            </button>

        </form>

    </div>
  )
}

export default SignUpPage