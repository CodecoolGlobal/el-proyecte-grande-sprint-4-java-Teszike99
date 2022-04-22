import SportCategory from "./SportCategory";
import BodyContent from "./BodyContent";

const Body = (props) => {
    return (
        <div className="body row">
            <SportCategory/>
            <BodyContent component={props.component} />
        </div>
    )
}

export default Body;