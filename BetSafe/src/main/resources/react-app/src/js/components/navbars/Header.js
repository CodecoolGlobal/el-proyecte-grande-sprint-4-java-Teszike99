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

            <img className="image-header" id="bats1" src={batsImage} alt=''/>
            <img className="image-header" id="batman" src={batmanImage} alt=''/>
            <img className="image-header" id="bat_title" src={image} alt=''/>
            <img className="image-header" id="bats2" src={batsImage} alt=''/>

        </div>
    )
}

export default Header;