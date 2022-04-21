import {useEffect, useState} from "react";
import {apiGet} from "../data/dataHandler";
import MatchesByOffice from "./MatchesByOffice";

const Office = () => {
    const [office, setOffice] = useState([]);
    const [matches, setMatches] = useState([]);
    const [boolean, setBoolean] = useState(false);

    const offices = office.map(offices => <div className="match-pair-container"><a href="#" onClick={() => handleClick(offices.name)}>{offices.name}</a></div>);
    const matchesMap = matches.map(match => <MatchesByOffice matches={match}/>)
    useEffect(() => {setBoolean(false)
        apiGet("/offices")
            .then(response => {setOffice(response)});
        },[]);

    function handleClick(office) {
        apiGet(`/search-office/${office}`)
            .then(response => {setMatches(response)}).then(() => setBoolean(true));

    }

    return (
        <div className="invest-page-container">
            {boolean ? matchesMap : offices}
        </div>
    )
}

export default Office;