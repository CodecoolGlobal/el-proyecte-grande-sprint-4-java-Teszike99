import SportCategory from "./SportCategory";
import BodyContent from "./BodyContent";

const Body = (props) => {
    return (
        <div>
            <SportCategory/>
            <BodyContent component={props.component}/>
        </div>
    )
}

export default Body;