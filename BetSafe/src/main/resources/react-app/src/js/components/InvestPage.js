import {useEffect, useState} from "react";
import {apiGet} from "../data/dataHandler";
import MatchPair from "./MatchPair";
const InvestPage = (props) => {

    const [data, setData] = useState([])
    const [investHomeText, setInvestHomeText] = useState(null)
    const [investGuestText, setInvestGuestText] = useState(null)
    const matchPairProfitList = [];
    const matchPairList = data.map( matchPair => <MatchPair matchPairData={matchPair} investHome={investHomeText} investGuest={investGuestText}/> )

    // get the data from db
    useEffect(() => {
        apiGet("/index/profit-matches")
            .then(response => {setData(response)});
    },[])

    // get the input values
    function getHomeInvestData(val){
        setInvestHomeText(val.target.value);
    }

    function getGuestInvestData(val){
        setInvestGuestText(val.target.value);
    }

    console.log(matchPairProfitList);
    return (
        <div className="invest-page-container">
            <div className="invest-container-title row">
                <h3 className="col-sm-6">Best home odds</h3>
                <h3 className="col-sm-6">Best guest odds</h3>
            </div>
            <div className="invest-calculate-container row">
                <div className="col-sm-6">
                    <label htmlFor="inveest-home-odds">Invest home odds:</label>
                    <font color = "black"><input type="text" id="inveest-home-odds" onChange={getHomeInvestData}/></font>
                </div>
                <div className="col-sm-6">
                    <label htmlFor="inveest-guest-odds">Invest guest odds:</label>
                    <font color = "black"><input type="text" id="inveest-guest-odds" onChange={getGuestInvestData}/></font>
                </div>
            </div>
            {matchPairList}
        </div>
    );
}

export default InvestPage;