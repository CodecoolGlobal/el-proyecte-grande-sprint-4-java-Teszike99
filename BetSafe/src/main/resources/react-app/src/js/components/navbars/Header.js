const Header = (props) => {
    return (
        <div className="header">
            <h1 className="header-text">BetSafe</h1>
            {props.currentUser ?
                <p>
                    {props.currentUser}
                </p>
                :
                <p>
                    <a href="/authenticate">Login</a>
                </p>}
            {props.currentUser ?
                <p><a onClick={() => {
                    props.logOut();
                }}>Log out</a></p>
                :
                <p>
                    <a href="/register">Register</a>
                </p>
            }
        </div>
    )
}

export default Header;