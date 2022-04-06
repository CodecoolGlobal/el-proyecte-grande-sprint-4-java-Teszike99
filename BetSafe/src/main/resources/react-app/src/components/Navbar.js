const Navbar = (props) => {
    return (
        <div className="topnav">
            <a className="active" href="#">Home</a>
            <a href="#">Sports</a>
            <a href="#">Offices</a>
            <div className="topnav-right">
                <a href="#">Search</a>
            </div>
        </div>
    )
}

export default Navbar;