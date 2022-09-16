import React, { Fragment } from 'react';
import Header from '../components/Header/Header';
import Footer from '../components/Footer/Footer';
import Hero from '../components/Hero/Hero';

const Home = () => {
  return (
    <Fragment>
      <Header />
        Homepage
        <Hero/>
      <Footer />
    </Fragment>
  )
}

export default Home