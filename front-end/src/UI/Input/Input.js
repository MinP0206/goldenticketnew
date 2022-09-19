import React from 'react'
import PropTypes from 'prop-types'
import { useController } from "react-hook-form";
import { withErrorBoundary } from "react-error-boundary";
import classes from './Input.module.scss';

function Input(props) {
    const {
        id,
        control,
        name,
        type,
        error = "",
        placeholder = "",
        children,
        ...rest
      } = props;
      const { field } = useController({
        control,
        name,
        defaultValue: "",
      });
  return (
    <div className={classes.container}>
        <input
        id={name}
        type={type}
        placeholder={error.length <= 0 ? placeholder : ""}
        {...rest}
        {...field}
        />
    {error.length > 0 && (
        <p>
          {error}
        </p>
      )}
      {children && (
        <span>
          {children}
        </span>
      )}
    </div>
  )
}

Input.propTypes = {
    name: PropTypes.string,
    type: PropTypes.string,
    control: PropTypes.any.isRequired,
}

export default Input
