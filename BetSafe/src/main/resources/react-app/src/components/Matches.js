import {useEffect, useState} from "react";
import MatchPairDiv from "./MatchPairDiv";
import {default as apiGet} from "../data/dataHandler"

const Matches = () => {
    const [data, setData] = useState([])

    useEffect(() => {
        apiGet("/index/profit-matches")
            .then(response => {setData(response)});
    },[])

    return (
        <div>
            <MatchPairDiv matches={data}/>
        </div>
    )
}

export default Matches;


