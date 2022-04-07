import Matches from "./Matches";
import bodyContent from "./BodyContent";
import HomePage from "./HomePage";
import BodyContent from "./BodyContent";

const Navbar = (props) => {
    return (
        <div className="topnav">
            <a href="#">Home</a>
            <a href="#">Sports</a>
            <a href="#">Offices</a>
            <div className="topnav-right">
                <a href="#">Search</a>
            </div>
        </div>
    )
}

export default Navbar;