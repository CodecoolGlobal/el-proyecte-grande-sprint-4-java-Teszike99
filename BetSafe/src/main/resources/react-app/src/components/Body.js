import SportCategory from "./SportCategory";
import BodyContent from "./BodyContent";


const Body = (props) => {
    return (
        <div className="main-body">
            <SportCategory></SportCategory>
            <BodyContent></BodyContent>

        </div>
    )
}

export default Body;