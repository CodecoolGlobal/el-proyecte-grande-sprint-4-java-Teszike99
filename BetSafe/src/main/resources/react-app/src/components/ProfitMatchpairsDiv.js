import {useEffect, useState} from "react";
import {matches} from "@testing-library/jest-dom/dist/utils";

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
                {matches}
            </ul>
        </div>
    )
}

export default ProfitMatchpairsDiv;


