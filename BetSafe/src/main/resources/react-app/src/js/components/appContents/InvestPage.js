import {useEffect, useState} from "react";
import {apiGet, apiGetJwt, apiGetWithJwt} from "../../data/dataHandler";
import MatchPair from "../contentTools/MatchPair";
const InvestPage = (props) => {
    const [data, setData] = useState([])
    const [investHomeText, setInvestHomeText] = useState(0);
    const [investGuestText, setInvestGuestText] = useState(0);
    const matchPairList = data.map( matchPair => <MatchPair matchPairData={matchPair} investHome={investHomeText} investGuest={investGuestText} profit={true}/> );
    //list created to check filter type (sport or betting office)
    let sportCategories = ["tennis", "E-sport", "Ping-Pong"];
    let officeCategories = ["BetterBet", "Esport", "MegaGame", "UniBet"];
    // get the data from db\
    let filter = props.filter;ű
    let jwtToken = window.localStorage.getItem("token");

    useEffect(() => {
        if (filter != null){
            if (sportCategories.includes(filter)){
                apiGetWithJwt(`search-sport/${filter}`, jwtToken)
                    .then(r => setData(r))
            }
            else if (officeCategories.includes(filter)){
                apiGetWithJwt(`search-office/${filter}`, jwtToken )
                    .then(r => setData(r))
            }
        }
        else {
            apiGetWithJwt("/match-pairs", jwtToken)
                .then(r => {setData(r)});
        }
    },[filter])
    // get the input values
    function getHomeInvestData(val){
        setInvestHomeText(val.target.value);
    }

    function getGuestInvestData(val){
        setInvestGuestText(val.target.value);
    }
    return (

        <div className="invest-page-container">
            <div className="invest-calculate-container row">
                <div className="col-sm-6">
                    <label htmlFor="invest-home-odds" >Invest home odds:</label>
                    <font color = "black"><input type="number" id="invest-odds" defaultValue={0} onChange={getHomeInvestData}/></font>
                </div>
                <div className="col-sm-6">
                    <label htmlFor="invest-guest-odds">Invest guest odds:</label>
                    <font color = "black"><input type="number" id="invest-odds" defaultValue={0} onChange={getGuestInvestData}/></font>
                </div>
            </div>
            {matchPairList}
        </div>
    );
}

export default InvestPage;