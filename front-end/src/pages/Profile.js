import React, { Fragment } from 'react';
import Footer from '../components/Footer/Footer';
import Header from '../components/Header/Header';
import UserProfile from '../components/Profile/UserProfile';

const Profile = () => {
  return (
    <Fragment>
      <Header></Header>
      <UserProfile />
      <Footer></Footer>
  </Fragment>
  )
}

export default Profile