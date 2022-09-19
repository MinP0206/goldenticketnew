import React , {useState} from 'react';
import classes from './Leftbar.module.scss';

function Leftbar({ activeButton }) {
    const [avatar, setAvatar] = useState(
        "https://frontend.tikicdn.com/_desktop-next/static/img/account/avatar.png"
      );

    // const { userInfo } = useSelector((state) => state.auth);

  return (
    <div className={classes.leftbar}>
        <div className={classes.leftbar__row}>
            <div className={classes.leftbar__row__title}>
                <span className={classes.leftbar__row__title__span}>
                    User Account
                </span>
            </div>
        </div>

        <div className={classes.leftbar__row}>
            <div className={classes.leftbar__row__title}>
                <span className={classes.leftbar__row__title__span}>
                    Ticket Ordered
                </span>
            </div>
        </div>

    </div>
  )
}

export default Leftbar