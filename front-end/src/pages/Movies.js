import React, { Fragment } from 'react';
import Header from '../components/Header/Header';
import Footer from '../components/Footer/Footer';
import Movie from "../components/Movies/Movie";

const Home = () => {
  return (
    <Fragment>
      <Header />
        <Movie/>
      <Footer />
    </Fragment>
  )
}

export default Home