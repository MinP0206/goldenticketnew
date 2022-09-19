import React, { Fragment } from 'react';
import Footer from '../components/Footer/Footer';
import Header from '../components/Header/Header';
import PageWasNotFound from './../components/Page Not Found/PageWasNotFound';

const PageNotFound = () => {
  return (
    <Fragment>
        <Header/>
        <PageWasNotFound />
        <Footer/>
    </Fragment>
  )
}

export default PageNotFound