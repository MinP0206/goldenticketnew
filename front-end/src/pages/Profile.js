import React, { Fragment } from 'react';
import Footer from '../components/Footer/Footer';
import Header from '../components/Header/Header';
import UserProfile from '../components/Profile/UserProfile';
import Leftbar from './../components/common/Leftbar/Leftbar';

const Profile = ({activeButton,changeAvatar}) => {
  return (
    <Fragment>
      <Header></Header>
      <Leftbar activeButton={activeButton}/>
      <UserProfile />
      {/* <Rightbar /> */}
      <Footer></Footer>
  </Fragment>
  )
}

export default Profile