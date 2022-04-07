import SportCategory from "./SportCategory";
import BodyContent from "./BodyContent";


import ProfitMatchpairsDiv from "./ProfitMatchpairsDiv";

const Body = (props) => {
    return (
        <div>
            <SportCategory/>
            <BodyContent/>
            <ProfitMatchpairsDiv/>
        </div>
    )
}

export default Body;