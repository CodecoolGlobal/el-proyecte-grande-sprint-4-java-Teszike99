import Button from '../contentTools/Button';
import {Link} from "react-router-dom";
import image from "../../../images/bat.png";
import batmanImage from "../../../images/batman.png";
import batsImage from "../../../images/bats.png";

const loginButtonTitle = "Login"
const loginButtonClassName = "login-button"
const registerButtonTitle = "Create account"
const registerButtonClassName = "register-button"

 const Header = (props) => {
     return (
         <div className="header">
             <img className="image-header" id="batman" src={batmanImage} alt=''/>
             <img className="image-header" id="bat_title" src={image} alt=''/>
             <b className="sub-title">Live your life, free from risk</b>
         </div>

    )
}

export default Header;
