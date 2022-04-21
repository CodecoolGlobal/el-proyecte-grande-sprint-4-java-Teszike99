const MatchPair = (props) =>  {
    let firstMatch = props.matchPairData[0];
    let secondMatch = props.matchPairData[1];
    let investHome = parseFloat(props.investHome);
    let investGuest = parseFloat(props.investGuest);
    let profitElementHome =  <h3>Profit: {investHome * parseFloat(firstMatch.homeOdds)}</h3>
    let profitElementGuest = <h3>Profit: {investGuest * parseFloat(secondMatch.guestOdds)}</h3>


    return (
        <div className= "match-pair-container row">
            <div className="match-title row">{firstMatch.matchDate} {firstMatch.players}</div>
            <div className="match-content-container">
                <div className="match-container first-match col-sm-6">
                    <h3><b>{firstMatch.bettingOffice}</b></h3>
                    <div className="odds-container">
                        <h3><font color = "#ff4500">Home odds: </font><font color= "#ff4500"><b>{firstMatch.homeOdds}</b></font></h3>
                        <h3>Guest odds: <font><b>{firstMatch.guestOdds}</b></font></h3>
                        {props.profit ? profitElementHome : null}
                    </div>
                </div>
                <div className="match-container second-match col-sm-6">
                    <h3><b>{secondMatch.bettingOffice}</b></h3>
                    <div className="odds-container">
                        <h3>Home odds: <b>{secondMatch.homeOdds}</b></h3>
                        <h3><font color = "#ff4500">Guest odds: </font><font color= "#ff4500"><b>{secondMatch.guestOdds}</b></font></h3>
                        {props.profit ? profitElementGuest : null}
                    </div>
                </div>
            </div>
        </div>
    )
}
export default MatchPair;