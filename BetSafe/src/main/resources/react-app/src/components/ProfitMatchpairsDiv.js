import {useEffect, useState} from "react";
import MatchPairDiv from "./MatchPairDiv";

const helperObject = {
    name: null,
    matches: []
}

const ProfitMatchpairsDiv = (props) => {
    const [data, setData] = useState(helperObject)

    useEffect(() => {
        const apiGet = () => {
            fetch("/index/profit-matches")
                .then((response) => response.json())
                .then((json) => {
                    setData(json);
                });
        }
        apiGet();
    },[])

    const matches = data.matches.map(match => <li>{match.players} <b>Date: {match.matchDate}</b></li>)

    return (
        <div>
            <ul>
                <MatchPairDiv matches={matches}/>
            </ul>
        </div>
    )
}

export default ProfitMatchpairsDiv;


