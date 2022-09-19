import React from 'react';
import { NavLink, useNavigate } from 'react-router-dom';
import classes from './../../components/Sign In Page/SignInPage.module.scss';
import quantum from './../../assets/theater.jpg';
import Input from '../../UI/Input/Input';
import IconEyeToggle from '../../UI/Icons/IconEyeToggle';
import * as yup from "yup";
import { yupResolver } from "@hookform/resolvers/yup";
import { useForm } from "react-hook-form";
import useToggleValue from './../../hooks/useToggleValue';
import { toast } from "react-toastify";
import { useSelector, useDispatch } from "react-redux";
import { register, resetError, setPassword } from '../../app/features/authSlice';

const schema = yup
  .object()
  .shape({
    name: yup.string().required("Vui lòng nhập tên tài khoản"),
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

const SignUpPage = () => {
  const { errorMessage } = useSelector((state) => state.auth);
  const dispatch = useDispatch();
  const navigate = useNavigate();

  const {
    handleSubmit,
    control,
    formState: { errors },
  } = useForm({
    resolver: yupResolver(schema),
    mode: "onSubmit",
  });

  const handleSignUp = (formValue) => {
    dispatch(setPassword(formValue?.password));
    dispatch(register({ formValue, navigate, toast }));
    if (errorMessage !== null) {
      toast.error(errorMessage);
    }
    dispatch(resetError());
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
                Sign Up
            </h3>
        </div>
        <form className={classes.signin__form} onSubmit={handleSubmit(handleSignUp)} method="post">
            <div className={classes.signin__form_formgroup}>
                <div>
                    <Input
                        control={control}
                        name="email"
                        type="email"
                        placeholder="Create email"
                        error={errors.email?.message}
                        autoComplete="off"
                    ></Input>
                </div>
            </div>

            <div className={classes.signin__form_formgroup}>
                <div>
                <Input
                    control={control}
                    name="password"
                    type={`${showPassword ? "text" : "password"}`}
                    placeholder="Create a password"
                    error={errors.password?.message}
                >
                    <IconEyeToggle
                        open={showPassword}
                        onClick={handleTogglePassword}
                    ></IconEyeToggle>
                </Input>
                </div>
            </div>
{/* 
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
            </div> */}
                <NavLink to={'/signin'}>
                    <span>
                        If you had an account? Sign In!
                    </span>
                </NavLink>
            <button className={classes.signin__form__button} type="submit">
                Sign Up
            </button>

        </form>

    </div>
  )
}

export default SignUpPage