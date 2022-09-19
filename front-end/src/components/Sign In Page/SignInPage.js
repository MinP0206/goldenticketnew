import React from 'react';
import { NavLink, useNavigate } from 'react-router-dom';
import classes from './SignInPage.module.scss';
import quantum from './../../assets/theater.jpg';
import * as yup from "yup";
import { yupResolver } from "@hookform/resolvers/yup";
import { useForm } from "react-hook-form";
import useToggleValue from './../../hooks/useToggleValue';
import { toast } from "react-toastify";
import { useSelector, useDispatch } from "react-redux";
import IconEyeToggle from '../../UI/Icons/IconEyeToggle';
import Input from '../../UI/Input/Input';
import { login, resetError, setPassword } from "./../../app/features/authSlice";

const schema = yup
  .object()
  .shape({
    email: yup
      .string()
      .required("Vui lòng nhập email")
      .email("Vui lòng nhập email hợp lệ"),
    password: yup
      .string()
      .required("Vui lòng nhập mật khẩu")
      .min(8, "Mật khẩu phải có độ dài tối đa 8 ký tự"),
  })
  .required();
const SignInPage = () => {
  const {
    handleSubmit,
    control,
    formState: { errors },
  } = useForm({
    resolver: yupResolver(schema),
    mode: "onSubmit",
  });
  const { isLoading, errorMessage } = useSelector((state) => state.auth);

  const dispatch = useDispatch();
  const navigate = useNavigate();

  const handleSignIn = (formValue) => {
    dispatch(setPassword(formValue?.password));
    dispatch(login({ formValue, navigate, toast }));
    console.log(formValue);
    if (errorMessage !== null) {
      toast.error(errorMessage);
      dispatch(resetError());
    }
  };

  const { value: showPassword, handleToggleValue: handleTogglePassword } =
    useToggleValue(false);
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
                Sign In
            </h3>
        </div>
        <form onSubmit={handleSubmit(handleSignIn)} className={classes.signin__form}>
            <div className={classes.signin__form_formgroup}>
                <div>
                    <Input className={classes.signin__form__input}
                    control={control}
                    placeholder='example@mail.com'
                    name='email'
                    type='email'
                    error={errors.email?.message}
                    autoComplete="off"
                    />
                </div>
                </div>

            <div className={classes.signin__form_formgroup}>
                <div>
                <Input
                    control={control}
                    name="password"
                    type={`${showPassword ? "text" : "password"}`}
                    placeholder="Enter password"
                    error={errors.password?.message}
                    className={classes.signin__form__input}
                >
                    <IconEyeToggle
                        open={showPassword}
                        onClick={handleTogglePassword}
                    ></IconEyeToggle>
          </Input>
                </div>
            </div>
                <NavLink to={'/signup'}>
                    <span>
                        Haven't a account? Register now!
                    </span>
                </NavLink>
            <button className={classes.signin__form__button} type="submit">
                Sign In
            </button>

        </form>

    </div>
  )
}

export default SignInPage