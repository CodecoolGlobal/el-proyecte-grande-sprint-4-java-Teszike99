import MatchDiv from "./MatchDiv";

const MatchPairDiv = (props) => {

    return (
        <div>
            <MatchDiv datas={props.matches[1]}/>
            <MatchDiv datas={props.matches[2]}/>
        </div>
    )
}

export default MatchPairDiv;