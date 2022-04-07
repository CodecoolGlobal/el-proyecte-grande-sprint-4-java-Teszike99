import {useEffect, useState} from "react";
import MatchPairDiv from "./MatchPairDiv";

const ProfitMatchpairsDiv = (props) => {
    const [data, setData] = useState([])

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

    return (
        <div>
            <MatchPairDiv matches={data}/>
        </div>
    )
}

export default ProfitMatchpairsDiv;


