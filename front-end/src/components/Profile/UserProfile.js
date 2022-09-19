import React, { useRef, useState} from 'react';
import { useForm } from 'react-hook-form';
import { useSelector } from 'react-redux';
import classes from './UserProfile.module.scss';


const UserProfile = () => {

  const { register, handleSubmit } = useForm();
  const imgSourceRef = useRef();
  // const [radioValue, setRadioValue] = useState("Nam");
  // const dateRef = useRef();
  const [isOpen, isOpenModal] = useState(false);
  const [avatar, setAvatar] = useState(null);
  // const [phone, setPhone] = useState("0376621299");
  const emailRef = useRef();
  // const phoneRef = useRef();
  // const onChange = (ev) => {
  //   setRadioValue(ev.target.value);
  // };
  // const gender = ["Nam", "Nữ", "Khác"];

  const onSubmit = (data) => {
    const info = {
      ...data,
      img: imgSourceRef.current.currentSrc,
      email: emailRef.current.value,  
    };
    console.log(info);
  };

  const { userInfo } = useSelector((state) => state.auth);
  console.log(userInfo);

  return (
    <div className={classes.profile}>
    <form
      onSubmit={handleSubmit(onSubmit)}
    >
      <div className={classes.container}>
        <div className={classes.avt}>
          {avatar === null ? (
            <img
              className={classes.avt__img}
              src="https://w7.pngwing.com/pngs/754/2/png-transparent-samsung-galaxy-a8-a8-user-login-telephone-avatar-pawn-blue-angle-sphere-thumbnail.png"
              alt=""
              ref={imgSourceRef}
            ></img>
            ) : (
            <img
              className={classes.avt__img}
              src={avatar}
              alt=""
              ref={imgSourceRef}
            ></img>
          )}

          <button 
            className={classes.avt__changebtn}
            onClick={() => {
              isOpenModal(true);
            }}>
            <span>
              Change avatar
            </span>
            {/* {isOpen && (
              <ChangeAvatarModal
                isOpen={isOpenModal}
                changeAvatar={setAvatar}
              />
            )} */}
          </button>
        </div>
      </div>
        <div className={classes.formgroup}>
          <div className={classes.formgroup__row}>
            <label>
              User name
            </label>
            <input 
              className={classes.formgroup__row__input}
              type="text"
              name=""
              id="name"
              {...register("Name")}
              placeholder="Add user name"
              defaultValue={`${userInfo?.user?.name}`}
            />
          </div>

          <div className={classes.formgroup__row}>
            <label>
              Email
            </label>
            <input 
              className={classes.formgroup__row__input}
              type="text"
              name=""
              id="email"
              {...register("Email")}
              placeholder="Add user Email"
              defaultValue={`${userInfo?.user?.email}`}
              ref={emailRef}
            />
          </div>
          <div>
            <button className={classes.formgroup__buttonsave}>
              <span>
                Save
              </span>
            </button>
          </div>
        </div>

    </form>
    </div>
  )
}

export default UserProfile