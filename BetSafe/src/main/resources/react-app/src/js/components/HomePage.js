import {elementFactory} from "../viewHandler/elementFactory";

const HomePage = () => {
    return (
        <div>
            {elementFactory.homePageFactory()}
        </div>
    )
}

export default HomePage;