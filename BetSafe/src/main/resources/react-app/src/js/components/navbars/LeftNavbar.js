const LeftNavbar = (props) => {
    return (
        <div className="left-nav col-md">
            <div onClick={event => props.setFilter("tennis")}>Tennis</div>
            <div onClick={event => props.setFilter("e-sport")}>E-sport</div>
            <div onClick={event => props.setFilter("ping-pong")}>PinPong</div>
        </div>
    )
}

export default LeftNavbar;