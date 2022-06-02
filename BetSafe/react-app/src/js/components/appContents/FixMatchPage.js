import {useEffect, useState} from "react";
import {apiGet, apiGetWithJwt} from "../../data/dataHandler";
import MatchPair from "../contentTools/MatchPair";
import {useNavigate} from "react-router-dom";

const FixMatchPage = (props) => {
    const [data, setData] = useState([])
    const matchPairList = data.map( matchPair => <MatchPair matchPairData={matchPair}/> );
    //list created to check filter type (sport or betting office)
    let sportCategories = ["tennis", "E-sport", "Ping-Pong"];
    let officeCategories = ["BetterBet", "Esport", "MegaGame", "UniBet"];
    let filter = props.filter;
    let jwtToken = window.localStorage.getItem("token");
    const navigate = useNavigate();

    useEffect(() => {
        if (filter != null){
            if (sportCategories.includes(filter)){
                apiGetWithJwt(`search-sport/${filter}`, jwtToken)
                    .then(r => handleAuthentication(r))
            }
            else if (officeCategories.includes(filter)){
                apiGetWithJwt(`search-office/${filter}`, jwtToken)
                    .then(r => handleAuthentication(r))
            }
        }
        else {
            apiGetWithJwt("/fix-match-pairs", jwtToken)
                .then(r => {handleAuthentication(r)});
        }
    },[filter])

    function handleAuthentication(response) {
        if (response===401) {
            navigate("/authenticate")
        }
        else {
            setData(response)
        }
    }

    return (
        <div className="fix-match-page-container">
            {matchPairList}
        </div>
    )
}

export default FixMatchPage;