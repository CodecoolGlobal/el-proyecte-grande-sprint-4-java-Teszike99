const Navbar = (props) => {
    return (
        <div className="topnav">
            <a href="#" onClick={() => props.onClick("home")}>Home</a>
            <a href="#" onClick={() => props.onClick("matches")}>All matches</a>
            <a href="#">Offices</a>
            <div className="topnav-right">
                <a href="#">Search</a>
            </div>
        </div>
    )
}

export default Navbar;