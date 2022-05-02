const LeftNavbar = (props) => {
    return (
        <div className="left-nav col-md">
            <div onClick={event => props.setFilter("tennis")}>Tennis</div>
            <div onClick={event => props.setFilter("E-sport")}>E-sport</div>
            <div onClick={event => props.setFilter("Ping-Pong")}>PinPong</div>
        </div>
    )
}

export default LeftNavbar;