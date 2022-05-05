const LeftNavbar = (props) => {
    return (
        <div className="left-nav col-md">
            <div><h3>SportType:</h3></div>
            <div onClick={event => props.setFilter("tennis")}>Tennis</div>
            <div onClick={event => props.setFilter("E-sport")}>E-sport</div>
            <div onClick={event => props.setFilter("Ping-Pong")}>PinPong</div><br/><br/>
            <div><h3>BettingOffice:</h3></div>
            <div onClick={event => props.setFilter("BetterBet")}>BetterBet</div>
            <div onClick={event => props.setFilter("Esport")}>Esport</div>
            <div onClick={event => props.setFilter("MegaGame")}>MegaGame</div>
            <div onClick={event => props.setFilter("UniBet")}>UniBet</div>

        </div>
    )
}

export default LeftNavbar;