import MatchDiv from "../components/MatchDiv";
import image from "../../images/bet.png";

export let elementFactory = {
    matchPairFactory: function (props){
        let evenFirstMatch = 0;
        return props.matches.map(matchPair =>
            <div className="matchPair row">
                <h5>{matchPair[evenFirstMatch].matchDate} {matchPair[evenFirstMatch].players}</h5>
                {(<MatchDiv className="match column" datas={matchPair.map(match =>
                    <div className="matchTitle">
                        <div className="matchOdds">
                            <h4>Home Odds: {match.homeOdds}</h4>
                            <h4>Guest odds: {match.guestOdds}</h4>
                        </div>
                        <h5>{match.bettingOffice}</h5>
                    </div>)}/>)}
            </div>);
    },

    homePageFactory: function (){
        return <div className="main-container">
            <h1>Live your life, free from risk</h1><br></br>
            <img className="image-container" src={image} alt=''/>
            <br/><br/><br/>
            <b>
                BetSafe is an online betting company that offers online sports betting.
                On this site you can place sports bets with the least possible risk.
                You can enter a sum of money after which the site calculates the best options
                based on match odds and betting offices.
            </b>
        </div>;
    }
}