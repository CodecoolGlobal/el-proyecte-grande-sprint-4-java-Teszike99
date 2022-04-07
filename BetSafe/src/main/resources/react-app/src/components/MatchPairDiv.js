import MatchDiv from "./MatchDiv";

const MatchPairDiv = (props) => {
    let pairlyFirstMatch = 0;
    let matchComponents = props.matches.map(matchPair =>
        <div className="matchPair row">
            <h5>{matchPair[pairlyFirstMatch].matchDate}  {matchPair[pairlyFirstMatch].players}</h5>
            {(<MatchDiv className="match column" datas={matchPair.map(match =>
            <div className="matchTitle">
                <div className="matchOdds">
                    <h4>Winner Odds: {match.winnerOdds}</h4>
                    <h4>Lose odds: {match.loseOdds}</h4>
                </div>
                <h5>{match.bettingOffice}</h5>
            </div>)} />)}
        </div>)


    return (
        <div>
            <h4>{matchComponents}</h4>
        </div>
    )
}

export default MatchPairDiv;