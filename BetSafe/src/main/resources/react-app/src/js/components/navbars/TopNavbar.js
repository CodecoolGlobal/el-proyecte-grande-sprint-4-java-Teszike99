import { Link } from "react-router-dom";

const TopNavbar = (props) => {
    return (
        <div className="topnav">
            <Link to="/" >Home</Link>
            <Link to="/invest-page">Invest calculator</Link>
            <Link to="/fix-match-page">Fix matches</Link>
            <a href="#">Offices</a>
            <div className="topnav-right">
                <a href="#">Search</a>
            </div>
        </div>
    )
}

export default TopNavbar;