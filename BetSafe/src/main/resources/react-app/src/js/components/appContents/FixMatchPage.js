import {useEffect, useState} from "react";
import {apiGet, apiGetWithJwt} from "../../data/dataHandler";
import MatchPair from "../contentTools/MatchPair";

const FixMatchPage = (props) => {
    const [data, setData] = useState([])
    const matchPairList = data.map( matchPair => <MatchPair matchPairData={matchPair}/> );
    //list created to check filter type (sport or betting office)
    let sportCategories = ["tennis", "E-sport", "Ping-Pong"];
    let officeCategories = ["BetterBet", "Esport", "MegaGame", "UniBet"];
    let filter = props.filter;
    let jwtToken = window.localStorage.getItem("token");

    useEffect(() => {
        if (filter != null){
            if (sportCategories.includes(filter)){
                apiGetWithJwt(`search-sport/${filter}`, jwtToken)
                    .then(r => setData(r))
            }
            else if (officeCategories.includes(filter)){
                apiGetWithJwt(`search-office/${filter}`, jwtToken)
                    .then(r => setData(r))
            }
        }
        else {
            apiGetWithJwt("/fix-match-pairs", jwtToken)
                .then(r => {setData(r)});
        }
    },[filter])

    return (
        <div className="fix-match-page-container">
            {matchPairList}
        </div>
    )
}

export default FixMatchPage;