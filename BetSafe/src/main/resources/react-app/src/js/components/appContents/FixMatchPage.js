import {useEffect, useState} from "react";
import {apiGet} from "../../data/dataHandler";
import MatchPair from "../contentTools/MatchPair";

const FixMatchPage = (props) => {
    const [data, setData] = useState([])
    const matchPairList = data.map( matchPair => <MatchPair matchPairData={matchPair}/> );
    useEffect(() => {
        apiGet("fix-match-pairs")
            .then(r => {setData(r)});
    },[])
    console.log(props.filter)
    return (
        <div className="fix-match-page-container">
            {matchPairList}
        </div>
    )
}

export default FixMatchPage;