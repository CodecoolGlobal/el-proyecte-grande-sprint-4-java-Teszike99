import {useEffect, useState} from "react";
import {apiGet} from "../data/dataHandler";

const FixMatchPage = () => {
    const [data, setData] = useState([])
    useEffect(() => {
        apiGet("/match-pairs")
            .then(response => {setData(response)});
    },[])
    console.log(data)
    return (
        <div>
            Fix Match Page
        </div>
    )
}

export default FixMatchPage;