import React from 'react';
import classes from './PageWasNotFound.module.scss';
import imgnotfound from './../../assets/404.jpg';

function PageNotFound() {
  return (
    <div className={classes.container}>
        <img
            className={classes.img}
            src={imgnotfound}
        ></img>
    </div>
  )
}

export default PageNotFound