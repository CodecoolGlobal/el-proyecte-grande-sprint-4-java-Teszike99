import SportCategory from "./SportCategory";
import BodyContent from "./BodyContent";
import {useEffect, useState} from "react";
import {apiGet} from "../data/dataHandler";

const Body = (props) => {
    const [data, setData] = useState([])

    useEffect(() => {
        apiGet("/match-pairs")
            .then(response => {setData(response)})
    }, [])

    function filterData(sport){
        let searchSport = sport.toLowerCase()
        apiGet(`search-sport/${searchSport}`)
            .then(res => setData(res))
    }

    return (
        <div className="body row">
            <SportCategory filterFunc={filterData}/>
            <BodyContent data={data} component={props.component}/>
        </div>
    )
}

export default Body;