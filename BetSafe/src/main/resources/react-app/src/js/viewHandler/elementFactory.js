import MatchPair from "../components/MatchPair";
import image from "../../images/bet.png";

export let elementFactory = {
    /*matchPairFactory: function (props){
        let evenFirstMatch = 0;
        return props.matches.map(matchPair =>
            <div className="match-pair-container">
                <div className="match-title">{matchPair[evenFirstMatch].matchDate} {matchPair[evenFirstMatch].players}</div>
                <div className="match-pair row">
                    {(<MatchPair className="match" datas={matchPair.map(match =>
                        <div class="col-sm-5">
                            <h5>{match.bettingOffice}</h5>
                            <div className="matchOdds">
                                <h4>Home Odds: {match.homeOdds}</h4>
                                <h4>Guest odds: {match.guestOdds}</h4>
                            </div>
                        </div>)}/>)}
                </div>
            </div>);
    },*/

    homePageFactory: function (){
        return <div className="home-container">
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