import Button from '../contentTools/Button';

const loginButtonTitle = "Login"
const loginButtonClassName = "login-button"
const registerButtonTitle = "Create account"
const registerButtonClassName = "register-button"

const Header = (props) => {
    return (
        <div className="header">
            <h1 className="header-text">BetSafe</h1>
            <Button title = {loginButtonTitle} className = {loginButtonClassName} ></Button>
            <Button title = {registerButtonTitle} className = {registerButtonClassName} ></Button>
        </div>
    )
}

export default Header;