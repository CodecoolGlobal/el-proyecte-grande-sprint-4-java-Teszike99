import {useEffect, useState} from "react";
import {apiGet} from "../data/dataHandler";
import MatchPair from "./MatchPair";

const FixMatchPage = () => {
    const [data, setData] = useState([])
    const matchPairList = data.map( matchPair => <MatchPair matchPairData={matchPair}/> );
    useEffect(() => {
        apiGet("/match-pairs")
            .then(response => {setData(response)});
    },[])
    console.log(data)
    return (
        <div className="fix-match-page-container">
            {matchPairList}
        </div>
    )
}

export default FixMatchPage;