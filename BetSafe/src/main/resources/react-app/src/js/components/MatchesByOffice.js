const MatchesByOffice = (props) => {
    console.log(props)
    return (
        <div className="match-pair-container">
            <b className="matches-text">{props.matches.bettingOffice}</b><br></br>
            <b className="matches-text">{props.matches.sportType}</b><br></br>
            <b className="matches-text">{props.matches.matchDate}</b><br></br>
            <b className="matches-text">{props.matches.homeOdds}-{props.matches.players}-{props.matches.guestOdds}</b>
        </div>
    )
}

export default MatchesByOffice;