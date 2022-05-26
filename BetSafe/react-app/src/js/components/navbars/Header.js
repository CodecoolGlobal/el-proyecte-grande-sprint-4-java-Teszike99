import Button from '../contentTools/Button';
import {Link} from "react-router-dom";

const loginButtonTitle = "Login"
const loginButtonClassName = "login-button"
const registerButtonTitle = "Create account"
const registerButtonClassName = "register-button"

const Header = (props) => {
    return (
        <div className="header">
            <h1 className="header-text">BetSafe</h1>
            <a href="/register">Reg</a>
            <a href="/login">Log</a>
        </div>
    )
}

export default Header;