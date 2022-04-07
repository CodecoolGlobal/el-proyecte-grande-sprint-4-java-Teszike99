import {elementFactory} from "../viewHandler/elementFactory";
const MatchPairDiv = (props) => {
    return (
        <div>
            <h4>{elementFactory.matchPairFactory(props)}</h4>
        </div>
    )
}

export default MatchPairDiv;