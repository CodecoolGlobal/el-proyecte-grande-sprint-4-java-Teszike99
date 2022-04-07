import SportCategory from "./SportCategory";
import BodyContent from "./BodyContent";


import Matches from "./Matches";
import HomePage from "./HomePage";

const Body = (props) => {
    return (
        <div>
            <SportCategory/>
            <BodyContent component={props.component}/>
        </div>
    )
}

export default Body;