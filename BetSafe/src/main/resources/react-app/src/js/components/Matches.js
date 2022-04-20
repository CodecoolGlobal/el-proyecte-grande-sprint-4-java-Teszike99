import {useEffect, useState} from "react";
import MatchPairDiv from "./MatchPairDiv";
import {default as apiGet} from "../data/dataHandler"

const Matches = () => {
    const [data, setData] = useState([])

    useEffect(() => {
        apiGet("/match_pairs")
            .then(response => {setData(response)});
    },[])

    return (
        <div className="main-container">
            <MatchPairDiv matches={data}/>
        </div>
    )
}

export default Matches;


