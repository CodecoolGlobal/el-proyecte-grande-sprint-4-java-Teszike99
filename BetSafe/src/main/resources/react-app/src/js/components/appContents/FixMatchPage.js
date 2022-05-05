import {useEffect, useState} from "react";
import {apiGet} from "../../data/dataHandler";
import MatchPair from "../contentTools/MatchPair";

const FixMatchPage = (props) => {
    const [data, setData] = useState([])
    const matchPairList = data.map( matchPair => <MatchPair matchPairData={matchPair}/> );
    //list created to check filter type (sport or betting office)
    let sportCategories = ["tennis", "E-sport", "Ping-Pong"];
    let officeCategories = ["BetterBet", "Esport", "MegaGame", "UniBet"];
    let filter = props.filter;

    useEffect(() => {
        if (filter != null){
            if (sportCategories.includes(filter)){
                apiGet(`search-sport/${filter}`)
                    .then(r => setData(r))
            }
            else if (officeCategories.includes(filter)){
                apiGet(`search-office/${filter}`)
                    .then(r => setData(r))
            }
        }
        else {
            apiGet("/fix-match-pairs")
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