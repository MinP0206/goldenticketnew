import React, { Fragment } from "react";
import Button from "./../../UI/Button/Button";

// import coverVID from "./../../assets/cover.mp4";
import poster from "./../../assets/poster.jpg";

import classes from "./Hero.module.scss";

const HomePageContent = () => {
    return (
        <Fragment>
            <h1 className={classes.hero__content__title}>the movies are waiting you</h1>
            <span className={classes.hero__content__tagline}>
            LET US KNOW WHAT MOVIES YOU LIKE TO WATCH?
            </span>
            <p className={classes.hero__content__description}>
            We provide the best service, fastest, make you most satisfied
            </p>
            <div className={classes.hero__content__cta}>
                <Button to="/booknow">Book Now</Button>
                <Button to="/learnmore" outline>
                    Learn More
                </Button>
            </div>
        </Fragment>
    );
};

const Hero = ({ isDynmic, children }) => {
    return (
        <div className={classes.container}>
            <img
                className={classes.img}
                src={poster}
            ></img>
            <div className={classes.hero}>
                <div className={classes.hero__content}>
                    {!isDynmic && <HomePageContent />}
                    {isDynmic && <h1 className={classes.hero__content__title}>{children}</h1>}
                </div>
            </div>
        </div>
    );
};

export default Hero;
