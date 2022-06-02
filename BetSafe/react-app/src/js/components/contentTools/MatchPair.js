const MatchPair = (props) =>  {
    let firstMatch = props.matchPairData[0];
    let secondMatch = props.matchPairData[1];
    let investHome = parseFloat(props.investHome);
    let investGuest = parseFloat(props.investGuest);
    let sumInvest = investHome + investGuest;
    let fixProfit = parseFloat(calculateProfit() * 100).toFixed(2) < 0 ? parseFloat(calculateProfit() * 100).toFixed(2) * (-1) : parseFloat(calculateProfit() * 100).toFixed(2);

    function calculateProfit(){
        let firstCaseProfit = 0;
        let secondCaseProfit = 0;
        if ( (secondMatch.homeOdds * firstMatch.guestOdds) > secondMatch.homeOdds + firstMatch.guestOdds){
            firstCaseProfit = 1 - (firstMatch.homeOdds * secondMatch.guestOdds)/(firstMatch.homeOdds + secondMatch.guestOdds)
        }
        if ((secondMatch.guestOdds * firstMatch.homeOdds) > secondMatch.guestOdds + firstMatch.homeOdds){
            secondCaseProfit = 1 - (firstMatch.guestOdds * secondMatch.homeOdds)/(firstMatch.guestOdds + secondMatch.homeOdds)
        }
        return firstCaseProfit > secondCaseProfit ? firstCaseProfit : secondCaseProfit;
    }
    //  invest page containers
    let homeProfitContainer = <div className="odds-container">
        <h3><font color = "#ff4500">Home odds: </font><font color= "#ff4500"><b>{firstMatch.homeOdds}</b></font></h3>
        <h3>Guest odds: <font><b>{firstMatch.guestOdds}</b></font></h3>
        <h3>Profit: {investHome * parseFloat(firstMatch.homeOdds) - sumInvest}</h3>
    </div>
    let guestProfitContainer= <div className="odds-container">
        <h3>Home odds: <b>{secondMatch.homeOdds}</b></h3>
        <h3><font color = "#ff4500">Guest odds: </font><font color= "#ff4500"><b>{secondMatch.guestOdds}</b></font></h3>
        <h3>Profit: {investGuest * parseFloat(secondMatch.guestOdds) - sumInvest}</h3>
    </div>
    // fix profit page container
    let fixProfitContainerSecondMatch =  <div className="odds-container">
        <h3>Home odds: <b>{secondMatch.homeOdds}</b></h3>
        <h3>Guest odds: <b>{secondMatch.guestOdds}</b></h3>
    </div>
    let fixProfitContainerFirstMatch = <div className="odds-container">
        <h3>Home odds: <b>{firstMatch.homeOdds}</b></h3>
        <h3>Guest odds: <b>{firstMatch.guestOdds}</b></h3>
    </div>

    return (
        <div className= "match-pair-container row">
            <div className="match-title row" id="sport">{firstMatch.sportType}</div>
            <div className="match-title row" id="players">{firstMatch.players.replace(',', " - ")}</div>
            <div className="match-title row" id="time">{firstMatch.matchDate.replace(firstMatch.matchDate.charAt(0), firstMatch.matchDate.charAt(0).toUpperCase())} </div>
            <div className="match-odds-title row ">
                <h3 className="match-title row" id="bestHome">Best home odds</h3>
                <h3 className="match-title row" id="bestGuest">Best guest odds</h3>
            </div>
            <div className="match-content-container m-4">
                <div className="match-container first-match col-sm-6">
                    <h3><b>{firstMatch.bettingOffice}</b></h3>
                    {props.profit ? homeProfitContainer : fixProfitContainerFirstMatch}
                </div>
                <div className="match-container second-match col-sm-6">
                    <h3><b>{secondMatch.bettingOffice}</b></h3>
                    {props.profit ? guestProfitContainer : fixProfitContainerSecondMatch}
                </div>
            </div>
            <div className= "fixProfitTitle">{props.profit ? null : "The profit percentage: " + fixProfit.toString() + " %"}</div>
        </div>
    )
}
export default MatchPair;