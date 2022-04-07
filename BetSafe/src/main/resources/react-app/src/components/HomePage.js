import {elementFactory} from "../viewHandler/elementFactory";
import matchDiv from "./MatchDiv";

const HomePage = () => {
    return (
        <div>
            {elementFactory.homePageFactory()}
        </div>
    )
}

export default HomePage;